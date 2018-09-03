package org.rsystems.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.rsystems.constants.SearchUserPortletKeys;
import org.rsystems.model.Data;
import org.rsystems.service.DataLocalServiceUtil;
import org.rsystems.share.model.Album;
import org.rsystems.share.service.AlbumLocalServiceUtil;
import org.rsystems.share.service.persistence.AlbumPK;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * @author gauri.shukla
 */
@Component(immediate = true, 
			property = { "com.liferay.portlet.display-category=category.sample",
						  "com.liferay.portlet.instanceable=true",
						  "com.liferay.portlet.single-page-application=false",
						  "javax.portlet.init-param.add-process-action-success-action=false",
						  "javax.portlet.display-name=searchuser Portlet", 
						  "javax.portlet.init-param.template-path=/",
						  "javax.portlet.init-param.view-template=/view.jsp",
						  "javax.portlet.name=" + SearchUserPortletKeys.SearchUser,
						  "javax.portlet.resource-bundle=content.Language",
						  "javax.portlet.security-role-ref=power-user,user" }, 
			service = Portlet.class)
public class SearchUserPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(SearchUserPortlet.class);
	private static final String ATTRIBUTE_VALID_EMAIL = "validEmail";
	private static final String ATTRIBUTE_USER_NAME = "userName";
	private static final String DIRECTORY_ID = "directoryId";
	private static final String RENDER_PARAM = "mvcPath";
	private static final String DEFAULT_DIRECTORY = "MyDocuments";

	public void searchByEmail(ActionRequest actionRequest, ActionResponse response) {		
		User loggedInUser = null;
		try {
			loggedInUser = PortalUtil.getUser(PortalUtil.getHttpServletRequest(actionRequest));
		} catch (PortalException e1) {
			_log.error("Logged in user exception:.", e1);
			e1.printStackTrace();
		}
		String loggedInEmailAddress = loggedInUser.getEmailAddress();

		String name = ParamUtil.getString(actionRequest, "emailAddress");
		if (StringUtils.isBlank(name)) {
			actionRequest.setAttribute("error", "Email Address field is blank.");
			return;
		}
		List<String> emailsArray = Arrays.asList(name.split("\\s*;\\s*"));
		String directoryId = ParamUtil.getString(actionRequest, "directoryId");
		System.out.println("email entered called" + name);
		User user = null;
		String commaSeperatedUserId = "";
		try {
			long companyId = PortalUtil.getDefaultCompanyId();
			if (emailsArray.size() > 0) {
				List<String> emailsList = new ArrayList<String>();
				for (String email : emailsArray) {
					email = email.trim();
					if (loggedInEmailAddress.equalsIgnoreCase(email)) {
						actionRequest.setAttribute("error",
								"Logged In user's Email and Entered Email Address are same: <b>" + email + "</b>.");
						return;
					}
					user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
					emailsList.add(user.getScreenName());
				}
				commaSeperatedUserId = String.join(";", emailsList);
			}

			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, name);
			actionRequest.setAttribute(ATTRIBUTE_VALID_EMAIL, name);
			actionRequest.setAttribute(ATTRIBUTE_USER_NAME, commaSeperatedUserId);
			actionRequest.setAttribute(DIRECTORY_ID, directoryId);
			response.setRenderParameter(RENDER_PARAM, "/user-share.jsp");
		} catch (NoSuchUserException e) {
			actionRequest.setAttribute("error", "User with email address: <b>" + name + "</b> doesn't exists.");
			_log.error("Error in retrieving user based on email address.", e);

		} catch (Exception e) {
			actionRequest.setAttribute("error", "Server under maintenance, Contact Administrator.");
			_log.error("Error in retrieving user based on email address.", e);
		}
	}

	/**
	 * Action method to share directory with provided email Ids.
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void shareWithSelectedEmails(ActionRequest actionRequest, ActionResponse actionResponse) {
		String directoryId = ParamUtil.getString(actionRequest, "directoryId");
		String userName = ParamUtil.getString(actionRequest, "userName");
		int album_Id = Integer.valueOf(directoryId);
		try {
			Data albumData = DataLocalServiceUtil.fetchData(album_Id);
			if (albumData == null) {
				actionRequest.setAttribute("error", "Album selected doesn't exists on server.");
				return;
			} else {
				String albumName = albumData.getAlbum_name();
				User loggedInUser = PortalUtil.getUser(PortalUtil.getHttpServletRequest(actionRequest));
				String userId = loggedInUser.getScreenName();				
				String privateAlbumName = DEFAULT_DIRECTORY + "~" + userId;
				if (privateAlbumName.equalsIgnoreCase(albumName)) {
					actionRequest.setAttribute("error", "MyDocuments cannot be shared.");
					return;
				}				
				AlbumPK sharePk = new AlbumPK();
				sharePk.setAlbum_id(album_Id);
				sharePk.setShared_user(userName);
				Album shareAlbum = AlbumLocalServiceUtil.fetchAlbum(sharePk);
				
				if(shareAlbum != null){
					actionRequest.setAttribute("error", "Album already shared with selected user.");
					return;
				} else{
					AlbumPK newSharePk = new AlbumPK();
					newSharePk.setAlbum_id(album_Id);
					newSharePk.setShared_user(userName);
					Album albumShare = AlbumLocalServiceUtil.createAlbum(newSharePk);
					albumShare.setAlbum_name(albumData.getAlbum_name());
					AlbumLocalServiceUtil.addAlbum(albumShare);
					boolean needAlbumUpdate = false;
					if(albumData.getAccess() != 2){
						albumData.setAccess(2);	
						needAlbumUpdate = true;
					}
					if(needAlbumUpdate){
						DataLocalServiceUtil.updateData(albumData);	
					}				
				}				
			}
			actionRequest.setAttribute("success", "success");
			actionRequest.setAttribute("userName", userName);
			actionResponse.setRenderParameter("mvcPath", "/user-share.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void successBtn(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			actionResponse.sendRedirect("/group/speedyfsphotoapp/redirect-after-success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		String directoryId = (String) renderRequest.getAttribute("directoryId");
		if (StringUtils.isBlank(directoryId)) {
			String url = PortalUtil.getCurrentURL(renderRequest);
			if (url.contains("?")) {
				String[] parts = url.split("\\?");
				String part2 = parts[1];
				if (part2.contains("directoryId=")) {
					String[] splitSubStr = part2.split("=");
					directoryId = splitSubStr[1];
					renderRequest.setAttribute("directoryId", directoryId);
				}
			}
		}
		SessionMessages.add(renderRequest,
				PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		super.render(renderRequest, renderResponse);
	}

}