package com.example.login.portlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(configurationPid = "com.example.login.portlet.LoginConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.name=MyLoginPortlet",
		"javax.portlet.display-name=Login",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class MyLoginPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		final String REDIRECT_URL = "/group/speedyfsphotoapp/photoapp-login-success";
		final String REDIRECT_FIELD = "redirect";
		if (_log.isDebugEnabled()) {
			_log.debug("Blade Message Portlet render");
		}
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(renderResponse);
		

		try {
			User user = PortalUtil.getUser(request);
			/*HttpSession session = request.getSession();
			String pwd = (String)session.getAttribute("pwd");*/			
			if(user != null /*&& StringUtils.isNotBlank(pwd)*/){
				String userId = user.getScreenName();
				String redirectUrl = _loginConfiguration.redirectURL();
				if (StringUtils.isBlank(redirectUrl)) {					
					redirectUrl = REDIRECT_URL;
				}	
							
				redirectUrl = redirectUrl + "?userId=" + userId /*+ "&pwd="+ session.getAttribute("pwd")*/;
				response.sendRedirect(redirectUrl);
			}
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		renderRequest.setAttribute(LoginConfiguration.class.getName(), _loginConfiguration);
		_log.info("Redirect to private page on login success:" + _loginConfiguration.redirectURL());
		super.doView(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_loginConfiguration = ConfigurableUtil.createConfigurable(LoginConfiguration.class, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(MyLoginPortlet.class);

	private volatile LoginConfiguration _loginConfiguration;
}