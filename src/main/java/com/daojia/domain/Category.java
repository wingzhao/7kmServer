/**
 * 
 */
package com.daojia.domain;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * 品类
 * 
 * @author zhaolei 2013年8月20日 下午6:24:50
 */
@Entity
public class Category implements Serializable{

	private static final long serialVersionUID = -6428978911973623236L;
	
	/**
	 * 品类id
	 */
	private Integer catId;
	
	/**
	 * 父品类id
	 */
	private Integer parentId;
	
	/**
	 * 品类名称
	 */
	private String catName;
	
	/**
	 * 品类状态
	 */
	private Integer catStatus;

	/**
	 * @return the catStatus
	 */
	public Integer getCatStatus() {
		return catStatus;
	}

	/**
	 * @param catStatus the catStatus to set
	 */
	public void setCatStatus(Integer catStatus) {
		this.catStatus = catStatus;
	}

	/**
	 * @return the catId
	 */
	public Integer getCatId() {
		return catId;
	}

	/**
	 * @param catId the catId to set
	 */
	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	/**
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the catName
	 */
	public String getCatName() {
		return catName;
	}

	/**
	 * @param catName the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
}
