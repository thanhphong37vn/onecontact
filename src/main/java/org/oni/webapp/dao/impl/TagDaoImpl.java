package org.oni.webapp.dao.impl;

import java.util.List;

import org.oni.webapp.dao.TagDao;
import org.oni.webapp.dao.base.impl.GenericDaoImpl;
import org.oni.webapp.dao.entity.Tag;
import org.oni.webapp.utils.PaginationBean;
import org.springframework.stereotype.Repository;

/**
 * This is the implementation class of the Tag DAO.
 * @author DungTV
 *
 */
@Repository
public class TagDaoImpl extends GenericDaoImpl<Tag, Integer> implements TagDao{
	
	public TagDaoImpl() {
		super(Tag.class, Integer.class);
	}

	@Override
	public List<Tag> searchByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> getListTag(PaginationBean paginationBean, Integer cate) {
		// TODO Auto-generated method stub
		return null;
	}	
	
}