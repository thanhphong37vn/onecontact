package org.oni.webapp.dao;

import java.util.List;

import org.oni.webapp.dao.base.GenericDao;
import org.oni.webapp.dao.entity.Account;
import org.oni.webapp.utils.PaginationBean;

/**
 * This is the interface of the Account DAO.
 * 
 * @author DungTV
 *
 */
public interface AccountDao extends GenericDao<Account, Integer> {
	public List<Account> searchByKey(String key);

	public List<Account> getListAccount(PaginationBean paginationBean,
			Integer cate);
}