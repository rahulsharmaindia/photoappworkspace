package com.rsystems.spring.gallery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsystems.spring.gallery.dao.ThumbnailDAO;
import com.rsystems.spring.gallery.domain.ThumbFile;

/**
 * Service implementation for accessing records from image_file table.
 * 
 * @author gauri.shukla
 *
 */
@Service
public class ThumbnailServiceImpl implements ThumbnailService {
	@Autowired
	private ThumbnailDAO thumbnailDAO;

	@Override
	@Transactional
	public List<ThumbFile> listThumbnails() {
		return thumbnailDAO.listThumbnails();
	}

	@Override
	@Transactional
	public List<String> listphotoIds() {
		List<Long> photoIdList = thumbnailDAO.listPhotoIds();
		List<String> photoIdListStr = new ArrayList<String>();
		for (Long item : photoIdList) {
			photoIdListStr.add(item.toString());
		}
		return photoIdListStr;
	}

	@Override
	@Transactional
	public ThumbFile getThumbnail(String photoId) {
		return thumbnailDAO.getThumbnail(Long.valueOf(photoId));
	}
}
