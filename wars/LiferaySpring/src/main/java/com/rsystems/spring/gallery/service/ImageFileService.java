package com.rsystems.spring.gallery.service;

import java.util.List;

import com.rsystems.spring.gallery.domain.FileData;;

/**
 * Service Interface for retrieving records from image_data table.
 * 
 * @author gauri.shukla
 *
 */
public interface ImageFileService {

	/**
	 * Method to get the list of photoIds whose corresponding images are
	 * uploaded by logged in user.
	 * 
	 * @param liferayScreenName
	 * @return
	 */
	public List<String> listPhotoIdsOfLoggedUser(String liferayScreenName);

	/**
	 * Method to get {@link FileData} against photoId.
	 * 
	 * @param photoId
	 * @return
	 */
	public FileData getImageFile(String photoId);

}
