package org.oni.webapp.authentication;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.oni.webapp.dao.entity.Account;
import org.oni.webapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * It is the user authentication provider of applications.
 * 
 * @author DungTV
 */
public class AuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {

	// @Autowired
	// private MessageAccessor messageAccessor;

	@Autowired
	private AccountService accountService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) {

		// do nothing
	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication) {

		String presentedPassword = authentication.getCredentials().toString();

		// System.out.println(username+"-"+presentedPassword);
		// Login
		LoginUserInfo loginUser = login(username, presentedPassword);
		if (loginUser == null) {
			throw new BadCredentialsException("Login ID or password is incorrect.");
			// this.messageAccessor.getMessage("login.badCredentials"));
		}

		return loginUser;
	}

	/*
	 * login process
	 */
	private LoginUserInfo login(String username, String password) {

		// Authentication failed if username is empty
		if (StringUtils.isEmpty(username)) {
			return null;
		}

		// Authentication failed if password is empty
		if (StringUtils.isEmpty(password)) {
			return null;
		}
		
		Account account = accountService.authenticate(username, password);
		if (account == null) {
			return null;
		}		

		Set<OniGrantedAuthority> grantedAuthorities = new HashSet<OniGrantedAuthority>();
		if (OniGrantedAuthority.ADMIN.name().equals(account.getRole())) {
			grantedAuthorities.add(OniGrantedAuthority.ADMIN);
		} else{
			grantedAuthorities.add(OniGrantedAuthority.USER);
		}
		

		return new LoginUserInfo(account.getId(), username, password, grantedAuthorities);
	}
}
