package org.oni.webapp.dao.entity.base;

import java.io.Serializable;

/**
 * It is a base interface for all Entity class
 * @author DungTV
 *
 */
public interface EntityBase<PK extends Serializable> extends Serializable{
	
	/**
	 * get primary key value
	 * @return primary key
	 */
	PK getId();
	
	/**
	 * set primary key
	 * @param pk primary key value
	 */
	void setId(PK pk);
}
