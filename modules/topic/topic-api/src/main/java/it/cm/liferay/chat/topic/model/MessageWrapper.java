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

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Message}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Message
 * @generated
 */
@ProviderType
public class MessageWrapper implements Message, ModelWrapper<Message> {
	public MessageWrapper(Message message) {
		_message = message;
	}

	@Override
	public Class<?> getModelClass() {
		return Message.class;
	}

	@Override
	public String getModelClassName() {
		return Message.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("messageId", getMessageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("topicId", getTopicId());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long topicId = (Long)attributes.get("topicId");

		if (topicId != null) {
			setTopicId(topicId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public Object clone() {
		return new MessageWrapper((Message)_message.clone());
	}

	@Override
	public int compareTo(Message message) {
		return _message.compareTo(message);
	}

	/**
	* Returns the company ID of this message.
	*
	* @return the company ID of this message
	*/
	@Override
	public long getCompanyId() {
		return _message.getCompanyId();
	}

	/**
	* Returns the content of this message.
	*
	* @return the content of this message
	*/
	@Override
	public String getContent() {
		return _message.getContent();
	}

	/**
	* Returns the create date of this message.
	*
	* @return the create date of this message
	*/
	@Override
	public Date getCreateDate() {
		return _message.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _message.getExpandoBridge();
	}

	/**
	* Returns the group ID of this message.
	*
	* @return the group ID of this message
	*/
	@Override
	public long getGroupId() {
		return _message.getGroupId();
	}

	/**
	* Returns the message ID of this message.
	*
	* @return the message ID of this message
	*/
	@Override
	public long getMessageId() {
		return _message.getMessageId();
	}

	/**
	* Returns the modified date of this message.
	*
	* @return the modified date of this message
	*/
	@Override
	public Date getModifiedDate() {
		return _message.getModifiedDate();
	}

	/**
	* Returns the primary key of this message.
	*
	* @return the primary key of this message
	*/
	@Override
	public long getPrimaryKey() {
		return _message.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _message.getPrimaryKeyObj();
	}

	@Override
	public it.cm.liferay.chat.topic.model.Topic getTopic()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _message.getTopic();
	}

	/**
	* Returns the topic ID of this message.
	*
	* @return the topic ID of this message
	*/
	@Override
	public long getTopicId() {
		return _message.getTopicId();
	}

	/**
	* Returns the user ID of this message.
	*
	* @return the user ID of this message
	*/
	@Override
	public long getUserId() {
		return _message.getUserId();
	}

	/**
	* Returns the user name of this message.
	*
	* @return the user name of this message
	*/
	@Override
	public String getUserName() {
		return _message.getUserName();
	}

	/**
	* Returns the user uuid of this message.
	*
	* @return the user uuid of this message
	*/
	@Override
	public String getUserUuid() {
		return _message.getUserUuid();
	}

	/**
	* Returns the uuid of this message.
	*
	* @return the uuid of this message
	*/
	@Override
	public String getUuid() {
		return _message.getUuid();
	}

	@Override
	public int hashCode() {
		return _message.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _message.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _message.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _message.isNew();
	}

	@Override
	public void persist() {
		_message.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_message.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this message.
	*
	* @param companyId the company ID of this message
	*/
	@Override
	public void setCompanyId(long companyId) {
		_message.setCompanyId(companyId);
	}

	/**
	* Sets the content of this message.
	*
	* @param content the content of this message
	*/
	@Override
	public void setContent(String content) {
		_message.setContent(content);
	}

	/**
	* Sets the create date of this message.
	*
	* @param createDate the create date of this message
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_message.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_message.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_message.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_message.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this message.
	*
	* @param groupId the group ID of this message
	*/
	@Override
	public void setGroupId(long groupId) {
		_message.setGroupId(groupId);
	}

	/**
	* Sets the message ID of this message.
	*
	* @param messageId the message ID of this message
	*/
	@Override
	public void setMessageId(long messageId) {
		_message.setMessageId(messageId);
	}

	/**
	* Sets the modified date of this message.
	*
	* @param modifiedDate the modified date of this message
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_message.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_message.setNew(n);
	}

	/**
	* Sets the primary key of this message.
	*
	* @param primaryKey the primary key of this message
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_message.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_message.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the topic ID of this message.
	*
	* @param topicId the topic ID of this message
	*/
	@Override
	public void setTopicId(long topicId) {
		_message.setTopicId(topicId);
	}

	/**
	* Sets the user ID of this message.
	*
	* @param userId the user ID of this message
	*/
	@Override
	public void setUserId(long userId) {
		_message.setUserId(userId);
	}

	/**
	* Sets the user name of this message.
	*
	* @param userName the user name of this message
	*/
	@Override
	public void setUserName(String userName) {
		_message.setUserName(userName);
	}

	/**
	* Sets the user uuid of this message.
	*
	* @param userUuid the user uuid of this message
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_message.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this message.
	*
	* @param uuid the uuid of this message
	*/
	@Override
	public void setUuid(String uuid) {
		_message.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Message> toCacheModel() {
		return _message.toCacheModel();
	}

	@Override
	public Message toEscapedModel() {
		return new MessageWrapper(_message.toEscapedModel());
	}

	@Override
	public String toString() {
		return _message.toString();
	}

	@Override
	public Message toUnescapedModel() {
		return new MessageWrapper(_message.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _message.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MessageWrapper)) {
			return false;
		}

		MessageWrapper messageWrapper = (MessageWrapper)obj;

		if (Objects.equals(_message, messageWrapper._message)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _message.getStagedModelType();
	}

	@Override
	public Message getWrappedModel() {
		return _message;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _message.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _message.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_message.resetOriginalValues();
	}

	private final Message _message;
}