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

package it.cm.liferay.chat.topic.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import it.cm.liferay.chat.topic.model.Topic;
import it.cm.liferay.chat.topic.model.TopicUserModel;
import it.cm.liferay.chat.topic.service.base.TopicLocalServiceBaseImpl;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The implementation of the topic local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.cm.liferay.chat.topic.service.TopicLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicLocalServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.TopicLocalServiceUtil
 */
public class TopicLocalServiceImpl extends TopicLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link it.cm.liferay.chat.topic.service.TopicLocalServiceUtil} to access the topic local service.
	 */

	@Override
	public Topic addTopic(
			long userId, long otherIds[])
		throws PortalException {

		long topicId = counterLocalService.increment(Topic.class.getName());
		Topic topic = topicPersistence.create(topicId);

		User user = userLocalService.getUser(userId);
		Date createDate = new Date();

		topic.setCompanyId(user.getCompanyId());
		topic.setCreateDate(createDate);
		topic.setUserId(userId);
		topic.setUserName(user.getFullName());
		topic.setModifiedDate(createDate);

		// TODO validate

		// TopicUser
		topicUserLocalService.addTopicUser(topicId, userId);

		for (long otherId : otherIds) {
			topicUserLocalService.addTopicUser(topicId, otherId);
		}

		return topicPersistence.update(topic);
	}

	@Override
	public Collection<Topic> getTopicsByUserId(long userId) {

		return topicUserPersistence
			.findByUserId(userId)
			.stream()
			.map(TopicUserModel::getTopicId)
			.map(topicLocalService::fetchTopic)
			.filter(Objects::nonNull)
			.collect(Collectors.toList());
	}

}