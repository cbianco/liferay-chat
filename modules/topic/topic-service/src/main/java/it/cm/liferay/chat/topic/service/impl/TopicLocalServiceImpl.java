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

import com.liferay.counter.kernel.model.Counter;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import it.cm.liferay.chat.topic.model.Topic;
import it.cm.liferay.chat.topic.service.base.TopicLocalServiceBaseImpl;

import java.util.Date;

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
			long companyId, long groupId, long userId)
		throws PortalException {

		Topic topic = topicPersistence.create(
			counterLocalService.increment());

		User user = userLocalService.getUser(userId);
		Date createDate = new Date();

		topic.setCompanyId(companyId);
		topic.setCreateDate(createDate);
		topic.setGroupId(groupId);
		topic.setUserId(userId);
		topic.setUserName(user.getFullName());
		topic.setModifiedDate(createDate);

		// TODO validate

		return topicPersistence.update(topic);
	}

}