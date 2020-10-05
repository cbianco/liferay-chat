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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for MessageUser. This utility wraps
 * {@link it.cm.liferay.chat.topic.service.impl.MessageUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MessageUserLocalService
 * @see it.cm.liferay.chat.topic.service.base.MessageUserLocalServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.impl.MessageUserLocalServiceImpl
 * @generated
 */
@ProviderType
public class MessageUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.cm.liferay.chat.topic.service.impl.MessageUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addMessageUser(long messageId, long userId, long topicId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().addMessageUser(messageId, userId, topicId);
	}

	public static void addMessageUser(long messageId, long userId,
		long topicId, boolean read)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().addMessageUser(messageId, userId, topicId, read);
	}

	/**
	* Adds the message user to the database. Also notifies the appropriate model listeners.
	*
	* @param messageUser the message user
	* @return the message user that was added
	*/
	public static it.cm.liferay.chat.topic.model.MessageUser addMessageUser(
		it.cm.liferay.chat.topic.model.MessageUser messageUser) {
		return getService().addMessageUser(messageUser);
	}

	public static int countUnreadTopicMessages(long userId, long topicId) {
		return getService().countUnreadTopicMessages(userId, topicId);
	}

	/**
	* Creates a new message user with the primary key. Does not add the message user to the database.
	*
	* @param messageUserPK the primary key for the new message user
	* @return the new message user
	*/
	public static it.cm.liferay.chat.topic.model.MessageUser createMessageUser(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK) {
		return getService().createMessageUser(messageUserPK);
	}

	/**
	* Deletes the message user from the database. Also notifies the appropriate model listeners.
	*
	* @param messageUser the message user
	* @return the message user that was removed
	*/
	public static it.cm.liferay.chat.topic.model.MessageUser deleteMessageUser(
		it.cm.liferay.chat.topic.model.MessageUser messageUser) {
		return getService().deleteMessageUser(messageUser);
	}

	/**
	* Deletes the message user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageUserPK the primary key of the message user
	* @return the message user that was removed
	* @throws PortalException if a message user with the primary key could not be found
	*/
	public static it.cm.liferay.chat.topic.model.MessageUser deleteMessageUser(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMessageUser(messageUserPK);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.cm.liferay.chat.topic.model.MessageUser fetchMessageUser(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK) {
		return getService().fetchMessageUser(messageUserPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the message user with the primary key.
	*
	* @param messageUserPK the primary key of the message user
	* @return the message user
	* @throws PortalException if a message user with the primary key could not be found
	*/
	public static it.cm.liferay.chat.topic.model.MessageUser getMessageUser(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMessageUser(messageUserPK);
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
	public static java.util.List<it.cm.liferay.chat.topic.model.MessageUser> getMessageUsers(
		int start, int end) {
		return getService().getMessageUsers(start, end);
	}

	/**
	* Returns the number of message users.
	*
	* @return the number of message users
	*/
	public static int getMessageUsersCount() {
		return getService().getMessageUsersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.Collection<it.cm.liferay.chat.topic.model.MessageUser> getUnreadTopicMessages(
		long topicId) {
		return getService().getUnreadTopicMessages(topicId);
	}

	public static boolean isRead(long userId, long messageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().isRead(userId, messageId);
	}

	public static void setReadTopic(long userId, long topicId) {
		getService().setReadTopic(userId, topicId);
	}

	/**
	* Updates the message user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param messageUser the message user
	* @return the message user that was updated
	*/
	public static it.cm.liferay.chat.topic.model.MessageUser updateMessageUser(
		it.cm.liferay.chat.topic.model.MessageUser messageUser) {
		return getService().updateMessageUser(messageUser);
	}

	public static MessageUserLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MessageUserLocalService, MessageUserLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MessageUserLocalService.class);

		ServiceTracker<MessageUserLocalService, MessageUserLocalService> serviceTracker =
			new ServiceTracker<MessageUserLocalService, MessageUserLocalService>(bundle.getBundleContext(),
				MessageUserLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}