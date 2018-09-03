package com.rsystems.spring.gallery.service;

import java.util.List;

import com.rsystems.spring.gallery.domain.ThumbFile;;

/**
 * Service Interface to get records from image_file table.
 * 
 * @author gauri.shukla
 *
 */
public interface ThumbnailService {

	/**
	 * Method to get the list of {@link ThumbFile}
	 * 
	 * @return
	 */
	public List<ThumbFile> listThumbnails();

	/**
	 * Method to get list of photoIds from image_file table.
	 * 
	 * @return
	 */
	public List<String> listphotoIds();

	/**
	 * Method to get {@link ThumbFile} against photoId.
	 * 
	 * @param photoId
	 * @return
	 */
	public ThumbFile getThumbnail(String photoId);

}
