/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.rsystems.share.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import org.rsystems.share.exception.NoSuchAlbumException;
import org.rsystems.share.model.Album;
import org.rsystems.share.model.impl.AlbumImpl;
import org.rsystems.share.model.impl.AlbumModelImpl;
import org.rsystems.share.service.persistence.AlbumPK;
import org.rsystems.share.service.persistence.AlbumPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the album service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AlbumPersistence
 * @see org.rsystems.share.service.persistence.AlbumUtil
 * @generated
 */
@ProviderType
public class AlbumPersistenceImpl extends BasePersistenceImpl<Album>
	implements AlbumPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AlbumUtil} to access the album persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AlbumImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumModelImpl.FINDER_CACHE_ENABLED, AlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumModelImpl.FINDER_CACHE_ENABLED, AlbumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AlbumPersistenceImpl() {
		setModelClass(Album.class);
	}

	/**
	 * Caches the album in the entity cache if it is enabled.
	 *
	 * @param album the album
	 */
	@Override
	public void cacheResult(Album album) {
		entityCache.putResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumImpl.class, album.getPrimaryKey(), album);

		album.resetOriginalValues();
	}

	/**
	 * Caches the albums in the entity cache if it is enabled.
	 *
	 * @param albums the albums
	 */
	@Override
	public void cacheResult(List<Album> albums) {
		for (Album album : albums) {
			if (entityCache.getResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
						AlbumImpl.class, album.getPrimaryKey()) == null) {
				cacheResult(album);
			}
			else {
				album.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all albums.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AlbumImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the album.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Album album) {
		entityCache.removeResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumImpl.class, album.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Album> albums) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Album album : albums) {
			entityCache.removeResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
				AlbumImpl.class, album.getPrimaryKey());
		}
	}

	/**
	 * Creates a new album with the primary key. Does not add the album to the database.
	 *
	 * @param albumPK the primary key for the new album
	 * @return the new album
	 */
	@Override
	public Album create(AlbumPK albumPK) {
		Album album = new AlbumImpl();

		album.setNew(true);
		album.setPrimaryKey(albumPK);

		return album;
	}

	/**
	 * Removes the album with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param albumPK the primary key of the album
	 * @return the album that was removed
	 * @throws NoSuchAlbumException if a album with the primary key could not be found
	 */
	@Override
	public Album remove(AlbumPK albumPK) throws NoSuchAlbumException {
		return remove((Serializable)albumPK);
	}

	/**
	 * Removes the album with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the album
	 * @return the album that was removed
	 * @throws NoSuchAlbumException if a album with the primary key could not be found
	 */
	@Override
	public Album remove(Serializable primaryKey) throws NoSuchAlbumException {
		Session session = null;

		try {
			session = openSession();

			Album album = (Album)session.get(AlbumImpl.class, primaryKey);

			if (album == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAlbumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(album);
		}
		catch (NoSuchAlbumException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Album removeImpl(Album album) {
		album = toUnwrappedModel(album);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(album)) {
				album = (Album)session.get(AlbumImpl.class,
						album.getPrimaryKeyObj());
			}

			if (album != null) {
				session.delete(album);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (album != null) {
			clearCache(album);
		}

		return album;
	}

	@Override
	public Album updateImpl(Album album) {
		album = toUnwrappedModel(album);

		boolean isNew = album.isNew();

		Session session = null;

		try {
			session = openSession();

			if (album.isNew()) {
				session.save(album);

				album.setNew(false);
			}
			else {
				album = (Album)session.merge(album);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
			AlbumImpl.class, album.getPrimaryKey(), album, false);

		album.resetOriginalValues();

		return album;
	}

	protected Album toUnwrappedModel(Album album) {
		if (album instanceof AlbumImpl) {
			return album;
		}

		AlbumImpl albumImpl = new AlbumImpl();

		albumImpl.setNew(album.isNew());
		albumImpl.setPrimaryKey(album.getPrimaryKey());

		albumImpl.setAlbum_id(album.getAlbum_id());
		albumImpl.setShared_user(album.getShared_user());
		albumImpl.setAlbum_name(album.getAlbum_name());

		return albumImpl;
	}

	/**
	 * Returns the album with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the album
	 * @return the album
	 * @throws NoSuchAlbumException if a album with the primary key could not be found
	 */
	@Override
	public Album findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAlbumException {
		Album album = fetchByPrimaryKey(primaryKey);

		if (album == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAlbumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return album;
	}

	/**
	 * Returns the album with the primary key or throws a {@link NoSuchAlbumException} if it could not be found.
	 *
	 * @param albumPK the primary key of the album
	 * @return the album
	 * @throws NoSuchAlbumException if a album with the primary key could not be found
	 */
	@Override
	public Album findByPrimaryKey(AlbumPK albumPK) throws NoSuchAlbumException {
		return findByPrimaryKey((Serializable)albumPK);
	}

	/**
	 * Returns the album with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the album
	 * @return the album, or <code>null</code> if a album with the primary key could not be found
	 */
	@Override
	public Album fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
				AlbumImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Album album = (Album)serializable;

		if (album == null) {
			Session session = null;

			try {
				session = openSession();

				album = (Album)session.get(AlbumImpl.class, primaryKey);

				if (album != null) {
					cacheResult(album);
				}
				else {
					entityCache.putResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
						AlbumImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AlbumModelImpl.ENTITY_CACHE_ENABLED,
					AlbumImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return album;
	}

	/**
	 * Returns the album with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param albumPK the primary key of the album
	 * @return the album, or <code>null</code> if a album with the primary key could not be found
	 */
	@Override
	public Album fetchByPrimaryKey(AlbumPK albumPK) {
		return fetchByPrimaryKey((Serializable)albumPK);
	}

	@Override
	public Map<Serializable, Album> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Album> map = new HashMap<Serializable, Album>();

		for (Serializable primaryKey : primaryKeys) {
			Album album = fetchByPrimaryKey(primaryKey);

			if (album != null) {
				map.put(primaryKey, album);
			}
		}

		return map;
	}

	/**
	 * Returns all the albums.
	 *
	 * @return the albums
	 */
	@Override
	public List<Album> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the albums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of albums
	 * @param end the upper bound of the range of albums (not inclusive)
	 * @return the range of albums
	 */
	@Override
	public List<Album> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the albums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of albums
	 * @param end the upper bound of the range of albums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of albums
	 */
	@Override
	public List<Album> findAll(int start, int end,
		OrderByComparator<Album> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the albums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of albums
	 * @param end the upper bound of the range of albums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of albums
	 */
	@Override
	public List<Album> findAll(int start, int end,
		OrderByComparator<Album> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Album> list = null;

		if (retrieveFromCache) {
			list = (List<Album>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ALBUM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALBUM;

				if (pagination) {
					sql = sql.concat(AlbumModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Album>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Album>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the albums from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Album album : findAll()) {
			remove(album);
		}
	}

	/**
	 * Returns the number of albums.
	 *
	 * @return the number of albums
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALBUM);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AlbumModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the album persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AlbumImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ALBUM = "SELECT album FROM Album album";
	private static final String _SQL_COUNT_ALBUM = "SELECT COUNT(album) FROM Album album";
	private static final String _ORDER_BY_ENTITY_ALIAS = "album.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Album exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(AlbumPersistenceImpl.class);
}