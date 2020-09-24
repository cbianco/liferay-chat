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
 * Provides the remote service utility for Message. This utility wraps
 * {@link it.cm.liferay.chat.topic.service.impl.MessageServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MessageService
 * @see it.cm.liferay.chat.topic.service.base.MessageServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.impl.MessageServiceImpl
 * @generated
 */
@ProviderType
public class MessageServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.cm.liferay.chat.topic.service.impl.MessageServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.Collection<it.cm.liferay.chat.topic.model.Message> getTopicMessages(
		long topicId) {
		return getService().getTopicMessages(topicId);
	}

	public static java.util.Collection<it.cm.liferay.chat.topic.model.Message> getTopicMessages(
		long topicId, int start, int end) {
		return getService().getTopicMessages(topicId, start, end);
	}

	public static MessageService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MessageService, MessageService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MessageService.class);

		ServiceTracker<MessageService, MessageService> serviceTracker = new ServiceTracker<MessageService, MessageService>(bundle.getBundleContext(),
				MessageService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}