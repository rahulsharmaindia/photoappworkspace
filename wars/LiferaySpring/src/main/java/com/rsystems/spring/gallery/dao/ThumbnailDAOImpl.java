package com.rsystems.spring.gallery.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rsystems.spring.gallery.domain.ThumbFile;

/**
 * Implementation to fetch records from image_file table.
 * 
 * @author gauri.shukla
 *
 */
@Repository
public class ThumbnailDAOImpl implements ThumbnailDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ThumbFile> listThumbnails() {
		Session session = null;
		Transaction txn = null;
		List<ThumbFile> thumbnailList = new ArrayList<ThumbFile>();
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			thumbnailList = session.createQuery("from ThumbFile").list();
			txn.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (!txn.wasCommitted()) {
				txn.rollback();
			}

			session.flush();
			session.close();
		}
		return thumbnailList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Long> listPhotoIds() {
		List<Long> photoIds = new ArrayList<Long>();
		Session session = null;
		Transaction txn = null;

		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			photoIds = session.createCriteria(ThumbFile.class).setProjection(Projections.property("file_id")).list();
			txn.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (!txn.wasCommitted()) {
				txn.rollback();
			}

			session.flush();
			session.close();
		}
		return photoIds;
	}

	@Override
	public ThumbFile getThumbnail(Long photoId) {
		ThumbFile thumbnail = null;
		Session session = null;
		Transaction txn = null;

		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			thumbnail = (ThumbFile) session.get(ThumbFile.class, photoId);
			txn.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (!txn.wasCommitted()) {
				txn.rollback();
			}

			session.flush();
			session.close();
		}
		return thumbnail;

	}

}
