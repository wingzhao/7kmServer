/**
 * 
 */
package com.daojia.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

/**
 * hibernata 使用的基础dao
 * 
 * @author zhaolei 2013年8月28日 下午5:28:51
 */
public abstract class HibernateDao<T> {

	private final Class<T> clazz;

	@SuppressWarnings("unchecked")
	public HibernateDao() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Resource
	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Force this session to flush. Must be called at the end of a unit of work,
	 * before committing the transaction and closing the session (depending on
	 * {@link #setFlushMode(FlushMode)}, {@link Transaction#commit()} calls this
	 * method).
	 * 
	 * @author zhaolei 2013年8月29日 上午1:02:22
	 * 
	 */
	public void flush() {
		getSession().flush();
	}

	/**
	 * Remove this instance from the session cache. Changes to the instance will
	 * not be synchronized with the database. This operation cascades to
	 * associated instances if the association is mapped with
	 * <tt>cascade="evict"</tt>.
	 * 
	 * @author zhaolei 2013年8月29日 上午1:04:50
	 * 
	 * @param po
	 */
	public void evict(T po) {
		getSession().evict(po);
	}

	/**
	 * Completely clear the session. Evict all loaded instances and cancel all
	 * pending saves, updates and deletions. Do not close open iterators or
	 * instances of <tt>ScrollableResults</tt>.
	 * 
	 * @author zhaolei 2013年8月29日 上午1:13:33
	 * 
	 */
	public void clear() {
		getSession().clear();
	}

	/**
	 * 保存对象
	 * 
	 * @author zhaolei 2013年8月29日 上午12:44:09
	 * 
	 * @param po
	 */
	public void save(T po) {
		getSession().save(po);
	}

	/**
	 * 保存一组对象
	 * 
	 * @author zhaolei 2013年8月29日 上午12:51:21
	 * 
	 * @param pos
	 */
	public void save(Collection<T> pos) {
		Session session = getSession();
		for (T po : pos) {
			session.save(po);
		}
	}

	/**
	 * 保存或者更新
	 * 
	 * @author zhaolei 2013年8月29日 上午12:47:10
	 * 
	 * @param po
	 */
	public void saveOrUpdate(T po) {
		getSession().saveOrUpdate(po);
	}

	/**
	 * 保存或者更新一组
	 * 
	 * @author zhaolei 2013年8月29日 上午12:50:01
	 * 
	 * @param pos
	 */
	public void saveOrUpdate(Collection<T> pos) {
		Session session = getSession();
		for (T po : pos) {
			session.saveOrUpdate(po);
		}
	}

	/**
	 * 更新
	 * 
	 * @author zhaolei 2013年8月29日 上午12:47:10
	 * 
	 * @param po
	 */
	public void update(T po) {
		getSession().update(po);
	}

	/**
	 * 更新一组
	 * 
	 * @author zhaolei 2013年8月29日 上午12:50:01
	 * 
	 * @param pos
	 */
	public void update(Collection<T> pos) {
		Session session = getSession();
		for (T po : pos) {
			session.update(po);
		}
	}

	/**
	 * 删除
	 * 
	 * @author zhaolei 2013年8月29日 上午12:47:10
	 * 
	 * @param po
	 */
	public void delete(T po) {
		getSession().delete(po);
	}

	/**
	 * 删除一组
	 * 
	 * @author zhaolei 2013年8月29日 上午12:50:01
	 * 
	 * @param pos
	 */
	public void delete(Collection<T> pos) {
		Session session = getSession();
		for (T po : pos) {
			session.delete(po);
		}
	}

	/**
	 * Copy the state of the given object onto the persistent object with the
	 * same identifier. If there is no persistent instance currently associated
	 * with the session, it will be loaded. Return the persistent instance. If
	 * the given instance is unsaved, save a copy of and return it as a newly
	 * persistent instance. The given instance does not become associated with
	 * the session. This operation cascades to associated instances if the
	 * association is mapped with {@code cascade="merge"}
	 * 
	 * @author zhaolei 2013年8月29日 上午1:00:05
	 * 
	 * @param po
	 */
	public void merge(T po) {
		getSession().merge(po);
	}

	/**
	 * Make a transient instance persistent. This operation cascades to
	 * associated instances if the association is mapped with
	 * {@code cascade="persist"} The semantics of this method are defined by
	 * JSR-220.
	 * 
	 * @author zhaolei 2013年8月29日 上午1:08:43
	 * 
	 * @param po
	 */
	public void persist(T po) {
		getSession().persist(po);
	}

	/**
	 * 根据主键查找
	 * 
	 * @author zhaolei 2013年8月29日 上午12:56:20
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		return (T) getSession().get(clazz, id);
	}

	/**
	 * 根据hql查询
	 * 
	 * @author zhaolei 2013年8月29日 上午1:29:23
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		setParameters(query, params);
		List<T> relList = query.list();
		return relList;
	}

	/**
	 * 根据dc查询
	 * 
	 * @author zhaolei 2013年8月29日 上午1:31:27
	 * 
	 * @param dc
	 * @return
	 */
	public List<T> find(DetachedCriteria dc) {
		return find(dc, -1, -1);
	}

	/**
	 * 根据dc分页查询
	 * 
	 * @author zhaolei 2013年8月29日 上午1:34:14
	 * 
	 * @param dc
	 * @param start
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(DetachedCriteria dc, int start, int size) {
		Criteria executableCriteria = dc.getExecutableCriteria(getSession());
		prepareCriteria(executableCriteria);
		if (start >= 0) {
			executableCriteria.setFirstResult(start);
		}
		if (size > 0) {
			executableCriteria.setMaxResults(size);
		}
		return executableCriteria.list();
	}

	/**
	 * 设置查询条件的一些基本属性
	 * 
	 * @author zhaolei 2013年8月29日 上午1:42:14
	 * 
	 * @param criteria
	 */
	private void prepareCriteria(Criteria criteria) {
		// if (isCacheQueries()) {
		// criteria.setCacheable(true);
		// if (getQueryCacheRegion() != null) {
		// criteria.setCacheRegion(getQueryCacheRegion());
		// }
		// }
		// if (getFetchSize() > 0) {
		// criteria.setFetchSize(getFetchSize());
		// }
		// if (getMaxResults() > 0) {
		// criteria.setMaxResults(getMaxResults());
		// }
		// SessionFactoryUtils.applyTransactionTimeout(criteria,
		// getSessionFactory());
	}

	/**
	 * 设置参数
	 * 
	 * @author zhaolei 2013年8月29日 上午1:25:24
	 * 
	 * @param query
	 * @param params
	 */
	private void setParameters(Query query, Object[] params) {
		if (params == null || params.length == 0) {
			return;
		} else {
			for (int i = 0; i < params.length; i++) {
				Object param = params[i];
				query.setParameter(i, param);
			}
		}
	}
}
