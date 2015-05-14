package org.oni.webapp.dao;

import java.util.List;

import org.oni.webapp.dao.base.GenericDao;
import org.oni.webapp.dao.entity.TabXnCompany;
import org.oni.webapp.dao.entity.TabXnCompanyKey;
import org.oni.webapp.utils.PaginationBean;

/**
 * This is the interface of the Account DAO.
 * 
 * @author DungTV
 *
 */
public interface TabXnCompanyDao extends
		GenericDao<TabXnCompany, TabXnCompanyKey> {
	public List<TabXnCompany> searchByKey(String key);

	public List<TabXnCompany> searchByCompanyName(String companyName);

	public List<TabXnCompany> searchByCompanyMobile(String companyMobile);

	public List<TabXnCompany> getListCompany(PaginationBean paginationBean,
			Integer cate);
}