package org.oni.webapp.form;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


/**
 * This is a form of News screen.
 * @author DungTV
 */
public class NewsForm extends AbstractForm{
		
	
	/** News ID */
    private Integer id;
    
    /**
     * TODO: about validation 
     * use javax.validation.constraints.* for validate
     * example: 
     * with String (4->12character) use  @Size(min=4, max=120),edit message source and use <form:errors> on JSP file
     */
    
	/** firs name */
//	@Size(min=3, max=30)
    private String title;

    /** last name */
//	@Size(min=3, max=30)
    private String intro;
	
	private	MultipartFile thumbnailFile;
	
	private	String thumbnail;
	
	/** last name */
//	@Size(min=3, max=30)
    private String content;
	
    private int enable;
	
	private boolean active;
	
	private Date lastUpdate;
	
	private int category;
	
	private String tags;
    /**
     * Constructor
     */
    public NewsForm() {        
//    	super("firstName");
    	clear();
    }	


	/**
	 * clear all values
	 */
	public void clear() {
		this.id = -1;
		this.title = "";
		this.intro = "";
		this.thumbnailFile = null;
		this.thumbnail = "";
		this.content = "";
		this.active = true;
		this.lastUpdate = null;
		tags="";
		setCommand("");
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the intro
	 */
	public String getIntro() {
		return intro;
	}


	/**
	 * @param intro the intro to set
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}


	/**
	 * @return the thumbnailFile
	 */
	public MultipartFile getThumbnailFile() {
		return thumbnailFile;
	}


	/**
	 * @param thumbnailFile the thumbnailFile to set
	 */
	public void setThumbnailFile(MultipartFile thumbnailFile) {
		this.thumbnailFile = thumbnailFile;
	}


	public String getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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


	/**
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}


	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}


	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}


	
	

    
}
