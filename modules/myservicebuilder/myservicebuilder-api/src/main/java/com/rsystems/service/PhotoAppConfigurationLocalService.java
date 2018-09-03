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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.rsystems.model.PhotoAppConfiguration;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for PhotoAppConfiguration. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PhotoAppConfigurationLocalServiceUtil
 * @see com.rsystems.service.base.PhotoAppConfigurationLocalServiceBaseImpl
 * @see com.rsystems.service.impl.PhotoAppConfigurationLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PhotoAppConfigurationLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhotoAppConfigurationLocalServiceUtil} to access the photo app configuration local service. Add custom service methods to {@link com.rsystems.service.impl.PhotoAppConfigurationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public DynamicQuery dynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the photo app configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param photoAppConfiguration the photo app configuration
	* @return the photo app configuration that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public PhotoAppConfiguration addPhotoAppConfiguration(
		PhotoAppConfiguration photoAppConfiguration);

	/**
	* Creates a new photo app configuration with the primary key. Does not add the photo app configuration to the database.
	*
	* @param configName the primary key for the new photo app configuration
	* @return the new photo app configuration
	*/
	public PhotoAppConfiguration createPhotoAppConfiguration(
		java.lang.String configName);

	/**
	* Deletes the photo app configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param photoAppConfiguration the photo app configuration
	* @return the photo app configuration that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public PhotoAppConfiguration deletePhotoAppConfiguration(
		PhotoAppConfiguration photoAppConfiguration);

	/**
	* Deletes the photo app configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration that was removed
	* @throws PortalException if a photo app configuration with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public PhotoAppConfiguration deletePhotoAppConfiguration(
		java.lang.String configName) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PhotoAppConfiguration fetchPhotoAppConfiguration(
		java.lang.String configName);

	/**
	* Returns the photo app configuration with the primary key.
	*
	* @param configName the primary key of the photo app configuration
	* @return the photo app configuration
	* @throws PortalException if a photo app configuration with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PhotoAppConfiguration getPhotoAppConfiguration(
		java.lang.String configName) throws PortalException;

	/**
	* Updates the photo app configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param photoAppConfiguration the photo app configuration
	* @return the photo app configuration that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public PhotoAppConfiguration updatePhotoAppConfiguration(
		PhotoAppConfiguration photoAppConfiguration);

	/**
	* Returns the number of photo app configurations.
	*
	* @return the number of photo app configurations
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPhotoAppConfigurationsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PhotoAppConfiguration> getPhotoAppConfigurations(int start,
		int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}