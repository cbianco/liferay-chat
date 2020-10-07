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

import it.cm.liferay.chat.topic.service.MessageUserServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link MessageUserServiceUtil} service utility. The
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
 * @see MessageUserServiceSoap
 * @see HttpPrincipal
 * @see MessageUserServiceUtil
 * @generated
 */
@ProviderType
public class MessageUserServiceHttp {
	public static int countUnreadTopicMessages(HttpPrincipal httpPrincipal,
		long userId, long topicId) {
		try {
			MethodKey methodKey = new MethodKey(MessageUserServiceUtil.class,
					"countUnreadTopicMessages",
					_countUnreadTopicMessagesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					topicId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.Collection<it.cm.liferay.chat.topic.model.MessageUser> getUnreadTopicMessages(
		HttpPrincipal httpPrincipal, long topicId) {
		try {
			MethodKey methodKey = new MethodKey(MessageUserServiceUtil.class,
					"getUnreadTopicMessages",
					_getUnreadTopicMessagesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, topicId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.Collection<it.cm.liferay.chat.topic.model.MessageUser>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static boolean isRead(HttpPrincipal httpPrincipal, long userId,
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(MessageUserServiceUtil.class,
					"isRead", _isReadParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					messageId);

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

			return ((Boolean)returnObj).booleanValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void setReadTopic(HttpPrincipal httpPrincipal, long userId,
		long topicId) {
		try {
			MethodKey methodKey = new MethodKey(MessageUserServiceUtil.class,
					"setReadTopic", _setReadTopicParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					topicId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MessageUserServiceHttp.class);
	private static final Class<?>[] _countUnreadTopicMessagesParameterTypes0 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getUnreadTopicMessagesParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _isReadParameterTypes2 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _setReadTopicParameterTypes3 = new Class[] {
			long.class, long.class
		};
}