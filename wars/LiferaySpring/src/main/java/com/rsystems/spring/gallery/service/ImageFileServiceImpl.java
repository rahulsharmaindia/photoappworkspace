package com.rsystems.spring.gallery.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rsystems.spring.gallery.dao.ImageFileDAO;
import com.rsystems.spring.gallery.domain.FileData;

/**
 * Service implementation of accessing records from image_data table.
 * 
 * @author gauri.shukla
 *
 */
@Service
public class ImageFileServiceImpl implements ImageFileService {
	@Autowired
	private ImageFileDAO imageDAO;

	@Resource(name="mediaProperties")
	Properties props;

	@Override
	public List<String> listPhotoIdsOfLoggedUser(String liferayScreenName) {
		List<Long> photoIdList = imageDAO.listPhotoIdsOfLoggedUser(liferayScreenName);
		List<String> photoIdListStr = new ArrayList<String>();
		for (Long item : photoIdList) {
			photoIdListStr.add(item.toString());
		}
		return photoIdListStr;
	}

	@Override
	public FileData getImageFile(String photoId) {		
		String filesLocation = props.getProperty("files.location");		
		if(StringUtils.isEmpty(filesLocation)){
			System.out.println("*************Configuration Error:Please place loaction in media.properties file****************");
			return null;
		}
		FileData fileData = imageDAO.getImageFile(Long.valueOf(photoId));
		if (StringUtils.isEmpty(filesLocation)) {
			System.out.println("file location is not mentioned in spring.properties file........");
		} else {
			String filePath = filesLocation + File.separator + fileData.getAlbumName() + File.separator
					+ fileData.getName();
			File file = new File(filePath);
			fileData.setFile_path(file.getAbsolutePath());
		}

		return fileData;
	}
}
