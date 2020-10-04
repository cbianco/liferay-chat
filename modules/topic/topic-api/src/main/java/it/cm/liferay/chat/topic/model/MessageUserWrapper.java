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

package it.cm.liferay.chat.topic.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link MessageUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageUser
 * @generated
 */
@ProviderType
public class MessageUserWrapper implements MessageUser,
	ModelWrapper<MessageUser> {
	public MessageUserWrapper(MessageUser messageUser) {
		_messageUser = messageUser;
	}

	@Override
	public Class<?> getModelClass() {
		return MessageUser.class;
	}

	@Override
	public String getModelClassName() {
		return MessageUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("userId", getUserId());
		attributes.put("topicId", getTopicId());
		attributes.put("read", isRead());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long topicId = (Long)attributes.get("topicId");

		if (topicId != null) {
			setTopicId(topicId);
		}

		Boolean read = (Boolean)attributes.get("read");

		if (read != null) {
			setRead(read);
		}
	}

	@Override
	public Object clone() {
		return new MessageUserWrapper((MessageUser)_messageUser.clone());
	}

	@Override
	public int compareTo(MessageUser messageUser) {
		return _messageUser.compareTo(messageUser);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _messageUser.getExpandoBridge();
	}

	/**
	* Returns the message ID of this message user.
	*
	* @return the message ID of this message user
	*/
	@Override
	public long getMessageId() {
		return _messageUser.getMessageId();
	}

	/**
	* Returns the primary key of this message user.
	*
	* @return the primary key of this message user
	*/
	@Override
	public it.cm.liferay.chat.topic.service.persistence.MessageUserPK getPrimaryKey() {
		return _messageUser.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _messageUser.getPrimaryKeyObj();
	}

	/**
	* Returns the read of this message user.
	*
	* @return the read of this message user
	*/
	@Override
	public boolean getRead() {
		return _messageUser.getRead();
	}

	/**
	* Returns the topic ID of this message user.
	*
	* @return the topic ID of this message user
	*/
	@Override
	public long getTopicId() {
		return _messageUser.getTopicId();
	}

	/**
	* Returns the user ID of this message user.
	*
	* @return the user ID of this message user
	*/
	@Override
	public long getUserId() {
		return _messageUser.getUserId();
	}

	/**
	* Returns the user uuid of this message user.
	*
	* @return the user uuid of this message user
	*/
	@Override
	public String getUserUuid() {
		return _messageUser.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _messageUser.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _messageUser.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _messageUser.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _messageUser.isNew();
	}

	/**
	* Returns <code>true</code> if this message user is read.
	*
	* @return <code>true</code> if this message user is read; <code>false</code> otherwise
	*/
	@Override
	public boolean isRead() {
		return _messageUser.isRead();
	}

	@Override
	public void persist() {
		_messageUser.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_messageUser.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_messageUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_messageUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_messageUser.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the message ID of this message user.
	*
	* @param messageId the message ID of this message user
	*/
	@Override
	public void setMessageId(long messageId) {
		_messageUser.setMessageId(messageId);
	}

	@Override
	public void setNew(boolean n) {
		_messageUser.setNew(n);
	}

	/**
	* Sets the primary key of this message user.
	*
	* @param primaryKey the primary key of this message user
	*/
	@Override
	public void setPrimaryKey(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK primaryKey) {
		_messageUser.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_messageUser.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this message user is read.
	*
	* @param read the read of this message user
	*/
	@Override
	public void setRead(boolean read) {
		_messageUser.setRead(read);
	}

	/**
	* Sets the topic ID of this message user.
	*
	* @param topicId the topic ID of this message user
	*/
	@Override
	public void setTopicId(long topicId) {
		_messageUser.setTopicId(topicId);
	}

	/**
	* Sets the user ID of this message user.
	*
	* @param userId the user ID of this message user
	*/
	@Override
	public void setUserId(long userId) {
		_messageUser.setUserId(userId);
	}

	/**
	* Sets the user uuid of this message user.
	*
	* @param userUuid the user uuid of this message user
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_messageUser.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MessageUser> toCacheModel() {
		return _messageUser.toCacheModel();
	}

	@Override
	public MessageUser toEscapedModel() {
		return new MessageUserWrapper(_messageUser.toEscapedModel());
	}

	@Override
	public String toString() {
		return _messageUser.toString();
	}

	@Override
	public MessageUser toUnescapedModel() {
		return new MessageUserWrapper(_messageUser.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _messageUser.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MessageUserWrapper)) {
			return false;
		}

		MessageUserWrapper messageUserWrapper = (MessageUserWrapper)obj;

		if (Objects.equals(_messageUser, messageUserWrapper._messageUser)) {
			return true;
		}

		return false;
	}

	@Override
	public MessageUser getWrappedModel() {
		return _messageUser;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _messageUser.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _messageUser.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_messageUser.resetOriginalValues();
	}

	private final MessageUser _messageUser;
}