package org.oni.webapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.oni.webapp.dao.NewsDao;
import org.oni.webapp.dao.base.GenericDao;
import org.oni.webapp.dao.entity.News;
import org.oni.webapp.enumeration.NewsType;
import org.oni.webapp.service.NewsService;
import org.oni.webapp.utils.PaginationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is an implement of service that manages the News.
 * 
 * @author DungTV
 * 
 */
@Service
public class NewsServiceImpl extends GenericServiceImpl<News, Integer> implements NewsService {

	@Autowired
	private NewsDao dao;

	@Override
	protected GenericDao<News, Integer> getDao() {
		return this.dao;
	}

	public List<News> getListNewsForPromos(PaginationBean paginationBean, Integer cate) {

		return dao.getListNewsForPromos(paginationBean, cate);		
	}

	public List<News> search(String key) {
		return dao.searchByKey(key);
	}

	public News findOneByCategory(NewsType cate) {
		return dao.findOne("category", cate.getValue());
	}
	
	public List<News> findByCategory(NewsType cate) {		
		return dao.findBy("category", cate.getValue());
	}

	public List<News> newsRelation(String key) {
		if (key == null || key.isEmpty()) return new ArrayList<News>();
		String[] keys = key.split(",");
		return dao.newsRelation(keys);
	}
	public List<News> newsSameCate(NewsType cate){
		return dao.newsSameCate(cate.getValue());
	}

	@Override
	public News createDefault(NewsType cate) {
		News news = this.dao.createEntity();
		news.setTitle(cate.getContent()+" title ");
		news.setCategory(cate.getValue());
		news.setContent("");
		news.setEnable(1);
		news.setIntro("");
		news.setTags("");
		news.setThumbnail("NONE");
		news.setLastUpdate(new Date());
		news.setId(this.dao.insert(news));
		
		return news;
	}
}