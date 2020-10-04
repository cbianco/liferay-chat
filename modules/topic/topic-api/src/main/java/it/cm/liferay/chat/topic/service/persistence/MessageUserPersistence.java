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

package it.cm.liferay.chat.topic.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.cm.liferay.chat.topic.exception.NoSuchMessageUserException;
import it.cm.liferay.chat.topic.model.MessageUser;

/**
 * The persistence interface for the message user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.cm.liferay.chat.topic.service.persistence.impl.MessageUserPersistenceImpl
 * @see MessageUserUtil
 * @generated
 */
@ProviderType
public interface MessageUserPersistence extends BasePersistence<MessageUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MessageUserUtil} to access the message user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the message users where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @return the matching message users
	*/
	public java.util.List<MessageUser> findByT_R(long topicId, boolean read);

	/**
	* Returns a range of all the message users where topicId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicId the topic ID
	* @param read the read
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @return the range of matching message users
	*/
	public java.util.List<MessageUser> findByT_R(long topicId, boolean read,
		int start, int end);

	/**
	* Returns an ordered range of all the message users where topicId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicId the topic ID
	* @param read the read
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching message users
	*/
	public java.util.List<MessageUser> findByT_R(long topicId, boolean read,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator);

	/**
	* Returns an ordered range of all the message users where topicId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicId the topic ID
	* @param read the read
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching message users
	*/
	public java.util.List<MessageUser> findByT_R(long topicId, boolean read,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first message user in the ordered set where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user
	* @throws NoSuchMessageUserException if a matching message user could not be found
	*/
	public MessageUser findByT_R_First(long topicId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException;

	/**
	* Returns the first message user in the ordered set where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public MessageUser fetchByT_R_First(long topicId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator);

	/**
	* Returns the last message user in the ordered set where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user
	* @throws NoSuchMessageUserException if a matching message user could not be found
	*/
	public MessageUser findByT_R_Last(long topicId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException;

	/**
	* Returns the last message user in the ordered set where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public MessageUser fetchByT_R_Last(long topicId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator);

	/**
	* Returns the message users before and after the current message user in the ordered set where topicId = &#63; and read = &#63;.
	*
	* @param messageUserPK the primary key of the current message user
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next message user
	* @throws NoSuchMessageUserException if a message user with the primary key could not be found
	*/
	public MessageUser[] findByT_R_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK,
		long topicId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException;

	/**
	* Removes all the message users where topicId = &#63; and read = &#63; from the database.
	*
	* @param topicId the topic ID
	* @param read the read
	*/
	public void removeByT_R(long topicId, boolean read);

	/**
	* Returns the number of message users where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @return the number of matching message users
	*/
	public int countByT_R(long topicId, boolean read);

	/**
	* Returns all the message users where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @return the matching message users
	*/
	public java.util.List<MessageUser> findByU_R(long userId, boolean read);

	/**
	* Returns a range of all the message users where userId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param read the read
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @return the range of matching message users
	*/
	public java.util.List<MessageUser> findByU_R(long userId, boolean read,
		int start, int end);

	/**
	* Returns an ordered range of all the message users where userId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param read the read
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching message users
	*/
	public java.util.List<MessageUser> findByU_R(long userId, boolean read,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator);

	/**
	* Returns an ordered range of all the message users where userId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param read the read
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching message users
	*/
	public java.util.List<MessageUser> findByU_R(long userId, boolean read,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first message user in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user
	* @throws NoSuchMessageUserException if a matching message user could not be found
	*/
	public MessageUser findByU_R_First(long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException;

	/**
	* Returns the first message user in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public MessageUser fetchByU_R_First(long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator);

	/**
	* Returns the last message user in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user
	* @throws NoSuchMessageUserException if a matching message user could not be found
	*/
	public MessageUser findByU_R_Last(long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException;

	/**
	* Returns the last message user in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public MessageUser fetchByU_R_Last(long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator);

	/**
	* Returns the message users before and after the current message user in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param messageUserPK the primary key of the current message user
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next message user
	* @throws NoSuchMessageUserException if a message user with the primary key could not be found
	*/
	public MessageUser[] findByU_R_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK,
		long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException;

	/**
	* Removes all the message users where userId = &#63; and read = &#63; from the database.
	*
	* @param userId the user ID
	* @param read the read
	*/
	public void removeByU_R(long userId, boolean read);

	/**
	* Returns the number of message users where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @return the number of matching message users
	*/
	public int countByU_R(long userId, boolean read);

	/**
	* Returns all the message users where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @return the matching message users
	*/
	public java.util.List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read);

	/**
	* Returns a range of all the message users where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @return the range of matching message users
	*/
	public java.util.List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read, int start, int end);

	/**
	* Returns an ordered range of all the message users where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching message users
	*/
	public java.util.List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator);

	/**
	* Returns an ordered range of all the message users where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching message users
	*/
	public java.util.List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first message user in the ordered set where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user
	* @throws NoSuchMessageUserException if a matching message user could not be found
	*/
	public MessageUser findByU_T_R_First(long userId, long topicId,
		boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException;

	/**
	* Returns the first message user in the ordered set where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public MessageUser fetchByU_T_R_First(long userId, long topicId,
		boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator);

	/**
	* Returns the last message user in the ordered set where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user
	* @throws NoSuchMessageUserException if a matching message user could not be found
	*/
	public MessageUser findByU_T_R_Last(long userId, long topicId,
		boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException;

	/**
	* Returns the last message user in the ordered set where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public MessageUser fetchByU_T_R_Last(long userId, long topicId,
		boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator);

	/**
	* Returns the message users before and after the current message user in the ordered set where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param messageUserPK the primary key of the current message user
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next message user
	* @throws NoSuchMessageUserException if a message user with the primary key could not be found
	*/
	public MessageUser[] findByU_T_R_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK,
		long userId, long topicId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException;

	/**
	* Removes all the message users where userId = &#63; and topicId = &#63; and read = &#63; from the database.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	*/
	public void removeByU_T_R(long userId, long topicId, boolean read);

	/**
	* Returns the number of message users where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @return the number of matching message users
	*/
	public int countByU_T_R(long userId, long topicId, boolean read);

	/**
	* Caches the message user in the entity cache if it is enabled.
	*
	* @param messageUser the message user
	*/
	public void cacheResult(MessageUser messageUser);

	/**
	* Caches the message users in the entity cache if it is enabled.
	*
	* @param messageUsers the message users
	*/
	public void cacheResult(java.util.List<MessageUser> messageUsers);

	/**
	* Creates a new message user with the primary key. Does not add the message user to the database.
	*
	* @param messageUserPK the primary key for the new message user
	* @return the new message user
	*/
	public MessageUser create(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK);

	/**
	* Removes the message user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageUserPK the primary key of the message user
	* @return the message user that was removed
	* @throws NoSuchMessageUserException if a message user with the primary key could not be found
	*/
	public MessageUser remove(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK)
		throws NoSuchMessageUserException;

	public MessageUser updateImpl(MessageUser messageUser);

	/**
	* Returns the message user with the primary key or throws a {@link NoSuchMessageUserException} if it could not be found.
	*
	* @param messageUserPK the primary key of the message user
	* @return the message user
	* @throws NoSuchMessageUserException if a message user with the primary key could not be found
	*/
	public MessageUser findByPrimaryKey(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK)
		throws NoSuchMessageUserException;

	/**
	* Returns the message user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageUserPK the primary key of the message user
	* @return the message user, or <code>null</code> if a message user with the primary key could not be found
	*/
	public MessageUser fetchByPrimaryKey(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK);

	@Override
	public java.util.Map<java.io.Serializable, MessageUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the message users.
	*
	* @return the message users
	*/
	public java.util.List<MessageUser> findAll();

	/**
	* Returns a range of all the message users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @return the range of message users
	*/
	public java.util.List<MessageUser> findAll(int start, int end);

	/**
	* Returns an ordered range of all the message users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of message users
	*/
	public java.util.List<MessageUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator);

	/**
	* Returns an ordered range of all the message users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MessageUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of message users
	* @param end the upper bound of the range of message users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of message users
	*/
	public java.util.List<MessageUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the message users from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of message users.
	*
	* @return the number of message users
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();

	public java.util.Set<String> getCompoundPKColumnNames();
}