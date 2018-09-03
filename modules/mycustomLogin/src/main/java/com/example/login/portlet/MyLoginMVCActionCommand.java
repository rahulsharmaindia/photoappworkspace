package com.example.login.portlet;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.example.login.util.CommonUtility;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(configurationPid = "com.example.login.portlet.LoginConfiguration", immediate = true, property = {
		"javax.portlet.name=MyLoginPortlet", "mvc.command.name=mylogin" }, service = MVCActionCommand.class)
public class MyLoginMVCActionCommand extends BaseMVCActionCommand {

	private static final String USER_ID = "userId";
	private static final String EMAIL_ID = "emailId";
	private static final String PASSWORD_ID = "password";
	private static final String REDIRECT_FIELD = "redirect";
	private static final String REMEMBER_ME = "rememberMe";
	private static final String REDIRECT_URL = "/group/speedyfsphotoapp/photoapp-login-success";
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_loginConfiguration = ConfigurableUtil.createConfigurable(LoginConfiguration.class, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(MyLoginPortlet.class);

	private volatile LoginConfiguration _loginConfiguration;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));

		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		String userId = request.getParameter(USER_ID).trim();
		String emailAddress = request.getParameter(EMAIL_ID).trim();
		String password = request.getParameter(PASSWORD_ID).trim();
		String encrypted = request.getParameter("encrypted").trim();

		if ((StringUtils.isBlank(emailAddress) && StringUtils.isBlank(userId))
				|| (StringUtils.isBlank(password) && StringUtils.isBlank(encrypted))) {
			_log.info("Blank fields not allowed!!!");
			return;
		}

		long companyId = PortalUtil.getDefaultCompanyId();
		User user = null;
		if (StringUtils.isBlank(userId)) {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
			userId = user.getScreenName();
		} else {
			user = UserLocalServiceUtil.getUserByScreenName(companyId, userId);
			emailAddress = user.getEmailAddress();
		}		
		if(StringUtils.isNotBlank(encrypted)){
			password = new CommonUtility().decrypt(encrypted);
		}
		
		/**
		 * if rememberMe set true user will be remembered till cookies/cache are not cleaned.
		 */
		boolean rememberMe = Boolean.parseBoolean(request.getParameter(REMEMBER_ME));
		String authType = CompanyConstants.AUTH_TYPE_EA;
		Group currentGroup = themeDisplay.getLayout().getGroup();
		request.getSession().setAttribute("siteURL", currentGroup.getFriendlyURL());
		AuthenticatedSessionManagerUtil.login(request, response, emailAddress, password, rememberMe, authType);
		String redirectUrl = _loginConfiguration.redirectURL();
		if (StringUtils.isBlank(redirectUrl)) {
			redirectUrl = request.getParameter(REDIRECT_FIELD).trim();
		}		
		if (StringUtils.isBlank(redirectUrl)) {
			redirectUrl = REDIRECT_URL;
		}
		String pwd = new CommonUtility().encrypt(password);		
		redirectUrl = redirectUrl + "?userId=" + userId + "&pwd="+ pwd;
		actionResponse.sendRedirect(redirectUrl);
	}

}
