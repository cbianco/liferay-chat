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

import it.cm.liferay.chat.topic.model.MessageUser;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the message user service. This utility wraps {@link it.cm.liferay.chat.topic.service.persistence.impl.MessageUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageUserPersistence
 * @see it.cm.liferay.chat.topic.service.persistence.impl.MessageUserPersistenceImpl
 * @generated
 */
@ProviderType
public class MessageUserUtil {
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
	public static void clearCache(MessageUser messageUser) {
		getPersistence().clearCache(messageUser);
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
	public static List<MessageUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MessageUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MessageUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MessageUser update(MessageUser messageUser) {
		return getPersistence().update(messageUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MessageUser update(MessageUser messageUser,
		ServiceContext serviceContext) {
		return getPersistence().update(messageUser, serviceContext);
	}

	/**
	* Returns all the message users where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @return the matching message users
	*/
	public static List<MessageUser> findByT_R(long topicId, boolean read) {
		return getPersistence().findByT_R(topicId, read);
	}

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
	public static List<MessageUser> findByT_R(long topicId, boolean read,
		int start, int end) {
		return getPersistence().findByT_R(topicId, read, start, end);
	}

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
	public static List<MessageUser> findByT_R(long topicId, boolean read,
		int start, int end, OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence()
				   .findByT_R(topicId, read, start, end, orderByComparator);
	}

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
	public static List<MessageUser> findByT_R(long topicId, boolean read,
		int start, int end, OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByT_R(topicId, read, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first message user in the ordered set where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user
	* @throws NoSuchMessageUserException if a matching message user could not be found
	*/
	public static MessageUser findByT_R_First(long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence().findByT_R_First(topicId, read, orderByComparator);
	}

	/**
	* Returns the first message user in the ordered set where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public static MessageUser fetchByT_R_First(long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence()
				   .fetchByT_R_First(topicId, read, orderByComparator);
	}

	/**
	* Returns the last message user in the ordered set where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user
	* @throws NoSuchMessageUserException if a matching message user could not be found
	*/
	public static MessageUser findByT_R_Last(long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence().findByT_R_Last(topicId, read, orderByComparator);
	}

	/**
	* Returns the last message user in the ordered set where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public static MessageUser fetchByT_R_Last(long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence().fetchByT_R_Last(topicId, read, orderByComparator);
	}

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
	public static MessageUser[] findByT_R_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK,
		long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence()
				   .findByT_R_PrevAndNext(messageUserPK, topicId, read,
			orderByComparator);
	}

	/**
	* Removes all the message users where topicId = &#63; and read = &#63; from the database.
	*
	* @param topicId the topic ID
	* @param read the read
	*/
	public static void removeByT_R(long topicId, boolean read) {
		getPersistence().removeByT_R(topicId, read);
	}

	/**
	* Returns the number of message users where topicId = &#63; and read = &#63;.
	*
	* @param topicId the topic ID
	* @param read the read
	* @return the number of matching message users
	*/
	public static int countByT_R(long topicId, boolean read) {
		return getPersistence().countByT_R(topicId, read);
	}

	/**
	* Returns all the message users where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @return the matching message users
	*/
	public static List<MessageUser> findByU_R(long userId, boolean read) {
		return getPersistence().findByU_R(userId, read);
	}

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
	public static List<MessageUser> findByU_R(long userId, boolean read,
		int start, int end) {
		return getPersistence().findByU_R(userId, read, start, end);
	}

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
	public static List<MessageUser> findByU_R(long userId, boolean read,
		int start, int end, OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence()
				   .findByU_R(userId, read, start, end, orderByComparator);
	}

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
	public static List<MessageUser> findByU_R(long userId, boolean read,
		int start, int end, OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_R(userId, read, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first message user in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user
	* @throws NoSuchMessageUserException if a matching message user could not be found
	*/
	public static MessageUser findByU_R_First(long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence().findByU_R_First(userId, read, orderByComparator);
	}

	/**
	* Returns the first message user in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public static MessageUser fetchByU_R_First(long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence().fetchByU_R_First(userId, read, orderByComparator);
	}

	/**
	* Returns the last message user in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user
	* @throws NoSuchMessageUserException if a matching message user could not be found
	*/
	public static MessageUser findByU_R_Last(long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence().findByU_R_Last(userId, read, orderByComparator);
	}

	/**
	* Returns the last message user in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public static MessageUser fetchByU_R_Last(long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence().fetchByU_R_Last(userId, read, orderByComparator);
	}

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
	public static MessageUser[] findByU_R_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK,
		long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence()
				   .findByU_R_PrevAndNext(messageUserPK, userId, read,
			orderByComparator);
	}

	/**
	* Removes all the message users where userId = &#63; and read = &#63; from the database.
	*
	* @param userId the user ID
	* @param read the read
	*/
	public static void removeByU_R(long userId, boolean read) {
		getPersistence().removeByU_R(userId, read);
	}

	/**
	* Returns the number of message users where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @return the number of matching message users
	*/
	public static int countByU_R(long userId, boolean read) {
		return getPersistence().countByU_R(userId, read);
	}

	/**
	* Returns all the message users where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @return the matching message users
	*/
	public static List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read) {
		return getPersistence().findByU_T_R(userId, topicId, read);
	}

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
	public static List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read, int start, int end) {
		return getPersistence().findByU_T_R(userId, topicId, read, start, end);
	}

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
	public static List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read, int start, int end,
		OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence()
				   .findByU_T_R(userId, topicId, read, start, end,
			orderByComparator);
	}

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
	public static List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read, int start, int end,
		OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_T_R(userId, topicId, read, start, end,
			orderByComparator, retrieveFromCache);
	}

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
	public static MessageUser findByU_T_R_First(long userId, long topicId,
		boolean read, OrderByComparator<MessageUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence()
				   .findByU_T_R_First(userId, topicId, read, orderByComparator);
	}

	/**
	* Returns the first message user in the ordered set where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public static MessageUser fetchByU_T_R_First(long userId, long topicId,
		boolean read, OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence()
				   .fetchByU_T_R_First(userId, topicId, read, orderByComparator);
	}

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
	public static MessageUser findByU_T_R_Last(long userId, long topicId,
		boolean read, OrderByComparator<MessageUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence()
				   .findByU_T_R_Last(userId, topicId, read, orderByComparator);
	}

	/**
	* Returns the last message user in the ordered set where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message user, or <code>null</code> if a matching message user could not be found
	*/
	public static MessageUser fetchByU_T_R_Last(long userId, long topicId,
		boolean read, OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence()
				   .fetchByU_T_R_Last(userId, topicId, read, orderByComparator);
	}

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
	public static MessageUser[] findByU_T_R_PrevAndNext(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK,
		long userId, long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence()
				   .findByU_T_R_PrevAndNext(messageUserPK, userId, topicId,
			read, orderByComparator);
	}

	/**
	* Removes all the message users where userId = &#63; and topicId = &#63; and read = &#63; from the database.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	*/
	public static void removeByU_T_R(long userId, long topicId, boolean read) {
		getPersistence().removeByU_T_R(userId, topicId, read);
	}

	/**
	* Returns the number of message users where userId = &#63; and topicId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param topicId the topic ID
	* @param read the read
	* @return the number of matching message users
	*/
	public static int countByU_T_R(long userId, long topicId, boolean read) {
		return getPersistence().countByU_T_R(userId, topicId, read);
	}

	/**
	* Caches the message user in the entity cache if it is enabled.
	*
	* @param messageUser the message user
	*/
	public static void cacheResult(MessageUser messageUser) {
		getPersistence().cacheResult(messageUser);
	}

	/**
	* Caches the message users in the entity cache if it is enabled.
	*
	* @param messageUsers the message users
	*/
	public static void cacheResult(List<MessageUser> messageUsers) {
		getPersistence().cacheResult(messageUsers);
	}

	/**
	* Creates a new message user with the primary key. Does not add the message user to the database.
	*
	* @param messageUserPK the primary key for the new message user
	* @return the new message user
	*/
	public static MessageUser create(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK) {
		return getPersistence().create(messageUserPK);
	}

	/**
	* Removes the message user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageUserPK the primary key of the message user
	* @return the message user that was removed
	* @throws NoSuchMessageUserException if a message user with the primary key could not be found
	*/
	public static MessageUser remove(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence().remove(messageUserPK);
	}

	public static MessageUser updateImpl(MessageUser messageUser) {
		return getPersistence().updateImpl(messageUser);
	}

	/**
	* Returns the message user with the primary key or throws a {@link NoSuchMessageUserException} if it could not be found.
	*
	* @param messageUserPK the primary key of the message user
	* @return the message user
	* @throws NoSuchMessageUserException if a message user with the primary key could not be found
	*/
	public static MessageUser findByPrimaryKey(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK)
		throws it.cm.liferay.chat.topic.exception.NoSuchMessageUserException {
		return getPersistence().findByPrimaryKey(messageUserPK);
	}

	/**
	* Returns the message user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageUserPK the primary key of the message user
	* @return the message user, or <code>null</code> if a message user with the primary key could not be found
	*/
	public static MessageUser fetchByPrimaryKey(
		it.cm.liferay.chat.topic.service.persistence.MessageUserPK messageUserPK) {
		return getPersistence().fetchByPrimaryKey(messageUserPK);
	}

	public static java.util.Map<java.io.Serializable, MessageUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the message users.
	*
	* @return the message users
	*/
	public static List<MessageUser> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<MessageUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<MessageUser> findAll(int start, int end,
		OrderByComparator<MessageUser> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<MessageUser> findAll(int start, int end,
		OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the message users from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of message users.
	*
	* @return the number of message users
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

	public static MessageUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MessageUserPersistence, MessageUserPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MessageUserPersistence.class);

		ServiceTracker<MessageUserPersistence, MessageUserPersistence> serviceTracker =
			new ServiceTracker<MessageUserPersistence, MessageUserPersistence>(bundle.getBundleContext(),
				MessageUserPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}