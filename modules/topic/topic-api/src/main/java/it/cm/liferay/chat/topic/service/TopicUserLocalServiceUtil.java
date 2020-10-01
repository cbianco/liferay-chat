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
 * Provides the local service utility for TopicUser. This utility wraps
 * {@link it.cm.liferay.chat.topic.service.impl.TopicUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TopicUserLocalService
 * @see it.cm.liferay.chat.topic.service.base.TopicUserLocalServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.impl.TopicUserLocalServiceImpl
 * @generated
 */
@ProviderType
public class TopicUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.cm.liferay.chat.topic.service.impl.TopicUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addTopicUser(long topicId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().addTopicUser(topicId, userId);
	}

	/**
	* Adds the topic user to the database. Also notifies the appropriate model listeners.
	*
	* @param topicUser the topic user
	* @return the topic user that was added
	*/
	public static it.cm.liferay.chat.topic.model.TopicUser addTopicUser(
		it.cm.liferay.chat.topic.model.TopicUser topicUser) {
		return getService().addTopicUser(topicUser);
	}

	public static int countByTopicId(long topicId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().countByTopicId(topicId);
	}

	/**
	* Creates a new topic user with the primary key. Does not add the topic user to the database.
	*
	* @param topicUserPK the primary key for the new topic user
	* @return the new topic user
	*/
	public static it.cm.liferay.chat.topic.model.TopicUser createTopicUser(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK) {
		return getService().createTopicUser(topicUserPK);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the topic user from the database. Also notifies the appropriate model listeners.
	*
	* @param topicUser the topic user
	* @return the topic user that was removed
	*/
	public static it.cm.liferay.chat.topic.model.TopicUser deleteTopicUser(
		it.cm.liferay.chat.topic.model.TopicUser topicUser) {
		return getService().deleteTopicUser(topicUser);
	}

	/**
	* Deletes the topic user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user that was removed
	* @throws PortalException if a topic user with the primary key could not be found
	*/
	public static it.cm.liferay.chat.topic.model.TopicUser deleteTopicUser(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTopicUser(topicUserPK);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.cm.liferay.chat.topic.model.impl.TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.cm.liferay.chat.topic.model.impl.TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.cm.liferay.chat.topic.model.TopicUser fetchTopicUser(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK) {
		return getService().fetchTopicUser(topicUserPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
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

	public static java.util.Collection<Long> getTopicIdsByUserId(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTopicIdsByUserId(userId);
	}

	/**
	* Returns the topic user with the primary key.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user
	* @throws PortalException if a topic user with the primary key could not be found
	*/
	public static it.cm.liferay.chat.topic.model.TopicUser getTopicUser(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTopicUser(topicUserPK);
	}

	/**
	* Returns a range of all the topic users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.cm.liferay.chat.topic.model.impl.TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @return the range of topic users
	*/
	public static java.util.List<it.cm.liferay.chat.topic.model.TopicUser> getTopicUsers(
		int start, int end) {
		return getService().getTopicUsers(start, end);
	}

	/**
	* Returns the number of topic users.
	*
	* @return the number of topic users
	*/
	public static int getTopicUsersCount() {
		return getService().getTopicUsersCount();
	}

	public static java.util.Collection<Long> getUserIdsByTopicId(long topicId) {
		return getService().getUserIdsByTopicId(topicId);
	}

	/**
	* Updates the topic user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param topicUser the topic user
	* @return the topic user that was updated
	*/
	public static it.cm.liferay.chat.topic.model.TopicUser updateTopicUser(
		it.cm.liferay.chat.topic.model.TopicUser topicUser) {
		return getService().updateTopicUser(topicUser);
	}

	public static TopicUserLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TopicUserLocalService, TopicUserLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TopicUserLocalService.class);

		ServiceTracker<TopicUserLocalService, TopicUserLocalService> serviceTracker =
			new ServiceTracker<TopicUserLocalService, TopicUserLocalService>(bundle.getBundleContext(),
				TopicUserLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}