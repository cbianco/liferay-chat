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
 * Provides the remote service utility for MessageUser. This utility wraps
 * {@link it.cm.liferay.chat.topic.service.impl.MessageUserServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MessageUserService
 * @see it.cm.liferay.chat.topic.service.base.MessageUserServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.impl.MessageUserServiceImpl
 * @generated
 */
@ProviderType
public class MessageUserServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.cm.liferay.chat.topic.service.impl.MessageUserServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static int countUnreadTopicMessages(long userId, long topicId) {
		return getService().countUnreadTopicMessages(userId, topicId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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

	public static MessageUserService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MessageUserService, MessageUserService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MessageUserService.class);

		ServiceTracker<MessageUserService, MessageUserService> serviceTracker = new ServiceTracker<MessageUserService, MessageUserService>(bundle.getBundleContext(),
				MessageUserService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}