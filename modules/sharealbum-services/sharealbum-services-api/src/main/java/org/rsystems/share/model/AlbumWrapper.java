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

package org.rsystems.share.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Album}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Album
 * @generated
 */
@ProviderType
public class AlbumWrapper implements Album, ModelWrapper<Album> {
	public AlbumWrapper(Album album) {
		_album = album;
	}

	@Override
	public Class<?> getModelClass() {
		return Album.class;
	}

	@Override
	public String getModelClassName() {
		return Album.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("album_id", getAlbum_id());
		attributes.put("shared_user", getShared_user());
		attributes.put("album_name", getAlbum_name());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer album_id = (Integer)attributes.get("album_id");

		if (album_id != null) {
			setAlbum_id(album_id);
		}

		String shared_user = (String)attributes.get("shared_user");

		if (shared_user != null) {
			setShared_user(shared_user);
		}

		String album_name = (String)attributes.get("album_name");

		if (album_name != null) {
			setAlbum_name(album_name);
		}
	}

	@Override
	public Album toEscapedModel() {
		return new AlbumWrapper(_album.toEscapedModel());
	}

	@Override
	public Album toUnescapedModel() {
		return new AlbumWrapper(_album.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _album.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _album.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _album.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _album.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Album> toCacheModel() {
		return _album.toCacheModel();
	}

	@Override
	public int compareTo(Album album) {
		return _album.compareTo(album);
	}

	/**
	* Returns the album_id of this album.
	*
	* @return the album_id of this album
	*/
	@Override
	public int getAlbum_id() {
		return _album.getAlbum_id();
	}

	@Override
	public int hashCode() {
		return _album.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _album.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AlbumWrapper((Album)_album.clone());
	}

	/**
	* Returns the album_name of this album.
	*
	* @return the album_name of this album
	*/
	@Override
	public java.lang.String getAlbum_name() {
		return _album.getAlbum_name();
	}

	/**
	* Returns the shared_user of this album.
	*
	* @return the shared_user of this album
	*/
	@Override
	public java.lang.String getShared_user() {
		return _album.getShared_user();
	}

	@Override
	public java.lang.String toString() {
		return _album.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _album.toXmlString();
	}

	/**
	* Returns the primary key of this album.
	*
	* @return the primary key of this album
	*/
	@Override
	public org.rsystems.share.service.persistence.AlbumPK getPrimaryKey() {
		return _album.getPrimaryKey();
	}

	@Override
	public void persist() {
		_album.persist();
	}

	/**
	* Sets the album_id of this album.
	*
	* @param album_id the album_id of this album
	*/
	@Override
	public void setAlbum_id(int album_id) {
		_album.setAlbum_id(album_id);
	}

	/**
	* Sets the album_name of this album.
	*
	* @param album_name the album_name of this album
	*/
	@Override
	public void setAlbum_name(java.lang.String album_name) {
		_album.setAlbum_name(album_name);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_album.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_album.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_album.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_album.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_album.setNew(n);
	}

	/**
	* Sets the primary key of this album.
	*
	* @param primaryKey the primary key of this album
	*/
	@Override
	public void setPrimaryKey(
		org.rsystems.share.service.persistence.AlbumPK primaryKey) {
		_album.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_album.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the shared_user of this album.
	*
	* @param shared_user the shared_user of this album
	*/
	@Override
	public void setShared_user(java.lang.String shared_user) {
		_album.setShared_user(shared_user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AlbumWrapper)) {
			return false;
		}

		AlbumWrapper albumWrapper = (AlbumWrapper)obj;

		if (Objects.equals(_album, albumWrapper._album)) {
			return true;
		}

		return false;
	}

	@Override
	public Album getWrappedModel() {
		return _album;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _album.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _album.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_album.resetOriginalValues();
	}

	private final Album _album;
}