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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.cm.liferay.chat.topic.service.model.TopicUser;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the topic user service. This utility wraps {@link it.cm.liferay.chat.topic.service.service.persistence.impl.TopicUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicUserPersistence
 * @see it.cm.liferay.chat.topic.service.service.persistence.impl.TopicUserPersistenceImpl
 * @generated
 */
@ProviderType
public class TopicUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TopicUser topicUser) {
		getPersistence().clearCache(topicUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TopicUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TopicUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TopicUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TopicUser update(TopicUser topicUser) {
		return getPersistence().update(topicUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TopicUser update(TopicUser topicUser,
		ServiceContext serviceContext) {
		return getPersistence().update(topicUser, serviceContext);
	}

	/**
	* Returns all the topic users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching topic users
	*/
	public static List<TopicUser> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<TopicUser> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<TopicUser> findByUuid(String uuid, int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<TopicUser> findByUuid(String uuid, int start, int end,
		OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first topic user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByUuid_First(String uuid,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first topic user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByUuid_First(String uuid,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByUuid_Last(String uuid,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByUuid_Last(String uuid,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the topic users before and after the current topic user in the ordered set where uuid = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public static TopicUser[] findByUuid_PrevAndNext(
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK,
		String uuid, OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException {
		return getPersistence()
				   .findByUuid_PrevAndNext(topicUserPK, uuid, orderByComparator);
	}

	/**
	* Removes all the topic users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of topic users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching topic users
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the topic user where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchTopicUserException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByUUID_G(String uuid, long groupId)
		throws it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the topic user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the topic user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the topic user where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the topic user that was removed
	*/
	public static TopicUser removeByUUID_G(String uuid, long groupId)
		throws it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of topic users where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching topic users
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the topic users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching topic users
	*/
	public static List<TopicUser> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<TopicUser> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<TopicUser> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<TopicUser> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first topic user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first topic user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static TopicUser[] findByUuid_C_PrevAndNext(
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK,
		String uuid, long companyId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(topicUserPK, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the topic users where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of topic users where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching topic users
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the topic user in the entity cache if it is enabled.
	*
	* @param topicUser the topic user
	*/
	public static void cacheResult(TopicUser topicUser) {
		getPersistence().cacheResult(topicUser);
	}

	/**
	* Caches the topic users in the entity cache if it is enabled.
	*
	* @param topicUsers the topic users
	*/
	public static void cacheResult(List<TopicUser> topicUsers) {
		getPersistence().cacheResult(topicUsers);
	}

	/**
	* Creates a new topic user with the primary key. Does not add the topic user to the database.
	*
	* @param topicUserPK the primary key for the new topic user
	* @return the new topic user
	*/
	public static TopicUser create(
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK) {
		return getPersistence().create(topicUserPK);
	}

	/**
	* Removes the topic user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user that was removed
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public static TopicUser remove(
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK)
		throws it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException {
		return getPersistence().remove(topicUserPK);
	}

	public static TopicUser updateImpl(TopicUser topicUser) {
		return getPersistence().updateImpl(topicUser);
	}

	/**
	* Returns the topic user with the primary key or throws a {@link NoSuchTopicUserException} if it could not be found.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public static TopicUser findByPrimaryKey(
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK)
		throws it.cm.liferay.chat.topic.service.exception.NoSuchTopicUserException {
		return getPersistence().findByPrimaryKey(topicUserPK);
	}

	/**
	* Returns the topic user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user, or <code>null</code> if a topic user with the primary key could not be found
	*/
	public static TopicUser fetchByPrimaryKey(
		it.cm.liferay.chat.topic.service.service.persistence.TopicUserPK topicUserPK) {
		return getPersistence().fetchByPrimaryKey(topicUserPK);
	}

	public static java.util.Map<java.io.Serializable, TopicUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the topic users.
	*
	* @return the topic users
	*/
	public static List<TopicUser> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<TopicUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<TopicUser> findAll(int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<TopicUser> findAll(int start, int end,
		OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the topic users from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of topic users.
	*
	* @return the number of topic users
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static java.util.Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static TopicUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TopicUserPersistence, TopicUserPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TopicUserPersistence.class);

		ServiceTracker<TopicUserPersistence, TopicUserPersistence> serviceTracker =
			new ServiceTracker<TopicUserPersistence, TopicUserPersistence>(bundle.getBundleContext(),
				TopicUserPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}