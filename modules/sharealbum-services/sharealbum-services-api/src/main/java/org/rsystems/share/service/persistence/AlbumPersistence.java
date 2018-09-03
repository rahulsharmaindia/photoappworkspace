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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.rsystems.share.exception.NoSuchAlbumException;
import org.rsystems.share.model.Album;

/**
 * The persistence interface for the album service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.rsystems.share.service.persistence.impl.AlbumPersistenceImpl
 * @see AlbumUtil
 * @generated
 */
@ProviderType
public interface AlbumPersistence extends BasePersistence<Album> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AlbumUtil} to access the album persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the album in the entity cache if it is enabled.
	*
	* @param album the album
	*/
	public void cacheResult(Album album);

	/**
	* Caches the albums in the entity cache if it is enabled.
	*
	* @param albums the albums
	*/
	public void cacheResult(java.util.List<Album> albums);

	/**
	* Creates a new album with the primary key. Does not add the album to the database.
	*
	* @param albumPK the primary key for the new album
	* @return the new album
	*/
	public Album create(AlbumPK albumPK);

	/**
	* Removes the album with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param albumPK the primary key of the album
	* @return the album that was removed
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public Album remove(AlbumPK albumPK) throws NoSuchAlbumException;

	public Album updateImpl(Album album);

	/**
	* Returns the album with the primary key or throws a {@link NoSuchAlbumException} if it could not be found.
	*
	* @param albumPK the primary key of the album
	* @return the album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public Album findByPrimaryKey(AlbumPK albumPK) throws NoSuchAlbumException;

	/**
	* Returns the album with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param albumPK the primary key of the album
	* @return the album, or <code>null</code> if a album with the primary key could not be found
	*/
	public Album fetchByPrimaryKey(AlbumPK albumPK);

	@Override
	public java.util.Map<java.io.Serializable, Album> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the albums.
	*
	* @return the albums
	*/
	public java.util.List<Album> findAll();

	/**
	* Returns a range of all the albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of albums
	*/
	public java.util.List<Album> findAll(int start, int end);

	/**
	* Returns an ordered range of all the albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of albums
	*/
	public java.util.List<Album> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Album> orderByComparator);

	/**
	* Returns an ordered range of all the albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of albums
	*/
	public java.util.List<Album> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Album> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the albums from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of albums.
	*
	* @return the number of albums
	*/
	public int countAll();
}