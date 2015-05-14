package org.oni.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.oni.webapp.dao.entity.News;
import org.oni.webapp.dao.entity.Tag;
import org.oni.webapp.enumeration.NewsType;
import org.oni.webapp.form.FNewsForm;
import org.oni.webapp.service.NewsService;
import org.oni.webapp.service.TagService;
import org.oni.webapp.utils.PaginationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontendController {
	/** View name */
	private static final String VIEW_NAME = "frontend/Home";
	private static final String VIEW_INTRO = "frontend/Intro";
	private static final String VIEW_PROMOS = "frontend/Promos";
	private static final String VIEW_PROMOS_SEARCH = "frontend/PromosSearch";
	private static final String VIEW_PROMOS_DETAIL = "frontend/PromosDetail";
	private static final String VIEW_USER_GUIDE = "frontend/Userguide";
	private static final String VIEW_CONTRACT = "frontend/Contact";

	public PaginationBean paginationBean = new PaginationBean();

	@Autowired
	private NewsService newsService;
	@Autowired
	private TagService tagService;

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String view(ModelMap modelMap) {
		return VIEW_NAME;
	}

	@RequestMapping(value = "intro", method = RequestMethod.GET)
	public String intro(ModelMap modelMap) {
		News entity = newsService.findOneByCategory(NewsType.INTRO);
		if (entity == null) {
			entity = new News();
		}
		modelMap.addAttribute("entity", entity);
		modelMap.addAttribute("active", "id_li_2");
		modelMap.addAttribute("menu_select", "Giới thiệu");
		modelMap.addAttribute("meta_description", "Giới thiệu");
		modelMap.addAttribute("meta_keywords", "Giới thiệu");

		return VIEW_INTRO;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "promos-{page}-{typepage}", method = RequestMethod.GET)
	public String promos(ModelMap modelMap, @PathVariable int page,
			@PathVariable int typepage) {

		paginationBean.setCurrentPage(page);

		List<Tag> listTags = tagService.getAll();
		List<News> listNews = newsService.getListNewsForPromos(paginationBean,
				Integer.valueOf(NewsType.PROMOS.getValue()));
		System.out.println("Size promos: " + listNews.size());
		List<News> listNewsRelation = newsService.newsSameCate(NewsType.PROMOS);

		if (listTags == null) {
			listTags = new ArrayList<Tag>();
		} else if (listNews == null) {
			listNews = new ArrayList<News>();
		} else if (listNewsRelation == null) {
			listNewsRelation = new ArrayList<News>();
		}
		System.out.println("Size listNewsRelation: " + listNewsRelation.size());
		modelMap.addAttribute("listNewsRelation", listNewsRelation);
		modelMap.addAttribute("paginationBean", paginationBean);
		modelMap.addAttribute("listTags", listTags);
		modelMap.addAttribute("typepage", typepage);
		modelMap.addAttribute("page", page);
		System.out.println(+page);
		System.out.println("Page Promos : " + page);
		String strReturn = pagination(page);
		modelMap.addAttribute("htmlInner", strReturn);
		modelMap.addAttribute("listNews", listNews);
		modelMap.addAttribute("active", "id_li_3");
		modelMap.addAttribute("menu_select", "Khuyến mại và tin tức");
		modelMap.addAttribute("meta_description", "Khuyến mại");
		modelMap.addAttribute("meta_keywords", "Khuyến mại");
		System.out.println("Thanh cong View Promos");
		return VIEW_PROMOS;
	}

	@RequestMapping(value = "detailnews-{newsId}", method = RequestMethod.GET)
	public String detail_news(FNewsForm form, ModelMap modelMap,
			@PathVariable int newsId) {
		News entity = newsService.findByPK(newsId);
		if (entity != null) {
			try {
				PropertyUtils.copyProperties(form, entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		List<News> listNewsRelation = newsService
				.newsRelation(entity.getTags());

		List<Tag> listTags = tagService.getAll();
		modelMap.addAttribute("listTags", listTags);
		modelMap.addAttribute("listNewsRelation", listNewsRelation);

		modelMap.addAttribute("active", "id_li_3");
		modelMap.addAttribute("menu_select", "Khuyến mại và tin tức");
		modelMap.addAttribute("meta_description", "Khuyến mại");
		modelMap.addAttribute("meta_keywords", "Khuyến mại");
		modelMap.addAttribute("form", form);
		return VIEW_PROMOS_DETAIL;
	}

	@RequestMapping(value = "search-{key}", method = RequestMethod.GET)
	public String SearchPromos(ModelMap modelMap, @PathVariable int key) {
		List<Tag> listTags = tagService.getAll();
		Tag tagSearch = tagService.findByPK(key);
		String strKey = "";
		List<News> listNews = null;
		List<News> listNewsRelation = null;
		if (tagSearch != null) {
			strKey = tagSearch.getName();
			listNews = newsService.search(strKey);
			listNewsRelation = newsService.newsRelation(strKey);
		}

		if (listNews == null) {
			listNews = new ArrayList<News>();
		}
		if (listNewsRelation == null) {
			listNewsRelation = new ArrayList<News>();
		}
		modelMap.addAttribute("listNewsRelation", listNewsRelation);
		modelMap.addAttribute("listTags", listTags);
		modelMap.addAttribute("paginationBean", paginationBean);
		modelMap.addAttribute("list", listNews);
		modelMap.addAttribute("key", strKey);
		modelMap.addAttribute("active", "id_li_3");
		modelMap.addAttribute("menu_select", "Khuyến mại và tin tức");
		modelMap.addAttribute("meta_description", "Khuyến mại");
		modelMap.addAttribute("meta_keywords", "Khuyến mại");
		return VIEW_PROMOS_SEARCH;
	}

	@RequestMapping(value = "guide", method = RequestMethod.GET)
	public String guide(ModelMap modelMap) {
		News entity = newsService.findOneByCategory(NewsType.USER_GUIDE);
		if (entity == null) {
			entity = new News();
		}
		modelMap.addAttribute("entity", entity);
		modelMap.addAttribute("active", "id_li_4");
		modelMap.addAttribute("menu_select", "Hướng dẫn sử dụng");
		modelMap.addAttribute("meta_description", "Hướng dẫn");
		modelMap.addAttribute("meta_keywords", "Hướng dẫn");

		return VIEW_USER_GUIDE;
	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String contact(ModelMap modelMap) {
		News entity = newsService.findOneByCategory(NewsType.CONTACT);
		if (entity == null) {
			entity = new News();
		}
		modelMap.addAttribute("entity", entity);
		modelMap.addAttribute("active", "id_li_5");
		modelMap.addAttribute("menu_select", "Liên hệ");
		modelMap.addAttribute("meta_description", "Liên hệ");
		modelMap.addAttribute("meta_keywords", "Liên hệ");

		return VIEW_CONTRACT;
	}

	private String pagination(int page) {
		String strReturn = "";
		strReturn += "<ul class='pagination pagination-lg pagination-border'>";
		if (paginationBean.getTotalPages() <= paginationBean.numberPageOnOneScreen) {
			strReturn += getLiString(1, paginationBean.getTotalPages(), page);
		} else {
			if (paginationBean.getCurrentPage() <= paginationBean.numberPageOnOneScreen) {
				strReturn += getLiString(1,
						paginationBean.numberPageOnOneScreen, page);
				strReturn += "<li><a href='promos-"
						+ (paginationBean.numberPageOnOneScreen + 1)
						+ "-0.html' id='ctl07_ctl08_hypNext' title='»'>»</a></li>";
			} else {
				if (paginationBean.getCurrentPage() > (paginationBean
						.getTotalPages() / paginationBean.numberPageOnOneScreen)
						* paginationBean.numberPageOnOneScreen) {
					int index = (paginationBean.getTotalPages() / paginationBean.numberPageOnOneScreen)
							* paginationBean.numberPageOnOneScreen;
					strReturn += "<li><a href='promos-"
							+ (index)
							+ "-0.html' id='ctl07_ctl08_hypPrev' title='«'>«</a></li>";
					strReturn += getLiString(index + 1,
							paginationBean.getTotalPages(), page);
				} else {
					int previou = 0;
					int next = 4;
					if ((paginationBean.getCurrentPage() % paginationBean.numberPageOnOneScreen) == 0) {
						previou = (paginationBean.getCurrentPage() / paginationBean.numberPageOnOneScreen)
								* paginationBean.numberPageOnOneScreen
								- paginationBean.numberPageOnOneScreen;
						next = (paginationBean.getCurrentPage() / paginationBean.numberPageOnOneScreen)
								* paginationBean.numberPageOnOneScreen;
					} else {
						previou = (paginationBean.getCurrentPage() / paginationBean.numberPageOnOneScreen)
								* paginationBean.numberPageOnOneScreen;
						next = (paginationBean.getCurrentPage() / paginationBean.numberPageOnOneScreen)
								* paginationBean.numberPageOnOneScreen
								+ paginationBean.numberPageOnOneScreen;
					}
					strReturn += "<li><a href='promos-"
							+ (previou)
							+ "-0.html' id='ctl07_ctl08_hypPrev' title='«'>«</a></li>";
					strReturn += getLiString(previou + 1, next, page);
					strReturn += "<li><a href='promos-"
							+ (next + 1)
							+ "-0.html' id='ctl07_ctl08_hypNext' title='»'>»</a></li>";
				}
			}
		}
		strReturn += "</ul>";
		return strReturn;
	}

	private String getLiString(int begin, int index, int page) {
		String strLi = "";
		for (int i = begin; i <= index; i++) {
			if (i == page) {
				strLi += "<li class='active'><a href='promos-" + (i)
						+ "-0.html' title='" + i + "'>" + i + "</a></li>";
			} else {
				strLi += "<li class=''><a href='promos-" + (i)
						+ "-0.html' title='" + i + "'>" + i + "</a></li>";
			}
		}
		return strLi;
	}
}
