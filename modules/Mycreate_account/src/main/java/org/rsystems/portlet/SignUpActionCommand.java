package org.rsystems.portlet;

import java.util.Map;

import javax.naming.NameAlreadyBoundException;
import javax.naming.ldap.LdapContext;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.rsystems.util.CommonUtility;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.ldap.configuration.LDAPServerConfiguration;

@Component( configurationPid = "com.liferay.portal.security.ldap.configuration.LDAPServerConfiguration",
			immediate = true,
			property = {"javax.portlet.name=SignUpPortlet", 
					"mvc.command.name=createUser" }, 
			service = MVCActionCommand.class)

public class SignUpActionCommand implements MVCActionCommand {
	
	private static final Log _log = LogFactoryUtil.getLog(
			SignUpActionCommand.class);
	
	public LDAPServerConfiguration getldapConfiguration() {
		return configuration;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(LDAPServerConfiguration.class, properties);
	}

	private volatile LDAPServerConfiguration configuration;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		System.out.println(" Original processAction method called");
		try {
			addUser(actionRequest, actionResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private void addUser(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		HttpServletRequest request = _portal.getHttpServletRequest(actionRequest);
		HttpServletResponse response = _portal.getHttpServletResponse(actionResponse);

		HttpSession session = request.getSession();

//		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		Company company = themeDisplay.getCompany();
		
		long companyId = PortalUtil.getCompanyId(request);

		
		boolean autoPassword = true;
		/**
		 * Set autoScreenName as true so that liferay can generate userId
		 * automatically if email address is unique.
		 * 
		 * This is required as user can login via UserID or emailID from mobile.		 * 
		 */
		//boolean autoScreenName = false;
		boolean autoScreenName = true;

		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress").trim();
		long facebookId = ParamUtil.getLong(actionRequest, "facebookId");
		String openId = ParamUtil.getString(actionRequest, "openId");
		String languageId = ParamUtil.getString(actionRequest, "languageId");
		String firstName = ParamUtil.getString(actionRequest, "firstName").trim();
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String lastName = ParamUtil.getString(actionRequest, "lastName").trim();
		long prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
		long suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
		String password1 = ParamUtil.getString(actionRequest, "password").trim();
		String password2 = ParamUtil.getString(actionRequest, "password1").trim();
		if (!password1.equalsIgnoreCase(password2)) {
			actionRequest.setAttribute("error", "Password mismatched!!!");
			return;
		}
		String screenName = emailAddress;
		int birthdayMonth = 1;
		int birthdayDay = 1;
		int birthdayYear = 1;
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = true;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);

		String userOrganization = ParamUtil.getString(actionRequest, "userOrganization");
		String userRole = ParamUtil.getString(actionRequest, "userRole");
		Organization organization = OrganizationLocalServiceUtil.fetchOrganization(companyId,
				userOrganization);
		if(organization == null){
			actionRequest.setAttribute("error", "Organization Configuration issue.");
			return;	
		}
		Role role = RoleLocalServiceUtil.fetchRole(companyId, userRole);

		Boolean openIdLoginPending = (Boolean) session.getAttribute(WebKeys.OPEN_ID_LOGIN_PENDING);

		if ((openIdLoginPending != null) && openIdLoginPending.booleanValue() && Validator.isNotNull(openId)) {

			sendEmail = false;
		}
		try {
			User user = _userService.addUserWithWorkflow(companyId, autoPassword, password1, password2,
					autoScreenName, screenName, emailAddress, facebookId, openId, LocaleUtil.fromLanguageId(languageId),
					firstName, middleName, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
					jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
			LdapContext ctx = LDAPConnectionUtils.createContext(configuration.baseProviderURL(),
					configuration.securityPrincipal(), configuration.securityCredential());
			LDAPService ldapService = new LDAPService();
			screenName = user.getScreenName();
			String status = ldapService.updateUserPassword(ctx, configuration.baseDN(), user, password1);
			
			UserLocalServiceUtil.addOrganizationUser(organization.getOrganizationId(), user.getUserId());
			UserLocalServiceUtil.addRoleUser(role.getRoleId(), user.getUserId());
			if (status.equalsIgnoreCase("success")) {
				AuthenticatedSessionManagerUtil.login(request, response,
				 emailAddress, password1, true,CompanyConstants.AUTH_TYPE_EA);
				actionRequest.setAttribute("userName", screenName);
				actionRequest.setAttribute("emailId",emailAddress);
				actionRequest.setAttribute("success", "success");
				actionRequest.setAttribute("pwd", new CommonUtility().encrypt(password1));				
			}
		} catch (UserEmailAddressException e) {
			if (e instanceof UserEmailAddressException.MustNotBeDuplicate) {
				actionRequest.setAttribute("error",
						"Email Address: <b>" + emailAddress + "</b> already exists.");
				return;
			}
			actionRequest.setAttribute("error", "Email Address entered is invalid.");
			return;
		} catch (UserScreenNameException e) {
			actionRequest.setAttribute("error", "UserId:<b>" + screenName
					+ "</b> already exists, Please use different <b>FirstName-LastName</b> combination.");
			return;
		} catch (NameAlreadyBoundException e) {
			actionRequest.setAttribute("error",
					"UserId:<b>" + screenName + "</b> already exists in LDAP, Please use different combination.");
			return;
		} catch (Exception e) {
			actionRequest.setAttribute("error", "Some error occured, Please contact Administrator.");
			_log.error("Exception while creating user.", e);
			return;
		}
	}

	@Reference
	private Portal _portal;

	@Reference
	private UserService _userService;
}