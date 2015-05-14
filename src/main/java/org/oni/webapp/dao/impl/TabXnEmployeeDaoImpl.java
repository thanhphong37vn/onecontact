package org.oni.webapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.oni.webapp.dao.TabXnEmployeeDao;
import org.oni.webapp.dao.base.impl.GenericDaoImpl;
import org.oni.webapp.dao.entity.TabXnEmployee;
import org.oni.webapp.dao.entity.TabXnEmployeeKey;
import org.oni.webapp.utils.PaginationBean;
import org.springframework.stereotype.Repository;

/**
 * This is the implementation class of the TabXnEmployeeDao.
 * 
 * @author Admin
 *
 */
@Repository
public class TabXnEmployeeDaoImpl extends
		GenericDaoImpl<TabXnEmployee, TabXnEmployeeKey> implements
		TabXnEmployeeDao {

	public TabXnEmployeeDaoImpl() {
		super(TabXnEmployee.class, TabXnEmployeeKey.class);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnEmployee> searchByKey(String key) {
		Criteria criteria = createCriteria().add(
				Restrictions.like("employeeId", "%" + key + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnEmployee> searchByCompanyKey(String key) {
		Criteria criteria = createCriteria().add(
				Restrictions.like("companyId", "%" + key + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnEmployee> searchByEmployeeName(String employeeName) {
		Criteria criteria = createCriteria().add(
				Restrictions.like("employeeByname", "%" + employeeName + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabXnEmployee> searchByEmployeeMobile(String employeePhone) {
		Criteria criteria = createCriteria().add(
				Restrictions.like("mobilePhone", "%" + employeePhone + "%"));
		return criteria.list();
	}

	@Override
	public List<TabXnEmployee> getListEmployee(PaginationBean paginationBean,
			Integer cate) {
		// TODO Auto-generated method stub
		return null;
	}

}