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

package it.cm.liferay.chat.topic.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.cm.liferay.chat.topic.model.Topic;
import it.cm.liferay.chat.topic.service.TopicService;
import it.cm.liferay.chat.topic.service.persistence.MessagePersistence;
import it.cm.liferay.chat.topic.service.persistence.MessageUserPersistence;
import it.cm.liferay.chat.topic.service.persistence.TopicPersistence;
import it.cm.liferay.chat.topic.service.persistence.TopicUserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the topic remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.cm.liferay.chat.topic.service.impl.TopicServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.cm.liferay.chat.topic.service.impl.TopicServiceImpl
 * @see it.cm.liferay.chat.topic.service.TopicServiceUtil
 * @generated
 */
public abstract class TopicServiceBaseImpl extends BaseServiceImpl
	implements TopicService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.cm.liferay.chat.topic.service.TopicServiceUtil} to access the topic remote service.
	 */

	/**
	 * Returns the message local service.
	 *
	 * @return the message local service
	 */
	public it.cm.liferay.chat.topic.service.MessageLocalService getMessageLocalService() {
		return messageLocalService;
	}

	/**
	 * Sets the message local service.
	 *
	 * @param messageLocalService the message local service
	 */
	public void setMessageLocalService(
		it.cm.liferay.chat.topic.service.MessageLocalService messageLocalService) {
		this.messageLocalService = messageLocalService;
	}

	/**
	 * Returns the message remote service.
	 *
	 * @return the message remote service
	 */
	public it.cm.liferay.chat.topic.service.MessageService getMessageService() {
		return messageService;
	}

	/**
	 * Sets the message remote service.
	 *
	 * @param messageService the message remote service
	 */
	public void setMessageService(
		it.cm.liferay.chat.topic.service.MessageService messageService) {
		this.messageService = messageService;
	}

	/**
	 * Returns the message persistence.
	 *
	 * @return the message persistence
	 */
	public MessagePersistence getMessagePersistence() {
		return messagePersistence;
	}

	/**
	 * Sets the message persistence.
	 *
	 * @param messagePersistence the message persistence
	 */
	public void setMessagePersistence(MessagePersistence messagePersistence) {
		this.messagePersistence = messagePersistence;
	}

	/**
	 * Returns the message user local service.
	 *
	 * @return the message user local service
	 */
	public it.cm.liferay.chat.topic.service.MessageUserLocalService getMessageUserLocalService() {
		return messageUserLocalService;
	}

	/**
	 * Sets the message user local service.
	 *
	 * @param messageUserLocalService the message user local service
	 */
	public void setMessageUserLocalService(
		it.cm.liferay.chat.topic.service.MessageUserLocalService messageUserLocalService) {
		this.messageUserLocalService = messageUserLocalService;
	}

	/**
	 * Returns the message user remote service.
	 *
	 * @return the message user remote service
	 */
	public it.cm.liferay.chat.topic.service.MessageUserService getMessageUserService() {
		return messageUserService;
	}

	/**
	 * Sets the message user remote service.
	 *
	 * @param messageUserService the message user remote service
	 */
	public void setMessageUserService(
		it.cm.liferay.chat.topic.service.MessageUserService messageUserService) {
		this.messageUserService = messageUserService;
	}

	/**
	 * Returns the message user persistence.
	 *
	 * @return the message user persistence
	 */
	public MessageUserPersistence getMessageUserPersistence() {
		return messageUserPersistence;
	}

	/**
	 * Sets the message user persistence.
	 *
	 * @param messageUserPersistence the message user persistence
	 */
	public void setMessageUserPersistence(
		MessageUserPersistence messageUserPersistence) {
		this.messageUserPersistence = messageUserPersistence;
	}

	/**
	 * Returns the topic local service.
	 *
	 * @return the topic local service
	 */
	public it.cm.liferay.chat.topic.service.TopicLocalService getTopicLocalService() {
		return topicLocalService;
	}

	/**
	 * Sets the topic local service.
	 *
	 * @param topicLocalService the topic local service
	 */
	public void setTopicLocalService(
		it.cm.liferay.chat.topic.service.TopicLocalService topicLocalService) {
		this.topicLocalService = topicLocalService;
	}

	/**
	 * Returns the topic remote service.
	 *
	 * @return the topic remote service
	 */
	public TopicService getTopicService() {
		return topicService;
	}

	/**
	 * Sets the topic remote service.
	 *
	 * @param topicService the topic remote service
	 */
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	/**
	 * Returns the topic persistence.
	 *
	 * @return the topic persistence
	 */
	public TopicPersistence getTopicPersistence() {
		return topicPersistence;
	}

	/**
	 * Sets the topic persistence.
	 *
	 * @param topicPersistence the topic persistence
	 */
	public void setTopicPersistence(TopicPersistence topicPersistence) {
		this.topicPersistence = topicPersistence;
	}

	/**
	 * Returns the topic user local service.
	 *
	 * @return the topic user local service
	 */
	public it.cm.liferay.chat.topic.service.TopicUserLocalService getTopicUserLocalService() {
		return topicUserLocalService;
	}

	/**
	 * Sets the topic user local service.
	 *
	 * @param topicUserLocalService the topic user local service
	 */
	public void setTopicUserLocalService(
		it.cm.liferay.chat.topic.service.TopicUserLocalService topicUserLocalService) {
		this.topicUserLocalService = topicUserLocalService;
	}

	/**
	 * Returns the topic user remote service.
	 *
	 * @return the topic user remote service
	 */
	public it.cm.liferay.chat.topic.service.TopicUserService getTopicUserService() {
		return topicUserService;
	}

	/**
	 * Sets the topic user remote service.
	 *
	 * @param topicUserService the topic user remote service
	 */
	public void setTopicUserService(
		it.cm.liferay.chat.topic.service.TopicUserService topicUserService) {
		this.topicUserService = topicUserService;
	}

	/**
	 * Returns the topic user persistence.
	 *
	 * @return the topic user persistence
	 */
	public TopicUserPersistence getTopicUserPersistence() {
		return topicUserPersistence;
	}

	/**
	 * Sets the topic user persistence.
	 *
	 * @param topicUserPersistence the topic user persistence
	 */
	public void setTopicUserPersistence(
		TopicUserPersistence topicUserPersistence) {
		this.topicUserPersistence = topicUserPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TopicService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Topic.class;
	}

	protected String getModelClassName() {
		return Topic.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = topicPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = it.cm.liferay.chat.topic.service.MessageLocalService.class)
	protected it.cm.liferay.chat.topic.service.MessageLocalService messageLocalService;
	@BeanReference(type = it.cm.liferay.chat.topic.service.MessageService.class)
	protected it.cm.liferay.chat.topic.service.MessageService messageService;
	@BeanReference(type = MessagePersistence.class)
	protected MessagePersistence messagePersistence;
	@BeanReference(type = it.cm.liferay.chat.topic.service.MessageUserLocalService.class)
	protected it.cm.liferay.chat.topic.service.MessageUserLocalService messageUserLocalService;
	@BeanReference(type = it.cm.liferay.chat.topic.service.MessageUserService.class)
	protected it.cm.liferay.chat.topic.service.MessageUserService messageUserService;
	@BeanReference(type = MessageUserPersistence.class)
	protected MessageUserPersistence messageUserPersistence;
	@BeanReference(type = it.cm.liferay.chat.topic.service.TopicLocalService.class)
	protected it.cm.liferay.chat.topic.service.TopicLocalService topicLocalService;
	@BeanReference(type = TopicService.class)
	protected TopicService topicService;
	@BeanReference(type = TopicPersistence.class)
	protected TopicPersistence topicPersistence;
	@BeanReference(type = it.cm.liferay.chat.topic.service.TopicUserLocalService.class)
	protected it.cm.liferay.chat.topic.service.TopicUserLocalService topicUserLocalService;
	@BeanReference(type = it.cm.liferay.chat.topic.service.TopicUserService.class)
	protected it.cm.liferay.chat.topic.service.TopicUserService topicUserService;
	@BeanReference(type = TopicUserPersistence.class)
	protected TopicUserPersistence topicUserPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}