package org.oni.webapp.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.beanutils.PropertyUtils;
import org.oni.webapp.components.HttpSessionAccessor;
import org.oni.webapp.controller.abstracts.AbstractController;
import org.oni.webapp.dao.entity.Tag;
import org.oni.webapp.dto.ListDto;
import org.oni.webapp.enumeration.ResultType;
import org.oni.webapp.form.TagForm;
import org.oni.webapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is the controller of the tag management page
 * 
 * @author DungTV
 */
@Controller
@RequestMapping(value = "/admin/tag/")
public class TagManagementController extends AbstractController {

	/** View name */
	private static final String VIEW_NAME = "admin/TagManagement";

	@Autowired
	private TagService tagService;

	@Autowired
	private HttpSessionAccessor sessionAccessor;

	/**
	 * display the list tag screen.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(TagForm form, ModelMap modelMap) {

		List<Tag> list = this.tagService.getAll();
		ListDto<Tag> listDto = new ListDto<Tag>(list, list.size());
		form.setCommand("list");
		modelMap.addAttribute("listDto", listDto);
		return VIEW_NAME;
	}

	/**
	 * display the add tag screen.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(TagForm form, ModelMap modelMap) {
		form.clear();
		return edit(form, modelMap, form.getId());
	}

	/**
	 * the action insert or update tag to database
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerTag(@Valid TagForm form, BindingResult result,
			ModelMap modelMap) {
		if (result.hasErrors()) {
			return edit(form, modelMap, form.getId());
		} else {
			form.setLastUpdate(new Date());
			form.setEnable(form.isActive() ? 1 : 0);
			Tag entity = this.tagService.createEntity();
			try {
				PropertyUtils.copyProperties(entity, form);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Tag> list = tagService.getAll();
			if (list.size() > 0)
				entity.setId((Integer) (list.get(list.size() - 1).getId() + 1));
			entity.setId(10);
			System.out.println("Vao day :" + entity.getName() + " : "
					+ entity.getId());

			int id = this.tagService.registerOrUpdate(entity);
			System.out.println("RegisterTag Thanh cong");
			this.sessionAccessor.addProcessResult(ResultType.SUCCESS,
					"admin.tag.save.success", String.valueOf(id));
			return list(form, modelMap);
		}
	}

	/**
	 * the action delete tag from database.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "delete-{tagId}", method = RequestMethod.GET)
	public String delete(TagForm form, ModelMap modelMap,
			@PathVariable int tagId) {
		this.tagService.deleteByPK(tagId);
		this.sessionAccessor.addProcessResult(ResultType.SUCCESS,
				"admin.tag.delete.success", String.valueOf(tagId));
		return list(form, modelMap);
	}

	/**
	 * display the edit tag screen.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "edit-{tagId}", method = RequestMethod.GET)
	public String edit(TagForm form, ModelMap modelMap, @PathVariable int tagId) {
		form.setCommand("register");
		Tag tag = this.tagService.findByPK(tagId);
		if (tag != null) {
			try {
				PropertyUtils.copyProperties(form, tag);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thanh cong");
		return VIEW_NAME;
	}

}
