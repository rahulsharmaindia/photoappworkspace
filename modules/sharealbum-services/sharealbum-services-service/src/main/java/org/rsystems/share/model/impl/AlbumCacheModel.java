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

package org.rsystems.share.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.rsystems.share.model.Album;
import org.rsystems.share.service.persistence.AlbumPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Album in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Album
 * @generated
 */
@ProviderType
public class AlbumCacheModel implements CacheModel<Album>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AlbumCacheModel)) {
			return false;
		}

		AlbumCacheModel albumCacheModel = (AlbumCacheModel)obj;

		if (albumPK.equals(albumCacheModel.albumPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, albumPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{album_id=");
		sb.append(album_id);
		sb.append(", shared_user=");
		sb.append(shared_user);
		sb.append(", album_name=");
		sb.append(album_name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Album toEntityModel() {
		AlbumImpl albumImpl = new AlbumImpl();

		albumImpl.setAlbum_id(album_id);

		if (shared_user == null) {
			albumImpl.setShared_user(StringPool.BLANK);
		}
		else {
			albumImpl.setShared_user(shared_user);
		}

		if (album_name == null) {
			albumImpl.setAlbum_name(StringPool.BLANK);
		}
		else {
			albumImpl.setAlbum_name(album_name);
		}

		albumImpl.resetOriginalValues();

		return albumImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		album_id = objectInput.readInt();
		shared_user = objectInput.readUTF();
		album_name = objectInput.readUTF();

		albumPK = new AlbumPK(album_id, shared_user);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(album_id);

		if (shared_user == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shared_user);
		}

		if (album_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(album_name);
		}
	}

	public int album_id;
	public String shared_user;
	public String album_name;
	public transient AlbumPK albumPK;
}