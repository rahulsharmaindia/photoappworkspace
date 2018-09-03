package org.rsystems.portlet;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(configurationPid = "org.rsystems.portlet.SignUpConfiguration",
		   configurationPolicy = ConfigurationPolicy.OPTIONAL,
		   immediate = true, 
		   property = { "javax.portlet.name=SignUpPortlet" },
		   service = ConfigurationAction.class)

public class SignUpConfigurationAction extends DefaultConfigurationAction {
	private static final String USER_ORGANIZATION = "userOrganization";
	private static final String USER_ROLE = "userRole";
	private static final String REDIRECT_URL = "redirectURL";

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String userOrganization = ParamUtil.getString(actionRequest, USER_ORGANIZATION);
		String userRole = ParamUtil.getString(actionRequest, USER_ROLE);
		String redirectURL = ParamUtil.getString(actionRequest, REDIRECT_URL);
		setPreference(actionRequest, REDIRECT_URL, redirectURL);
		setPreference(actionRequest, USER_ORGANIZATION, userOrganization);
		setPreference(actionRequest, USER_ROLE, userRole);

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(SignUpConfiguration.class.getName(), _signUpConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_signUpConfiguration = ConfigurableUtil.createConfigurable(SignUpConfiguration.class, properties);
	}

	private volatile SignUpConfiguration _signUpConfiguration;

}