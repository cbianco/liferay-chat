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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.cm.liferay.chat.topic.service.http.TopicServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.cm.liferay.chat.topic.service.http.TopicServiceSoap
 * @generated
 */
@ProviderType
public class TopicSoap implements Serializable {
	public static TopicSoap toSoapModel(Topic model) {
		TopicSoap soapModel = new TopicSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTopicId(model.getTopicId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TopicSoap[] toSoapModels(Topic[] models) {
		TopicSoap[] soapModels = new TopicSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TopicSoap[][] toSoapModels(Topic[][] models) {
		TopicSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TopicSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TopicSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TopicSoap[] toSoapModels(List<Topic> models) {
		List<TopicSoap> soapModels = new ArrayList<TopicSoap>(models.size());

		for (Topic model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TopicSoap[soapModels.size()]);
	}

	public TopicSoap() {
	}

	public long getPrimaryKey() {
		return _topicId;
	}

	public void setPrimaryKey(long pk) {
		setTopicId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTopicId() {
		return _topicId;
	}

	public void setTopicId(long topicId) {
		_topicId = topicId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _topicId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}