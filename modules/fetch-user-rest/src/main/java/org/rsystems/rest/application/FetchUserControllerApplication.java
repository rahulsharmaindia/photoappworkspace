package org.rsystems.rest.application;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.rsystems.rest.dto.RestResponse;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * @author gauri.shukla
 */
@ApplicationPath("/user-info")
@Component(immediate = true, service = Application.class)
public class FetchUserControllerApplication extends Application {

	private static final Log _log = LogFactoryUtil.getLog(FetchUserControllerApplication.class);

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String fetchUserId(@FormParam("emailId") String emailId) {

		long companyId = PortalUtil.getDefaultCompanyId();
		RestResponse restResponse = new RestResponse();

		User user;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailId);
			if (user != null) {
				restResponse.setFirstName(user.getFirstName());
				restResponse.setLastName(user.getLastName());
				restResponse.setUserId(user.getScreenName());
				restResponse.setResponseMsg("User retrieved successfully.");
				restResponse.setStatus("true");
			} else {
				restResponse.setResponseMsg("User doesn't exist.");
				restResponse.setStatus("false");
			}
		} catch (NoSuchUserException e) {
			restResponse.setResponseMsg("No user exists with email address: " + emailId);
			restResponse.setStatus("false");
			_log.info("NoSuchUserException in fetch user details.", e);
		} catch (PortalException e) {
			restResponse.setResponseMsg("Exception while fetching user.");
			restResponse.setStatus("false");
			_log.info("Exception in fetch user details.", e);
		}
		return JSONFactoryUtil.serialize(restResponse);

	}

}