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
 * This class is a wrapper for {@link TopicUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicUser
 * @generated
 */
@ProviderType
public class TopicUserWrapper implements TopicUser, ModelWrapper<TopicUser> {
	public TopicUserWrapper(TopicUser topicUser) {
		_topicUser = topicUser;
	}

	@Override
	public Class<?> getModelClass() {
		return TopicUser.class;
	}

	@Override
	public String getModelClassName() {
		return TopicUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("topicId", getTopicId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long topicId = (Long)attributes.get("topicId");

		if (topicId != null) {
			setTopicId(topicId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public Object clone() {
		return new TopicUserWrapper((TopicUser)_topicUser.clone());
	}

	@Override
	public int compareTo(TopicUser topicUser) {
		return _topicUser.compareTo(topicUser);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _topicUser.getExpandoBridge();
	}

	/**
	* Returns the primary key of this topic user.
	*
	* @return the primary key of this topic user
	*/
	@Override
	public it.cm.liferay.chat.topic.service.persistence.TopicUserPK getPrimaryKey() {
		return _topicUser.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _topicUser.getPrimaryKeyObj();
	}

	/**
	* Returns the topic ID of this topic user.
	*
	* @return the topic ID of this topic user
	*/
	@Override
	public long getTopicId() {
		return _topicUser.getTopicId();
	}

	/**
	* Returns the user ID of this topic user.
	*
	* @return the user ID of this topic user
	*/
	@Override
	public long getUserId() {
		return _topicUser.getUserId();
	}

	/**
	* Returns the user uuid of this topic user.
	*
	* @return the user uuid of this topic user
	*/
	@Override
	public String getUserUuid() {
		return _topicUser.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _topicUser.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _topicUser.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _topicUser.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _topicUser.isNew();
	}

	@Override
	public void persist() {
		_topicUser.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_topicUser.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_topicUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_topicUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_topicUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_topicUser.setNew(n);
	}

	/**
	* Sets the primary key of this topic user.
	*
	* @param primaryKey the primary key of this topic user
	*/
	@Override
	public void setPrimaryKey(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK primaryKey) {
		_topicUser.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_topicUser.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the topic ID of this topic user.
	*
	* @param topicId the topic ID of this topic user
	*/
	@Override
	public void setTopicId(long topicId) {
		_topicUser.setTopicId(topicId);
	}

	/**
	* Sets the user ID of this topic user.
	*
	* @param userId the user ID of this topic user
	*/
	@Override
	public void setUserId(long userId) {
		_topicUser.setUserId(userId);
	}

	/**
	* Sets the user uuid of this topic user.
	*
	* @param userUuid the user uuid of this topic user
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_topicUser.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TopicUser> toCacheModel() {
		return _topicUser.toCacheModel();
	}

	@Override
	public TopicUser toEscapedModel() {
		return new TopicUserWrapper(_topicUser.toEscapedModel());
	}

	@Override
	public String toString() {
		return _topicUser.toString();
	}

	@Override
	public TopicUser toUnescapedModel() {
		return new TopicUserWrapper(_topicUser.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _topicUser.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicUserWrapper)) {
			return false;
		}

		TopicUserWrapper topicUserWrapper = (TopicUserWrapper)obj;

		if (Objects.equals(_topicUser, topicUserWrapper._topicUser)) {
			return true;
		}

		return false;
	}

	@Override
	public TopicUser getWrappedModel() {
		return _topicUser;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _topicUser.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _topicUser.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_topicUser.resetOriginalValues();
	}

	private final TopicUser _topicUser;
}