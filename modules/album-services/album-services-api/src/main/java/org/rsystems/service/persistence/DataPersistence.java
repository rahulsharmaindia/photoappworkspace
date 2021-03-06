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

package org.rsystems.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.rsystems.exception.NoSuchDataException;

import org.rsystems.model.Data;

/**
 * The persistence interface for the data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.rsystems.service.persistence.impl.DataPersistenceImpl
 * @see DataUtil
 * @generated
 */
@ProviderType
public interface DataPersistence extends BasePersistence<Data> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataUtil} to access the data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the data in the entity cache if it is enabled.
	*
	* @param data the data
	*/
	public void cacheResult(Data data);

	/**
	* Caches the datas in the entity cache if it is enabled.
	*
	* @param datas the datas
	*/
	public void cacheResult(java.util.List<Data> datas);

	/**
	* Creates a new data with the primary key. Does not add the data to the database.
	*
	* @param album_id the primary key for the new data
	* @return the new data
	*/
	public Data create(int album_id);

	/**
	* Removes the data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param album_id the primary key of the data
	* @return the data that was removed
	* @throws NoSuchDataException if a data with the primary key could not be found
	*/
	public Data remove(int album_id) throws NoSuchDataException;

	public Data updateImpl(Data data);

	/**
	* Returns the data with the primary key or throws a {@link NoSuchDataException} if it could not be found.
	*
	* @param album_id the primary key of the data
	* @return the data
	* @throws NoSuchDataException if a data with the primary key could not be found
	*/
	public Data findByPrimaryKey(int album_id) throws NoSuchDataException;

	/**
	* Returns the data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param album_id the primary key of the data
	* @return the data, or <code>null</code> if a data with the primary key could not be found
	*/
	public Data fetchByPrimaryKey(int album_id);

	@Override
	public java.util.Map<java.io.Serializable, Data> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the datas.
	*
	* @return the datas
	*/
	public java.util.List<Data> findAll();

	/**
	* Returns a range of all the datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of datas
	* @param end the upper bound of the range of datas (not inclusive)
	* @return the range of datas
	*/
	public java.util.List<Data> findAll(int start, int end);

	/**
	* Returns an ordered range of all the datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of datas
	* @param end the upper bound of the range of datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of datas
	*/
	public java.util.List<Data> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Data> orderByComparator);

	/**
	* Returns an ordered range of all the datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of datas
	* @param end the upper bound of the range of datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of datas
	*/
	public java.util.List<Data> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Data> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the datas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of datas.
	*
	* @return the number of datas
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}