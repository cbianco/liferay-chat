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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.cm.liferay.chat.topic.model.Topic;
import it.cm.liferay.chat.topic.model.TopicModel;
import it.cm.liferay.chat.topic.model.TopicSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Topic service. Represents a row in the &quot;Conversation_Topic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TopicModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TopicImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicImpl
 * @see Topic
 * @see TopicModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TopicModelImpl extends BaseModelImpl<Topic> implements TopicModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a topic model instance should use the {@link Topic} interface instead.
	 */
	public static final String TABLE_NAME = "Conversation_Topic";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "topicId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("topicId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table Conversation_Topic (uuid_ VARCHAR(75) null,topicId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table Conversation_Topic";
	public static final String ORDER_BY_JPQL = " ORDER BY topic.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Conversation_Topic.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(it.cm.liferay.chat.topic.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.it.cm.liferay.chat.topic.model.Topic"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(it.cm.liferay.chat.topic.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.it.cm.liferay.chat.topic.model.Topic"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(it.cm.liferay.chat.topic.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.cm.liferay.chat.topic.model.Topic"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Topic toModel(TopicSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Topic model = new TopicImpl();

		model.setUuid(soapModel.getUuid());
		model.setTopicId(soapModel.getTopicId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Topic> toModels(TopicSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Topic> models = new ArrayList<Topic>(soapModels.length);

		for (TopicSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(it.cm.liferay.chat.topic.service.util.ServiceProps.get(
				"lock.expiration.time.it.cm.liferay.chat.topic.model.Topic"));

	public TopicModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _topicId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTopicId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _topicId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getTopicId() {
		return _topicId;
	}

	@Override
	public void setTopicId(long topicId) {
		_topicId = topicId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Topic.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Topic.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Topic toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Topic)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TopicImpl topicImpl = new TopicImpl();

		topicImpl.setUuid(getUuid());
		topicImpl.setTopicId(getTopicId());
		topicImpl.setCompanyId(getCompanyId());
		topicImpl.setUserId(getUserId());
		topicImpl.setUserName(getUserName());
		topicImpl.setCreateDate(getCreateDate());
		topicImpl.setModifiedDate(getModifiedDate());

		topicImpl.resetOriginalValues();

		return topicImpl;
	}

	@Override
	public int compareTo(Topic topic) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), topic.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Topic)) {
			return false;
		}

		Topic topic = (Topic)obj;

		long primaryKey = topic.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TopicModelImpl topicModelImpl = this;

		topicModelImpl._originalUuid = topicModelImpl._uuid;

		topicModelImpl._originalCompanyId = topicModelImpl._companyId;

		topicModelImpl._setOriginalCompanyId = false;

		topicModelImpl._setModifiedDate = false;

		topicModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Topic> toCacheModel() {
		TopicCacheModel topicCacheModel = new TopicCacheModel();

		topicCacheModel.uuid = getUuid();

		String uuid = topicCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			topicCacheModel.uuid = null;
		}

		topicCacheModel.topicId = getTopicId();

		topicCacheModel.companyId = getCompanyId();

		topicCacheModel.userId = getUserId();

		topicCacheModel.userName = getUserName();

		String userName = topicCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			topicCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			topicCacheModel.createDate = createDate.getTime();
		}
		else {
			topicCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			topicCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			topicCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return topicCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", topicId=");
		sb.append(getTopicId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("it.cm.liferay.chat.topic.model.Topic");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>topicId</column-name><column-value><![CDATA[");
		sb.append(getTopicId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Topic.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Topic.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _topicId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private Topic _escapedModel;
}