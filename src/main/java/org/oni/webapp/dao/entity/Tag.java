package org.oni.webapp.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.oni.webapp.dao.entity.base.EntityBaseImpl;

/**
 * 
 * @author DungTV
 * 
 */
@Entity
@Table(name = "cms_ncs_tag")
public class Tag extends EntityBaseImpl<Integer> {

	private static final long serialVersionUID = 8629474716416940296L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_sequence")
//	@SequenceGenerator(name = "tag_sequence", sequenceName = "tag_sequence")  
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
		
	@Column(name = "enable", nullable = false)
	private int enable;
	
	@Column(name = "last_update", nullable = false)
	private Date lastUpdate;
	
	/**
	 * Constructor
	 */
	public Tag() {
	}
	
	
	public Integer getId() {
		return this.id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the enable
	 */
	public int getEnable() {
		return enable;
	}


	/**
	 * @param enable the enable to set
	 */
	public void setEnable(int enable) {
		this.enable = enable;
	}


	/**
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}


	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	

}
