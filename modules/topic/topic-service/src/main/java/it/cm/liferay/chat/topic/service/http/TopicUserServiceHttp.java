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

package it.cm.liferay.chat.topic.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import it.cm.liferay.chat.topic.service.TopicUserServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link TopicUserServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicUserServiceSoap
 * @see HttpPrincipal
 * @see TopicUserServiceUtil
 * @generated
 */
@ProviderType
public class TopicUserServiceHttp {
	public static java.util.Collection<Long> getTopicIdsByUserId(
		HttpPrincipal httpPrincipal, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TopicUserServiceUtil.class,
					"getTopicIdsByUserId", _getTopicIdsByUserIdParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.Collection<Long>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static it.cm.liferay.chat.topic.model.Topic getTopicByUserIds(
		HttpPrincipal httpPrincipal, long userId1, long userId2)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TopicUserServiceUtil.class,
					"getTopicByUserIds", _getTopicByUserIdsParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId1,
					userId2);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (it.cm.liferay.chat.topic.model.Topic)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.Collection<Long> getUserIdsByTopicId(
		HttpPrincipal httpPrincipal, long topicId) {
		try {
			MethodKey methodKey = new MethodKey(TopicUserServiceUtil.class,
					"getUserIdsByTopicId", _getUserIdsByTopicIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, topicId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.Collection<Long>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TopicUserServiceHttp.class);
	private static final Class<?>[] _getTopicIdsByUserIdParameterTypes0 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getTopicByUserIdsParameterTypes1 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getUserIdsByTopicIdParameterTypes2 = new Class[] {
			long.class
		};
}