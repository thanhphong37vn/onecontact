package org.oni.webapp.dao;

import java.util.List;

import org.oni.webapp.dao.base.GenericDao;
import org.oni.webapp.dao.entity.TabXnEmployee;
import org.oni.webapp.dao.entity.TabXnEmployeeKey;
import org.oni.webapp.utils.PaginationBean;

/**
 * This is the interface of the Account DAO.
 * 
 * @author Admin
 *
 */
public interface TabXnEmployeeDao extends
		GenericDao<TabXnEmployee, TabXnEmployeeKey> {
	public List<TabXnEmployee> searchByKey(String key);

	public List<TabXnEmployee> searchByCompanyKey(String key);

	public List<TabXnEmployee> searchByEmployeeName(String employeeName);

	public List<TabXnEmployee> searchByEmployeeMobile(String employeePhone);

	public List<TabXnEmployee> getListEmployee(PaginationBean paginationBean,
			Integer cate);
}