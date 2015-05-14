package org.oni.webapp.controller;

import java.util.List;

import org.oni.webapp.bean.EmployeeCompanyBean;
import org.oni.webapp.components.FileUploadHelper;
import org.oni.webapp.components.HttpSessionAccessor;
import org.oni.webapp.controller.abstracts.AbstractController;
import org.oni.webapp.dao.entity.News;
import org.oni.webapp.dao.impl.EmployeeCompanyBeanImpl;
import org.oni.webapp.dto.ListDto;
import org.oni.webapp.enumeration.NewsType;
import org.oni.webapp.form.EmployeeCompanyForm;
import org.oni.webapp.form.NewsForm;
import org.oni.webapp.service.EmployeeCompanyService;
import org.oni.webapp.service.NewsService;
import org.oni.webapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * This is the controller of the information imployees and companies
 * 
 * @author Admin
 *
 */
@Controller
@RequestMapping(value = "/admin/pass/")
public class PassController extends AbstractController {
	/** View name */
	// private static final String VIEW_NAME = "admin/pass";

	@Autowired
	private EmployeeCompanyService ecpService;

	// @Autowired
	// private HttpSessionAccessor sessionAccessor;

	/**
	 * display the list account screen.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String list(EmployeeCompanyForm formEcmp, ModelMap modelMap) {

		// String employeeName = formEcmp.getEmployeeName();
		// String employeeNo = formEcmp.getEmployeeNo();
		// String mobilePhone = formEcmp.getMobilePhone();
		// String companyMobile = formEcmp.getCompanyMobile();
		// String companyName = formEcmp.getCompanyName();

		EmployeeCompanyBeanImpl beanImpl = new EmployeeCompanyBeanImpl();
		List<EmployeeCompanyBean> list = beanImpl.getResultListAll();
		// List<EmployeeCompanyBean> list = beanImpl.getResultList(employeeName,
		// employeeNo, mobilePhone, companyMobile, companyName);
		ListDto<EmployeeCompanyBean> listDto = new ListDto<EmployeeCompanyBean>(
				list, list.size());
		formEcmp.setCommand("search");
		modelMap.addAttribute("listDto", listDto);
		return "admin/Pass";
	}

	/** View name */
	private static final String VIEW_NAME = "admin/NewsManagement";

	// private static final String SPECIAL_VIEW_NAME =
	// "admin/SpecialNewsManagement";

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
	 * @return the accountService
	 */
	// public EmployeeCompanyServiceImpl getAccountService() {
	// return ecpService;
	// }

	/**
	 * @param accountService
	 *            the accountService to set
	 */
	// public void setAccountService(EmployeeCompanyServiceImpl accountService)
	// {
	// this.ecpService = accountService;
	// }
}
