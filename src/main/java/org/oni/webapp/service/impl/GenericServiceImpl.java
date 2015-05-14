package org.oni.webapp.service.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.oni.webapp.dao.base.GenericDao;
import org.oni.webapp.dao.entity.base.EntityBase;
import org.oni.webapp.exception.ErrorType;
import org.oni.webapp.exception.OniException;
import org.oni.webapp.service.GenericService;

/**
 * implement of class GenericService
 * 
 * @author DungTV
 * 
 * @param <E>
 *            Class of Entity
 * @param <PK>
 *            Class of Primary Key
 */
public abstract class GenericServiceImpl<E extends EntityBase<PK>, PK extends Serializable>
		implements GenericService<E, PK> {

	
	public E findByPK(PK id) {
		if (id != null) {
			return getDao().findByPK(id);
		}
		return null;
		
	}

	
	public PK insert(E entity) {
		return getDao().insert(entity);

	}

	
	public void update(E entity) {
		getDao().update(entity);

	}

	
	public void deleteByPK(PK pk) {
		getDao().deleteByPK(pk);
	}

	
	public List<E> getAll() {
		return getDao().findAll();
	}

	
	public PK registerOrUpdate(E e) {
		try {
			E entity = null;
			if (e.getId() != null) {
				entity = findByPK(e.getId());
			}
			if (entity == null) {
				// create entity if not existed
				entity = getDao().createEntity();
				PropertyUtils.copyProperties(entity, e);
				return getDao().insert(entity);
			} else {
				PropertyUtils.copyProperties(entity, e);
				getDao().update(entity);
				return entity.getId();
			}
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new OniException(ErrorType.UNKNOW_ERROR, e1);
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new OniException(ErrorType.UNKNOW_ERROR, e1);
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new OniException(ErrorType.UNKNOW_ERROR, e1);
		}
	}

	
	public E createEntity() {
		return getDao().createEntity();
	};

	protected abstract GenericDao<E, PK> getDao();

}
