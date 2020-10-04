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

package it.cm.liferay.chat.topic.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.cm.liferay.chat.topic.exception.NoSuchMessageUserException;
import it.cm.liferay.chat.topic.model.MessageUser;
import it.cm.liferay.chat.topic.model.impl.MessageUserImpl;
import it.cm.liferay.chat.topic.model.impl.MessageUserModelImpl;
import it.cm.liferay.chat.topic.service.persistence.MessageUserPK;
import it.cm.liferay.chat.topic.service.persistence.MessageUserPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the message user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageUserPersistence
 * @see it.cm.liferay.chat.topic.service.persistence.MessageUserUtil
 * @generated
 */
@ProviderType
public class MessageUserPersistenceImpl extends BasePersistenceImpl<MessageUser>
	implements MessageUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MessageUserUtil} to access the message user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MessageUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, MessageUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, MessageUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_R = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, MessageUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_R",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_R = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, MessageUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_R",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			MessageUserModelImpl.TOPICID_COLUMN_BITMASK |
			MessageUserModelImpl.READ_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_R = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_R",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the message users where topicId = &#63; and read = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param read the read
	 * @return the matching message users
	 */
	@Override
	public List<MessageUser> findByT_R(long topicId, boolean read) {
		return findByT_R(topicId, read, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<MessageUser> findByT_R(long topicId, boolean read, int start,
		int end) {
		return findByT_R(topicId, read, start, end, null);
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
	@Override
	public List<MessageUser> findByT_R(long topicId, boolean read, int start,
		int end, OrderByComparator<MessageUser> orderByComparator) {
		return findByT_R(topicId, read, start, end, orderByComparator, true);
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
	@Override
	public List<MessageUser> findByT_R(long topicId, boolean read, int start,
		int end, OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_R;
			finderArgs = new Object[] { topicId, read };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_R;
			finderArgs = new Object[] {
					topicId, read,
					
					start, end, orderByComparator
				};
		}

		List<MessageUser> list = null;

		if (retrieveFromCache) {
			list = (List<MessageUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MessageUser messageUser : list) {
					if ((topicId != messageUser.getTopicId()) ||
							(read != messageUser.isRead())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MESSAGEUSER_WHERE);

			query.append(_FINDER_COLUMN_T_R_TOPICID_2);

			query.append(_FINDER_COLUMN_T_R_READ_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MessageUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(topicId);

				qPos.add(read);

				if (!pagination) {
					list = (List<MessageUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MessageUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public MessageUser findByT_R_First(long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException {
		MessageUser messageUser = fetchByT_R_First(topicId, read,
				orderByComparator);

		if (messageUser != null) {
			return messageUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("topicId=");
		msg.append(topicId);

		msg.append(", read=");
		msg.append(read);

		msg.append("}");

		throw new NoSuchMessageUserException(msg.toString());
	}

	/**
	 * Returns the first message user in the ordered set where topicId = &#63; and read = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param read the read
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message user, or <code>null</code> if a matching message user could not be found
	 */
	@Override
	public MessageUser fetchByT_R_First(long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator) {
		List<MessageUser> list = findByT_R(topicId, read, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MessageUser findByT_R_Last(long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException {
		MessageUser messageUser = fetchByT_R_Last(topicId, read,
				orderByComparator);

		if (messageUser != null) {
			return messageUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("topicId=");
		msg.append(topicId);

		msg.append(", read=");
		msg.append(read);

		msg.append("}");

		throw new NoSuchMessageUserException(msg.toString());
	}

	/**
	 * Returns the last message user in the ordered set where topicId = &#63; and read = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param read the read
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message user, or <code>null</code> if a matching message user could not be found
	 */
	@Override
	public MessageUser fetchByT_R_Last(long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator) {
		int count = countByT_R(topicId, read);

		if (count == 0) {
			return null;
		}

		List<MessageUser> list = findByT_R(topicId, read, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MessageUser[] findByT_R_PrevAndNext(MessageUserPK messageUserPK,
		long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException {
		MessageUser messageUser = findByPrimaryKey(messageUserPK);

		Session session = null;

		try {
			session = openSession();

			MessageUser[] array = new MessageUserImpl[3];

			array[0] = getByT_R_PrevAndNext(session, messageUser, topicId,
					read, orderByComparator, true);

			array[1] = messageUser;

			array[2] = getByT_R_PrevAndNext(session, messageUser, topicId,
					read, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MessageUser getByT_R_PrevAndNext(Session session,
		MessageUser messageUser, long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MESSAGEUSER_WHERE);

		query.append(_FINDER_COLUMN_T_R_TOPICID_2);

		query.append(_FINDER_COLUMN_T_R_READ_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MessageUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(topicId);

		qPos.add(read);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(messageUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MessageUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the message users where topicId = &#63; and read = &#63; from the database.
	 *
	 * @param topicId the topic ID
	 * @param read the read
	 */
	@Override
	public void removeByT_R(long topicId, boolean read) {
		for (MessageUser messageUser : findByT_R(topicId, read,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(messageUser);
		}
	}

	/**
	 * Returns the number of message users where topicId = &#63; and read = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param read the read
	 * @return the number of matching message users
	 */
	@Override
	public int countByT_R(long topicId, boolean read) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_R;

		Object[] finderArgs = new Object[] { topicId, read };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MESSAGEUSER_WHERE);

			query.append(_FINDER_COLUMN_T_R_TOPICID_2);

			query.append(_FINDER_COLUMN_T_R_READ_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(topicId);

				qPos.add(read);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_T_R_TOPICID_2 = "messageUser.topicId = ? AND ";
	private static final String _FINDER_COLUMN_T_R_READ_2 = "messageUser.read = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_R = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, MessageUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_R",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_R = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, MessageUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_R",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			MessageUserModelImpl.USERID_COLUMN_BITMASK |
			MessageUserModelImpl.READ_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_R = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_R",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the message users where userId = &#63; and read = &#63;.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @return the matching message users
	 */
	@Override
	public List<MessageUser> findByU_R(long userId, boolean read) {
		return findByU_R(userId, read, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<MessageUser> findByU_R(long userId, boolean read, int start,
		int end) {
		return findByU_R(userId, read, start, end, null);
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
	@Override
	public List<MessageUser> findByU_R(long userId, boolean read, int start,
		int end, OrderByComparator<MessageUser> orderByComparator) {
		return findByU_R(userId, read, start, end, orderByComparator, true);
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
	@Override
	public List<MessageUser> findByU_R(long userId, boolean read, int start,
		int end, OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_R;
			finderArgs = new Object[] { userId, read };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_R;
			finderArgs = new Object[] {
					userId, read,
					
					start, end, orderByComparator
				};
		}

		List<MessageUser> list = null;

		if (retrieveFromCache) {
			list = (List<MessageUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MessageUser messageUser : list) {
					if ((userId != messageUser.getUserId()) ||
							(read != messageUser.isRead())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MESSAGEUSER_WHERE);

			query.append(_FINDER_COLUMN_U_R_USERID_2);

			query.append(_FINDER_COLUMN_U_R_READ_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MessageUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(read);

				if (!pagination) {
					list = (List<MessageUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MessageUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public MessageUser findByU_R_First(long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException {
		MessageUser messageUser = fetchByU_R_First(userId, read,
				orderByComparator);

		if (messageUser != null) {
			return messageUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", read=");
		msg.append(read);

		msg.append("}");

		throw new NoSuchMessageUserException(msg.toString());
	}

	/**
	 * Returns the first message user in the ordered set where userId = &#63; and read = &#63;.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message user, or <code>null</code> if a matching message user could not be found
	 */
	@Override
	public MessageUser fetchByU_R_First(long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator) {
		List<MessageUser> list = findByU_R(userId, read, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MessageUser findByU_R_Last(long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException {
		MessageUser messageUser = fetchByU_R_Last(userId, read,
				orderByComparator);

		if (messageUser != null) {
			return messageUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", read=");
		msg.append(read);

		msg.append("}");

		throw new NoSuchMessageUserException(msg.toString());
	}

	/**
	 * Returns the last message user in the ordered set where userId = &#63; and read = &#63;.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message user, or <code>null</code> if a matching message user could not be found
	 */
	@Override
	public MessageUser fetchByU_R_Last(long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator) {
		int count = countByU_R(userId, read);

		if (count == 0) {
			return null;
		}

		List<MessageUser> list = findByU_R(userId, read, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MessageUser[] findByU_R_PrevAndNext(MessageUserPK messageUserPK,
		long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException {
		MessageUser messageUser = findByPrimaryKey(messageUserPK);

		Session session = null;

		try {
			session = openSession();

			MessageUser[] array = new MessageUserImpl[3];

			array[0] = getByU_R_PrevAndNext(session, messageUser, userId, read,
					orderByComparator, true);

			array[1] = messageUser;

			array[2] = getByU_R_PrevAndNext(session, messageUser, userId, read,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MessageUser getByU_R_PrevAndNext(Session session,
		MessageUser messageUser, long userId, boolean read,
		OrderByComparator<MessageUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MESSAGEUSER_WHERE);

		query.append(_FINDER_COLUMN_U_R_USERID_2);

		query.append(_FINDER_COLUMN_U_R_READ_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MessageUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(read);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(messageUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MessageUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the message users where userId = &#63; and read = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param read the read
	 */
	@Override
	public void removeByU_R(long userId, boolean read) {
		for (MessageUser messageUser : findByU_R(userId, read,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(messageUser);
		}
	}

	/**
	 * Returns the number of message users where userId = &#63; and read = &#63;.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @return the number of matching message users
	 */
	@Override
	public int countByU_R(long userId, boolean read) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_R;

		Object[] finderArgs = new Object[] { userId, read };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MESSAGEUSER_WHERE);

			query.append(_FINDER_COLUMN_U_R_USERID_2);

			query.append(_FINDER_COLUMN_U_R_READ_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(read);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_R_USERID_2 = "messageUser.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_R_READ_2 = "messageUser.read = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_T_R = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, MessageUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_T_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T_R = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, MessageUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_T_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			MessageUserModelImpl.USERID_COLUMN_BITMASK |
			MessageUserModelImpl.TOPICID_COLUMN_BITMASK |
			MessageUserModelImpl.READ_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_T_R = new FinderPath(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_T_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the message users where userId = &#63; and topicId = &#63; and read = &#63;.
	 *
	 * @param userId the user ID
	 * @param topicId the topic ID
	 * @param read the read
	 * @return the matching message users
	 */
	@Override
	public List<MessageUser> findByU_T_R(long userId, long topicId, boolean read) {
		return findByU_T_R(userId, topicId, read, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read, int start, int end) {
		return findByU_T_R(userId, topicId, read, start, end, null);
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
	@Override
	public List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read, int start, int end,
		OrderByComparator<MessageUser> orderByComparator) {
		return findByU_T_R(userId, topicId, read, start, end,
			orderByComparator, true);
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
	@Override
	public List<MessageUser> findByU_T_R(long userId, long topicId,
		boolean read, int start, int end,
		OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T_R;
			finderArgs = new Object[] { userId, topicId, read };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_T_R;
			finderArgs = new Object[] {
					userId, topicId, read,
					
					start, end, orderByComparator
				};
		}

		List<MessageUser> list = null;

		if (retrieveFromCache) {
			list = (List<MessageUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MessageUser messageUser : list) {
					if ((userId != messageUser.getUserId()) ||
							(topicId != messageUser.getTopicId()) ||
							(read != messageUser.isRead())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_MESSAGEUSER_WHERE);

			query.append(_FINDER_COLUMN_U_T_R_USERID_2);

			query.append(_FINDER_COLUMN_U_T_R_TOPICID_2);

			query.append(_FINDER_COLUMN_U_T_R_READ_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MessageUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(topicId);

				qPos.add(read);

				if (!pagination) {
					list = (List<MessageUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MessageUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public MessageUser findByU_T_R_First(long userId, long topicId,
		boolean read, OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException {
		MessageUser messageUser = fetchByU_T_R_First(userId, topicId, read,
				orderByComparator);

		if (messageUser != null) {
			return messageUser;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", topicId=");
		msg.append(topicId);

		msg.append(", read=");
		msg.append(read);

		msg.append("}");

		throw new NoSuchMessageUserException(msg.toString());
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
	@Override
	public MessageUser fetchByU_T_R_First(long userId, long topicId,
		boolean read, OrderByComparator<MessageUser> orderByComparator) {
		List<MessageUser> list = findByU_T_R(userId, topicId, read, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MessageUser findByU_T_R_Last(long userId, long topicId,
		boolean read, OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException {
		MessageUser messageUser = fetchByU_T_R_Last(userId, topicId, read,
				orderByComparator);

		if (messageUser != null) {
			return messageUser;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", topicId=");
		msg.append(topicId);

		msg.append(", read=");
		msg.append(read);

		msg.append("}");

		throw new NoSuchMessageUserException(msg.toString());
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
	@Override
	public MessageUser fetchByU_T_R_Last(long userId, long topicId,
		boolean read, OrderByComparator<MessageUser> orderByComparator) {
		int count = countByU_T_R(userId, topicId, read);

		if (count == 0) {
			return null;
		}

		List<MessageUser> list = findByU_T_R(userId, topicId, read, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MessageUser[] findByU_T_R_PrevAndNext(MessageUserPK messageUserPK,
		long userId, long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator)
		throws NoSuchMessageUserException {
		MessageUser messageUser = findByPrimaryKey(messageUserPK);

		Session session = null;

		try {
			session = openSession();

			MessageUser[] array = new MessageUserImpl[3];

			array[0] = getByU_T_R_PrevAndNext(session, messageUser, userId,
					topicId, read, orderByComparator, true);

			array[1] = messageUser;

			array[2] = getByU_T_R_PrevAndNext(session, messageUser, userId,
					topicId, read, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MessageUser getByU_T_R_PrevAndNext(Session session,
		MessageUser messageUser, long userId, long topicId, boolean read,
		OrderByComparator<MessageUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_MESSAGEUSER_WHERE);

		query.append(_FINDER_COLUMN_U_T_R_USERID_2);

		query.append(_FINDER_COLUMN_U_T_R_TOPICID_2);

		query.append(_FINDER_COLUMN_U_T_R_READ_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MessageUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(topicId);

		qPos.add(read);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(messageUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MessageUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the message users where userId = &#63; and topicId = &#63; and read = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param topicId the topic ID
	 * @param read the read
	 */
	@Override
	public void removeByU_T_R(long userId, long topicId, boolean read) {
		for (MessageUser messageUser : findByU_T_R(userId, topicId, read,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(messageUser);
		}
	}

	/**
	 * Returns the number of message users where userId = &#63; and topicId = &#63; and read = &#63;.
	 *
	 * @param userId the user ID
	 * @param topicId the topic ID
	 * @param read the read
	 * @return the number of matching message users
	 */
	@Override
	public int countByU_T_R(long userId, long topicId, boolean read) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_T_R;

		Object[] finderArgs = new Object[] { userId, topicId, read };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MESSAGEUSER_WHERE);

			query.append(_FINDER_COLUMN_U_T_R_USERID_2);

			query.append(_FINDER_COLUMN_U_T_R_TOPICID_2);

			query.append(_FINDER_COLUMN_U_T_R_READ_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(topicId);

				qPos.add(read);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_T_R_USERID_2 = "messageUser.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_T_R_TOPICID_2 = "messageUser.topicId = ? AND ";
	private static final String _FINDER_COLUMN_U_T_R_READ_2 = "messageUser.read = ?";

	public MessageUserPersistenceImpl() {
		setModelClass(MessageUser.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("read", "read_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the message user in the entity cache if it is enabled.
	 *
	 * @param messageUser the message user
	 */
	@Override
	public void cacheResult(MessageUser messageUser) {
		entityCache.putResult(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserImpl.class, messageUser.getPrimaryKey(), messageUser);

		messageUser.resetOriginalValues();
	}

	/**
	 * Caches the message users in the entity cache if it is enabled.
	 *
	 * @param messageUsers the message users
	 */
	@Override
	public void cacheResult(List<MessageUser> messageUsers) {
		for (MessageUser messageUser : messageUsers) {
			if (entityCache.getResult(
						MessageUserModelImpl.ENTITY_CACHE_ENABLED,
						MessageUserImpl.class, messageUser.getPrimaryKey()) == null) {
				cacheResult(messageUser);
			}
			else {
				messageUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all message users.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MessageUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the message user.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MessageUser messageUser) {
		entityCache.removeResult(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserImpl.class, messageUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MessageUser> messageUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MessageUser messageUser : messageUsers) {
			entityCache.removeResult(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
				MessageUserImpl.class, messageUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new message user with the primary key. Does not add the message user to the database.
	 *
	 * @param messageUserPK the primary key for the new message user
	 * @return the new message user
	 */
	@Override
	public MessageUser create(MessageUserPK messageUserPK) {
		MessageUser messageUser = new MessageUserImpl();

		messageUser.setNew(true);
		messageUser.setPrimaryKey(messageUserPK);

		return messageUser;
	}

	/**
	 * Removes the message user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageUserPK the primary key of the message user
	 * @return the message user that was removed
	 * @throws NoSuchMessageUserException if a message user with the primary key could not be found
	 */
	@Override
	public MessageUser remove(MessageUserPK messageUserPK)
		throws NoSuchMessageUserException {
		return remove((Serializable)messageUserPK);
	}

	/**
	 * Removes the message user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the message user
	 * @return the message user that was removed
	 * @throws NoSuchMessageUserException if a message user with the primary key could not be found
	 */
	@Override
	public MessageUser remove(Serializable primaryKey)
		throws NoSuchMessageUserException {
		Session session = null;

		try {
			session = openSession();

			MessageUser messageUser = (MessageUser)session.get(MessageUserImpl.class,
					primaryKey);

			if (messageUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMessageUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(messageUser);
		}
		catch (NoSuchMessageUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MessageUser removeImpl(MessageUser messageUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(messageUser)) {
				messageUser = (MessageUser)session.get(MessageUserImpl.class,
						messageUser.getPrimaryKeyObj());
			}

			if (messageUser != null) {
				session.delete(messageUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (messageUser != null) {
			clearCache(messageUser);
		}

		return messageUser;
	}

	@Override
	public MessageUser updateImpl(MessageUser messageUser) {
		boolean isNew = messageUser.isNew();

		if (!(messageUser instanceof MessageUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(messageUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(messageUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in messageUser proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MessageUser implementation " +
				messageUser.getClass());
		}

		MessageUserModelImpl messageUserModelImpl = (MessageUserModelImpl)messageUser;

		Session session = null;

		try {
			session = openSession();

			if (messageUser.isNew()) {
				session.save(messageUser);

				messageUser.setNew(false);
			}
			else {
				messageUser = (MessageUser)session.merge(messageUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MessageUserModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					messageUserModelImpl.getTopicId(),
					messageUserModelImpl.isRead()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_T_R, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_R,
				args);

			args = new Object[] {
					messageUserModelImpl.getUserId(),
					messageUserModelImpl.isRead()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_U_R, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_R,
				args);

			args = new Object[] {
					messageUserModelImpl.getUserId(),
					messageUserModelImpl.getTopicId(),
					messageUserModelImpl.isRead()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_U_T_R, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T_R,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((messageUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						messageUserModelImpl.getOriginalTopicId(),
						messageUserModelImpl.getOriginalRead()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_T_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_R,
					args);

				args = new Object[] {
						messageUserModelImpl.getTopicId(),
						messageUserModelImpl.isRead()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_T_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_R,
					args);
			}

			if ((messageUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						messageUserModelImpl.getOriginalUserId(),
						messageUserModelImpl.getOriginalRead()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_R,
					args);

				args = new Object[] {
						messageUserModelImpl.getUserId(),
						messageUserModelImpl.isRead()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_R,
					args);
			}

			if ((messageUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						messageUserModelImpl.getOriginalUserId(),
						messageUserModelImpl.getOriginalTopicId(),
						messageUserModelImpl.getOriginalRead()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_T_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T_R,
					args);

				args = new Object[] {
						messageUserModelImpl.getUserId(),
						messageUserModelImpl.getTopicId(),
						messageUserModelImpl.isRead()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_T_R, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T_R,
					args);
			}
		}

		entityCache.putResult(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
			MessageUserImpl.class, messageUser.getPrimaryKey(), messageUser,
			false);

		messageUser.resetOriginalValues();

		return messageUser;
	}

	/**
	 * Returns the message user with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the message user
	 * @return the message user
	 * @throws NoSuchMessageUserException if a message user with the primary key could not be found
	 */
	@Override
	public MessageUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMessageUserException {
		MessageUser messageUser = fetchByPrimaryKey(primaryKey);

		if (messageUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMessageUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return messageUser;
	}

	/**
	 * Returns the message user with the primary key or throws a {@link NoSuchMessageUserException} if it could not be found.
	 *
	 * @param messageUserPK the primary key of the message user
	 * @return the message user
	 * @throws NoSuchMessageUserException if a message user with the primary key could not be found
	 */
	@Override
	public MessageUser findByPrimaryKey(MessageUserPK messageUserPK)
		throws NoSuchMessageUserException {
		return findByPrimaryKey((Serializable)messageUserPK);
	}

	/**
	 * Returns the message user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the message user
	 * @return the message user, or <code>null</code> if a message user with the primary key could not be found
	 */
	@Override
	public MessageUser fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
				MessageUserImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MessageUser messageUser = (MessageUser)serializable;

		if (messageUser == null) {
			Session session = null;

			try {
				session = openSession();

				messageUser = (MessageUser)session.get(MessageUserImpl.class,
						primaryKey);

				if (messageUser != null) {
					cacheResult(messageUser);
				}
				else {
					entityCache.putResult(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
						MessageUserImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MessageUserModelImpl.ENTITY_CACHE_ENABLED,
					MessageUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return messageUser;
	}

	/**
	 * Returns the message user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageUserPK the primary key of the message user
	 * @return the message user, or <code>null</code> if a message user with the primary key could not be found
	 */
	@Override
	public MessageUser fetchByPrimaryKey(MessageUserPK messageUserPK) {
		return fetchByPrimaryKey((Serializable)messageUserPK);
	}

	@Override
	public Map<Serializable, MessageUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MessageUser> map = new HashMap<Serializable, MessageUser>();

		for (Serializable primaryKey : primaryKeys) {
			MessageUser messageUser = fetchByPrimaryKey(primaryKey);

			if (messageUser != null) {
				map.put(primaryKey, messageUser);
			}
		}

		return map;
	}

	/**
	 * Returns all the message users.
	 *
	 * @return the message users
	 */
	@Override
	public List<MessageUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MessageUser> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<MessageUser> findAll(int start, int end,
		OrderByComparator<MessageUser> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<MessageUser> findAll(int start, int end,
		OrderByComparator<MessageUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<MessageUser> list = null;

		if (retrieveFromCache) {
			list = (List<MessageUser>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MESSAGEUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MESSAGEUSER;

				if (pagination) {
					sql = sql.concat(MessageUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MessageUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MessageUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the message users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MessageUser messageUser : findAll()) {
			remove(messageUser);
		}
	}

	/**
	 * Returns the number of message users.
	 *
	 * @return the number of message users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MESSAGEUSER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MessageUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the message user persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MessageUserImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MESSAGEUSER = "SELECT messageUser FROM MessageUser messageUser";
	private static final String _SQL_SELECT_MESSAGEUSER_WHERE = "SELECT messageUser FROM MessageUser messageUser WHERE ";
	private static final String _SQL_COUNT_MESSAGEUSER = "SELECT COUNT(messageUser) FROM MessageUser messageUser";
	private static final String _SQL_COUNT_MESSAGEUSER_WHERE = "SELECT COUNT(messageUser) FROM MessageUser messageUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "messageUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MessageUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MessageUser exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MessageUserPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"read"
			});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(new String[] {
				"messageId", "userId"
			});
}