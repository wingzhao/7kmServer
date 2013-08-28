/**
 * 
 */
package com.daojia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daojia.domain.Category;

/**
 * 品类Service
 * 
 * @author zhaolei 2013年8月28日 上午11:57:01
 */
@Service
public class CategoryService {

	/**
	 * 通过id获得品类
	 * 
	 * @author zhaolei 2013年8月28日 下午3:21:15
	 * 
	 * @param categoryId
	 * @return
	 */
	public Category getById(Integer categoryId) {
		return null;
	}

	/**
	 * 保存品类
	 * 
	 * @author zhaolei 2013年8月28日 上午11:58:29
	 * 
	 * @param category
	 */
	public void save(Category category) {

	}

	/**
	 * 更新品类
	 * 
	 * @author zhaolei 2013年8月28日 下午12:00:06
	 * 
	 * @param category
	 */
	public void update(Category category) {

	}

	/**
	 * 删除品类
	 * 
	 * @author zhaolei 2013年8月28日 下午12:00:43
	 * 
	 * @param category
	 */
	public void remove(Category category) {

	}

	/**
	 * 获取所有可用品类
	 * 
	 * @author zhaolei 2013年8月28日 下午3:22:55
	 * 
	 * @return
	 */
	public List<Category> getAllEnableCategories() {
		return null;
	}

	/**
	 * 获取所有品类
	 * 
	 * @author zhaolei 2013年8月28日 下午3:21:50
	 * 
	 * @return
	 */
	public List<Category> getAllCategories() {
		return null;
	}

}
