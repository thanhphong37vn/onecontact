package org.oni.webapp.form;

import java.util.Date;

import javax.validation.constraints.Size;



/**
 * This is a form of Account screen.
 * @author DungTV
 */
public class AccountForm extends AbstractForm{
		
	
	/** Account ID */
    private Integer id;
    
    
	/** firs name */
//	@Size(min=3, max=30)
    private String username;
	
    /** last name */
//	@Size(min=3, max=30)
    private String password;
	
	private	String role;
	
	private Date dateCreate;
	
	private int enable;
	
	private boolean active;
    /**
     * Constructor
     */
    public AccountForm() {        
//    	super("firstName");
    	clear();
    }	


	/**
	 * clear all values
	 */
	public void clear() {
		this.id = -1;
		this.username = "";
		this.password = "";
		this.dateCreate = null;
		this.role = "";
		this.active= true;
		this.enable = 1;
		setCommand("");
		
	}


	public Integer getId() {
		return id;
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
	 * @param username the username to set
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
	 * @param password the password to set
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
	 * @param role the role to set
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
	 * @param dateCreate the dateCreate to set
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
	 * @param enable the enable to set
	 */
	public void setEnable(int enable) {
		this.enable = enable;
	}


	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}


	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

    
}
