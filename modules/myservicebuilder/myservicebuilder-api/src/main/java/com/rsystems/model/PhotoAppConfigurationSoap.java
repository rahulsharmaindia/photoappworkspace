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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rsystems.service.http.PhotoAppConfigurationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rsystems.service.http.PhotoAppConfigurationServiceSoap
 * @generated
 */
@ProviderType
public class PhotoAppConfigurationSoap implements Serializable {
	public static PhotoAppConfigurationSoap toSoapModel(
		PhotoAppConfiguration model) {
		PhotoAppConfigurationSoap soapModel = new PhotoAppConfigurationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setConfigName(model.getConfigName());
		soapModel.setValue1(model.getValue1());
		soapModel.setValue2(model.getValue2());
		soapModel.setValue3(model.getValue3());
		soapModel.setValue4(model.getValue4());

		return soapModel;
	}

	public static PhotoAppConfigurationSoap[] toSoapModels(
		PhotoAppConfiguration[] models) {
		PhotoAppConfigurationSoap[] soapModels = new PhotoAppConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhotoAppConfigurationSoap[][] toSoapModels(
		PhotoAppConfiguration[][] models) {
		PhotoAppConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhotoAppConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhotoAppConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhotoAppConfigurationSoap[] toSoapModels(
		List<PhotoAppConfiguration> models) {
		List<PhotoAppConfigurationSoap> soapModels = new ArrayList<PhotoAppConfigurationSoap>(models.size());

		for (PhotoAppConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhotoAppConfigurationSoap[soapModels.size()]);
	}

	public PhotoAppConfigurationSoap() {
	}

	public String getPrimaryKey() {
		return _configName;
	}

	public void setPrimaryKey(String pk) {
		setConfigName(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getConfigName() {
		return _configName;
	}

	public void setConfigName(String configName) {
		_configName = configName;
	}

	public String getValue1() {
		return _value1;
	}

	public void setValue1(String value1) {
		_value1 = value1;
	}

	public String getValue2() {
		return _value2;
	}

	public void setValue2(String value2) {
		_value2 = value2;
	}

	public String getValue3() {
		return _value3;
	}

	public void setValue3(String value3) {
		_value3 = value3;
	}

	public String getValue4() {
		return _value4;
	}

	public void setValue4(String value4) {
		_value4 = value4;
	}

	private String _uuid;
	private String _configName;
	private String _value1;
	private String _value2;
	private String _value3;
	private String _value4;
}