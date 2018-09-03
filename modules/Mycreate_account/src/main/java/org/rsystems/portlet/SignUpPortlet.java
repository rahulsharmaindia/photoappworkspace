package org.rsystems.portlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * @author rahul.sharma3
 */
@Component(configurationPid = "org.rsystems.portlet.SignUpConfiguration",
immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.name=SignUpPortlet",
		"javax.portlet.display-name=Create User",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SignUpPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		if (_log.isDebugEnabled()) {
			_log.debug("SignUpPortlet - doView() called");
		}
		renderRequest.setAttribute(SignUpConfiguration.class.getName(), _signUpConfiguration);
		SessionMessages.add(renderRequest,
				PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		_log.info("Redirect to private page on login success:" + _signUpConfiguration.redirectURL());	
		super.doView(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_signUpConfiguration = ConfigurableUtil.createConfigurable(SignUpConfiguration.class, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(SignUpConfiguration.class);

	private volatile SignUpConfiguration _signUpConfiguration;

}