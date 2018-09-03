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

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

@Component(
	immediate = true,
    service = ModelListener.class
)
public class MycustomloginModelListener extends BaseModelListener<User> {
	 
	 
	 @Override
	 public void onAfterUpdate(User model) throws ModelListenerException {
	 _log.debug("user is updateing");
	 super.onAfterUpdate(model);
	 }
	 @Override
		public void onBeforeCreate(User model) throws ModelListenerException {
		 _log.debug("user is creating");
		 super.onBeforeCreate(model);
		}
	 
	 private static final Log _log = LogFactoryUtil.getLog(MycustomloginModelListener.class);
	}