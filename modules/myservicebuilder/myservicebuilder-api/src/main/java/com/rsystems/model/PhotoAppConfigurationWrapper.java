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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link PhotoAppConfiguration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhotoAppConfiguration
 * @generated
 */
@ProviderType
public class PhotoAppConfigurationWrapper implements PhotoAppConfiguration,
	ModelWrapper<PhotoAppConfiguration> {
	public PhotoAppConfigurationWrapper(
		PhotoAppConfiguration photoAppConfiguration) {
		_photoAppConfiguration = photoAppConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return PhotoAppConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return PhotoAppConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("configName", getConfigName());
		attributes.put("value1", getValue1());
		attributes.put("value2", getValue2());
		attributes.put("value3", getValue3());
		attributes.put("value4", getValue4());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String configName = (String)attributes.get("configName");

		if (configName != null) {
			setConfigName(configName);
		}

		String value1 = (String)attributes.get("value1");

		if (value1 != null) {
			setValue1(value1);
		}

		String value2 = (String)attributes.get("value2");

		if (value2 != null) {
			setValue2(value2);
		}

		String value3 = (String)attributes.get("value3");

		if (value3 != null) {
			setValue3(value3);
		}

		String value4 = (String)attributes.get("value4");

		if (value4 != null) {
			setValue4(value4);
		}
	}

	@Override
	public PhotoAppConfiguration toEscapedModel() {
		return new PhotoAppConfigurationWrapper(_photoAppConfiguration.toEscapedModel());
	}

	@Override
	public PhotoAppConfiguration toUnescapedModel() {
		return new PhotoAppConfigurationWrapper(_photoAppConfiguration.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _photoAppConfiguration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _photoAppConfiguration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _photoAppConfiguration.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _photoAppConfiguration.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PhotoAppConfiguration> toCacheModel() {
		return _photoAppConfiguration.toCacheModel();
	}

	@Override
	public int compareTo(PhotoAppConfiguration photoAppConfiguration) {
		return _photoAppConfiguration.compareTo(photoAppConfiguration);
	}

	@Override
	public int hashCode() {
		return _photoAppConfiguration.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _photoAppConfiguration.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PhotoAppConfigurationWrapper((PhotoAppConfiguration)_photoAppConfiguration.clone());
	}

	/**
	* Returns the config name of this photo app configuration.
	*
	* @return the config name of this photo app configuration
	*/
	@Override
	public java.lang.String getConfigName() {
		return _photoAppConfiguration.getConfigName();
	}

	/**
	* Returns the primary key of this photo app configuration.
	*
	* @return the primary key of this photo app configuration
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _photoAppConfiguration.getPrimaryKey();
	}

	/**
	* Returns the uuid of this photo app configuration.
	*
	* @return the uuid of this photo app configuration
	*/
	@Override
	public java.lang.String getUuid() {
		return _photoAppConfiguration.getUuid();
	}

	/**
	* Returns the value1 of this photo app configuration.
	*
	* @return the value1 of this photo app configuration
	*/
	@Override
	public java.lang.String getValue1() {
		return _photoAppConfiguration.getValue1();
	}

	/**
	* Returns the value2 of this photo app configuration.
	*
	* @return the value2 of this photo app configuration
	*/
	@Override
	public java.lang.String getValue2() {
		return _photoAppConfiguration.getValue2();
	}

	/**
	* Returns the value3 of this photo app configuration.
	*
	* @return the value3 of this photo app configuration
	*/
	@Override
	public java.lang.String getValue3() {
		return _photoAppConfiguration.getValue3();
	}

	/**
	* Returns the value4 of this photo app configuration.
	*
	* @return the value4 of this photo app configuration
	*/
	@Override
	public java.lang.String getValue4() {
		return _photoAppConfiguration.getValue4();
	}

	@Override
	public java.lang.String toString() {
		return _photoAppConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _photoAppConfiguration.toXmlString();
	}

	@Override
	public void persist() {
		_photoAppConfiguration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_photoAppConfiguration.setCachedModel(cachedModel);
	}

	/**
	* Sets the config name of this photo app configuration.
	*
	* @param configName the config name of this photo app configuration
	*/
	@Override
	public void setConfigName(java.lang.String configName) {
		_photoAppConfiguration.setConfigName(configName);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_photoAppConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_photoAppConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_photoAppConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_photoAppConfiguration.setNew(n);
	}

	/**
	* Sets the primary key of this photo app configuration.
	*
	* @param primaryKey the primary key of this photo app configuration
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_photoAppConfiguration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_photoAppConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this photo app configuration.
	*
	* @param uuid the uuid of this photo app configuration
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_photoAppConfiguration.setUuid(uuid);
	}

	/**
	* Sets the value1 of this photo app configuration.
	*
	* @param value1 the value1 of this photo app configuration
	*/
	@Override
	public void setValue1(java.lang.String value1) {
		_photoAppConfiguration.setValue1(value1);
	}

	/**
	* Sets the value2 of this photo app configuration.
	*
	* @param value2 the value2 of this photo app configuration
	*/
	@Override
	public void setValue2(java.lang.String value2) {
		_photoAppConfiguration.setValue2(value2);
	}

	/**
	* Sets the value3 of this photo app configuration.
	*
	* @param value3 the value3 of this photo app configuration
	*/
	@Override
	public void setValue3(java.lang.String value3) {
		_photoAppConfiguration.setValue3(value3);
	}

	/**
	* Sets the value4 of this photo app configuration.
	*
	* @param value4 the value4 of this photo app configuration
	*/
	@Override
	public void setValue4(java.lang.String value4) {
		_photoAppConfiguration.setValue4(value4);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhotoAppConfigurationWrapper)) {
			return false;
		}

		PhotoAppConfigurationWrapper photoAppConfigurationWrapper = (PhotoAppConfigurationWrapper)obj;

		if (Objects.equals(_photoAppConfiguration,
					photoAppConfigurationWrapper._photoAppConfiguration)) {
			return true;
		}

		return false;
	}

	@Override
	public PhotoAppConfiguration getWrappedModel() {
		return _photoAppConfiguration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _photoAppConfiguration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _photoAppConfiguration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_photoAppConfiguration.resetOriginalValues();
	}

	private final PhotoAppConfiguration _photoAppConfiguration;
}