package org.oni.webapp.dao;

import java.util.List;

import org.oni.webapp.dao.base.GenericDao;
import org.oni.webapp.dao.entity.News;
import org.oni.webapp.utils.PaginationBean;

/**
 * This is the interface of the News DAO.
 * 
 * @author DungTV
 *
 */
public interface NewsDao extends GenericDao<News, Integer> {

	public List<News> searchByKey(String key);

	public List<News> newsRelation(String[] keys);

	public List<News> newsSameCate(Integer cate);

	public List<News> getListNewsForPromos(PaginationBean paginationBean,
			Integer cate);
}