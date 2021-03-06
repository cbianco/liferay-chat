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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.cm.liferay.chat.topic.model.TopicUser;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the topic user service. This utility wraps {@link it.cm.liferay.chat.topic.service.persistence.impl.TopicUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicUserPersistence
 * @see it.cm.liferay.chat.topic.service.persistence.impl.TopicUserPersistenceImpl
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
	* Returns all the topic users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching topic users
	*/
	public static List<TopicUser> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

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
	public static List<TopicUser> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static List<TopicUser> findByUserId(long userId, int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

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
	public static List<TopicUser> findByUserId(long userId, int start, int end,
		OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByUserId_First(long userId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByUserId_First(long userId,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByUserId_Last(long userId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByUserId_Last(long userId,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the topic users before and after the current topic user in the ordered set where userId = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public static TopicUser[] findByUserId_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK,
		long userId, OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence()
				   .findByUserId_PrevAndNext(topicUserPK, userId,
			orderByComparator);
	}

	/**
	* Removes all the topic users where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of topic users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching topic users
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the topic users where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @return the matching topic users
	*/
	public static List<TopicUser> findByTopicId(long topicId) {
		return getPersistence().findByTopicId(topicId);
	}

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
	public static List<TopicUser> findByTopicId(long topicId, int start, int end) {
		return getPersistence().findByTopicId(topicId, start, end);
	}

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
	public static List<TopicUser> findByTopicId(long topicId, int start,
		int end, OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence()
				   .findByTopicId(topicId, start, end, orderByComparator);
	}

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
	public static List<TopicUser> findByTopicId(long topicId, int start,
		int end, OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTopicId(topicId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByTopicId_First(long topicId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence().findByTopicId_First(topicId, orderByComparator);
	}

	/**
	* Returns the first topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByTopicId_First(long topicId,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().fetchByTopicId_First(topicId, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByTopicId_Last(long topicId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence().findByTopicId_Last(topicId, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByTopicId_Last(long topicId,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().fetchByTopicId_Last(topicId, orderByComparator);
	}

	/**
	* Returns the topic users before and after the current topic user in the ordered set where topicId = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public static TopicUser[] findByTopicId_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK,
		long topicId, OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence()
				   .findByTopicId_PrevAndNext(topicUserPK, topicId,
			orderByComparator);
	}

	/**
	* Removes all the topic users where topicId = &#63; from the database.
	*
	* @param topicId the topic ID
	*/
	public static void removeByTopicId(long topicId) {
		getPersistence().removeByTopicId(topicId);
	}

	/**
	* Returns the number of topic users where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @return the number of matching topic users
	*/
	public static int countByTopicId(long topicId) {
		return getPersistence().countByTopicId(topicId);
	}

	/**
	* Returns all the topic users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching topic users
	*/
	public static List<TopicUser> findByUserIds(long userId) {
		return getPersistence().findByUserIds(userId);
	}

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
	public static List<TopicUser> findByUserIds(long userId, int start, int end) {
		return getPersistence().findByUserIds(userId, start, end);
	}

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
	public static List<TopicUser> findByUserIds(long userId, int start,
		int end, OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence()
				   .findByUserIds(userId, start, end, orderByComparator);
	}

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
	public static List<TopicUser> findByUserIds(long userId, int start,
		int end, OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserIds(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByUserIds_First(long userId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence().findByUserIds_First(userId, orderByComparator);
	}

	/**
	* Returns the first topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByUserIds_First(long userId,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().fetchByUserIds_First(userId, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByUserIds_Last(long userId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence().findByUserIds_Last(userId, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByUserIds_Last(long userId,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().fetchByUserIds_Last(userId, orderByComparator);
	}

	/**
	* Returns the topic users before and after the current topic user in the ordered set where userId = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public static TopicUser[] findByUserIds_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK,
		long userId, OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence()
				   .findByUserIds_PrevAndNext(topicUserPK, userId,
			orderByComparator);
	}

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
	public static List<TopicUser> findByUserIds(long[] userIds) {
		return getPersistence().findByUserIds(userIds);
	}

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
	public static List<TopicUser> findByUserIds(long[] userIds, int start,
		int end) {
		return getPersistence().findByUserIds(userIds, start, end);
	}

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
	public static List<TopicUser> findByUserIds(long[] userIds, int start,
		int end, OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence()
				   .findByUserIds(userIds, start, end, orderByComparator);
	}

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
	public static List<TopicUser> findByUserIds(long[] userIds, int start,
		int end, OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserIds(userIds, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Removes all the topic users where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserIds(long userId) {
		getPersistence().removeByUserIds(userId);
	}

	/**
	* Returns the number of topic users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching topic users
	*/
	public static int countByUserIds(long userId) {
		return getPersistence().countByUserIds(userId);
	}

	/**
	* Returns the number of topic users where userId = any &#63;.
	*
	* @param userIds the user IDs
	* @return the number of matching topic users
	*/
	public static int countByUserIds(long[] userIds) {
		return getPersistence().countByUserIds(userIds);
	}

	/**
	* Returns all the topic users where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @return the matching topic users
	*/
	public static List<TopicUser> findByTopicIds(long topicId) {
		return getPersistence().findByTopicIds(topicId);
	}

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
	public static List<TopicUser> findByTopicIds(long topicId, int start,
		int end) {
		return getPersistence().findByTopicIds(topicId, start, end);
	}

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
	public static List<TopicUser> findByTopicIds(long topicId, int start,
		int end, OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence()
				   .findByTopicIds(topicId, start, end, orderByComparator);
	}

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
	public static List<TopicUser> findByTopicIds(long topicId, int start,
		int end, OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTopicIds(topicId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByTopicIds_First(long topicId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence().findByTopicIds_First(topicId, orderByComparator);
	}

	/**
	* Returns the first topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByTopicIds_First(long topicId,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().fetchByTopicIds_First(topicId, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user
	* @throws NoSuchTopicUserException if a matching topic user could not be found
	*/
	public static TopicUser findByTopicIds_Last(long topicId,
		OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence().findByTopicIds_Last(topicId, orderByComparator);
	}

	/**
	* Returns the last topic user in the ordered set where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	*/
	public static TopicUser fetchByTopicIds_Last(long topicId,
		OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence().fetchByTopicIds_Last(topicId, orderByComparator);
	}

	/**
	* Returns the topic users before and after the current topic user in the ordered set where topicId = &#63;.
	*
	* @param topicUserPK the primary key of the current topic user
	* @param topicId the topic ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic user
	* @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	*/
	public static TopicUser[] findByTopicIds_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK,
		long topicId, OrderByComparator<TopicUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence()
				   .findByTopicIds_PrevAndNext(topicUserPK, topicId,
			orderByComparator);
	}

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
	public static List<TopicUser> findByTopicIds(long[] topicIds) {
		return getPersistence().findByTopicIds(topicIds);
	}

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
	public static List<TopicUser> findByTopicIds(long[] topicIds, int start,
		int end) {
		return getPersistence().findByTopicIds(topicIds, start, end);
	}

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
	public static List<TopicUser> findByTopicIds(long[] topicIds, int start,
		int end, OrderByComparator<TopicUser> orderByComparator) {
		return getPersistence()
				   .findByTopicIds(topicIds, start, end, orderByComparator);
	}

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
	public static List<TopicUser> findByTopicIds(long[] topicIds, int start,
		int end, OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTopicIds(topicIds, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Removes all the topic users where topicId = &#63; from the database.
	*
	* @param topicId the topic ID
	*/
	public static void removeByTopicIds(long topicId) {
		getPersistence().removeByTopicIds(topicId);
	}

	/**
	* Returns the number of topic users where topicId = &#63;.
	*
	* @param topicId the topic ID
	* @return the number of matching topic users
	*/
	public static int countByTopicIds(long topicId) {
		return getPersistence().countByTopicIds(topicId);
	}

	/**
	* Returns the number of topic users where topicId = any &#63;.
	*
	* @param topicIds the topic IDs
	* @return the number of matching topic users
	*/
	public static int countByTopicIds(long[] topicIds) {
		return getPersistence().countByTopicIds(topicIds);
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
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK) {
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
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
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
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK)
		throws it.cm.liferay.chat.topic.exception.NoSuchTopicUserException {
		return getPersistence().findByPrimaryKey(topicUserPK);
	}

	/**
	* Returns the topic user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param topicUserPK the primary key of the topic user
	* @return the topic user, or <code>null</code> if a topic user with the primary key could not be found
	*/
	public static TopicUser fetchByPrimaryKey(
		it.cm.liferay.chat.topic.service.persistence.TopicUserPK topicUserPK) {
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