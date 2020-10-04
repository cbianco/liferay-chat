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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import it.cm.liferay.chat.topic.model.Message;

import java.util.Collection;

/**
 * Provides the remote service interface for Message. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MessageServiceUtil
 * @see it.cm.liferay.chat.topic.service.base.MessageServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.impl.MessageServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=conversation", "json.web.service.context.path=Message"}, service = MessageService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MessageService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MessageServiceUtil} to access the message remote service. Add custom service methods to {@link it.cm.liferay.chat.topic.service.impl.MessageServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Message addMessage(long userId, long topicId, String content)
		throws PortalException;

	public int countUnreadTopicMessages(long topicId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Collection<Message> getTopicMessages(long topicId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Collection<Message> getTopicMessages(long topicId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Collection<Message> getUnreadTopicMessages(long topicId);
}