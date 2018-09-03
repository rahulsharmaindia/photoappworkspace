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

package org.rsystems.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.rsystems.model.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Data in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Data
 * @generated
 */
@ProviderType
public class DataCacheModel implements CacheModel<Data>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataCacheModel)) {
			return false;
		}

		DataCacheModel dataCacheModel = (DataCacheModel)obj;

		if (album_id == dataCacheModel.album_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, album_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{album_id=");
		sb.append(album_id);
		sb.append(", album_name=");
		sb.append(album_name);
		sb.append(", album_path=");
		sb.append(album_path);
		sb.append(", creation_date=");
		sb.append(creation_date);
		sb.append(", created_by=");
		sb.append(created_by);
		sb.append(", access=");
		sb.append(access);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Data toEntityModel() {
		DataImpl dataImpl = new DataImpl();

		dataImpl.setAlbum_id(album_id);

		if (album_name == null) {
			dataImpl.setAlbum_name(StringPool.BLANK);
		}
		else {
			dataImpl.setAlbum_name(album_name);
		}

		if (album_path == null) {
			dataImpl.setAlbum_path(StringPool.BLANK);
		}
		else {
			dataImpl.setAlbum_path(album_path);
		}

		if (creation_date == Long.MIN_VALUE) {
			dataImpl.setCreation_date(null);
		}
		else {
			dataImpl.setCreation_date(new Date(creation_date));
		}

		if (created_by == null) {
			dataImpl.setCreated_by(StringPool.BLANK);
		}
		else {
			dataImpl.setCreated_by(created_by);
		}

		dataImpl.setAccess(access);

		dataImpl.resetOriginalValues();

		return dataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		album_id = objectInput.readInt();
		album_name = objectInput.readUTF();
		album_path = objectInput.readUTF();
		creation_date = objectInput.readLong();
		created_by = objectInput.readUTF();

		access = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(album_id);

		if (album_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(album_name);
		}

		if (album_path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(album_path);
		}

		objectOutput.writeLong(creation_date);

		if (created_by == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(created_by);
		}

		objectOutput.writeInt(access);
	}

	public int album_id;
	public String album_name;
	public String album_path;
	public long creation_date;
	public String created_by;
	public int access;
}