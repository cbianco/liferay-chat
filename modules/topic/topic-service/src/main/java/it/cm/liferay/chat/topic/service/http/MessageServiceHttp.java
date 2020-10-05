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

import it.cm.liferay.chat.topic.service.MessageServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link MessageServiceUtil} service utility. The
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
 * @see MessageServiceSoap
 * @see HttpPrincipal
 * @see MessageServiceUtil
 * @generated
 */
@ProviderType
public class MessageServiceHttp {
	public static it.cm.liferay.chat.topic.model.Message addMessage(
		HttpPrincipal httpPrincipal, long userId, long topicId, String content)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(MessageServiceUtil.class,
					"addMessage", _addMessageParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					topicId, content);

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

			return (it.cm.liferay.chat.topic.model.Message)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getTopicMessages(
		HttpPrincipal httpPrincipal, long userId, long topicId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(MessageServiceUtil.class,
					"getTopicMessages", _getTopicMessagesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					topicId);

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

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.Collection<it.cm.liferay.chat.topic.model.Message> getTopicMessages(
		HttpPrincipal httpPrincipal, long userId, long topicId, int start,
		int end) {
		try {
			MethodKey methodKey = new MethodKey(MessageServiceUtil.class,
					"getTopicMessages", _getTopicMessagesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					topicId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.Collection<it.cm.liferay.chat.topic.model.Message>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MessageServiceHttp.class);
	private static final Class<?>[] _addMessageParameterTypes0 = new Class[] {
			long.class, long.class, String.class
		};
	private static final Class<?>[] _getTopicMessagesParameterTypes1 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getTopicMessagesParameterTypes2 = new Class[] {
			long.class, long.class, int.class, int.class
		};
}