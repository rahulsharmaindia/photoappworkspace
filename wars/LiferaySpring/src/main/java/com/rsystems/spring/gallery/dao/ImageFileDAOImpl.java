package com.rsystems.spring.gallery.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rsystems.spring.gallery.domain.FileData;
/**
 * Implementation class to get record from image_data table.
 *  
 * @author gauri.shukla
 *
 */
@Repository
public class ImageFileDAOImpl implements ImageFileDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Long> listPhotoIdsOfLoggedUser(String liferayScreenName) {
		List<Long> photoIds = new ArrayList<Long>();
		Session session = null;
		Transaction txn = null;

		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			photoIds = session.createCriteria(FileData.class).setProjection(Projections.property("file_id"))
					.add(Restrictions.eq("createdBy", liferayScreenName)).list();
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
	public FileData getImageFile(Long photoId) {

		FileData imageData = null;
		Session session = null;
		Transaction txn = null;

		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			Criteria criteria = session.createCriteria(FileData.class).add(Restrictions.eq("file_id", photoId));

			Object result = criteria.uniqueResult();
			if (result != null) {
				imageData = (FileData) result;
			}
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
		return imageData;
	}

}
