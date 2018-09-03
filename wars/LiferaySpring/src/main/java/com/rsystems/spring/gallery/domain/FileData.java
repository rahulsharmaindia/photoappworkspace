package com.rsystems.spring.gallery.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

/**
 * Entity class of image_data table which is representation of uploaded image.
 * 
 * @author gauri.shukla
 *
 */
@Immutable
@Entity
@Table(name = "file_data")
public class FileData {
	private static final long serialVersionUID = 5020367798695319492L;
	@Id
	private Long file_id;
	@Transient
	private String file_path;
	@Column
	private String name;
	@Column
	private String comments;
	@Column
	private Long size;
	@Column
	private String albumName;
	@Column
	private Integer media_type;
	@Column
	private Timestamp lastModified;
	@Column(name = "creation_date")
	private String creation_date;
	@Column(name = "created_by")
	private String createdBy;

	public Long getFile_id() {
		return file_id;
	}

	public void setFile_id(Long file_id) {
		this.file_id = file_id;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
