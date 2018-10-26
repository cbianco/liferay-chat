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
 * This class is a wrapper for {@link Topic}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Topic
 * @generated
 */
@ProviderType
public class TopicWrapper implements Topic, ModelWrapper<Topic> {
	public TopicWrapper(Topic topic) {
		_topic = topic;
	}

	@Override
	public Class<?> getModelClass() {
		return Topic.class;
	}

	@Override
	public String getModelClassName() {
		return Topic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("topicId", getTopicId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long topicId = (Long)attributes.get("topicId");

		if (topicId != null) {
			setTopicId(topicId);
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
	}

	@Override
	public Object clone() {
		return new TopicWrapper((Topic)_topic.clone());
	}

	@Override
	public int compareTo(Topic topic) {
		return _topic.compareTo(topic);
	}

	/**
	* Returns the company ID of this topic.
	*
	* @return the company ID of this topic
	*/
	@Override
	public long getCompanyId() {
		return _topic.getCompanyId();
	}

	/**
	* Returns the create date of this topic.
	*
	* @return the create date of this topic
	*/
	@Override
	public Date getCreateDate() {
		return _topic.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _topic.getExpandoBridge();
	}

	/**
	* Returns the modified date of this topic.
	*
	* @return the modified date of this topic
	*/
	@Override
	public Date getModifiedDate() {
		return _topic.getModifiedDate();
	}

	/**
	* Returns the primary key of this topic.
	*
	* @return the primary key of this topic
	*/
	@Override
	public long getPrimaryKey() {
		return _topic.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _topic.getPrimaryKeyObj();
	}

	/**
	* Returns the topic ID of this topic.
	*
	* @return the topic ID of this topic
	*/
	@Override
	public long getTopicId() {
		return _topic.getTopicId();
	}

	/**
	* Returns the user ID of this topic.
	*
	* @return the user ID of this topic
	*/
	@Override
	public long getUserId() {
		return _topic.getUserId();
	}

	/**
	* Returns the user name of this topic.
	*
	* @return the user name of this topic
	*/
	@Override
	public String getUserName() {
		return _topic.getUserName();
	}

	/**
	* Returns the user uuid of this topic.
	*
	* @return the user uuid of this topic
	*/
	@Override
	public String getUserUuid() {
		return _topic.getUserUuid();
	}

	/**
	* Returns the uuid of this topic.
	*
	* @return the uuid of this topic
	*/
	@Override
	public String getUuid() {
		return _topic.getUuid();
	}

	@Override
	public int hashCode() {
		return _topic.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _topic.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _topic.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _topic.isNew();
	}

	@Override
	public void persist() {
		_topic.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_topic.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this topic.
	*
	* @param companyId the company ID of this topic
	*/
	@Override
	public void setCompanyId(long companyId) {
		_topic.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this topic.
	*
	* @param createDate the create date of this topic
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_topic.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_topic.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_topic.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_topic.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this topic.
	*
	* @param modifiedDate the modified date of this topic
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_topic.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_topic.setNew(n);
	}

	/**
	* Sets the primary key of this topic.
	*
	* @param primaryKey the primary key of this topic
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_topic.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_topic.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the topic ID of this topic.
	*
	* @param topicId the topic ID of this topic
	*/
	@Override
	public void setTopicId(long topicId) {
		_topic.setTopicId(topicId);
	}

	/**
	* Sets the user ID of this topic.
	*
	* @param userId the user ID of this topic
	*/
	@Override
	public void setUserId(long userId) {
		_topic.setUserId(userId);
	}

	/**
	* Sets the user name of this topic.
	*
	* @param userName the user name of this topic
	*/
	@Override
	public void setUserName(String userName) {
		_topic.setUserName(userName);
	}

	/**
	* Sets the user uuid of this topic.
	*
	* @param userUuid the user uuid of this topic
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_topic.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this topic.
	*
	* @param uuid the uuid of this topic
	*/
	@Override
	public void setUuid(String uuid) {
		_topic.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Topic> toCacheModel() {
		return _topic.toCacheModel();
	}

	@Override
	public Topic toEscapedModel() {
		return new TopicWrapper(_topic.toEscapedModel());
	}

	@Override
	public String toString() {
		return _topic.toString();
	}

	@Override
	public Topic toUnescapedModel() {
		return new TopicWrapper(_topic.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _topic.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicWrapper)) {
			return false;
		}

		TopicWrapper topicWrapper = (TopicWrapper)obj;

		if (Objects.equals(_topic, topicWrapper._topic)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _topic.getStagedModelType();
	}

	@Override
	public Topic getWrappedModel() {
		return _topic;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _topic.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _topic.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_topic.resetOriginalValues();
	}

	private final Topic _topic;
}