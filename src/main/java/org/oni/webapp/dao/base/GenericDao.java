package org.oni.webapp.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.oni.webapp.dao.entity.base.EntityBase;
import org.oni.webapp.enumeration.SortDir;



/**
 * This is the interface of the base DAO.
 * @author DungTV
 * @param <E> Class of Entity
 * @param <PK> Class of Primary Key
 */
public interface GenericDao<E extends EntityBase<PK>, PK extends Serializable> {

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
     * I will update additional entity if the entity already exists, update it, otherwise insert entity to database
     * @param entity entity
     */
    public void insertOrUpdate(E entity);

    /**
     * Update the specified fields of an entity.
     * @param pk primary key
     * @param fieldName field name
     * @param value value
     */
    public void updateField(PK pk, String fieldName, Object value);

    /**
     * update the specified fields of an entity.
     * @param pk primary key
     * @param valueMap Map of field names and values
     */
    public void updateFields(PK pk, Map<String, Object> valueMap);

    /**
     * Delete entity from database
     * @param entity entity
     */
    public void delete(E entity);

    /**
     * Delete entity from database
     * @param pk primary key
     */
    public void deleteByPK(PK pk);

    /**
     * Delete entities from database
     * @param pks set of primary key
     */
    public void deleteByPKs(Collection<PK> pks);

    /**
     * Delete entity from database
     * @param fieldName field name
     * @param value value
     */
    public void deleteBy(String fieldName, Object value);

    /**
     * Delete entity from database
     * @param fieldName field name
     * @param values set of values
     */
    public void deleteBy(String fieldName, Collection<?> values);


    /**
     * Get the entity from database
     * @param pk primary key
     * @return entity
     */
    public E findByPK(PK pk);

    /**
     * Get one entity.
     * @param fieldName field name
     * @param value value
     * @return Entity
     */
    public E findOne(String fieldName, Object value);

    /**
     * Get a list of entities.
     * @param fieldName field name
     * @param value value
     * @return List of entities
     */
    public List<E> findBy(String fieldName, Object value);

    /**
     * Get a list of entities.
     * @param map Map of field names and values
     * @return List of entities
     */
    public List<E> findBy(Map<String, Object> map);

    /**
     * Get a list of entities.
     * @param pks set of primary key
     * @return List of entities
     */
    public List<E> findByPKs(Collection<?> pks);

    /**
     * Get a list of entities.
     * @param fieldName field name
     * @param values set of values
     * @return List of entities
     */
    public List<E> findBy(String fieldName, Collection<?> values);

    /**
     * Check entity exists
     * @param pk primary key
     * @return entity exists?
     */
    public boolean isExisted(PK pk);

    /**
     * Check entity exists
     * @param fieldName field name
     * @param value value
     * @return entity exists?
     */
    public boolean isExisted(String fieldName, Object value);

    /**
     * Check entity exists
     * @param fieldName field name
     * @param values set of values
     * @return Entity exist? of the values ​​contained in the values, return true if it exists at least one
     */
    public boolean isExisted(String fieldName, Collection<?> values);

    /**
     * Get a list of all entities.
     * @return List of all entities
     */
    public List<E> findAll();

    /**
     * Get a list of all entities.
     * @param sortKey sort key
     * @param sortDir sort direction
     * @return List of all entities
     */
    public List<E> findAll(String sortKey, SortDir sortDir);

    /**
     * Get a list of all entities.
     * @param offset start position
     * @param size number record
     * @param sortKey sort key
     * @param sortDir sort direction
     * @return List of all entities
     */
    public List<E> find(int offset, int size, String sortKey, SortDir sortDir);

    /**
     * Get a set of primary key of all entities.
     * @return Set of primary key of all entities
     */
    public Collection<PK> getAllPKs();

    /**
     * Get the total number.
     * @return Total number
     */
    public long countAll();
    
    
    /**
     * create an object of the entity class
     * @return an instance of Entity
     */
    public E createEntity();
    
    /**
     * create an object of the entity PrimaryKey class
     * @return
     */
    public PK createPK();  
    
    /**
     * return the implementation class of the Entity.
     * @return
     */
    public Class<? extends E> getEntityClass();
}
