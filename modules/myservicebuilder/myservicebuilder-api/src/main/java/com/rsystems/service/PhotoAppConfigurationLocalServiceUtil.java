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

package com.rsystems.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for PhotoAppConfiguration. This utility wraps
 * {@link com.rsystems.service.impl.PhotoAppConfigurationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PhotoAppConfigurationLocalService
 * @see com.rsystems.service.base.PhotoAppConfigurationLocalServiceBaseImpl
 * @see com.rsystems.service.impl.PhotoAppConfigurationLocalServiceImpl
 * @generated
 */
@ProviderType
public class PhotoAppConfigurationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rsystems.service.impl.PhotoAppConfigurationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the photo app configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param photoAppConfiguration the photo app configuration
	* @return the photo app configuration that was added
	*/
	public static com.rsystems.model.PhotoAppConfiguration addPhotoAppConfiguration(
		com.rsystems.model.PhotoAppConfiguration photoAppConfiguration) {
		return getService().addPhotoAppConfiguration(photoAppConfiguration);
	}

	/**
	* Creates a new photo app configuration with the primary key. Does not add the photo app configuration to the database.
	*
	* @param configName the primary key for the new photo app configuration
	* @return the new photo app configuration
	*/
	public static com.rsystems.model.PhotoAppConfiguration createPhotoAppConfiguration(
		java.lang.String configName) {
		return getService().createPhotoAppConfiguration(configName);
	}

	/**
	* Deletes the photo app configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param photoAppConfiguration the photo app configuration
	* @return the photo app configuration that was removed
	*/
	public static com.rsystems.model.PhotoAppConfiguration deletePhotoAppConfiguration(
		com.rsystems.model.PhotoAppConfiguration photoAppConfiguration) {
		return getService().deletePhotoAppConfiguration(photoAppConfiguration);
	}

	/**
	* Deletes the photo app configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration that was removed
	* @throws PortalException if a photo app configuration with the primary key could not be found
	*/
	public static com.rsystems.model.PhotoAppConfiguration deletePhotoAppConfiguration(
		java.lang.String configName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePhotoAppConfiguration(configName);
	}

	public static com.rsystems.model.PhotoAppConfiguration fetchPhotoAppConfiguration(
		java.lang.String configName) {
		return getService().fetchPhotoAppConfiguration(configName);
	}

	/**
	* Returns the photo app configuration with the primary key.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration
	* @throws PortalException if a photo app configuration with the primary key could not be found
	*/
	public static com.rsystems.model.PhotoAppConfiguration getPhotoAppConfiguration(
		java.lang.String configName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPhotoAppConfiguration(configName);
	}

	/**
	* Updates the photo app configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param photoAppConfiguration the photo app configuration
	* @return the photo app configuration that was updated
	*/
	public static com.rsystems.model.PhotoAppConfiguration updatePhotoAppConfiguration(
		com.rsystems.model.PhotoAppConfiguration photoAppConfiguration) {
		return getService().updatePhotoAppConfiguration(photoAppConfiguration);
	}

	/**
	* Returns the number of photo app configurations.
	*
	* @return the number of photo app configurations
	*/
	public static int getPhotoAppConfigurationsCount() {
		return getService().getPhotoAppConfigurationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rsystems.model.impl.PhotoAppConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rsystems.model.impl.PhotoAppConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the photo app configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rsystems.model.impl.PhotoAppConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of photo app configurations
	* @param end the upper bound of the range of photo app configurations (not inclusive)
	* @return the range of photo app configurations
	*/
	public static java.util.List<com.rsystems.model.PhotoAppConfiguration> getPhotoAppConfigurations(
		int start, int end) {
		return getService().getPhotoAppConfigurations(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static PhotoAppConfigurationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhotoAppConfigurationLocalService, PhotoAppConfigurationLocalService> _serviceTracker =
		ServiceTrackerFactory.open(PhotoAppConfigurationLocalService.class);
}