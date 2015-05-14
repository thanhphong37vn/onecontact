package org.oni.webapp.form;

import java.util.Date;

import javax.validation.constraints.Size;


/**
 * This is a form of Tag screen.
 * @author DungTV
 */
public class TagForm extends AbstractForm{
		
	
	/** Tag ID */
    private Integer id;
    
	/** firs name */
	@Size(min=3, max=30)
    private String name;

	private int enable;
	
	private boolean active;
	
	private Date lastUpdate;
	
    /**
     * Constructor
     */
    public TagForm() {        
//    	super("firstName");
    	clear();
    }	


	/**
	 * clear all values
	 */
	public void clear() {
		this.id = -1;		
		setCommand("");
		active = true;
		
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


	/**
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}


	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

    
}
