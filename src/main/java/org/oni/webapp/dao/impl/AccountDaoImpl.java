package org.oni.webapp.dao.impl;

import java.util.List;

import org.oni.webapp.dao.AccountDao;
import org.oni.webapp.dao.base.impl.GenericDaoImpl;
import org.oni.webapp.dao.entity.Account;
import org.oni.webapp.utils.PaginationBean;
import org.springframework.stereotype.Repository;

/**
 * This is the implementation class of the Account DAO.
 * 
 * @author DungTV
 *
 */
@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account, Integer> implements
		AccountDao {

	public AccountDaoImpl() {
		super(Account.class, Integer.class);
	}

	@Override
	public List<Account> searchByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getListAccount(PaginationBean paginationBean,
			Integer cate) {
		// TODO Auto-generated method stub
		return null;
	}

}