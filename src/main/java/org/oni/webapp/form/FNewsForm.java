package org.oni.webapp.form;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * This is a form of News screen.
 * 
 * @author DungTV
 */
public class FNewsForm extends AbstractForm {

	/** News ID */
	private Integer id;

	/**
	 * TODO: about validation use javax.validation.constraints.* for validate
	 * example: with String (4->12character) use @Size(min=4, max=120),edit
	 * message source and use <form:errors> on JSP file
	 */

	/** firs name */
	// @Size(min=3, max=30)
	private String title;

	/** last name */
	// @Size(min=3, max=30)
	private String intro;

	private MultipartFile thumbnailFile;

	private String thumbnail;

	/** last name */
	// @Size(min=3, max=30)
	private String content;

	private Date lastUpdate;
	private String tags;
	private Integer category;

	/**
	 * Constructor
	 */
	public FNewsForm() {
		// super("firstName");
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
		this.lastUpdate = null;
		this.setCategory(null);
		this.setTags("");
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
	 * @param title
	 *            the title to set
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
	 * @param intro
	 *            the intro to set
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
	 * @param thumbnailFile
	 *            the thumbnailFile to set
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
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate
	 *            the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getCategory() {
		return category;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTags() {
		return tags;
	}

}
