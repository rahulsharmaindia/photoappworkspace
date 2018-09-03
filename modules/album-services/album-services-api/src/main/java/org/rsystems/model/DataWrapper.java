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

package org.rsystems.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Data}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Data
 * @generated
 */
@ProviderType
public class DataWrapper implements Data, ModelWrapper<Data> {
	public DataWrapper(Data data) {
		_data = data;
	}

	@Override
	public Class<?> getModelClass() {
		return Data.class;
	}

	@Override
	public String getModelClassName() {
		return Data.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("album_id", getAlbum_id());
		attributes.put("album_name", getAlbum_name());
		attributes.put("album_path", getAlbum_path());
		attributes.put("creation_date", getCreation_date());
		attributes.put("created_by", getCreated_by());
		attributes.put("access", getAccess());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer album_id = (Integer)attributes.get("album_id");

		if (album_id != null) {
			setAlbum_id(album_id);
		}

		String album_name = (String)attributes.get("album_name");

		if (album_name != null) {
			setAlbum_name(album_name);
		}

		String album_path = (String)attributes.get("album_path");

		if (album_path != null) {
			setAlbum_path(album_path);
		}

		Date creation_date = (Date)attributes.get("creation_date");

		if (creation_date != null) {
			setCreation_date(creation_date);
		}

		String created_by = (String)attributes.get("created_by");

		if (created_by != null) {
			setCreated_by(created_by);
		}

		Integer access = (Integer)attributes.get("access");

		if (access != null) {
			setAccess(access);
		}
	}

	@Override
	public Data toEscapedModel() {
		return new DataWrapper(_data.toEscapedModel());
	}

	@Override
	public Data toUnescapedModel() {
		return new DataWrapper(_data.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _data.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _data.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _data.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _data.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Data> toCacheModel() {
		return _data.toCacheModel();
	}

	@Override
	public int compareTo(Data data) {
		return _data.compareTo(data);
	}

	/**
	* Returns the access of this data.
	*
	* @return the access of this data
	*/
	@Override
	public int getAccess() {
		return _data.getAccess();
	}

	/**
	* Returns the album_id of this data.
	*
	* @return the album_id of this data
	*/
	@Override
	public int getAlbum_id() {
		return _data.getAlbum_id();
	}

	/**
	* Returns the primary key of this data.
	*
	* @return the primary key of this data
	*/
	@Override
	public int getPrimaryKey() {
		return _data.getPrimaryKey();
	}

	@Override
	public int hashCode() {
		return _data.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _data.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DataWrapper((Data)_data.clone());
	}

	/**
	* Returns the album_name of this data.
	*
	* @return the album_name of this data
	*/
	@Override
	public java.lang.String getAlbum_name() {
		return _data.getAlbum_name();
	}

	/**
	* Returns the album_path of this data.
	*
	* @return the album_path of this data
	*/
	@Override
	public java.lang.String getAlbum_path() {
		return _data.getAlbum_path();
	}

	/**
	* Returns the created_by of this data.
	*
	* @return the created_by of this data
	*/
	@Override
	public java.lang.String getCreated_by() {
		return _data.getCreated_by();
	}

	@Override
	public java.lang.String toString() {
		return _data.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _data.toXmlString();
	}

	/**
	* Returns the creation_date of this data.
	*
	* @return the creation_date of this data
	*/
	@Override
	public Date getCreation_date() {
		return _data.getCreation_date();
	}

	@Override
	public void persist() {
		_data.persist();
	}

	/**
	* Sets the access of this data.
	*
	* @param access the access of this data
	*/
	@Override
	public void setAccess(int access) {
		_data.setAccess(access);
	}

	/**
	* Sets the album_id of this data.
	*
	* @param album_id the album_id of this data
	*/
	@Override
	public void setAlbum_id(int album_id) {
		_data.setAlbum_id(album_id);
	}

	/**
	* Sets the album_name of this data.
	*
	* @param album_name the album_name of this data
	*/
	@Override
	public void setAlbum_name(java.lang.String album_name) {
		_data.setAlbum_name(album_name);
	}

	/**
	* Sets the album_path of this data.
	*
	* @param album_path the album_path of this data
	*/
	@Override
	public void setAlbum_path(java.lang.String album_path) {
		_data.setAlbum_path(album_path);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_data.setCachedModel(cachedModel);
	}

	/**
	* Sets the created_by of this data.
	*
	* @param created_by the created_by of this data
	*/
	@Override
	public void setCreated_by(java.lang.String created_by) {
		_data.setCreated_by(created_by);
	}

	/**
	* Sets the creation_date of this data.
	*
	* @param creation_date the creation_date of this data
	*/
	@Override
	public void setCreation_date(Date creation_date) {
		_data.setCreation_date(creation_date);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_data.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_data.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_data.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_data.setNew(n);
	}

	/**
	* Sets the primary key of this data.
	*
	* @param primaryKey the primary key of this data
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_data.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_data.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataWrapper)) {
			return false;
		}

		DataWrapper dataWrapper = (DataWrapper)obj;

		if (Objects.equals(_data, dataWrapper._data)) {
			return true;
		}

		return false;
	}

	@Override
	public Data getWrappedModel() {
		return _data;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _data.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _data.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_data.resetOriginalValues();
	}

	private final Data _data;
}