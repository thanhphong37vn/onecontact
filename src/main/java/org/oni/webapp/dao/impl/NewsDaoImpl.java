package org.oni.webapp.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.oni.webapp.constants.Constants;
import org.oni.webapp.dao.NewsDao;
import org.oni.webapp.dao.base.impl.GenericDaoImpl;
import org.oni.webapp.dao.entity.News;
import org.oni.webapp.enumeration.NewsType;
import org.oni.webapp.utils.PaginationBean;
import org.springframework.stereotype.Repository;

/**
 * This is the implementation class of the News DAO.
 * 
 * @author DungTV
 * 
 */
@Repository
public class NewsDaoImpl extends GenericDaoImpl<News, Integer> implements
		NewsDao {

	public NewsDaoImpl() {
		super(News.class, Integer.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<News> searchByKey(String key) {
		Criteria c = createCriteria().add(
				Restrictions.like("tags", "%" + key + "%")).addOrder(
				Order.desc("lastUpdate"));
		List<News> list = c.list();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<News> newsRelation(String[] keys) {
		Session s = getCurrentSession();
		String strQuery = "SELECT * FROM cms_ncs_news WHERE ";
		int index = keys.length;
		for (int i = 0; i < index; i++) {
			if ((i + 1) == index) {
				strQuery += "tags LIKE '%" + keys[i] + "%' ";
			} else {
				strQuery += "tags LIKE '%" + keys[i] + "%' OR ";
			}
		}
		strQuery += " ORDER BY last_update LIMIT "
				+ Constants.MAX_RECORED_RELATION;
		Query query = s.createSQLQuery(strQuery).addEntity(News.class);
		List<News> listReturn = query.list();
		return listReturn;

		// Criteria c = createCriteria();
		// Disjunction disjunction = Restrictions.disjunction();
		// Restrictions restrictions = null;
		// for (int i = 0; i < keys.length; i++) {
		// disjunction.add(Restrictions.like("tags", "%" + keys[i] + "%"));
		// }
		// c.add(disjunction);
		// c.addOrder(Order.desc("lastUpdate"));
		// c.setMaxResults(Constants.MAX_RECORED_RELATION);
		// List<News> list = c.list();
		// return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<News> newsSameCate(Integer cate) {
		Session session = getOpenSession();
		List<News> list = null;
		try {

			Criteria c = session.createCriteria(News.class)
					.add(Restrictions.eq("category", cate))
					.addOrder(Order.desc("lastUpdate"))
					.setMaxResults(Constants.MAX_RECORED_RELATION);

			list = c.list();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<News> getListNewsForPromos(PaginationBean paginationBean,
			Integer cate) {

		Criteria criteria = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select count(*) from News where ");
		sb.append("category = ").append(cate);
		String sQuery = sb.toString();
		System.out.println("getListNewsForPromos : " + sQuery);

		Query query = getCurrentSession().createQuery(sQuery);
		Iterator count = query.iterate();

		Long totalRecords = (Long) count.next();
		System.out.println("So ban ghi : " + totalRecords);

		Integer totalR = Integer.valueOf(totalRecords.toString());
		paginationBean.setTotalRecords(totalR);
		// criteria = getOpenSession().createCriteria("from News");
		Session session = getOpenSession();
		List<News> listReturn = null;
		try {
			criteria = session.createCriteria(News.class);
			criteria.add(Restrictions.like("category", cate));
			criteria.add(Restrictions.eq("enable", 1));
			criteria.addOrder(Order.desc("lastUpdate"));
			System.out.println(paginationBean.getTotalPages());
			System.out.println(paginationBean.getStartIndex());
			// criteria.setFirstResult(paginationBean.getStartIndex());
			System.out.println(paginationBean.getPageSize());
			// criteria.setMaxResults(paginationBean.getPageSize());
			listReturn = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception

		} finally {
			session.close();
		}
		System.out.println("Size  : " + listReturn.size());
		return listReturn;

	}

	public static void main(String[] args) {
		NewsDaoImpl newsDaoImplImpl = new NewsDaoImpl();
		List<News> newsForPromos = newsDaoImplImpl.getListNewsForPromos(
				new PaginationBean(2),
				Integer.valueOf(NewsType.PROMOS.getValue()));
		// List<News> newsForPromos = newsDaoImplImpl.getListNewsForPromos(
		// new PaginationBean(2), 0);

		if (newsForPromos.size() > 0) {

			for (News news : newsForPromos) {
				System.out.println(news.toString());
			}
		}
		System.out.println();

	}
}