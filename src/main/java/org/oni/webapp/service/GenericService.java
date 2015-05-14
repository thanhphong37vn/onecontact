package org.oni.webapp.service;

import java.io.Serializable;
import java.util.List;

import org.oni.webapp.dao.entity.base.EntityBase;

/**
 * This is the interface of the base SERVICE.
 * @author DungTV
 *
 * @param <E> Class of Entity
 * @param <PK> Class of Primary Key
 */
public interface GenericService<E extends EntityBase<PK>, PK extends Serializable> {
	
	/**
     * Get the entity from database
     * @param id primary key
     * @return entity
     */
	public E findByPK(PK id);
	
	/**
     * Add entity to database
     * @param entity entity
     * @return primary key
     */
	public PK insert(E entity);

	/**
     * Update entity to database
     * @param entity entity
     */
	public void update(E entity);

	 /**
     * Delete entity from database
     * @param pk primary key
     */
	public void deleteByPK(PK id);

	/**
     * Get a list of all entities.
     * @return List of all entities
     */
	public List<E> getAll();	
	
	/**
	 * register or update entity to database
	 * @param entity entity
	 * @return primary key
	 */
	public PK registerOrUpdate(E entity);
	
	/**
     * create an object of the entity class
     * @return an instance of Entity
     */
    public E createEntity();
}
