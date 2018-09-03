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

import org.rsystems.share.service.persistence.AlbumPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.rsystems.share.service.http.AlbumServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see org.rsystems.share.service.http.AlbumServiceSoap
 * @generated
 */
@ProviderType
public class AlbumSoap implements Serializable {
	public static AlbumSoap toSoapModel(Album model) {
		AlbumSoap soapModel = new AlbumSoap();

		soapModel.setAlbum_id(model.getAlbum_id());
		soapModel.setShared_user(model.getShared_user());
		soapModel.setAlbum_name(model.getAlbum_name());

		return soapModel;
	}

	public static AlbumSoap[] toSoapModels(Album[] models) {
		AlbumSoap[] soapModels = new AlbumSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AlbumSoap[][] toSoapModels(Album[][] models) {
		AlbumSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AlbumSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AlbumSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AlbumSoap[] toSoapModels(List<Album> models) {
		List<AlbumSoap> soapModels = new ArrayList<AlbumSoap>(models.size());

		for (Album model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AlbumSoap[soapModels.size()]);
	}

	public AlbumSoap() {
	}

	public AlbumPK getPrimaryKey() {
		return new AlbumPK(_album_id, _shared_user);
	}

	public void setPrimaryKey(AlbumPK pk) {
		setAlbum_id(pk.album_id);
		setShared_user(pk.shared_user);
	}

	public int getAlbum_id() {
		return _album_id;
	}

	public void setAlbum_id(int album_id) {
		_album_id = album_id;
	}

	public String getShared_user() {
		return _shared_user;
	}

	public void setShared_user(String shared_user) {
		_shared_user = shared_user;
	}

	public String getAlbum_name() {
		return _album_name;
	}

	public void setAlbum_name(String album_name) {
		_album_name = album_name;
	}

	private int _album_id;
	private String _shared_user;
	private String _album_name;
}