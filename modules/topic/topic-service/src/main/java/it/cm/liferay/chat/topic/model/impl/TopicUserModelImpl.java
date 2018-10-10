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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.cm.liferay.chat.topic.model.TopicUser;
import it.cm.liferay.chat.topic.model.TopicUserModel;
import it.cm.liferay.chat.topic.model.TopicUserSoap;
import it.cm.liferay.chat.topic.service.persistence.TopicUserPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TopicUser service. Represents a row in the &quot;Conversation_TopicUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TopicUserModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TopicUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicUserImpl
 * @see TopicUser
 * @see TopicUserModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TopicUserModelImpl extends BaseModelImpl<TopicUser>
	implements TopicUserModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a topic user model instance should use the {@link TopicUser} interface instead.
	 */
	public static final String TABLE_NAME = "Conversation_TopicUser";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "topicId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("topicId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table Conversation_TopicUser (uuid_ VARCHAR(75) null,topicId LONG not null,userId LONG not null,groupId LONG,companyId LONG,primary key (topicId, userId))";
	public static final String TABLE_SQL_DROP = "drop table Conversation_TopicUser";
	public static final String ORDER_BY_JPQL = " ORDER BY topicUser.id.topicId ASC, topicUser.id.userId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Conversation_TopicUser.topicId ASC, Conversation_TopicUser.userId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(it.cm.liferay.chat.topic.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.it.cm.liferay.chat.topic.model.TopicUser"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(it.cm.liferay.chat.topic.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.it.cm.liferay.chat.topic.model.TopicUser"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(it.cm.liferay.chat.topic.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.cm.liferay.chat.topic.model.TopicUser"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long TOPICID_COLUMN_BITMASK = 8L;
	public static final long USERID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TopicUser toModel(TopicUserSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TopicUser model = new TopicUserImpl();

		model.setUuid(soapModel.getUuid());
		model.setTopicId(soapModel.getTopicId());
		model.setUserId(soapModel.getUserId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TopicUser> toModels(TopicUserSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TopicUser> models = new ArrayList<TopicUser>(soapModels.length);

		for (TopicUserSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(it.cm.liferay.chat.topic.service.util.ServiceProps.get(
				"lock.expiration.time.it.cm.liferay.chat.topic.model.TopicUser"));

	public TopicUserModelImpl() {
	}

	@Override
	public TopicUserPK getPrimaryKey() {
		return new TopicUserPK(_topicId, _userId);
	}

	@Override
	public void setPrimaryKey(TopicUserPK primaryKey) {
		setTopicId(primaryKey.topicId);
		setUserId(primaryKey.userId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new TopicUserPK(_topicId, _userId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((TopicUserPK)primaryKeyObj);
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

		attributes.put("uuid", getUuid());
		attributes.put("topicId", getTopicId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public TopicUser toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TopicUser)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TopicUserImpl topicUserImpl = new TopicUserImpl();

		topicUserImpl.setUuid(getUuid());
		topicUserImpl.setTopicId(getTopicId());
		topicUserImpl.setUserId(getUserId());
		topicUserImpl.setGroupId(getGroupId());
		topicUserImpl.setCompanyId(getCompanyId());

		topicUserImpl.resetOriginalValues();

		return topicUserImpl;
	}

	@Override
	public int compareTo(TopicUser topicUser) {
		TopicUserPK primaryKey = topicUser.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TopicUser)) {
			return false;
		}

		TopicUser topicUser = (TopicUser)obj;

		TopicUserPK primaryKey = topicUser.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		TopicUserModelImpl topicUserModelImpl = this;

		topicUserModelImpl._originalUuid = topicUserModelImpl._uuid;

		topicUserModelImpl._originalGroupId = topicUserModelImpl._groupId;

		topicUserModelImpl._setOriginalGroupId = false;

		topicUserModelImpl._originalCompanyId = topicUserModelImpl._companyId;

		topicUserModelImpl._setOriginalCompanyId = false;

		topicUserModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TopicUser> toCacheModel() {
		TopicUserCacheModel topicUserCacheModel = new TopicUserCacheModel();

		topicUserCacheModel.topicUserPK = getPrimaryKey();

		topicUserCacheModel.uuid = getUuid();

		String uuid = topicUserCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			topicUserCacheModel.uuid = null;
		}

		topicUserCacheModel.topicId = getTopicId();

		topicUserCacheModel.userId = getUserId();

		topicUserCacheModel.groupId = getGroupId();

		topicUserCacheModel.companyId = getCompanyId();

		return topicUserCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", topicId=");
		sb.append(getTopicId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.cm.liferay.chat.topic.model.TopicUser");
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TopicUser.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TopicUser.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _topicId;
	private long _userId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _columnBitmask;
	private TopicUser _escapedModel;
}