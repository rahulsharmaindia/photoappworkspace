package com.rsystems.spring.gallery.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.rsystems.spring.gallery.domain.FileData;
import com.rsystems.spring.gallery.domain.ThumbFile;
import com.rsystems.spring.gallery.service.ImageFileService;
import com.rsystems.spring.gallery.service.ThumbnailService;
/**
 * Controller to display thumbnails and corresponding image of logged in user.
 * 
 * @author gauri.shukla
 *
 */
@Controller("thumbnailsGalleryController")
@RequestMapping("VIEW")
public class ThumbnailsGalleryController {
	private static final String CONTENT_TYPE = "image/jpeg";

	@Autowired
	private ThumbnailService thumbnailService;

	@Autowired
	private ImageFileService imageFileService;

	@RenderMapping
	public String listContacts(RenderRequest renderRequest) {

		User loggedInUser = null;
		boolean isUserExists = false;
		try {
			loggedInUser = PortalUtil.getUser(PortalUtil.getHttpServletRequest(renderRequest));
		} catch (PortalException e) {
			System.out.println("Exception occurred while retrieving logged in user." + e);
			e.printStackTrace();
		}
		List<String> thumbnailList = new ArrayList<String>();
		if (null != loggedInUser) {
			isUserExists = true;
			thumbnailList = imageFileService.listPhotoIdsOfLoggedUser(loggedInUser.getScreenName());

		} else {
			thumbnailList = thumbnailService.listphotoIds();
		}
		renderRequest.setAttribute("isUserExists", isUserExists);
		renderRequest.setAttribute("photIds", thumbnailList);

		return "view";
	}

	@RequestMapping(params = "render=get-thumbnail")
	public void serveThumbnail(@RequestParam(value = "imageid", required = true) String photoId,
			ResourceRequest request, ResourceResponse response) {
		try {
			ThumbFile file = thumbnailService.getThumbnail(photoId);
			if (null != file.getSmall()) {
				byte[] blobAsBytes = file.getSmall();
				response.setContentType(CONTENT_TYPE);
				OutputStream o = response.getPortletOutputStream();
				o.write(blobAsBytes);
				o.flush();
				o.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "render=get-image")
	public void serveImage(@RequestParam(value = "imageid", required = true) String photoId, ResourceRequest request,
			ResourceResponse response) {
		try {
			FileData file = imageFileService.getImageFile(photoId);
			response.setContentType(CONTENT_TYPE);
			readImage(file.getFile_path(), response.getPortletOutputStream());
		} catch (IOException e) {
			System.out.println("Exception occurred while retrieving Image from physical location." + e);
			e.printStackTrace();
		}
	}

	/**
	 * Method to read uploaded file and write to output strea.
	 * 
	 * @param filePath
	 * @param o
	 */
	private void readImage(String filePath, OutputStream o) {
		byte[] byteArray = null;
		FileInputStream imgStream = null;
		FileChannel channel = null;
		try {
			imgStream = new FileInputStream(filePath);
			channel = imgStream.getChannel();
			MappedByteBuffer mappedByteBuf;
			mappedByteBuf = channel.map(MapMode.READ_ONLY, 0, channel.size());
			byteArray = new byte[mappedByteBuf.limit()];
			mappedByteBuf.get(byteArray);
			o.write(byteArray, 0, mappedByteBuf.limit());
			mappedByteBuf.clear();
			channel.close();
			imgStream.close();
			System.gc();
			o.flush();
			o.close();
		} catch (IOException e) {
			System.out.println("Exception occurred while writing image to output stream." + e);
			e.printStackTrace();
		}
	}

}
