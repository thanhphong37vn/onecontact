package org.oni.webapp.authentication;

import java.util.Collection;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * This is the login user information.
 * @author DungTV
 */
public class LoginUserInfo extends User {

	private static final long serialVersionUID = 2405565349037037066L;

	/** user ID */
    private long userId;

    /**
     * Constructor
     * @param userId user ID
     * @param loginId oginID
     * @param password password
     * @param authorities list authority
     */
    public LoginUserInfo(
            long userId, String loginId, String password, Collection<? extends GrantedAuthority> authorities) {

        super(loginId, password, authorities);
        this.userId = userId;
       
    }

    /**
     * get userID
     * @return userID
     */
    public long getUserId() {
        return this.userId;
    }

    /**
     * set userID
     * @param userId userID
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * get loginID
     * @return loginID
     */
    public String getLoginId() {
        return getUsername();
    }

    /**
     * is User
     * @return 
     */
    public boolean isGeneralUser() {
        return getAuthorities().contains(OniGrantedAuthority.USER);
    }

    /**
     * is Administrator
     * @return 
     */
    public boolean isAdministrator() {
        return getAuthorities().contains(OniGrantedAuthority.ADMIN);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
