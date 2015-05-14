package org.oni.webapp.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.oni.webapp.dao.entity.base.EntityBaseImpl;
import org.oni.webapp.enumeration.NewsType;
import org.oni.webapp.exception.ErrorType;
import org.oni.webapp.exception.OniException;

/**
 * 
 * @author DungTV
 * 
 */
@Entity
@Table(name = "cms_ncs_news")
public class News extends EntityBaseImpl<Integer> {

	private static final long serialVersionUID = -6577085590489587931L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_sequence")
//	@SequenceGenerator(name = "news_sequence", sequenceName = "news_sequence")  
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "intro", nullable = false)
	private String intro;
	
	@Column(name = "thumbnail", nullable = false)
	private String thumbnail;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@Column(name = "category", nullable = false)
	private int category;
	
	@Column(name = "tags")
	private String tags;
	
	
	@Column(name = "enable", nullable = false)
	private int enable;
	
	@Column(name = "last_update", nullable = false)
	private Date lastUpdate;
	
	/**
	 * Constructor
	 */
	public News() {
	}
	
	
	public Integer getId() {
		return this.id;
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
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}


	/**
	 * @param thumbnail the thumbnail to set
	 */
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
	
	public NewsType getNewsType() {
		NewsType type = NewsType.getInstance(this.category);
        if (type == null) {
            throw new OniException(ErrorType.UNKNOW_ERROR);
        }
        return type;
    }



	

}
