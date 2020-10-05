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

package it.cm.liferay.chat.topic.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MessageUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MessageUserLocalService
 * @generated
 */
@ProviderType
public class MessageUserLocalServiceWrapper implements MessageUserLocalService,
	ServiceWrapper<MessageUserLocalService> {
	public MessageUserLocalServiceWrapper(
		MessageUserLocalService messageUserLocalService) {
		_messageUserLocalService = messageUserLocalService;
	}

	@Override
	public void addMessageUser(long messageId, long userId, long topicId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_messageUserLocalService.addMessageUser(messageId, userId, topicId);
	}

	@Override
	public void addMessageUser(long messageId, long userId, long topicId,
		boolean read)
		throws com.liferay.portal.kernel.exception.PortalException {
		_messageUserLocalService.addMessageUser(messageId, userId, topicId, read);
	}

	/**
	* Adds the message user to the database. Also notifies the appropriate model listeners.
	*
	* @param messageUser the message user
	* @return the message user that was added
	*/
	@Override
	public it.cm.liferay.chat.topic.model.MessageUser addMessageUser(
		it.cm.liferay.chat.topic.model.MessageUser messageUser) {
		return _messageUserLocalService.addMessageUser(messageUser);
	}

	@Override
	public int countUnreadTopicMessages(long userId, long topicId) {
		return _messageUserLocalService.countUnreadTopicMessages(userId, topicId);
	}

	/**
	* Creates a new message user with the primary key. Does not add the message user to the database.
	*
	* @param messageUserPK the primary key for the new message user
	* @return the new message user
	*/
	@Override
	public it.cm.liferay.chat.topic.model.MessageUser createMessageUser(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK) {
		return _messageUserLocalService.createMessageUser(messageUserPK);
	}

	/**
	* Deletes the message user from the database. Also notifies the appropriate model listeners.
	*
	* @param messageUser the message user
	* @return the message user that was removed
	*/
	@Override
	public it.cm.liferay.chat.topic.model.MessageUser deleteMessageUser(
		it.cm.liferay.chat.topic.model.MessageUser messageUser) {
		return _messageUserLocalService.deleteMessageUser(messageUser);
	}

	/**
	* Deletes the message user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageUserPK the primary key of the message user
	* @return the message user that was removed
	* @throws PortalException if a message user with the primary key could not be found
	*/
	@Override
	public it.cm.liferay.chat.topic.model.MessageUser deleteMessageUser(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _messageUserLocalService.deleteMessageUser(messageUserPK);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _messageUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _messageUserLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _messageUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.cm.liferay.chat.topic.model.impl.MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _messageUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.cm.liferay.chat.topic.model.impl.MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _messageUserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _messageUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _messageUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.cm.liferay.chat.topic.model.MessageUser fetchMessageUser(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK) {
		return _messageUserLocalService.fetchMessageUser(messageUserPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _messageUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _messageUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the message user with the primary key.
	*
	* @param messageUserPK the primary key of the message user
	* @return the message user
	* @throws PortalException if a message user with the primary key could not be found
	*/
	@Override
	public it.cm.liferay.chat.topic.model.MessageUser getMessageUser(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _messageUserLocalService.getMessageUser(messageUserPK);
	}

	/**
	* Returns a range of all the message users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.cm.liferay.chat.topic.model.impl.MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @return the range of message users
	*/
	@Override
	public java.util.List<it.cm.liferay.chat.topic.model.MessageUser> getMessageUsers(
		int start, int end) {
		return _messageUserLocalService.getMessageUsers(start, end);
	}

	/**
	* Returns the number of message users.
	*
	* @return the number of message users
	*/
	@Override
	public int getMessageUsersCount() {
		return _messageUserLocalService.getMessageUsersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _messageUserLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _messageUserLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.Collection<it.cm.liferay.chat.topic.model.MessageUser> getUnreadTopicMessages(
		long topicId) {
		return _messageUserLocalService.getUnreadTopicMessages(topicId);
	}

	@Override
	public boolean isRead(long userId, long messageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _messageUserLocalService.isRead(userId, messageId);
	}

	@Override
	public void setReadTopic(long userId, long topicId) {
		_messageUserLocalService.setReadTopic(userId, topicId);
	}

	/**
	* Updates the message user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param messageUser the message user
	* @return the message user that was updated
	*/
	@Override
	public it.cm.liferay.chat.topic.model.MessageUser updateMessageUser(
		it.cm.liferay.chat.topic.model.MessageUser messageUser) {
		return _messageUserLocalService.updateMessageUser(messageUser);
	}

	@Override
	public MessageUserLocalService getWrappedService() {
		return _messageUserLocalService;
	}

	@Override
	public void setWrappedService(
		MessageUserLocalService messageUserLocalService) {
		_messageUserLocalService = messageUserLocalService;
	}

	private MessageUserLocalService _messageUserLocalService;
}