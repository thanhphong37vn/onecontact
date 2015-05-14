package org.oni.webapp.form;

import java.util.Date;


/**
 * This is a form of News screen.
 * @author DungTV
 */
public class MessageForm extends AbstractForm{
		
	
	/** News ID */
    private Integer id;
        
	private String name;
	
	private String email;
	
	private String content;
	
	private boolean read;
	
	private Date dateCreate;
	
    /**
     * Constructor
     */
    public MessageForm() {      
    	clear();
    }	


	/**
	 * clear all values
	 */
	public void clear() {
		this.id = -1;		
		setCommand("");
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}


	/**
	 * @return the read
	 */
	public boolean isRead() {
		return read;
	}


	/**
	 * @param read the read to set
	 */
	public void setRead(boolean read) {
		this.read = read;
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

	
	
    
}
