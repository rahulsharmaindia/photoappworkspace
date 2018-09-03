package org.rsystems.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.rsystems.model.LdapConfigModel;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.rsystems.model.PhotoAppConfiguration;
import com.rsystems.service.PhotoAppConfigurationLocalServiceUtil;

/**
 * @author rahul.sharma3
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LDAP Configuration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LDAPConfigurationPortlet extends MVCPortlet {
	
	private final String LDAP_CONFIGURATION= "LDAP_CONFIGURATION";
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		super.render(renderRequest, renderResponse);
	}
}