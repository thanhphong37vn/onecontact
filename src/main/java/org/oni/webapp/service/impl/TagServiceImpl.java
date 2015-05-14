package org.oni.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.oni.webapp.dao.TagDao;
import org.oni.webapp.dao.base.GenericDao;
import org.oni.webapp.dao.entity.Tag;
import org.oni.webapp.dto.TagDto;
import org.oni.webapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is an implement of service that manages the Tag. 
 * @author DungTV
 *
 */
@Service
public class TagServiceImpl extends GenericServiceImpl<Tag, Integer> implements TagService {
	
	@Autowired
	private TagDao dao;
		
	@Override
	protected GenericDao<Tag, Integer> getDao() {
		return this.dao;
	}

	@Override
	public List<TagDto> getTags(String selectedTags){
		List<String> selectedString = new ArrayList<String>();
		if (selectedTags != null && !selectedTags.isEmpty()) {
			String[] temp = selectedTags.split(",");			
			for (int i = 0; i < temp.length; i++) {
				selectedString.add(temp[i].trim());
			}
		}
		List<Tag> list = getAll();
		List<TagDto> results = new ArrayList<TagDto>();
		for (Tag tag : list) {
			boolean isSelected = false;
			if (selectedString.contains(tag.getName())) {
				isSelected = true;
			}
			results.add(new TagDto(tag.getName(), isSelected));
		}
		return results;
	}	
	
}