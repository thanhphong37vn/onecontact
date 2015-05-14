package org.oni.webapp.service;

import java.util.List;

import org.oni.webapp.dao.entity.News;
import org.oni.webapp.enumeration.NewsType;
import org.oni.webapp.utils.PaginationBean;

/**
 * This is an interface of service that manages the News.
 * 
 * @author DungTV
 * 
 */
public interface NewsService extends GenericService<News, Integer> {

	public List<News> getListNewsForPromos(PaginationBean paginationBean, Integer cate);

	public List<News> search(String key);
	
	public News findOneByCategory(NewsType cate);
	
	public List<News> findByCategory(NewsType cate);
	
	public List<News> newsRelation(String key);
	
	public List<News> newsSameCate(NewsType cate);

	public News createDefault(NewsType cate);
}