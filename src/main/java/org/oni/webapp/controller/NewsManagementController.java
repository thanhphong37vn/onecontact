package org.oni.webapp.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.beanutils.PropertyUtils;
import org.oni.webapp.components.FileUploadHelper;
import org.oni.webapp.components.HttpSessionAccessor;
import org.oni.webapp.controller.abstracts.AbstractController;
import org.oni.webapp.dao.entity.News;
import org.oni.webapp.dto.ListDto;
import org.oni.webapp.enumeration.NewsType;
import org.oni.webapp.enumeration.ResultType;
import org.oni.webapp.exception.ErrorType;
import org.oni.webapp.exception.OniException;
import org.oni.webapp.form.NewsForm;
import org.oni.webapp.service.NewsService;
import org.oni.webapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is the controller of the news management page
 * 
 * @author DungTV
 */
@Controller
@RequestMapping(value = "/admin/news/")
public class NewsManagementController extends AbstractController {

	/** View name */
	private static final String VIEW_NAME = "admin/NewsManagement";

	private static final String SPECIAL_VIEW_NAME = "admin/SpecialNewsManagement";

	@Autowired
	private NewsService newsService;

	@Autowired
	private TagService tagService;

	@Autowired
	private HttpSessionAccessor sessionAccessor;

	@Autowired
	private FileUploadHelper fileUploadHelper;

	/**
	 * display the list news screen.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	// @RequestMapping(value = "list", params = {"page"}, method =
	// RequestMethod.GET)
	// public String list(NewsForm form, ModelMap modelMap ,@RequestParam(value
	// = "page") int page) {
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(NewsForm form, ModelMap modelMap) {

		List<News> list = this.newsService.findByCategory(NewsType.PROMOS);
		ListDto<News> listDto = new ListDto<News>(list, list.size());
		form.setCommand("list");
		modelMap.addAttribute("listDto", listDto);
		return VIEW_NAME;
	}

	/**
	 * display the add news screen.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(NewsForm form, ModelMap modelMap) {
		form.clear();
		return edit(form, modelMap, form.getId());
	}

	/**
	 * the action insert or update news to database
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerNews(@Valid NewsForm form, BindingResult result,
			ModelMap modelMap) {
		if (result.hasErrors()) {
			return edit(form, modelMap, form.getId());
		} else {
			String uploadUrl = fileUploadHelper.upload(form.getThumbnailFile());
			if (uploadUrl != null) {
				form.setThumbnail(uploadUrl);
			}
			// else form.setThumbnail(Constants.UNDEFINE_IMAGE);
			form.setLastUpdate(new Date());
			form.setEnable(form.isActive() ? 1 : 0);
			form.setCategory(NewsType.PROMOS.getValue());
			News entity = this.newsService.createEntity();
			try {
				PropertyUtils.copyProperties(entity, form);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int id = this.newsService.registerOrUpdate(entity);
			this.sessionAccessor.addProcessResult(ResultType.SUCCESS,
					"admin.news.save.success", String.valueOf(id));
			System.out.println("Thanh cong");
			return list(form, modelMap);
		}
	}

	/**
	 * the action delete news from database.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "delete-{newsId}", method = RequestMethod.GET)
	public String delete(NewsForm form, ModelMap modelMap,
			@PathVariable int newsId) {
		this.newsService.deleteByPK(newsId);
		this.sessionAccessor.addProcessResult(ResultType.SUCCESS,
				"admin.news.delete.success", String.valueOf(newsId));
		return list(form, modelMap);
	}

	/**
	 * display the edit news screen.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "edit-{newsId}", method = RequestMethod.GET)
	public String edit(NewsForm form, ModelMap modelMap,
			@PathVariable int newsId) {
		form.setCommand("register");
		News news = this.newsService.findByPK(newsId);
		if (news != null) {
			try {
				PropertyUtils.copyProperties(form, news);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		modelMap.addAttribute("tagsList", tagService.getTags(form.getTags()));
		return VIEW_NAME;
	}

	@RequestMapping(value = "intro", method = RequestMethod.GET)
	public String intro(NewsForm form, ModelMap modelMap) {

		return specialNews(form, modelMap, NewsType.INTRO);
	}

	private String specialNews(NewsForm form, ModelMap modelMap,
			NewsType newsType) {
		News news = this.newsService.findOneByCategory(newsType);
		if (news == null) {
			news = this.newsService.createDefault(newsType);
		}

		if (news != null) {
			try {
				PropertyUtils.copyProperties(form, news);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String type = "";
		switch (newsType) {
		case INTRO:
			type = "intro";
			break;
		case CONTACT:
			type = "contact";
			break;
		case USER_GUIDE:
			type = "guide";
			break;
		default:
			break;
		}
		modelMap.addAttribute("newsType", type);
		return SPECIAL_VIEW_NAME;
	}

	@RequestMapping(value = "guide", method = RequestMethod.GET)
	public String guide(NewsForm form, ModelMap modelMap) {

		return specialNews(form, modelMap, NewsType.USER_GUIDE);
	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String contact(NewsForm form, ModelMap modelMap) {

		return specialNews(form, modelMap, NewsType.CONTACT);
	}

	@RequestMapping(value = "update-special", method = RequestMethod.POST)
	public String registerSpecialNews(@Valid NewsForm form,
			BindingResult result, ModelMap modelMap) {
		NewsType type = NewsType.getInstance(form.getCategory());
		if (type == null) {
			throw new OniException(ErrorType.UNKNOW_ERROR);
		}
		if (!result.hasErrors()) {

			form.setLastUpdate(new Date());
			form.setEnable(1);
			News entity = this.newsService.createEntity();
			try {
				PropertyUtils.copyProperties(entity, form);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int id = this.newsService.registerOrUpdate(entity);
			this.sessionAccessor.addProcessResult(ResultType.SUCCESS,
					"admin.news.save.success", String.valueOf(id));
		}
		return specialNews(form, modelMap, type);
	}

}
