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

import it.cm.liferay.chat.topic.model.MessageUser;
import it.cm.liferay.chat.topic.service.persistence.MessageUserPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MessageUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MessageUser
 * @generated
 */
@ProviderType
public class MessageUserCacheModel implements CacheModel<MessageUser>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MessageUserCacheModel)) {
			return false;
		}

		MessageUserCacheModel messageUserCacheModel = (MessageUserCacheModel)obj;

		if (messageUserPK.equals(messageUserCacheModel.messageUserPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, messageUserPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{messageId=");
		sb.append(messageId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", topicId=");
		sb.append(topicId);
		sb.append(", read=");
		sb.append(read);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MessageUser toEntityModel() {
		MessageUserImpl messageUserImpl = new MessageUserImpl();

		messageUserImpl.setMessageId(messageId);
		messageUserImpl.setUserId(userId);
		messageUserImpl.setTopicId(topicId);
		messageUserImpl.setRead(read);

		messageUserImpl.resetOriginalValues();

		return messageUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		messageId = objectInput.readLong();

		userId = objectInput.readLong();

		topicId = objectInput.readLong();

		read = objectInput.readBoolean();

		messageUserPK = new MessageUserPK(messageId, userId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(messageId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(topicId);

		objectOutput.writeBoolean(read);
	}

	public long messageId;
	public long userId;
	public long topicId;
	public boolean read;
	public transient MessageUserPK messageUserPK;
}