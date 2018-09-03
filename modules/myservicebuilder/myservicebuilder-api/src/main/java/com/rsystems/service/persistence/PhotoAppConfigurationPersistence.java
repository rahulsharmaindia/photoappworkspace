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

package com.rsystems.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.rsystems.exception.NoSuchPhotoAppConfigurationException;

import com.rsystems.model.PhotoAppConfiguration;

/**
 * The persistence interface for the photo app configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rsystems.service.persistence.impl.PhotoAppConfigurationPersistenceImpl
 * @see PhotoAppConfigurationUtil
 * @generated
 */
@ProviderType
public interface PhotoAppConfigurationPersistence extends BasePersistence<PhotoAppConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhotoAppConfigurationUtil} to access the photo app configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the photo app configurations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching photo app configurations
	*/
	public java.util.List<PhotoAppConfiguration> findByUuid(
		java.lang.String uuid);

	/**
	* Returns a range of all the photo app configurations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhotoAppConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of photo app configurations
	* @param end the upper bound of the range of photo app configurations (not inclusive)
	* @return the range of matching photo app configurations
	*/
	public java.util.List<PhotoAppConfiguration> findByUuid(
		java.lang.String uuid, int start, int end);

	/**
	* Returns an ordered range of all the photo app configurations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhotoAppConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of photo app configurations
	* @param end the upper bound of the range of photo app configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching photo app configurations
	*/
	public java.util.List<PhotoAppConfiguration> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhotoAppConfiguration> orderByComparator);

	/**
	* Returns an ordered range of all the photo app configurations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhotoAppConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of photo app configurations
	* @param end the upper bound of the range of photo app configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching photo app configurations
	*/
	public java.util.List<PhotoAppConfiguration> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhotoAppConfiguration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first photo app configuration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo app configuration
	* @throws NoSuchPhotoAppConfigurationException if a matching photo app configuration could not be found
	*/
	public PhotoAppConfiguration findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhotoAppConfiguration> orderByComparator)
		throws NoSuchPhotoAppConfigurationException;

	/**
	* Returns the first photo app configuration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo app configuration, or <code>null</code> if a matching photo app configuration could not be found
	*/
	public PhotoAppConfiguration fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhotoAppConfiguration> orderByComparator);

	/**
	* Returns the last photo app configuration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo app configuration
	* @throws NoSuchPhotoAppConfigurationException if a matching photo app configuration could not be found
	*/
	public PhotoAppConfiguration findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhotoAppConfiguration> orderByComparator)
		throws NoSuchPhotoAppConfigurationException;

	/**
	* Returns the last photo app configuration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo app configuration, or <code>null</code> if a matching photo app configuration could not be found
	*/
	public PhotoAppConfiguration fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhotoAppConfiguration> orderByComparator);

	/**
	* Returns the photo app configurations before and after the current photo app configuration in the ordered set where uuid = &#63;.
	*
	* @param configName the primary key of the current photo app configuration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next photo app configuration
	* @throws NoSuchPhotoAppConfigurationException if a photo app configuration with the primary key could not be found
	*/
	public PhotoAppConfiguration[] findByUuid_PrevAndNext(
		java.lang.String configName, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PhotoAppConfiguration> orderByComparator)
		throws NoSuchPhotoAppConfigurationException;

	/**
	* Removes all the photo app configurations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of photo app configurations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching photo app configurations
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the photo app configuration in the entity cache if it is enabled.
	*
	* @param photoAppConfiguration the photo app configuration
	*/
	public void cacheResult(PhotoAppConfiguration photoAppConfiguration);

	/**
	* Caches the photo app configurations in the entity cache if it is enabled.
	*
	* @param photoAppConfigurations the photo app configurations
	*/
	public void cacheResult(
		java.util.List<PhotoAppConfiguration> photoAppConfigurations);

	/**
	* Creates a new photo app configuration with the primary key. Does not add the photo app configuration to the database.
	*
	* @param configName the primary key for the new photo app configuration
	* @return the new photo app configuration
	*/
	public PhotoAppConfiguration create(java.lang.String configName);

	/**
	* Removes the photo app configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration that was removed
	* @throws NoSuchPhotoAppConfigurationException if a photo app configuration with the primary key could not be found
	*/
	public PhotoAppConfiguration remove(java.lang.String configName)
		throws NoSuchPhotoAppConfigurationException;

	public PhotoAppConfiguration updateImpl(
		PhotoAppConfiguration photoAppConfiguration);

	/**
	* Returns the photo app configuration with the primary key or throws a {@link NoSuchPhotoAppConfigurationException} if it could not be found.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration
	* @throws NoSuchPhotoAppConfigurationException if a photo app configuration with the primary key could not be found
	*/
	public PhotoAppConfiguration findByPrimaryKey(java.lang.String configName)
		throws NoSuchPhotoAppConfigurationException;

	/**
	* Returns the photo app configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration, or <code>null</code> if a photo app configuration with the primary key could not be found
	*/
	public PhotoAppConfiguration fetchByPrimaryKey(java.lang.String configName);

	@Override
	public java.util.Map<java.io.Serializable, PhotoAppConfiguration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the photo app configurations.
	*
	* @return the photo app configurations
	*/
	public java.util.List<PhotoAppConfiguration> findAll();

	/**
	* Returns a range of all the photo app configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhotoAppConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of photo app configurations
	* @param end the upper bound of the range of photo app configurations (not inclusive)
	* @return the range of photo app configurations
	*/
	public java.util.List<PhotoAppConfiguration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the photo app configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhotoAppConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of photo app configurations
	* @param end the upper bound of the range of photo app configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of photo app configurations
	*/
	public java.util.List<PhotoAppConfiguration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhotoAppConfiguration> orderByComparator);

	/**
	* Returns an ordered range of all the photo app configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PhotoAppConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of photo app configurations
	* @param end the upper bound of the range of photo app configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of photo app configurations
	*/
	public java.util.List<PhotoAppConfiguration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhotoAppConfiguration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the photo app configurations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of photo app configurations.
	*
	* @return the number of photo app configurations
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}