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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.rsystems.share.model.Album;
import org.rsystems.share.model.AlbumModel;
import org.rsystems.share.model.AlbumSoap;
import org.rsystems.share.service.persistence.AlbumPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Album service. Represents a row in the &quot;Share_Album&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link AlbumModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AlbumImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AlbumImpl
 * @see Album
 * @see AlbumModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class AlbumModelImpl extends BaseModelImpl<Album> implements AlbumModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a album model instance should use the {@link Album} interface instead.
	 */
	public static final String TABLE_NAME = "Share_Album";
	public static final Object[][] TABLE_COLUMNS = {
			{ "album_id", Types.INTEGER },
			{ "shared_user", Types.VARCHAR },
			{ "album_name", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("album_id", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("shared_user", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("album_name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Share_Album (album_id INTEGER not null,shared_user VARCHAR(75) not null,album_name VARCHAR(75) null,primary key (album_id, shared_user))";
	public static final String TABLE_SQL_DROP = "drop table Share_Album";
	public static final String ORDER_BY_JPQL = " ORDER BY album.id.album_id ASC, album.id.shared_user ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Share_Album.album_id ASC, Share_Album.shared_user ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.rsystems.share.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.rsystems.share.model.Album"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.rsystems.share.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.rsystems.share.model.Album"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Album toModel(AlbumSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Album model = new AlbumImpl();

		model.setAlbum_id(soapModel.getAlbum_id());
		model.setShared_user(soapModel.getShared_user());
		model.setAlbum_name(soapModel.getAlbum_name());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Album> toModels(AlbumSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Album> models = new ArrayList<Album>(soapModels.length);

		for (AlbumSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.rsystems.share.service.util.ServiceProps.get(
				"lock.expiration.time.org.rsystems.share.model.Album"));

	public AlbumModelImpl() {
	}

	@Override
	public AlbumPK getPrimaryKey() {
		return new AlbumPK(_album_id, _shared_user);
	}

	@Override
	public void setPrimaryKey(AlbumPK primaryKey) {
		setAlbum_id(primaryKey.album_id);
		setShared_user(primaryKey.shared_user);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AlbumPK(_album_id, _shared_user);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AlbumPK)primaryKeyObj);
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public int getAlbum_id() {
		return _album_id;
	}

	@Override
	public void setAlbum_id(int album_id) {
		_album_id = album_id;
	}

	@JSON
	@Override
	public String getShared_user() {
		if (_shared_user == null) {
			return StringPool.BLANK;
		}
		else {
			return _shared_user;
		}
	}

	@Override
	public void setShared_user(String shared_user) {
		_shared_user = shared_user;
	}

	@JSON
	@Override
	public String getAlbum_name() {
		if (_album_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _album_name;
		}
	}

	@Override
	public void setAlbum_name(String album_name) {
		_album_name = album_name;
	}

	@Override
	public Album toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Album)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AlbumImpl albumImpl = new AlbumImpl();

		albumImpl.setAlbum_id(getAlbum_id());
		albumImpl.setShared_user(getShared_user());
		albumImpl.setAlbum_name(getAlbum_name());

		albumImpl.resetOriginalValues();

		return albumImpl;
	}

	@Override
	public int compareTo(Album album) {
		AlbumPK primaryKey = album.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Album)) {
			return false;
		}

		Album album = (Album)obj;

		AlbumPK primaryKey = album.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Album> toCacheModel() {
		AlbumCacheModel albumCacheModel = new AlbumCacheModel();

		albumCacheModel.albumPK = getPrimaryKey();

		albumCacheModel.album_id = getAlbum_id();

		albumCacheModel.shared_user = getShared_user();

		String shared_user = albumCacheModel.shared_user;

		if ((shared_user != null) && (shared_user.length() == 0)) {
			albumCacheModel.shared_user = null;
		}

		albumCacheModel.album_name = getAlbum_name();

		String album_name = albumCacheModel.album_name;

		if ((album_name != null) && (album_name.length() == 0)) {
			albumCacheModel.album_name = null;
		}

		return albumCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{album_id=");
		sb.append(getAlbum_id());
		sb.append(", shared_user=");
		sb.append(getShared_user());
		sb.append(", album_name=");
		sb.append(getAlbum_name());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.rsystems.share.model.Album");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>album_id</column-name><column-value><![CDATA[");
		sb.append(getAlbum_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shared_user</column-name><column-value><![CDATA[");
		sb.append(getShared_user());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>album_name</column-name><column-value><![CDATA[");
		sb.append(getAlbum_name());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Album.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Album.class
		};
	private int _album_id;
	private String _shared_user;
	private String _album_name;
	private Album _escapedModel;
}