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

package it.cm.liferay.chat.topic.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.cm.liferay.chat.topic.model.TopicUser;
import it.cm.liferay.chat.topic.service.persistence.TopicUserPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TopicUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TopicUser
 * @generated
 */
@ProviderType
public class TopicUserCacheModel implements CacheModel<TopicUser>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicUserCacheModel)) {
			return false;
		}

		TopicUserCacheModel topicUserCacheModel = (TopicUserCacheModel)obj;

		if (topicUserPK.equals(topicUserCacheModel.topicUserPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, topicUserPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{topicId=");
		sb.append(topicId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TopicUser toEntityModel() {
		TopicUserImpl topicUserImpl = new TopicUserImpl();

		topicUserImpl.setTopicId(topicId);
		topicUserImpl.setUserId(userId);

		topicUserImpl.resetOriginalValues();

		return topicUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		topicId = objectInput.readLong();

		userId = objectInput.readLong();

		topicUserPK = new TopicUserPK(topicId, userId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(topicId);

		objectOutput.writeLong(userId);
	}

	public long topicId;
	public long userId;
	public transient TopicUserPK topicUserPK;
}