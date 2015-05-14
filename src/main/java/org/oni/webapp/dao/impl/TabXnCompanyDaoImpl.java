package org.oni.webapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.oni.webapp.dao.TabXnCompanyDao;
import org.oni.webapp.dao.base.impl.GenericDaoImpl;
import org.oni.webapp.dao.entity.TabXnCompany;
import org.oni.webapp.dao.entity.TabXnCompanyKey;
import org.oni.webapp.dao.entity.TabXnEmployee;
import org.oni.webapp.dao.entity.TabXnEmployeeKey;
import org.oni.webapp.utils.PaginationBean;
import org.springframework.stereotype.Repository;

/**
 * This is the implementation class of the TabXnCompanyDaoImpl.
 * 
 * @author Admin
 *
 */
@Repository
public class TabXnCompanyDaoImpl extends
		GenericDaoImpl<TabXnCompany, TabXnCompanyKey> implements
		TabXnCompanyDao {

	public TabXnCompanyDaoImpl(Class<? extends TabXnCompany> entityClass,
			Class<? extends TabXnCompanyKey> pkClass) {
		super(entityClass, pkClass);
		// TODO Auto-generated constructor stub
	}

	public TabXnCompanyDaoImpl() {
		// TODO Auto-generated constructor stub
		super(TabXnCompany.class, TabXnCompanyKey.class);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnCompany> searchByKey(String key) {
		// TODO Auto-generated method stub
		Criteria criteria = createCriteria().add(
				Restrictions.like("companyId", "%" + key + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnCompany> searchByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		Criteria criteria = createCriteria().add(
				Restrictions.like("companyName", "%" + companyName + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnCompany> searchByCompanyMobile(String companyMobile) {
		// TODO Auto-generated method stub
		Criteria criteria = createCriteria().add(
				Restrictions.like("companyMobile", "%" + companyMobile + "%"));
		return criteria.list();
	}

	@Override
	public List<TabXnCompany> getListCompany(PaginationBean paginationBean,
			Integer cate) {
		// TODO Auto-generated method stub
		return null;
	}

}