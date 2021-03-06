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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Data service. Represents a row in the &quot;Album_Data&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.rsystems.model.impl.DataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.rsystems.model.impl.DataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Data
 * @see org.rsystems.model.impl.DataImpl
 * @see org.rsystems.model.impl.DataModelImpl
 * @generated
 */
@ProviderType
public interface DataModel extends BaseModel<Data> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a data model instance should use the {@link Data} interface instead.
	 */

	/**
	 * Returns the primary key of this data.
	 *
	 * @return the primary key of this data
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this data.
	 *
	 * @param primaryKey the primary key of this data
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the album_id of this data.
	 *
	 * @return the album_id of this data
	 */
	public int getAlbum_id();

	/**
	 * Sets the album_id of this data.
	 *
	 * @param album_id the album_id of this data
	 */
	public void setAlbum_id(int album_id);

	/**
	 * Returns the album_name of this data.
	 *
	 * @return the album_name of this data
	 */
	@AutoEscape
	public String getAlbum_name();

	/**
	 * Sets the album_name of this data.
	 *
	 * @param album_name the album_name of this data
	 */
	public void setAlbum_name(String album_name);

	/**
	 * Returns the album_path of this data.
	 *
	 * @return the album_path of this data
	 */
	@AutoEscape
	public String getAlbum_path();

	/**
	 * Sets the album_path of this data.
	 *
	 * @param album_path the album_path of this data
	 */
	public void setAlbum_path(String album_path);

	/**
	 * Returns the creation_date of this data.
	 *
	 * @return the creation_date of this data
	 */
	public Date getCreation_date();

	/**
	 * Sets the creation_date of this data.
	 *
	 * @param creation_date the creation_date of this data
	 */
	public void setCreation_date(Date creation_date);

	/**
	 * Returns the created_by of this data.
	 *
	 * @return the created_by of this data
	 */
	@AutoEscape
	public String getCreated_by();

	/**
	 * Sets the created_by of this data.
	 *
	 * @param created_by the created_by of this data
	 */
	public void setCreated_by(String created_by);

	/**
	 * Returns the access of this data.
	 *
	 * @return the access of this data
	 */
	public int getAccess();

	/**
	 * Sets the access of this data.
	 *
	 * @param access the access of this data
	 */
	public void setAccess(int access);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Data data);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Data> toCacheModel();

	@Override
	public Data toEscapedModel();

	@Override
	public Data toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}