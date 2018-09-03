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

package org.rsystems.share.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Album service. Represents a row in the &quot;Share_Album&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AlbumModel
 * @see org.rsystems.share.model.impl.AlbumImpl
 * @see org.rsystems.share.model.impl.AlbumModelImpl
 * @generated
 */
@ImplementationClassName("org.rsystems.share.model.impl.AlbumImpl")
@ProviderType
public interface Album extends AlbumModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.rsystems.share.model.impl.AlbumImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Album, Integer> ALBUM_ID_ACCESSOR = new Accessor<Album, Integer>() {
			@Override
			public Integer get(Album album) {
				return album.getAlbum_id();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<Album> getTypeClass() {
				return Album.class;
			}
		};

	public static final Accessor<Album, String> SHARED_USER_ACCESSOR = new Accessor<Album, String>() {
			@Override
			public String get(Album album) {
				return album.getShared_user();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Album> getTypeClass() {
				return Album.class;
			}
		};
}