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

import it.cm.liferay.chat.topic.service.persistence.TopicUserPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.cm.liferay.chat.topic.service.http.TopicUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.cm.liferay.chat.topic.service.http.TopicUserServiceSoap
 * @generated
 */
@ProviderType
public class TopicUserSoap implements Serializable {
	public static TopicUserSoap toSoapModel(TopicUser model) {
		TopicUserSoap soapModel = new TopicUserSoap();

		soapModel.setTopicId(model.getTopicId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static TopicUserSoap[] toSoapModels(TopicUser[] models) {
		TopicUserSoap[] soapModels = new TopicUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TopicUserSoap[][] toSoapModels(TopicUser[][] models) {
		TopicUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TopicUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TopicUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TopicUserSoap[] toSoapModels(List<TopicUser> models) {
		List<TopicUserSoap> soapModels = new ArrayList<TopicUserSoap>(models.size());

		for (TopicUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TopicUserSoap[soapModels.size()]);
	}

	public TopicUserSoap() {
	}

	public TopicUserPK getPrimaryKey() {
		return new TopicUserPK(_topicId, _userId);
	}

	public void setPrimaryKey(TopicUserPK pk) {
		setTopicId(pk.topicId);
		setUserId(pk.userId);
	}

	public long getTopicId() {
		return _topicId;
	}

	public void setTopicId(long topicId) {
		_topicId = topicId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _topicId;
	private long _userId;
}