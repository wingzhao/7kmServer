/**
 * 
 */
package com.daojia.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * hibernata 使用的基础dao
 * 
 * @author zhaolei 2013年8月28日 下午5:28:51
 */
public class HibernateDao<T> {
	/**
     * spring 封装的hibernateTemplate,protected是为了用不同的数据源
     */
    protected HibernateTemplate hibernateTemplate;
    protected Class<T> clazz;

}
