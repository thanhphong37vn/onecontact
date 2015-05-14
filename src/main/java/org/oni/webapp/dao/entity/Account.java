package org.oni.webapp.dao.entity;

import java.util.Date;
import javax.persistence.*;
import org.oni.webapp.dao.entity.base.EntityBaseImpl;

/**
 * 
 * @author DungTV
 * 
 */
@Entity
@Table(name = "cms_ncs_account")
public class Account extends EntityBaseImpl<Integer> {

	private static final long serialVersionUID = -8911229883786114030L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "account_sequence")
	// @SequenceGenerator(name = "account_sequence", sequenceName =
	// "account_sequence")
	@Column(name = "id")
	private Integer id;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "role", nullable = false)
	private String role;

	@Column(name = "date_create", nullable = false)
	private Date dateCreate;

	@Column(name = "enable", nullable = false)
	private int enable;

	/**
	 * Constructor
	 */
	public Account() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the dateCreate
	 */
	public Date getDateCreate() {
		return dateCreate;
	}

	/**
	 * @param dateCreate
	 *            the dateCreate to set
	 */
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	/**
	 * @return the enable
	 */
	public int getEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *            the enable to set
	 */
	public void setEnable(int enable) {
		this.enable = enable;
	}

}
