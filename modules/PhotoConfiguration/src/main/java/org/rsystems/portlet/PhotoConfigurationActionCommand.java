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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.rsystems.model.PhotoAppConfiguration;
import com.rsystems.service.PhotoAppConfigurationLocalServiceUtil;

@Component(
	immediate = true,
	property = {
        "javax.portlet.name=org_rsystems_portlet_PhotoConfigurationPortlet",
        "mvc.command.name=processAction"
    },
    service = MVCActionCommand.class
)
public class PhotoConfigurationActionCommand implements MVCActionCommand {
	
	private final String PHOTO_CONFIGURATION= "PHOTO_CONFIGURATION";
	@Override
	public boolean processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {
		System.out.println(" Original processAction method called");
		_handleActionCommand(actionRequest);

		return true;
	}

	private void _handleActionCommand(ActionRequest actionRequest) {
		String rootpath = ParamUtil.get(actionRequest, "rootPath", StringPool.BLANK);
		String servername = ParamUtil.get(actionRequest, "serverName", StringPool.BLANK);
		
		PhotoAppConfiguration appConfiguration = null;
		try {
			appConfiguration = PhotoAppConfigurationLocalServiceUtil.fetchPhotoAppConfiguration(PHOTO_CONFIGURATION);
			if(appConfiguration==null){
				appConfiguration = PhotoAppConfigurationLocalServiceUtil.createPhotoAppConfiguration(PHOTO_CONFIGURATION);
			}
			appConfiguration.setValue1(rootpath);
			appConfiguration.setValue2(servername);
		} catch (Exception e) {
			e.printStackTrace();
			_log.error("Error whilesaving ldap configurtation",e);
		}
		PhotoAppConfigurationLocalServiceUtil.updatePhotoAppConfiguration(appConfiguration);
		
	}

	private static final Log _log = LogFactoryUtil.getLog(
			PhotoConfigurationActionCommand.class);
}