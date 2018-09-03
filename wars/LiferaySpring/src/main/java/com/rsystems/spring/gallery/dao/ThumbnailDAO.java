package com.rsystems.spring.gallery.dao;

import java.util.List;

import com.rsystems.spring.gallery.domain.ThumbFile;
/**
 * Interface to fetch records from image_file table.
 * 
 * @author gauri.shukla
 *
 */
public interface ThumbnailDAO {

	/**
	 * Method to return list of all thumbnails.
	 * 
	 * @return
	 */
	public List<ThumbFile> listThumbnails();

	/**
	 * Method will return list of photo_id.
	 * 
	 * @return
	 */
	public List<Long> listPhotoIds();

	/**
	 * Method returns {@link ThumbFile} based on passed photoId as parameter.
	 * 
	 * @param photoId
	 * @return
	 */
	public ThumbFile getThumbnail(Long photoId);

}
