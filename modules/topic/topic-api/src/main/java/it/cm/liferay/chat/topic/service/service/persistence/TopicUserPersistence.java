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

package it.cm.liferay.chat.topic.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException;
import it.cm.liferay.chat.topic.service.model.TopicUser;

/**
 * The persistence interface for the topic user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.cm.liferay.chat.topic.service.service.persistence.impl.TopicUserPersistenceImpl
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
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK,
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
	* Returns the topic user where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTopicUserException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByUUID_G(String uuid, long groupId)
		throws NoSuchTopicUserException;

	/**
	* Returns the topic user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the topic user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the topic user where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the topic user that was removed
	*/
	public TopicUser removeByUUID_G(String uuid, long groupId)
		throws NoSuchTopicUserException;

	/**
	* Returns the number of topic users where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching topic users
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the topic users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching topic users
	*/
	public java.util.List<TopicUser> findByUuid_C(String uuid, long companyId);

	/**
	* Returns a range of all the topic users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @return the range of matching topic users
	*/
	public java.util.List<TopicUser> findByUuid_C(String uuid, long companyId,
		int start, int end);

	/**
	* Returns an ordered range of all the topic users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns an ordered range of all the topic users where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of topic users
	* @param end the upper bound of the range of topic users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching topic users
	*/
	public java.util.List<TopicUser> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first topic user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the first topic user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the last topic user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public TopicUser findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Returns the last topic user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public TopicUser fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator);

	/**
	* Returns the topic users before and after the current topic user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public TopicUser[] findByUuid_C_PrevAndNext(
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK,
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException;

	/**
	* Removes all the topic users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of topic users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching topic users
	*/
	public int countByUuid_C(String uuid, long companyId);

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
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK);

	/**
	* Removes the topic user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user that was removed
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public TopicUser remove(
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK)
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
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK)
		throws NoSuchTopicUserException;

	/**
	* Returns the topic user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user, or <code>null</code> if a topic user with the primary key could not be found
	*/
	public TopicUser fetchByPrimaryKey(
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK);

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