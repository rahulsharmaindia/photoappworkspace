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
package content;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;

@Component(immediate = true, property = {
		"key=logout.events.pre" }, service = LifecycleAction.class)
public class MyCustomPreLogoutAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		try {
			Object siteURL=lifecycleEvent.getRequest().getSession().getAttribute("siteURL");
			String postLogoutURL = "/web" +  (siteURL==null?"":siteURL);//group.getFriendlyURL();
			lifecycleEvent.getResponse().sendRedirect(postLogoutURL);
		} catch (IOException e) {
			System.out.println("MyCustomPreLogoutAction - login.event.post=" + lifecycleEvent);
			e.printStackTrace();
		}
	}

}