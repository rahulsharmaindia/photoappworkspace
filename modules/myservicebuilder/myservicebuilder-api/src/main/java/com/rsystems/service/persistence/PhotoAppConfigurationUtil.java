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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.rsystems.model.PhotoAppConfiguration;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the photo app configuration service. This utility wraps {@link com.rsystems.service.persistence.impl.PhotoAppConfigurationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhotoAppConfigurationPersistence
 * @see com.rsystems.service.persistence.impl.PhotoAppConfigurationPersistenceImpl
 * @generated
 */
@ProviderType
public class PhotoAppConfigurationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PhotoAppConfiguration photoAppConfiguration) {
		getPersistence().clearCache(photoAppConfiguration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PhotoAppConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhotoAppConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhotoAppConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PhotoAppConfiguration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PhotoAppConfiguration update(
		PhotoAppConfiguration photoAppConfiguration) {
		return getPersistence().update(photoAppConfiguration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PhotoAppConfiguration update(
		PhotoAppConfiguration photoAppConfiguration,
		ServiceContext serviceContext) {
		return getPersistence().update(photoAppConfiguration, serviceContext);
	}

	/**
	* Returns all the photo app configurations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching photo app configurations
	*/
	public static List<PhotoAppConfiguration> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<PhotoAppConfiguration> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<PhotoAppConfiguration> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<PhotoAppConfiguration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<PhotoAppConfiguration> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<PhotoAppConfiguration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first photo app configuration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo app configuration
	* @throws NoSuchPhotoAppConfigurationException if a matching photo app configuration could not be found
	*/
	public static PhotoAppConfiguration findByUuid_First(
		java.lang.String uuid,
		OrderByComparator<PhotoAppConfiguration> orderByComparator)
		throws com.rsystems.exception.NoSuchPhotoAppConfigurationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first photo app configuration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching photo app configuration, or <code>null</code> if a matching photo app configuration could not be found
	*/
	public static PhotoAppConfiguration fetchByUuid_First(
		java.lang.String uuid,
		OrderByComparator<PhotoAppConfiguration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last photo app configuration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo app configuration
	* @throws NoSuchPhotoAppConfigurationException if a matching photo app configuration could not be found
	*/
	public static PhotoAppConfiguration findByUuid_Last(java.lang.String uuid,
		OrderByComparator<PhotoAppConfiguration> orderByComparator)
		throws com.rsystems.exception.NoSuchPhotoAppConfigurationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last photo app configuration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching photo app configuration, or <code>null</code> if a matching photo app configuration could not be found
	*/
	public static PhotoAppConfiguration fetchByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<PhotoAppConfiguration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the photo app configurations before and after the current photo app configuration in the ordered set where uuid = &#63;.
	*
	* @param configName the primary key of the current photo app configuration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next photo app configuration
	* @throws NoSuchPhotoAppConfigurationException if a photo app configuration with the primary key could not be found
	*/
	public static PhotoAppConfiguration[] findByUuid_PrevAndNext(
		java.lang.String configName, java.lang.String uuid,
		OrderByComparator<PhotoAppConfiguration> orderByComparator)
		throws com.rsystems.exception.NoSuchPhotoAppConfigurationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(configName, uuid, orderByComparator);
	}

	/**
	* Removes all the photo app configurations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of photo app configurations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching photo app configurations
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the photo app configuration in the entity cache if it is enabled.
	*
	* @param photoAppConfiguration the photo app configuration
	*/
	public static void cacheResult(PhotoAppConfiguration photoAppConfiguration) {
		getPersistence().cacheResult(photoAppConfiguration);
	}

	/**
	* Caches the photo app configurations in the entity cache if it is enabled.
	*
	* @param photoAppConfigurations the photo app configurations
	*/
	public static void cacheResult(
		List<PhotoAppConfiguration> photoAppConfigurations) {
		getPersistence().cacheResult(photoAppConfigurations);
	}

	/**
	* Creates a new photo app configuration with the primary key. Does not add the photo app configuration to the database.
	*
	* @param configName the primary key for the new photo app configuration
	* @return the new photo app configuration
	*/
	public static PhotoAppConfiguration create(java.lang.String configName) {
		return getPersistence().create(configName);
	}

	/**
	* Removes the photo app configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration that was removed
	* @throws NoSuchPhotoAppConfigurationException if a photo app configuration with the primary key could not be found
	*/
	public static PhotoAppConfiguration remove(java.lang.String configName)
		throws com.rsystems.exception.NoSuchPhotoAppConfigurationException {
		return getPersistence().remove(configName);
	}

	public static PhotoAppConfiguration updateImpl(
		PhotoAppConfiguration photoAppConfiguration) {
		return getPersistence().updateImpl(photoAppConfiguration);
	}

	/**
	* Returns the photo app configuration with the primary key or throws a {@link NoSuchPhotoAppConfigurationException} if it could not be found.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration
	* @throws NoSuchPhotoAppConfigurationException if a photo app configuration with the primary key could not be found
	*/
	public static PhotoAppConfiguration findByPrimaryKey(
		java.lang.String configName)
		throws com.rsystems.exception.NoSuchPhotoAppConfigurationException {
		return getPersistence().findByPrimaryKey(configName);
	}

	/**
	* Returns the photo app configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration, or <code>null</code> if a photo app configuration with the primary key could not be found
	*/
	public static PhotoAppConfiguration fetchByPrimaryKey(
		java.lang.String configName) {
		return getPersistence().fetchByPrimaryKey(configName);
	}

	public static java.util.Map<java.io.Serializable, PhotoAppConfiguration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the photo app configurations.
	*
	* @return the photo app configurations
	*/
	public static List<PhotoAppConfiguration> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PhotoAppConfiguration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PhotoAppConfiguration> findAll(int start, int end,
		OrderByComparator<PhotoAppConfiguration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PhotoAppConfiguration> findAll(int start, int end,
		OrderByComparator<PhotoAppConfiguration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the photo app configurations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of photo app configurations.
	*
	* @return the number of photo app configurations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PhotoAppConfigurationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhotoAppConfigurationPersistence, PhotoAppConfigurationPersistence> _serviceTracker =
		ServiceTrackerFactory.open(PhotoAppConfigurationPersistence.class);
}