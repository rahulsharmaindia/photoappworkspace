/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rsystems.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the PhotoAppConfiguration service. Represents a row in the &quot;photoapplication_PhotoAppConfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PhotoAppConfigurationModel
 * @see com.rsystems.model.impl.PhotoAppConfigurationImpl
 * @see com.rsystems.model.impl.PhotoAppConfigurationModelImpl
 * @generated
 */
@ImplementationClassName("com.rsystems.model.impl.PhotoAppConfigurationImpl")
@ProviderType
public interface PhotoAppConfiguration extends PhotoAppConfigurationModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.rsystems.model.impl.PhotoAppConfigurationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PhotoAppConfiguration, String> CONFIG_NAME_ACCESSOR =
		new Accessor<PhotoAppConfiguration, String>() {
			@Override
			public String get(PhotoAppConfiguration photoAppConfiguration) {
				return photoAppConfiguration.getConfigName();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<PhotoAppConfiguration> getTypeClass() {
				return PhotoAppConfiguration.class;
			}
		};
}