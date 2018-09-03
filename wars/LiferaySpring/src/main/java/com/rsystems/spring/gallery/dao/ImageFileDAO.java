package com.rsystems.spring.gallery.dao;

import java.util.List;

import com.rsystems.spring.gallery.domain.FileData;

/**
 * Interface to fetch records from image_data table.
 * 
 * @author gauri.shukla
 *
 */
public interface ImageFileDAO {

	/**
	 * Method will return list of photoId for those images which are uploaded by
	 * logged in user.
	 * 
	 * @param liferayScreenName
	 * @return
	 */
	public List<Long> listPhotoIdsOfLoggedUser(String liferayScreenName);

	/**
	 * Method return {@link FileData} associated with photoId parameter.
	 * 
	 * @param photoId
	 * @return
	 */
	public FileData getImageFile(Long photoId);

}
