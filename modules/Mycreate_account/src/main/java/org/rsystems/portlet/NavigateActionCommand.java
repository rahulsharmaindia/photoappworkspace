/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.rsystems.portlet;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
@Component(	configurationPid = "com.example.login.portlet.SignUpConfiguration", 
			immediate = true, 
			property = { "javax.portlet.name=SignUpPortlet",
						  "mvc.command.name=redirectToNative" }, 
			service = MVCActionCommand.class)

public class NavigateActionCommand extends BaseMVCActionCommand {
	
	private volatile SignUpConfiguration _signUpConfiguration;
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_signUpConfiguration = ConfigurableUtil.createConfigurable(SignUpConfiguration.class, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(NavigateActionCommand.class);

	

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {		
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		_log.info("Redirect value saved in preference:---"+redirectURL);		
		actionResponse.sendRedirect(redirectURL);
	}

}