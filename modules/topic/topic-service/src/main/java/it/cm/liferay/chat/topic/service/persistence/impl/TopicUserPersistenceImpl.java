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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.cm.liferay.chat.topic.exception.NoSuchTopicUserException;
import it.cm.liferay.chat.topic.model.TopicUser;
import it.cm.liferay.chat.topic.model.impl.TopicUserImpl;
import it.cm.liferay.chat.topic.model.impl.TopicUserModelImpl;
import it.cm.liferay.chat.topic.service.persistence.TopicUserPK;
import it.cm.liferay.chat.topic.service.persistence.TopicUserPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the topic user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicUserPersistence
 * @see it.cm.liferay.chat.topic.service.persistence.TopicUserUtil
 * @generated
 */
@ProviderType
public class TopicUserPersistenceImpl extends BasePersistenceImpl<TopicUser>
	implements TopicUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TopicUserUtil} to access the topic user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TopicUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, TopicUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, TopicUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, TopicUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, TopicUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			TopicUserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the topic users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching topic users
	 */
	@Override
	public List<TopicUser> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TopicUser> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<TopicUser> findByUserId(long userId, int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<TopicUser> findByUserId(long userId, int start, int end,
		OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<TopicUser> list = null;

		if (retrieveFromCache) {
			list = (List<TopicUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TopicUser topicUser : list) {
					if ((userId != topicUser.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TOPICUSER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TopicUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first topic user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic user
	 * @throws NoSuchTopicUserException if a matching topic user could not be found
	 */
	@Override
	public TopicUser findByUserId_First(long userId,
		OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = fetchByUserId_First(userId, orderByComparator);

		if (topicUser != null) {
			return topicUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchTopicUserException(msg.toString());
	}

	/**
	 * Returns the first topic user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	 */
	@Override
	public TopicUser fetchByUserId_First(long userId,
		OrderByComparator<TopicUser> orderByComparator) {
		List<TopicUser> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last topic user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic user
	 * @throws NoSuchTopicUserException if a matching topic user could not be found
	 */
	@Override
	public TopicUser findByUserId_Last(long userId,
		OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = fetchByUserId_Last(userId, orderByComparator);

		if (topicUser != null) {
			return topicUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchTopicUserException(msg.toString());
	}

	/**
	 * Returns the last topic user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	 */
	@Override
	public TopicUser fetchByUserId_Last(long userId,
		OrderByComparator<TopicUser> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<TopicUser> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TopicUser[] findByUserId_PrevAndNext(TopicUserPK topicUserPK,
		long userId, OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = findByPrimaryKey(topicUserPK);

		Session session = null;

		try {
			session = openSession();

			TopicUser[] array = new TopicUserImpl[3];

			array[0] = getByUserId_PrevAndNext(session, topicUser, userId,
					orderByComparator, true);

			array[1] = topicUser;

			array[2] = getByUserId_PrevAndNext(session, topicUser, userId,
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

	protected TopicUser getByUserId_PrevAndNext(Session session,
		TopicUser topicUser, long userId,
		OrderByComparator<TopicUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOPICUSER_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(TopicUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(topicUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TopicUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the topic users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (TopicUser topicUser : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(topicUser);
		}
	}

	/**
	 * Returns the number of topic users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching topic users
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOPICUSER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "topicUser.id.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPICID = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, TopicUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTopicId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICID =
		new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, TopicUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTopicId",
			new String[] { Long.class.getName() },
			TopicUserModelImpl.TOPICID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TOPICID = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTopicId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the topic users where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @return the matching topic users
	 */
	@Override
	public List<TopicUser> findByTopicId(long topicId) {
		return findByTopicId(topicId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TopicUser> findByTopicId(long topicId, int start, int end) {
		return findByTopicId(topicId, start, end, null);
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
	@Override
	public List<TopicUser> findByTopicId(long topicId, int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return findByTopicId(topicId, start, end, orderByComparator, true);
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
	@Override
	public List<TopicUser> findByTopicId(long topicId, int start, int end,
		OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICID;
			finderArgs = new Object[] { topicId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPICID;
			finderArgs = new Object[] { topicId, start, end, orderByComparator };
		}

		List<TopicUser> list = null;

		if (retrieveFromCache) {
			list = (List<TopicUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TopicUser topicUser : list) {
					if ((topicId != topicUser.getTopicId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TOPICUSER_WHERE);

			query.append(_FINDER_COLUMN_TOPICID_TOPICID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TopicUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(topicId);

				if (!pagination) {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first topic user in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic user
	 * @throws NoSuchTopicUserException if a matching topic user could not be found
	 */
	@Override
	public TopicUser findByTopicId_First(long topicId,
		OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = fetchByTopicId_First(topicId, orderByComparator);

		if (topicUser != null) {
			return topicUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("topicId=");
		msg.append(topicId);

		msg.append("}");

		throw new NoSuchTopicUserException(msg.toString());
	}

	/**
	 * Returns the first topic user in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	 */
	@Override
	public TopicUser fetchByTopicId_First(long topicId,
		OrderByComparator<TopicUser> orderByComparator) {
		List<TopicUser> list = findByTopicId(topicId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last topic user in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic user
	 * @throws NoSuchTopicUserException if a matching topic user could not be found
	 */
	@Override
	public TopicUser findByTopicId_Last(long topicId,
		OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = fetchByTopicId_Last(topicId, orderByComparator);

		if (topicUser != null) {
			return topicUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("topicId=");
		msg.append(topicId);

		msg.append("}");

		throw new NoSuchTopicUserException(msg.toString());
	}

	/**
	 * Returns the last topic user in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	 */
	@Override
	public TopicUser fetchByTopicId_Last(long topicId,
		OrderByComparator<TopicUser> orderByComparator) {
		int count = countByTopicId(topicId);

		if (count == 0) {
			return null;
		}

		List<TopicUser> list = findByTopicId(topicId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TopicUser[] findByTopicId_PrevAndNext(TopicUserPK topicUserPK,
		long topicId, OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = findByPrimaryKey(topicUserPK);

		Session session = null;

		try {
			session = openSession();

			TopicUser[] array = new TopicUserImpl[3];

			array[0] = getByTopicId_PrevAndNext(session, topicUser, topicId,
					orderByComparator, true);

			array[1] = topicUser;

			array[2] = getByTopicId_PrevAndNext(session, topicUser, topicId,
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

	protected TopicUser getByTopicId_PrevAndNext(Session session,
		TopicUser topicUser, long topicId,
		OrderByComparator<TopicUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOPICUSER_WHERE);

		query.append(_FINDER_COLUMN_TOPICID_TOPICID_2);

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
			query.append(TopicUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(topicId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(topicUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TopicUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the topic users where topicId = &#63; from the database.
	 *
	 * @param topicId the topic ID
	 */
	@Override
	public void removeByTopicId(long topicId) {
		for (TopicUser topicUser : findByTopicId(topicId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(topicUser);
		}
	}

	/**
	 * Returns the number of topic users where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @return the number of matching topic users
	 */
	@Override
	public int countByTopicId(long topicId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TOPICID;

		Object[] finderArgs = new Object[] { topicId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOPICUSER_WHERE);

			query.append(_FINDER_COLUMN_TOPICID_TOPICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(topicId);

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

	private static final String _FINDER_COLUMN_TOPICID_TOPICID_2 = "topicUser.id.topicId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDS = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, TopicUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIds",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDS =
		new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, TopicUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIds",
			new String[] { Long.class.getName() },
			TopicUserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDS = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIds",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDS = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByUserIds",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the topic users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching topic users
	 */
	@Override
	public List<TopicUser> findByUserIds(long userId) {
		return findByUserIds(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TopicUser> findByUserIds(long userId, int start, int end) {
		return findByUserIds(userId, start, end, null);
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
	@Override
	public List<TopicUser> findByUserIds(long userId, int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return findByUserIds(userId, start, end, orderByComparator, true);
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
	@Override
	public List<TopicUser> findByUserIds(long userId, int start, int end,
		OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDS;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDS;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<TopicUser> list = null;

		if (retrieveFromCache) {
			list = (List<TopicUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TopicUser topicUser : list) {
					if ((userId != topicUser.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TOPICUSER_WHERE);

			query.append(_FINDER_COLUMN_USERIDS_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TopicUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first topic user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic user
	 * @throws NoSuchTopicUserException if a matching topic user could not be found
	 */
	@Override
	public TopicUser findByUserIds_First(long userId,
		OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = fetchByUserIds_First(userId, orderByComparator);

		if (topicUser != null) {
			return topicUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchTopicUserException(msg.toString());
	}

	/**
	 * Returns the first topic user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	 */
	@Override
	public TopicUser fetchByUserIds_First(long userId,
		OrderByComparator<TopicUser> orderByComparator) {
		List<TopicUser> list = findByUserIds(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last topic user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic user
	 * @throws NoSuchTopicUserException if a matching topic user could not be found
	 */
	@Override
	public TopicUser findByUserIds_Last(long userId,
		OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = fetchByUserIds_Last(userId, orderByComparator);

		if (topicUser != null) {
			return topicUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchTopicUserException(msg.toString());
	}

	/**
	 * Returns the last topic user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	 */
	@Override
	public TopicUser fetchByUserIds_Last(long userId,
		OrderByComparator<TopicUser> orderByComparator) {
		int count = countByUserIds(userId);

		if (count == 0) {
			return null;
		}

		List<TopicUser> list = findByUserIds(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TopicUser[] findByUserIds_PrevAndNext(TopicUserPK topicUserPK,
		long userId, OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = findByPrimaryKey(topicUserPK);

		Session session = null;

		try {
			session = openSession();

			TopicUser[] array = new TopicUserImpl[3];

			array[0] = getByUserIds_PrevAndNext(session, topicUser, userId,
					orderByComparator, true);

			array[1] = topicUser;

			array[2] = getByUserIds_PrevAndNext(session, topicUser, userId,
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

	protected TopicUser getByUserIds_PrevAndNext(Session session,
		TopicUser topicUser, long userId,
		OrderByComparator<TopicUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOPICUSER_WHERE);

		query.append(_FINDER_COLUMN_USERIDS_USERID_2);

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
			query.append(TopicUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(topicUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TopicUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<TopicUser> findByUserIds(long[] userIds) {
		return findByUserIds(userIds, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TopicUser> findByUserIds(long[] userIds, int start, int end) {
		return findByUserIds(userIds, start, end, null);
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
	@Override
	public List<TopicUser> findByUserIds(long[] userIds, int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return findByUserIds(userIds, start, end, orderByComparator, true);
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
	@Override
	public List<TopicUser> findByUserIds(long[] userIds, int start, int end,
		OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		if (userIds == null) {
			userIds = new long[0];
		}
		else if (userIds.length > 1) {
			userIds = ArrayUtil.unique(userIds);

			Arrays.sort(userIds);
		}

		if (userIds.length == 1) {
			return findByUserIds(userIds[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(userIds) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(userIds),
					
					start, end, orderByComparator
				};
		}

		List<TopicUser> list = null;

		if (retrieveFromCache) {
			list = (List<TopicUser>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDS,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TopicUser topicUser : list) {
					if (!ArrayUtil.contains(userIds, topicUser.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TOPICUSER_WHERE);

			if (userIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_USERIDS_USERID_7);

				query.append(StringUtil.merge(userIds));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TopicUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDS,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the topic users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserIds(long userId) {
		for (TopicUser topicUser : findByUserIds(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(topicUser);
		}
	}

	/**
	 * Returns the number of topic users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching topic users
	 */
	@Override
	public int countByUserIds(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDS;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOPICUSER_WHERE);

			query.append(_FINDER_COLUMN_USERIDS_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	/**
	 * Returns the number of topic users where userId = any &#63;.
	 *
	 * @param userIds the user IDs
	 * @return the number of matching topic users
	 */
	@Override
	public int countByUserIds(long[] userIds) {
		if (userIds == null) {
			userIds = new long[0];
		}
		else if (userIds.length > 1) {
			userIds = ArrayUtil.unique(userIds);

			Arrays.sort(userIds);
		}

		Object[] finderArgs = new Object[] { StringUtil.merge(userIds) };

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TOPICUSER_WHERE);

			if (userIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_USERIDS_USERID_7);

				query.append(StringUtil.merge(userIds));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDS,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERIDS_USERID_2 = "topicUser.id.userId = ?";
	private static final String _FINDER_COLUMN_USERIDS_USERID_7 = "topicUser.id.userId IN (";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPICIDS = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, TopicUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTopicIds",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICIDS =
		new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, TopicUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTopicIds",
			new String[] { Long.class.getName() },
			TopicUserModelImpl.TOPICID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TOPICIDS = new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTopicIds",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TOPICIDS =
		new FinderPath(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTopicIds",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the topic users where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @return the matching topic users
	 */
	@Override
	public List<TopicUser> findByTopicIds(long topicId) {
		return findByTopicIds(topicId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<TopicUser> findByTopicIds(long topicId, int start, int end) {
		return findByTopicIds(topicId, start, end, null);
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
	@Override
	public List<TopicUser> findByTopicIds(long topicId, int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return findByTopicIds(topicId, start, end, orderByComparator, true);
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
	@Override
	public List<TopicUser> findByTopicIds(long topicId, int start, int end,
		OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICIDS;
			finderArgs = new Object[] { topicId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPICIDS;
			finderArgs = new Object[] { topicId, start, end, orderByComparator };
		}

		List<TopicUser> list = null;

		if (retrieveFromCache) {
			list = (List<TopicUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TopicUser topicUser : list) {
					if ((topicId != topicUser.getTopicId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TOPICUSER_WHERE);

			query.append(_FINDER_COLUMN_TOPICIDS_TOPICID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TopicUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(topicId);

				if (!pagination) {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first topic user in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic user
	 * @throws NoSuchTopicUserException if a matching topic user could not be found
	 */
	@Override
	public TopicUser findByTopicIds_First(long topicId,
		OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = fetchByTopicIds_First(topicId, orderByComparator);

		if (topicUser != null) {
			return topicUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("topicId=");
		msg.append(topicId);

		msg.append("}");

		throw new NoSuchTopicUserException(msg.toString());
	}

	/**
	 * Returns the first topic user in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic user, or <code>null</code> if a matching topic user could not be found
	 */
	@Override
	public TopicUser fetchByTopicIds_First(long topicId,
		OrderByComparator<TopicUser> orderByComparator) {
		List<TopicUser> list = findByTopicIds(topicId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last topic user in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic user
	 * @throws NoSuchTopicUserException if a matching topic user could not be found
	 */
	@Override
	public TopicUser findByTopicIds_Last(long topicId,
		OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = fetchByTopicIds_Last(topicId, orderByComparator);

		if (topicUser != null) {
			return topicUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("topicId=");
		msg.append(topicId);

		msg.append("}");

		throw new NoSuchTopicUserException(msg.toString());
	}

	/**
	 * Returns the last topic user in the ordered set where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic user, or <code>null</code> if a matching topic user could not be found
	 */
	@Override
	public TopicUser fetchByTopicIds_Last(long topicId,
		OrderByComparator<TopicUser> orderByComparator) {
		int count = countByTopicIds(topicId);

		if (count == 0) {
			return null;
		}

		List<TopicUser> list = findByTopicIds(topicId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TopicUser[] findByTopicIds_PrevAndNext(TopicUserPK topicUserPK,
		long topicId, OrderByComparator<TopicUser> orderByComparator)
		throws NoSuchTopicUserException {
		TopicUser topicUser = findByPrimaryKey(topicUserPK);

		Session session = null;

		try {
			session = openSession();

			TopicUser[] array = new TopicUserImpl[3];

			array[0] = getByTopicIds_PrevAndNext(session, topicUser, topicId,
					orderByComparator, true);

			array[1] = topicUser;

			array[2] = getByTopicIds_PrevAndNext(session, topicUser, topicId,
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

	protected TopicUser getByTopicIds_PrevAndNext(Session session,
		TopicUser topicUser, long topicId,
		OrderByComparator<TopicUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOPICUSER_WHERE);

		query.append(_FINDER_COLUMN_TOPICIDS_TOPICID_2);

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
			query.append(TopicUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(topicId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(topicUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TopicUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<TopicUser> findByTopicIds(long[] topicIds) {
		return findByTopicIds(topicIds, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<TopicUser> findByTopicIds(long[] topicIds, int start, int end) {
		return findByTopicIds(topicIds, start, end, null);
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
	@Override
	public List<TopicUser> findByTopicIds(long[] topicIds, int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return findByTopicIds(topicIds, start, end, orderByComparator, true);
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
	@Override
	public List<TopicUser> findByTopicIds(long[] topicIds, int start, int end,
		OrderByComparator<TopicUser> orderByComparator,
		boolean retrieveFromCache) {
		if (topicIds == null) {
			topicIds = new long[0];
		}
		else if (topicIds.length > 1) {
			topicIds = ArrayUtil.unique(topicIds);

			Arrays.sort(topicIds);
		}

		if (topicIds.length == 1) {
			return findByTopicIds(topicIds[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(topicIds) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(topicIds),
					
					start, end, orderByComparator
				};
		}

		List<TopicUser> list = null;

		if (retrieveFromCache) {
			list = (List<TopicUser>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPICIDS,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TopicUser topicUser : list) {
					if (!ArrayUtil.contains(topicIds, topicUser.getTopicId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TOPICUSER_WHERE);

			if (topicIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_TOPICIDS_TOPICID_7);

				query.append(StringUtil.merge(topicIds));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TopicUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPICIDS,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_TOPICIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the topic users where topicId = &#63; from the database.
	 *
	 * @param topicId the topic ID
	 */
	@Override
	public void removeByTopicIds(long topicId) {
		for (TopicUser topicUser : findByTopicIds(topicId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(topicUser);
		}
	}

	/**
	 * Returns the number of topic users where topicId = &#63;.
	 *
	 * @param topicId the topic ID
	 * @return the number of matching topic users
	 */
	@Override
	public int countByTopicIds(long topicId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TOPICIDS;

		Object[] finderArgs = new Object[] { topicId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOPICUSER_WHERE);

			query.append(_FINDER_COLUMN_TOPICIDS_TOPICID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(topicId);

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

	/**
	 * Returns the number of topic users where topicId = any &#63;.
	 *
	 * @param topicIds the topic IDs
	 * @return the number of matching topic users
	 */
	@Override
	public int countByTopicIds(long[] topicIds) {
		if (topicIds == null) {
			topicIds = new long[0];
		}
		else if (topicIds.length > 1) {
			topicIds = ArrayUtil.unique(topicIds);

			Arrays.sort(topicIds);
		}

		Object[] finderArgs = new Object[] { StringUtil.merge(topicIds) };

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TOPICIDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TOPICUSER_WHERE);

			if (topicIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_TOPICIDS_TOPICID_7);

				query.append(StringUtil.merge(topicIds));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TOPICIDS,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TOPICIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TOPICIDS_TOPICID_2 = "topicUser.id.topicId = ?";
	private static final String _FINDER_COLUMN_TOPICIDS_TOPICID_7 = "topicUser.id.topicId IN (";

	public TopicUserPersistenceImpl() {
		setModelClass(TopicUser.class);
	}

	/**
	 * Caches the topic user in the entity cache if it is enabled.
	 *
	 * @param topicUser the topic user
	 */
	@Override
	public void cacheResult(TopicUser topicUser) {
		entityCache.putResult(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserImpl.class, topicUser.getPrimaryKey(), topicUser);

		topicUser.resetOriginalValues();
	}

	/**
	 * Caches the topic users in the entity cache if it is enabled.
	 *
	 * @param topicUsers the topic users
	 */
	@Override
	public void cacheResult(List<TopicUser> topicUsers) {
		for (TopicUser topicUser : topicUsers) {
			if (entityCache.getResult(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
						TopicUserImpl.class, topicUser.getPrimaryKey()) == null) {
				cacheResult(topicUser);
			}
			else {
				topicUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all topic users.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TopicUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the topic user.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TopicUser topicUser) {
		entityCache.removeResult(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserImpl.class, topicUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TopicUser> topicUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TopicUser topicUser : topicUsers) {
			entityCache.removeResult(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
				TopicUserImpl.class, topicUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new topic user with the primary key. Does not add the topic user to the database.
	 *
	 * @param topicUserPK the primary key for the new topic user
	 * @return the new topic user
	 */
	@Override
	public TopicUser create(TopicUserPK topicUserPK) {
		TopicUser topicUser = new TopicUserImpl();

		topicUser.setNew(true);
		topicUser.setPrimaryKey(topicUserPK);

		return topicUser;
	}

	/**
	 * Removes the topic user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param topicUserPK the primary key of the topic user
	 * @return the topic user that was removed
	 * @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	 */
	@Override
	public TopicUser remove(TopicUserPK topicUserPK)
		throws NoSuchTopicUserException {
		return remove((Serializable)topicUserPK);
	}

	/**
	 * Removes the topic user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the topic user
	 * @return the topic user that was removed
	 * @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	 */
	@Override
	public TopicUser remove(Serializable primaryKey)
		throws NoSuchTopicUserException {
		Session session = null;

		try {
			session = openSession();

			TopicUser topicUser = (TopicUser)session.get(TopicUserImpl.class,
					primaryKey);

			if (topicUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTopicUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(topicUser);
		}
		catch (NoSuchTopicUserException nsee) {
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
	protected TopicUser removeImpl(TopicUser topicUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(topicUser)) {
				topicUser = (TopicUser)session.get(TopicUserImpl.class,
						topicUser.getPrimaryKeyObj());
			}

			if (topicUser != null) {
				session.delete(topicUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (topicUser != null) {
			clearCache(topicUser);
		}

		return topicUser;
	}

	@Override
	public TopicUser updateImpl(TopicUser topicUser) {
		boolean isNew = topicUser.isNew();

		if (!(topicUser instanceof TopicUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(topicUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(topicUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in topicUser proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TopicUser implementation " +
				topicUser.getClass());
		}

		TopicUserModelImpl topicUserModelImpl = (TopicUserModelImpl)topicUser;

		Session session = null;

		try {
			session = openSession();

			if (topicUser.isNew()) {
				session.save(topicUser);

				topicUser.setNew(false);
			}
			else {
				topicUser = (TopicUser)session.merge(topicUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TopicUserModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { topicUserModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
				args);

			args = new Object[] { topicUserModelImpl.getTopicId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TOPICID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICID,
				args);

			args = new Object[] { topicUserModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDS,
				args);

			args = new Object[] { topicUserModelImpl.getTopicId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TOPICIDS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICIDS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((topicUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						topicUserModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { topicUserModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((topicUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						topicUserModelImpl.getOriginalTopicId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TOPICID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICID,
					args);

				args = new Object[] { topicUserModelImpl.getTopicId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TOPICID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICID,
					args);
			}

			if ((topicUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						topicUserModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDS,
					args);

				args = new Object[] { topicUserModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDS,
					args);
			}

			if ((topicUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						topicUserModelImpl.getOriginalTopicId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TOPICIDS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICIDS,
					args);

				args = new Object[] { topicUserModelImpl.getTopicId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TOPICIDS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TOPICIDS,
					args);
			}
		}

		entityCache.putResult(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
			TopicUserImpl.class, topicUser.getPrimaryKey(), topicUser, false);

		topicUser.resetOriginalValues();

		return topicUser;
	}

	/**
	 * Returns the topic user with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the topic user
	 * @return the topic user
	 * @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	 */
	@Override
	public TopicUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTopicUserException {
		TopicUser topicUser = fetchByPrimaryKey(primaryKey);

		if (topicUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTopicUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return topicUser;
	}

	/**
	 * Returns the topic user with the primary key or throws a {@link NoSuchTopicUserException} if it could not be found.
	 *
	 * @param topicUserPK the primary key of the topic user
	 * @return the topic user
	 * @throws NoSuchTopicUserException if a topic user with the primary key could not be found
	 */
	@Override
	public TopicUser findByPrimaryKey(TopicUserPK topicUserPK)
		throws NoSuchTopicUserException {
		return findByPrimaryKey((Serializable)topicUserPK);
	}

	/**
	 * Returns the topic user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the topic user
	 * @return the topic user, or <code>null</code> if a topic user with the primary key could not be found
	 */
	@Override
	public TopicUser fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
				TopicUserImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TopicUser topicUser = (TopicUser)serializable;

		if (topicUser == null) {
			Session session = null;

			try {
				session = openSession();

				topicUser = (TopicUser)session.get(TopicUserImpl.class,
						primaryKey);

				if (topicUser != null) {
					cacheResult(topicUser);
				}
				else {
					entityCache.putResult(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
						TopicUserImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TopicUserModelImpl.ENTITY_CACHE_ENABLED,
					TopicUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return topicUser;
	}

	/**
	 * Returns the topic user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param topicUserPK the primary key of the topic user
	 * @return the topic user, or <code>null</code> if a topic user with the primary key could not be found
	 */
	@Override
	public TopicUser fetchByPrimaryKey(TopicUserPK topicUserPK) {
		return fetchByPrimaryKey((Serializable)topicUserPK);
	}

	@Override
	public Map<Serializable, TopicUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TopicUser> map = new HashMap<Serializable, TopicUser>();

		for (Serializable primaryKey : primaryKeys) {
			TopicUser topicUser = fetchByPrimaryKey(primaryKey);

			if (topicUser != null) {
				map.put(primaryKey, topicUser);
			}
		}

		return map;
	}

	/**
	 * Returns all the topic users.
	 *
	 * @return the topic users
	 */
	@Override
	public List<TopicUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TopicUser> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TopicUser> findAll(int start, int end,
		OrderByComparator<TopicUser> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TopicUser> findAll(int start, int end,
		OrderByComparator<TopicUser> orderByComparator,
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

		List<TopicUser> list = null;

		if (retrieveFromCache) {
			list = (List<TopicUser>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TOPICUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOPICUSER;

				if (pagination) {
					sql = sql.concat(TopicUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TopicUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the topic users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TopicUser topicUser : findAll()) {
			remove(topicUser);
		}
	}

	/**
	 * Returns the number of topic users.
	 *
	 * @return the number of topic users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOPICUSER);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TopicUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the topic user persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TopicUserImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TOPICUSER = "SELECT topicUser FROM TopicUser topicUser";
	private static final String _SQL_SELECT_TOPICUSER_WHERE = "SELECT topicUser FROM TopicUser topicUser WHERE ";
	private static final String _SQL_COUNT_TOPICUSER = "SELECT COUNT(topicUser) FROM TopicUser topicUser";
	private static final String _SQL_COUNT_TOPICUSER_WHERE = "SELECT COUNT(topicUser) FROM TopicUser topicUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "topicUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TopicUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TopicUser exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TopicUserPersistenceImpl.class);
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(new String[] {
				"topicId", "userId"
			});
}