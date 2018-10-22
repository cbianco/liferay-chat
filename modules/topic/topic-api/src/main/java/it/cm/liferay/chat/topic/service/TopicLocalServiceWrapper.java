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
 * Provides a wrapper for {@link TopicLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TopicLocalService
 * @generated
 */
@ProviderType
public class TopicLocalServiceWrapper implements TopicLocalService,
	ServiceWrapper<TopicLocalService> {
	public TopicLocalServiceWrapper(TopicLocalService topicLocalService) {
		_topicLocalService = topicLocalService;
	}

	@Override
	public it.cm.liferay.chat.topic.model.Topic addTopic(long companyId,
		long groupId, long userId, long[] otherIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicLocalService.addTopic(companyId, groupId, userId, otherIds);
	}

	/**
	* Adds the topic to the database. Also notifies the appropriate model listeners.
	*
	* @param topic the topic
	* @return the topic that was added
	*/
	@Override
	public it.cm.liferay.chat.topic.model.Topic addTopic(
		it.cm.liferay.chat.topic.model.Topic topic) {
		return _topicLocalService.addTopic(topic);
	}

	/**
	* Creates a new topic with the primary key. Does not add the topic to the database.
	*
	* @param topicId the primary key for the new topic
	* @return the new topic
	*/
	@Override
	public it.cm.liferay.chat.topic.model.Topic createTopic(long topicId) {
		return _topicLocalService.createTopic(topicId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the topic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param topicId the primary key of the topic
	* @return the topic that was removed
	* @throws PortalException if a topic with the primary key could not be found
	*/
	@Override
	public it.cm.liferay.chat.topic.model.Topic deleteTopic(long topicId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicLocalService.deleteTopic(topicId);
	}

	/**
	* Deletes the topic from the database. Also notifies the appropriate model listeners.
	*
	* @param topic the topic
	* @return the topic that was removed
	*/
	@Override
	public it.cm.liferay.chat.topic.model.Topic deleteTopic(
		it.cm.liferay.chat.topic.model.Topic topic) {
		return _topicLocalService.deleteTopic(topic);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _topicLocalService.dynamicQuery();
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
		return _topicLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.cm.liferay.chat.topic.model.impl.TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _topicLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.cm.liferay.chat.topic.model.impl.TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _topicLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _topicLocalService.dynamicQueryCount(dynamicQuery);
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
		return _topicLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.cm.liferay.chat.topic.model.Topic fetchTopic(long topicId) {
		return _topicLocalService.fetchTopic(topicId);
	}

	/**
	* Returns the topic matching the UUID and group.
	*
	* @param uuid the topic's UUID
	* @param groupId the primary key of the group
	* @return the matching topic, or <code>null</code> if a matching topic could not be found
	*/
	@Override
	public it.cm.liferay.chat.topic.model.Topic fetchTopicByUuidAndGroupId(
		String uuid, long groupId) {
		return _topicLocalService.fetchTopicByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _topicLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _topicLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _topicLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _topicLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the topic with the primary key.
	*
	* @param topicId the primary key of the topic
	* @return the topic
	* @throws PortalException if a topic with the primary key could not be found
	*/
	@Override
	public it.cm.liferay.chat.topic.model.Topic getTopic(long topicId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicLocalService.getTopic(topicId);
	}

	/**
	* Returns the topic matching the UUID and group.
	*
	* @param uuid the topic's UUID
	* @param groupId the primary key of the group
	* @return the matching topic
	* @throws PortalException if a matching topic could not be found
	*/
	@Override
	public it.cm.liferay.chat.topic.model.Topic getTopicByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicLocalService.getTopicByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the topics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.cm.liferay.chat.topic.model.impl.TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of topics
	* @param end the upper bound of the range of topics (not inclusive)
	* @return the range of topics
	*/
	@Override
	public java.util.List<it.cm.liferay.chat.topic.model.Topic> getTopics(
		int start, int end) {
		return _topicLocalService.getTopics(start, end);
	}

	/**
	* Returns all the topics matching the UUID and company.
	*
	* @param uuid the UUID of the topics
	* @param companyId the primary key of the company
	* @return the matching topics, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<it.cm.liferay.chat.topic.model.Topic> getTopicsByUuidAndCompanyId(
		String uuid, long companyId) {
		return _topicLocalService.getTopicsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of topics matching the UUID and company.
	*
	* @param uuid the UUID of the topics
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of topics
	* @param end the upper bound of the range of topics (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching topics, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<it.cm.liferay.chat.topic.model.Topic> getTopicsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<it.cm.liferay.chat.topic.model.Topic> orderByComparator) {
		return _topicLocalService.getTopicsByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of topics.
	*
	* @return the number of topics
	*/
	@Override
	public int getTopicsCount() {
		return _topicLocalService.getTopicsCount();
	}

	/**
	* Updates the topic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param topic the topic
	* @return the topic that was updated
	*/
	@Override
	public it.cm.liferay.chat.topic.model.Topic updateTopic(
		it.cm.liferay.chat.topic.model.Topic topic) {
		return _topicLocalService.updateTopic(topic);
	}

	@Override
	public TopicLocalService getWrappedService() {
		return _topicLocalService;
	}

	@Override
	public void setWrappedService(TopicLocalService topicLocalService) {
		_topicLocalService = topicLocalService;
	}

	private TopicLocalService _topicLocalService;
}