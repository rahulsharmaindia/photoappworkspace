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

package org.rsystems.share.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AlbumPK implements Comparable<AlbumPK>, Serializable {
	public int album_id;
	public String shared_user;

	public AlbumPK() {
	}

	public AlbumPK(int album_id, String shared_user) {
		this.album_id = album_id;
		this.shared_user = shared_user;
	}

	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public String getShared_user() {
		return shared_user;
	}

	public void setShared_user(String shared_user) {
		this.shared_user = shared_user;
	}

	@Override
	public int compareTo(AlbumPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (album_id < pk.album_id) {
			value = -1;
		}
		else if (album_id > pk.album_id) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = shared_user.compareTo(pk.shared_user);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AlbumPK)) {
			return false;
		}

		AlbumPK pk = (AlbumPK)obj;

		if ((album_id == pk.album_id) && (shared_user.equals(pk.shared_user))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, album_id);
		hashCode = HashUtil.hash(hashCode, shared_user);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("album_id");
		sb.append(StringPool.EQUAL);
		sb.append(album_id);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("shared_user");
		sb.append(StringPool.EQUAL);
		sb.append(shared_user);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}