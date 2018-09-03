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

package com.rsystems.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.rsystems.model.PhotoAppConfiguration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PhotoAppConfiguration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PhotoAppConfiguration
 * @generated
 */
@ProviderType
public class PhotoAppConfigurationCacheModel implements CacheModel<PhotoAppConfiguration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhotoAppConfigurationCacheModel)) {
			return false;
		}

		PhotoAppConfigurationCacheModel photoAppConfigurationCacheModel = (PhotoAppConfigurationCacheModel)obj;

		if (configName.equals(photoAppConfigurationCacheModel.configName)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, configName);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", configName=");
		sb.append(configName);
		sb.append(", value1=");
		sb.append(value1);
		sb.append(", value2=");
		sb.append(value2);
		sb.append(", value3=");
		sb.append(value3);
		sb.append(", value4=");
		sb.append(value4);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhotoAppConfiguration toEntityModel() {
		PhotoAppConfigurationImpl photoAppConfigurationImpl = new PhotoAppConfigurationImpl();

		if (uuid == null) {
			photoAppConfigurationImpl.setUuid(StringPool.BLANK);
		}
		else {
			photoAppConfigurationImpl.setUuid(uuid);
		}

		if (configName == null) {
			photoAppConfigurationImpl.setConfigName(StringPool.BLANK);
		}
		else {
			photoAppConfigurationImpl.setConfigName(configName);
		}

		if (value1 == null) {
			photoAppConfigurationImpl.setValue1(StringPool.BLANK);
		}
		else {
			photoAppConfigurationImpl.setValue1(value1);
		}

		if (value2 == null) {
			photoAppConfigurationImpl.setValue2(StringPool.BLANK);
		}
		else {
			photoAppConfigurationImpl.setValue2(value2);
		}

		if (value3 == null) {
			photoAppConfigurationImpl.setValue3(StringPool.BLANK);
		}
		else {
			photoAppConfigurationImpl.setValue3(value3);
		}

		if (value4 == null) {
			photoAppConfigurationImpl.setValue4(StringPool.BLANK);
		}
		else {
			photoAppConfigurationImpl.setValue4(value4);
		}

		photoAppConfigurationImpl.resetOriginalValues();

		return photoAppConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		configName = objectInput.readUTF();
		value1 = objectInput.readUTF();
		value2 = objectInput.readUTF();
		value3 = objectInput.readUTF();
		value4 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (configName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(configName);
		}

		if (value1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value1);
		}

		if (value2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value2);
		}

		if (value3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value3);
		}

		if (value4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value4);
		}
	}

	public String uuid;
	public String configName;
	public String value1;
	public String value2;
	public String value3;
	public String value4;
}