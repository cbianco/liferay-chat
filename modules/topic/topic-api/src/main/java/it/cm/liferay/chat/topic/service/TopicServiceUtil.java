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
 * Provides the remote service utility for Topic. This utility wraps
 * {@link it.cm.liferay.chat.topic.service.impl.TopicServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TopicService
 * @see it.cm.liferay.chat.topic.service.base.TopicServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.impl.TopicServiceImpl
 * @generated
 */
@ProviderType
public class TopicServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.cm.liferay.chat.topic.service.impl.TopicServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static it.cm.liferay.chat.topic.model.Topic addTopic(
		long companyId, long userId1, long user2)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addTopic(companyId, userId1, user2);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static it.cm.liferay.chat.topic.model.Topic getTopic(long topicId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTopic(topicId);
	}

	public static it.cm.liferay.chat.topic.model.Topic getTopicByUserIds(
		long companyId, long userId1, long userId2)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTopicByUserIds(companyId, userId1, userId2);
	}

	public static TopicService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TopicService, TopicService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TopicService.class);

		ServiceTracker<TopicService, TopicService> serviceTracker = new ServiceTracker<TopicService, TopicService>(bundle.getBundleContext(),
				TopicService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}