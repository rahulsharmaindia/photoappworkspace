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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.rsystems.service.http.DataServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see org.rsystems.service.http.DataServiceSoap
 * @generated
 */
@ProviderType
public class DataSoap implements Serializable {
	public static DataSoap toSoapModel(Data model) {
		DataSoap soapModel = new DataSoap();

		soapModel.setAlbum_id(model.getAlbum_id());
		soapModel.setAlbum_name(model.getAlbum_name());
		soapModel.setAlbum_path(model.getAlbum_path());
		soapModel.setCreation_date(model.getCreation_date());
		soapModel.setCreated_by(model.getCreated_by());
		soapModel.setAccess(model.getAccess());

		return soapModel;
	}

	public static DataSoap[] toSoapModels(Data[] models) {
		DataSoap[] soapModels = new DataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataSoap[][] toSoapModels(Data[][] models) {
		DataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataSoap[] toSoapModels(List<Data> models) {
		List<DataSoap> soapModels = new ArrayList<DataSoap>(models.size());

		for (Data model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataSoap[soapModels.size()]);
	}

	public DataSoap() {
	}

	public int getPrimaryKey() {
		return _album_id;
	}

	public void setPrimaryKey(int pk) {
		setAlbum_id(pk);
	}

	public int getAlbum_id() {
		return _album_id;
	}

	public void setAlbum_id(int album_id) {
		_album_id = album_id;
	}

	public String getAlbum_name() {
		return _album_name;
	}

	public void setAlbum_name(String album_name) {
		_album_name = album_name;
	}

	public String getAlbum_path() {
		return _album_path;
	}

	public void setAlbum_path(String album_path) {
		_album_path = album_path;
	}

	public Date getCreation_date() {
		return _creation_date;
	}

	public void setCreation_date(Date creation_date) {
		_creation_date = creation_date;
	}

	public String getCreated_by() {
		return _created_by;
	}

	public void setCreated_by(String created_by) {
		_created_by = created_by;
	}

	public int getAccess() {
		return _access;
	}

	public void setAccess(int access) {
		_access = access;
	}

	private int _album_id;
	private String _album_name;
	private String _album_path;
	private Date _creation_date;
	private String _created_by;
	private int _access;
}