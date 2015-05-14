package org.oni.webapp.service;

import java.util.List;

import org.oni.webapp.dao.entity.Tag;
import org.oni.webapp.dto.TagDto;

/**
 * This is an interface of service that manages the Tag. 
 * @author DungTV
 *
 */
public interface TagService extends GenericService<Tag, Integer>{

	List<TagDto> getTags(String selectedTags);
	

	
}