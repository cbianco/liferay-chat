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

import it.cm.liferay.chat.topic.service.persistence.MessageUserPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.cm.liferay.chat.topic.service.http.MessageUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.cm.liferay.chat.topic.service.http.MessageUserServiceSoap
 * @generated
 */
@ProviderType
public class MessageUserSoap implements Serializable {
	public static MessageUserSoap toSoapModel(MessageUser model) {
		MessageUserSoap soapModel = new MessageUserSoap();

		soapModel.setMessageId(model.getMessageId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTopicId(model.getTopicId());
		soapModel.setRead(model.isRead());

		return soapModel;
	}

	public static MessageUserSoap[] toSoapModels(MessageUser[] models) {
		MessageUserSoap[] soapModels = new MessageUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MessageUserSoap[][] toSoapModels(MessageUser[][] models) {
		MessageUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MessageUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MessageUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MessageUserSoap[] toSoapModels(List<MessageUser> models) {
		List<MessageUserSoap> soapModels = new ArrayList<MessageUserSoap>(models.size());

		for (MessageUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MessageUserSoap[soapModels.size()]);
	}

	public MessageUserSoap() {
	}

	public MessageUserPK getPrimaryKey() {
		return new MessageUserPK(_messageId, _userId);
	}

	public void setPrimaryKey(MessageUserPK pk) {
		setMessageId(pk.messageId);
		setUserId(pk.userId);
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getTopicId() {
		return _topicId;
	}

	public void setTopicId(long topicId) {
		_topicId = topicId;
	}

	public boolean getRead() {
		return _read;
	}

	public boolean isRead() {
		return _read;
	}

	public void setRead(boolean read) {
		_read = read;
	}

	private long _messageId;
	private long _userId;
	private long _topicId;
	private boolean _read;
}