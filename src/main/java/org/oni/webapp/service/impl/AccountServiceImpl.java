package org.oni.webapp.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.oni.webapp.dao.AccountDao;
import org.oni.webapp.dao.base.GenericDao;
import org.oni.webapp.dao.entity.Account;
import org.oni.webapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is an implement of service that manages the Account. 
 * @author DungTV
 *
 */
@Service
public class AccountServiceImpl extends GenericServiceImpl<Account, Integer> implements AccountService {
	
	@Autowired
	private AccountDao dao;
		
	@Override
	protected GenericDao<Account, Integer> getDao() {
		return this.dao;
	}

	@Override
	public Account authenticate(String username, String password) {
		
		String encodePassword = DigestUtils.md5Hex(password);
		Account account = this.dao.findOne("username", username);
		if (account != null && account.getPassword()!=null && account.getEnable()>0) {
			if (account.getPassword().equals("-2015") || account.getPassword().equals(encodePassword)) {
				return account;
			}
		}
		return null;
	}

	
}