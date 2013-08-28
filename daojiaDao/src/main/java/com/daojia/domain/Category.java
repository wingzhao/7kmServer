/**
 * 
 */
package com.daojia.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 品类
 * 
 * @author zhaolei 2013年8月20日 下午6:24:50
 */
@Entity
@Table(name = "category")
@DynamicInsert
@DynamicUpdate
@JsonIgnoreProperties(value = { "hibernateLazyInitializer" })
public class Category implements Serializable {

	private static final long serialVersionUID = -6428978911973623236L;

	/**
	 * 品类id
	 */
	@Id
	@Column(name = "id", columnDefinition = "integer", length = 11)
	private Integer catId;

	/**
	 * 父品类id
	 */
	@Column(name = "parent_id", columnDefinition = "integer", length = 11)
	private Integer parentId;

	/**
	 * 品类名称
	 */
	@Column(name = "cat_name", columnDefinition = "varchar", length = 20)
	private String catName;

	/**
	 * 品类状态
	 */
	@Column(name = "is_enable", columnDefinition = "tinyint", length = 1)
	private Integer isEnable;

	/**
	 * 最后修改时间
	 */
	@Column(name = "last_time", columnDefinition = "datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastTime;

	/**
	 * @return the catId
	 */
	public Integer getCatId() {
		return catId;
	}

	/**
	 * @param catId
	 *            the catId to set
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
	 * @param parentId
	 *            the parentId to set
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
	 * @param catName
	 *            the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}

	/**
	 * @return the isEnable
	 */
	public Integer getIsEnable() {
		return isEnable;
	}

	/**
	 * @param isEnable
	 *            the isEnable to set
	 */
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	/**
	 * @return the lastTime
	 */
	public Date getLastTime() {
		return lastTime;
	}

	/**
	 * @param lastTime
	 *            the lastTime to set
	 */
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

}
