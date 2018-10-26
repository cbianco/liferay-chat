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
 * Provides a wrapper for {@link TopicUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TopicUserLocalService
 * @generated
 */
@ProviderType
public class TopicUserLocalServiceWrapper implements TopicUserLocalService,
	ServiceWrapper<TopicUserLocalService> {
	public TopicUserLocalServiceWrapper(
		TopicUserLocalService topicUserLocalService) {
		_topicUserLocalService = topicUserLocalService;
	}

	/**
	* Adds the topic user to the database. Also notifies the appropriate model listeners.
	*
	* @param topicUser the topic user
	* @return the topic user that was added
	*/
	@Override
	public it.cm.liferay.chat.topic.model.TopicUser addTopicUser(
		it.cm.liferay.chat.topic.model.TopicUser topicUser) {
		return _topicUserLocalService.addTopicUser(topicUser);
	}

	/**
	* Creates a new topic user with the primary key. Does not add the topic user to the database.
	*
	* @param topicUserPK the primary key for the new topic user
	* @return the new topic user
	*/
	@Override
	public it.cm.liferay.chat.topic.model.TopicUser createTopicUser(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK) {
		return _topicUserLocalService.createTopicUser(topicUserPK);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicUserLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the topic user from the database. Also notifies the appropriate model listeners.
	*
	* @param topicUser the topic user
	* @return the topic user that was removed
	*/
	@Override
	public it.cm.liferay.chat.topic.model.TopicUser deleteTopicUser(
		it.cm.liferay.chat.topic.model.TopicUser topicUser) {
		return _topicUserLocalService.deleteTopicUser(topicUser);
	}

	/**
	* Deletes the topic user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user that was removed
	* @throws PortalException if a topic user with the primary key could not be found
	*/
	@Override
	public it.cm.liferay.chat.topic.model.TopicUser deleteTopicUser(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicUserLocalService.deleteTopicUser(topicUserPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _topicUserLocalService.dynamicQuery();
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
		return _topicUserLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _topicUserLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _topicUserLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _topicUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _topicUserLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.cm.liferay.chat.topic.model.TopicUser fetchTopicUser(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK) {
		return _topicUserLocalService.fetchTopicUser(topicUserPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _topicUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _topicUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _topicUserLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the topic user with the primary key.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user
	* @throws PortalException if a topic user with the primary key could not be found
	*/
	@Override
	public it.cm.liferay.chat.topic.model.TopicUser getTopicUser(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicUserLocalService.getTopicUser(topicUserPK);
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
	@Override
	public java.util.List<it.cm.liferay.chat.topic.model.TopicUser> getTopicUsers(
		int start, int end) {
		return _topicUserLocalService.getTopicUsers(start, end);
	}

	/**
	* Returns the number of topic users.
	*
	* @return the number of topic users
	*/
	@Override
	public int getTopicUsersCount() {
		return _topicUserLocalService.getTopicUsersCount();
	}

	/**
	* Updates the topic user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param topicUser the topic user
	* @return the topic user that was updated
	*/
	@Override
	public it.cm.liferay.chat.topic.model.TopicUser updateTopicUser(
		it.cm.liferay.chat.topic.model.TopicUser topicUser) {
		return _topicUserLocalService.updateTopicUser(topicUser);
	}

	@Override
	public TopicUserLocalService getWrappedService() {
		return _topicUserLocalService;
	}

	@Override
	public void setWrappedService(TopicUserLocalService topicUserLocalService) {
		_topicUserLocalService = topicUserLocalService;
	}

	private TopicUserLocalService _topicUserLocalService;
}