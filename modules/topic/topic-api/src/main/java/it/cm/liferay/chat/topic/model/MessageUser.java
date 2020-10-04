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
 * The extended model interface for the MessageUser service. Represents a row in the &quot;Conversation_MessageUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MessageUserModel
 * @see it.cm.liferay.chat.topic.model.impl.MessageUserImpl
 * @see it.cm.liferay.chat.topic.model.impl.MessageUserModelImpl
 * @generated
 */
@ImplementationClassName("it.cm.liferay.chat.topic.model.impl.MessageUserImpl")
@ProviderType
public interface MessageUser extends MessageUserModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link it.cm.liferay.chat.topic.model.impl.MessageUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MessageUser, Long> MESSAGE_ID_ACCESSOR = new Accessor<MessageUser, Long>() {
			@Override
			public Long get(MessageUser messageUser) {
				return messageUser.getMessageId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MessageUser> getTypeClass() {
				return MessageUser.class;
			}
		};

	public static final Accessor<MessageUser, Long> USER_ID_ACCESSOR = new Accessor<MessageUser, Long>() {
			@Override
			public Long get(MessageUser messageUser) {
				return messageUser.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MessageUser> getTypeClass() {
				return MessageUser.class;
			}
		};
}