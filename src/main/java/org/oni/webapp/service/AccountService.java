package org.oni.webapp.service;

import org.oni.webapp.dao.entity.Account;

/**
 * This is an interface of service that manages the Account.
 * 
 * @author DungTV
 *
 */
public interface AccountService extends GenericService<Account, Integer> {

	Account authenticate(String username, String password);

}