package org.oni.webapp.dao.base.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.oni.webapp.dao.base.GenericDao;
import org.oni.webapp.dao.entity.base.EntityBase;
import org.oni.webapp.enumeration.SortDir;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is the Hibernate implementation class of the base DAO.
 * 
 * @author DungTV
 * @param <E>
 *            Class of Entity
 * @param <PK>
 *            Class of Primary Key
 */
public abstract class GenericDaoImpl<E extends EntityBase<PK>, PK extends Serializable>
		implements GenericDao<E, PK> {

	/** Class of Entity */
	private final Class<? extends E> entityClass;

	/** Class of Primary Key */
	private final Class<? extends PK> pkClass;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Constructor
	 * 
	 * @param entityClass
	 *            Class of Entity
	 * @param pkClass
	 *            Class of Primary Key
	 */
	public GenericDaoImpl(Class<? extends E> entityClass,
			Class<? extends PK> pkClass) {
		this.entityClass = entityClass;
		this.pkClass = pkClass;

		// verify entity class
		Entity e = this.entityClass.getAnnotation(Entity.class);
		if (e == null) {
			throw new RuntimeException(
					"Please specify the class Entity annotation of JPA is attached.");
		}
		// verify primary key class
		if (Serializable.class.isAssignableFrom(this.pkClass) == false) {
			throw new RuntimeException(
					"Please specify the class PK extend from Serializable class");
		}
	}

	@SuppressWarnings("unchecked")
	public PK insert(E entity) {
		return (PK) getCurrentSession().save(entity);
	}

	public void update(E entity) {
		getCurrentSession().update(entity);
	}

	public void insertOrUpdate(E entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void updateField(PK pk, String fieldName, Object value) {

		Map<String, Object> valueMap = new HashMap<String, Object>(1);
		valueMap.put(fieldName, value);
		updateFields(pk, valueMap);
	}

	public void updateFields(PK pk, Map<String, Object> valueMap) {

		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ").append(getEntityClassName()).append(" SET ");
		for (Map.Entry<String, ?> entry : valueMap.entrySet()) {
			sb.append(entry.getKey()).append(" = :" + entry.getKey() + ", ");
		}
		sb.deleteCharAt(sb.length() - 2);
		sb.append("WHERE id = :pk");

		Query query = getCurrentSession().createQuery(sb.toString());
		for (Map.Entry<String, ?> entry : valueMap.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.setParameter("pk", pk);

		query.executeUpdate();
	}

	public void delete(E entity) {

		getCurrentSession().delete(entity);
	}

	public void deleteByPK(PK pk) {

		getCurrentSession()
				.createQuery(
						"DELETE FROM " + getEntityClassName()
								+ " WHERE id = :pk").setParameter("pk", pk)
				.executeUpdate();
	}

	public void deleteByPKs(Collection<PK> pks) {

		deleteBy("id", pks);
	}

	public void deleteBy(String fieldName, Object value) {

		getCurrentSession()
				.createQuery(
						"DELETE FROM " + getEntityClassName() + " " + "WHERE "
								+ fieldName + " = :value")
				.setParameter("value", value).executeUpdate();
	}

	public void deleteBy(String fieldName, Collection<?> values) {

		if (CollectionUtils.isEmpty(values)) {
			return;
		}

		getCurrentSession()
				.createQuery(
						"DELETE FROM " + getEntityClassName() + " " + "WHERE "
								+ fieldName + " in (:values)")
				.setParameterList("values", values).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public E findByPK(PK pk) {

		return (E) getCurrentSession().get(this.entityClass, (Serializable) pk);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {

		return createCriteria().list();
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll(String sortKey, SortDir sortDir) {

		Criteria criteria = createCriteria();
		setSortParamsToCriteria(criteria, sortKey, sortDir);

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<E> find(int offset, int size, String sortKey, SortDir sortDir) {

		Criteria criteria = createCriteria();
		setParamsToCriteria(criteria, offset, size, sortKey, sortDir);

		return criteria.list();
	}

	public long countAll() {

		Long count = (Long) createCriteria().setProjection(
				Projections.rowCount()).uniqueResult();
		return count.longValue();
	}

	public E findOne(String fieldName, Object value) {

		@SuppressWarnings("unchecked")
		E object = (E) createCriteria().add(Restrictions.eq(fieldName, value))
				.uniqueResult();
		return object;
	}

	public List<E> findBy(String fieldName, Object value) {

		@SuppressWarnings("unchecked")
		List<E> list = createCriteria().add(Restrictions.eq(fieldName, value))
				.list();
		return list;
	}

	public List<E> findBy(Map<String, Object> map) {

		// find all entities if the map is empty
		if (map == null || map.isEmpty()) {
			return findAll();
		}

		Criteria criteria = createCriteria();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String fieldName = entry.getKey();
			Object value = entry.getValue();
			criteria.add(Restrictions.eq(fieldName, value));
		}
		@SuppressWarnings("unchecked")
		List<E> list = criteria.list();
		return list;
	}

	public List<E> findByPKs(Collection<?> values) {
		return findBy("id", values);
	}

	@SuppressWarnings("unchecked")
	public List<E> findBy(String fieldName, Collection<?> values) {

		List<E> list;
		if (CollectionUtils.isNotEmpty(values)) {
			list = createCriteria().add(Restrictions.in(fieldName, values))
					.list();
		} else {
			list = new ArrayList<E>(0);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public Collection<PK> getAllPKs() {

		List<PK> pks = createCriteria().setProjection(Projections.id()).list();
		return new HashSet<PK>(pks);
	}

	public boolean isExisted(PK pk) {

		E object = findByPK(pk);
		return object != null;
	}

	public boolean isExisted(String fieldName, Object value) {

		E object = findOne(fieldName, value);
		return object != null;
	}

	public boolean isExisted(String fieldName, Collection<?> values) {

		Long count;

		if (CollectionUtils.isNotEmpty(values)) {
			count = (Long) createCriteria()
					.add(Restrictions.in(fieldName, values)).setMaxResults(1)
					.setProjection(Projections.rowCount()).uniqueResult();
			return count.longValue() > 0;
		} else {
			return false;
		}
	}

	/*
	 * Set the list parameters to the Criteria.
	 */
	private void setParamsToCriteria(Criteria criteria, int offset, int size,
			String sortKey, SortDir sortDir) {

		// range specification
		criteria.setFirstResult(offset);
		criteria.setMaxResults(size);

		// order specified
		setSortParamsToCriteria(criteria, sortKey, sortDir);
	}

	/*
	 * Set the list sort parameters to the Criteria.
	 */
	private void setSortParamsToCriteria(Criteria criteria, String sortKey,
			SortDir sortDir) {

		// order specified
		if (StringUtils.isNotEmpty(sortKey)) {
			Order order;
			if (sortDir == SortDir.DESC) {
				order = Order.desc(sortKey);
			} else {
				order = Order.asc(sortKey);
			}
			criteria.addOrder(order);
		}
	}

	public Class<? extends E> getEntityClass() {
		return this.entityClass;
	}

	/**
	 * Get the class name of the entity.
	 * 
	 * @return エンティティのクラス名
	 */
	protected String getEntityClassName() {
		return getEntityClass().getSimpleName();
	}

	/**
	 * create Criteria
	 * 
	 * @return Criteria
	 */
	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(this.entityClass);
	}

	/**
	 * Get the SessionFactory.
	 * 
	 * @return SessionFactory
	 */
	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	/**
	 * get the session
	 * 
	 * @return Session
	 */
	public Session getCurrentSession() {
		return this.getSessionFactory().getCurrentSession();
	}

	/*
	 * open the session
	 * 
	 * @return Session
	 */
	public Session getOpenSession() {
		return this.getSessionFactory().openSession();
	}

	public E createEntity() {
		return newInstanceWithConvertRuntimeException(entityClass);
	}

	public PK createPK() {
		return newInstanceWithConvertRuntimeException(this.pkClass);
	}

	private static <T> T newInstanceWithConvertRuntimeException(Class<T> cls) {
		try {
			return cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
