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

import it.cm.liferay.chat.topic.exception.NoSuchTopicUserException;
import it.cm.liferay.chat.topic.model.TopicUser;

/**
 * The persistence interface for the topic user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.cm.liferay.chat.topic.service.persistence.impl.TopicUserPersistenceImpl
 * @see TopicUserUtil
 * @generated
 */
@ProviderType
public interface TopicUserPersistence extends BasePersistence<TopicUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TopicUserUtil} to access the topic user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the topic users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching topic users
	*/
	public java.util.List<TopicUser> findByUuid(String uuid);

	/**
	* Returns a range of all the topic users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @return the range of matching topic users
	*/
	public java.util.List<TopicUser> findByUuid(String uuid, int start, int end);

	/**
	* Returns an ordered range of all the topic users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns an ordered range of all the topic users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first topic user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the first topic user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the last topic user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the last topic user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the topic users before and after the current topic user in the ordered set where uuid = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public TopicUser[] findByUuid_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Removes all the topic users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of topic users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching topic users
	*/
	public int countByUuid(String uuid);

	/**
	* Returns all the topic users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching topic users
	*/
	public java.util.List<TopicUser> findByUserId(long userId);

	/**
	* Returns a range of all the topic users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @return the range of matching topic users
	*/
	public java.util.List<TopicUser> findByUserId(long userId, int start,
		int end);

	/**
	* Returns an ordered range of all the topic users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns an ordered range of all the topic users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the first topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the last topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the last topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the topic users before and after the current topic user in the ordered set where userId = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public TopicUser[] findByUserId_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Removes all the topic users where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of topic users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching topic users
	*/
	public int countByUserId(long userId);

	/**
	* Returns all the topic users where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @return the matching topic users
	*/
	public java.util.List<TopicUser> findByTopicId(long topicId);

	/**
	* Returns a range of all the topic users where topicId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicId the topic ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @return the range of matching topic users
	*/
	public java.util.List<TopicUser> findByTopicId(long topicId, int start,
		int end);

	/**
	* Returns an ordered range of all the topic users where topicId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicId the topic ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByTopicId(long topicId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns an ordered range of all the topic users where topicId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicId the topic ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByTopicId(long topicId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByTopicId_First(long topicId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the first topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByTopicId_First(long topicId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the last topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByTopicId_Last(long topicId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the last topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByTopicId_Last(long topicId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the topic users before and after the current topic user in the ordered set where topicId = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public TopicUser[] findByTopicId_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK,
		long topicId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Removes all the topic users where topicId = &#63; from the database.
	*
	* @param topicId the topic ID
	*/
	public void removeByTopicId(long topicId);

	/**
	* Returns the number of topic users where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @return the number of matching topic users
	*/
	public int countByTopicId(long topicId);

	/**
	* Returns all the topic users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching topic users
	*/
	public java.util.List<TopicUser> findByUserIds(long userId);

	/**
	* Returns a range of all the topic users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @return the range of matching topic users
	*/
	public java.util.List<TopicUser> findByUserIds(long userId, int start,
		int end);

	/**
	* Returns an ordered range of all the topic users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByUserIds(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns an ordered range of all the topic users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByUserIds(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByUserIds_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the first topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByUserIds_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the last topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByUserIds_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the last topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByUserIds_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the topic users before and after the current topic user in the ordered set where userId = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public TopicUser[] findByUserIds_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns all the topic users where userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIds the user IDs
	* @return the matching topic users
	*/
	public java.util.List<TopicUser> findByUserIds(long[] userIds);

	/**
	* Returns a range of all the topic users where userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIds the user IDs
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @return the range of matching topic users
	*/
	public java.util.List<TopicUser> findByUserIds(long[] userIds, int start,
		int end);

	/**
	* Returns an ordered range of all the topic users where userId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userIds the user IDs
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByUserIds(long[] userIds, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns an ordered range of all the topic users where userId = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByUserIds(long[] userIds, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the topic users where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserIds(long userId);

	/**
	* Returns the number of topic users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching topic users
	*/
	public int countByUserIds(long userId);

	/**
	* Returns the number of topic users where userId = any &#63;.
	*
	* @param userIds the user IDs
	* @return the number of matching topic users
	*/
	public int countByUserIds(long[] userIds);

	/**
	* Returns all the topic users where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @return the matching topic users
	*/
	public java.util.List<TopicUser> findByTopicIds(long topicId);

	/**
	* Returns a range of all the topic users where topicId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicId the topic ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @return the range of matching topic users
	*/
	public java.util.List<TopicUser> findByTopicIds(long topicId, int start,
		int end);

	/**
	* Returns an ordered range of all the topic users where topicId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicId the topic ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByTopicIds(long topicId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns an ordered range of all the topic users where topicId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicId the topic ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByTopicIds(long topicId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByTopicIds_First(long topicId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the first topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByTopicIds_First(long topicId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the last topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByTopicIds_Last(long topicId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the last topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByTopicIds_Last(long topicId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the topic users before and after the current topic user in the ordered set where topicId = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public TopicUser[] findByTopicIds_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK,
		long topicId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns all the topic users where topicId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicIds the topic IDs
	* @return the matching topic users
	*/
	public java.util.List<TopicUser> findByTopicIds(long[] topicIds);

	/**
	* Returns a range of all the topic users where topicId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicIds the topic IDs
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @return the range of matching topic users
	*/
	public java.util.List<TopicUser> findByTopicIds(long[] topicIds, int start,
		int end);

	/**
	* Returns an ordered range of all the topic users where topicId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicIds the topic IDs
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByTopicIds(long[] topicIds, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns an ordered range of all the topic users where topicId = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param topicId the topic ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByTopicIds(long[] topicIds, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the topic users where topicId = &#63; from the database.
	*
	* @param topicId the topic ID
	*/
	public void removeByTopicIds(long topicId);

	/**
	* Returns the number of topic users where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @return the number of matching topic users
	*/
	public int countByTopicIds(long topicId);

	/**
	* Returns the number of topic users where topicId = any &#63;.
	*
	* @param topicIds the topic IDs
	* @return the number of matching topic users
	*/
	public int countByTopicIds(long[] topicIds);

	/**
	* Caches the topic user in the entity cache if it is enabled.
	*
	* @param topicUser the topic user
	*/
	public void cacheResult(TopicUser topicUser);

	/**
	* Caches the topic users in the entity cache if it is enabled.
	*
	* @param topicUsers the topic users
	*/
	public void cacheResult(java.util.List<TopicUser> topicUsers);

	/**
	* Creates a new topic user with the primary key. Does not add the topic user to the database.
	*
	* @param topicUserPK the primary key for the new topic user
	* @return the new topic user
	*/
	public TopicUser create(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK);

	/**
	* Removes the topic user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user that was removed
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public TopicUser remove(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK)
		throws NoSuchTopicUserException;

	public TopicUser updateImpl(TopicUser topicUser);

	/**
	* Returns the topic user with the primary key or throws a {@link NoSuchTopicUserException} if it could not be found.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public TopicUser findByPrimaryKey(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK)
		throws NoSuchTopicUserException;

	/**
	* Returns the topic user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user, or <code>null</code> if a topic user with the primary key could not be found
	*/
	public TopicUser fetchByPrimaryKey(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK);

	@Override
	public java.util.Map<java.io.Serializable, TopicUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the topic users.
	*
	* @return the topic users
	*/
	public java.util.List<TopicUser> findAll();

	/**
	* Returns a range of all the topic users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @return the range of topic users
	*/
	public java.util.List<TopicUser> findAll(int start, int end);

	/**
	* Returns an ordered range of all the topic users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of topic users
	*/
	public java.util.List<TopicUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns an ordered range of all the topic users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of topic users
	*/
	public java.util.List<TopicUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the topic users from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of topic users.
	*
	* @return the number of topic users
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();

	public java.util.Set<String> getCompoundPKColumnNames();
}