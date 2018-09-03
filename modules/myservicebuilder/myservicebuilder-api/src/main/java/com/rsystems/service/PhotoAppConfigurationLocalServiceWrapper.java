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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PhotoAppConfigurationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhotoAppConfigurationLocalService
 * @generated
 */
@ProviderType
public class PhotoAppConfigurationLocalServiceWrapper
	implements PhotoAppConfigurationLocalService,
		ServiceWrapper<PhotoAppConfigurationLocalService> {
	public PhotoAppConfigurationLocalServiceWrapper(
		PhotoAppConfigurationLocalService photoAppConfigurationLocalService) {
		_photoAppConfigurationLocalService = photoAppConfigurationLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _photoAppConfigurationLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _photoAppConfigurationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _photoAppConfigurationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the photo app configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param photoAppConfiguration the photo app configuration
	* @return the photo app configuration that was added
	*/
	@Override
	public com.rsystems.model.PhotoAppConfiguration addPhotoAppConfiguration(
		com.rsystems.model.PhotoAppConfiguration photoAppConfiguration) {
		return _photoAppConfigurationLocalService.addPhotoAppConfiguration(photoAppConfiguration);
	}

	/**
	* Creates a new photo app configuration with the primary key. Does not add the photo app configuration to the database.
	*
	* @param configName the primary key for the new photo app configuration
	* @return the new photo app configuration
	*/
	@Override
	public com.rsystems.model.PhotoAppConfiguration createPhotoAppConfiguration(
		java.lang.String configName) {
		return _photoAppConfigurationLocalService.createPhotoAppConfiguration(configName);
	}

	/**
	* Deletes the photo app configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param photoAppConfiguration the photo app configuration
	* @return the photo app configuration that was removed
	*/
	@Override
	public com.rsystems.model.PhotoAppConfiguration deletePhotoAppConfiguration(
		com.rsystems.model.PhotoAppConfiguration photoAppConfiguration) {
		return _photoAppConfigurationLocalService.deletePhotoAppConfiguration(photoAppConfiguration);
	}

	/**
	* Deletes the photo app configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration that was removed
	* @throws PortalException if a photo app configuration with the primary key could not be found
	*/
	@Override
	public com.rsystems.model.PhotoAppConfiguration deletePhotoAppConfiguration(
		java.lang.String configName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _photoAppConfigurationLocalService.deletePhotoAppConfiguration(configName);
	}

	@Override
	public com.rsystems.model.PhotoAppConfiguration fetchPhotoAppConfiguration(
		java.lang.String configName) {
		return _photoAppConfigurationLocalService.fetchPhotoAppConfiguration(configName);
	}

	/**
	* Returns the photo app configuration with the primary key.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration
	* @throws PortalException if a photo app configuration with the primary key could not be found
	*/
	@Override
	public com.rsystems.model.PhotoAppConfiguration getPhotoAppConfiguration(
		java.lang.String configName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _photoAppConfigurationLocalService.getPhotoAppConfiguration(configName);
	}

	/**
	* Updates the photo app configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param photoAppConfiguration the photo app configuration
	* @return the photo app configuration that was updated
	*/
	@Override
	public com.rsystems.model.PhotoAppConfiguration updatePhotoAppConfiguration(
		com.rsystems.model.PhotoAppConfiguration photoAppConfiguration) {
		return _photoAppConfigurationLocalService.updatePhotoAppConfiguration(photoAppConfiguration);
	}

	/**
	* Returns the number of photo app configurations.
	*
	* @return the number of photo app configurations
	*/
	@Override
	public int getPhotoAppConfigurationsCount() {
		return _photoAppConfigurationLocalService.getPhotoAppConfigurationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _photoAppConfigurationLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _photoAppConfigurationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _photoAppConfigurationLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _photoAppConfigurationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
	@Override
	public java.util.List<com.rsystems.model.PhotoAppConfiguration> getPhotoAppConfigurations(
		int start, int end) {
		return _photoAppConfigurationLocalService.getPhotoAppConfigurations(start,
			end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _photoAppConfigurationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _photoAppConfigurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public PhotoAppConfigurationLocalService getWrappedService() {
		return _photoAppConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		PhotoAppConfigurationLocalService photoAppConfigurationLocalService) {
		_photoAppConfigurationLocalService = photoAppConfigurationLocalService;
	}

	private PhotoAppConfigurationLocalService _photoAppConfigurationLocalService;
}