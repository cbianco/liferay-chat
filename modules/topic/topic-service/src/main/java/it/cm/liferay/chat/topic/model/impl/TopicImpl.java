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
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.exception.PortalException;
import it.cm.liferay.chat.topic.service.TopicUserService;

import java.util.Collection;

/**
 * The extended model implementation for the Topic service. Represents a row in the &quot;Conversation_Topic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.cm.liferay.chat.topic.model.Topic} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class TopicImpl extends TopicBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a topic model instance should use the {@link it.cm.liferay.chat.topic.model.Topic} interface instead.
	 */
	public TopicImpl() {
	}

	public Collection<Long> getUserIds() throws PortalException {
		return topicUserService.getUserIdsByTopicId(getTopicId());
	}

	@BeanReference(type = TopicUserService.class)
	protected TopicUserService topicUserService;

}