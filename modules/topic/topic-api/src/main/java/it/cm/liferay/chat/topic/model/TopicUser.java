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

package it.cm.liferay.chat.topic.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the TopicUser service. Represents a row in the &quot;Conversation_TopicUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TopicUserModel
 * @see it.cm.liferay.chat.topic.model.impl.TopicUserImpl
 * @see it.cm.liferay.chat.topic.model.impl.TopicUserModelImpl
 * @generated
 */
@ImplementationClassName("it.cm.liferay.chat.topic.model.impl.TopicUserImpl")
@ProviderType
public interface TopicUser extends TopicUserModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link it.cm.liferay.chat.topic.model.impl.TopicUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TopicUser, Long> TOPIC_ID_ACCESSOR = new Accessor<TopicUser, Long>() {
			@Override
			public Long get(TopicUser topicUser) {
				return topicUser.getTopicId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TopicUser> getTypeClass() {
				return TopicUser.class;
			}
		};

	public static final Accessor<TopicUser, Long> USER_ID_ACCESSOR = new Accessor<TopicUser, Long>() {
			@Override
			public Long get(TopicUser topicUser) {
				return topicUser.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TopicUser> getTypeClass() {
				return TopicUser.class;
			}
		};
}