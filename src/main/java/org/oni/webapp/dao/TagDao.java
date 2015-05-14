package org.oni.webapp.dao;

import java.util.List;

import org.oni.webapp.dao.base.GenericDao;
import org.oni.webapp.dao.entity.Tag;
import org.oni.webapp.utils.PaginationBean;

/**
 * This is the interface of the Tag DAO.
 * 
 * @author DungTV
 *
 */
public interface TagDao extends GenericDao<Tag, Integer> {
	public List<Tag> searchByKey(String key);

	public List<Tag> getListTag(PaginationBean paginationBean, Integer cate);
}