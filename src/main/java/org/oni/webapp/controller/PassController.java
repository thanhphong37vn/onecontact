package org.oni.webapp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.oni.webapp.bean.EmployeeCompanyBean;
import org.oni.webapp.components.FileUploadHelper;
import org.oni.webapp.components.HttpSessionAccessor;
import org.oni.webapp.controller.abstracts.AbstractController;
import org.oni.webapp.dao.entity.News;
import org.oni.webapp.dto.ListDto;
import org.oni.webapp.enumeration.NewsType;
import org.oni.webapp.form.EmployeeCompanyForm;
import org.oni.webapp.form.NewsForm;
import org.oni.webapp.service.EmployeeCompanyService;
import org.oni.webapp.service.NewsService;
import org.oni.webapp.service.TagService;
import org.oni.webapp.utils.DateUtil;
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
	@Autowired
	private SessionFactory sessionFactory;

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

		// EmployeeCompanyBeanImpl beanImpl = new EmployeeCompanyBeanImpl();
		// List<EmployeeCompanyBean> list = beanImpl.getResultListAll();
		List<EmployeeCompanyBean> list = ecpService.getResultListAll();
		// List<EmployeeCompanyBean> list = beanImpl.getResultList(employeeName,
		// employeeNo, mobilePhone, companyMobile, companyName);
		int size = list.size();
		System.out.println("So luong record:" + size);
		formEcmp.setCommand("search");
		modelMap.addAttribute("listDto", list);
		System.out.println("Redirect sang pass Page");
		return "admin/Pass";

	}

	@SuppressWarnings("deprecation")
	public List<EmployeeCompanyBean> getResultListAll() {
		Session session = sessionFactory.openSession();
		Connection connection = session.connection();

		List<EmployeeCompanyBean> list = new ArrayList<EmployeeCompanyBean>();
		PreparedStatement prpStm = null;
		ResultSet rs = null;
		StringBuilder qBuilder = new StringBuilder();
		try {
			System.out.println("Trang thai dong connection : "
					+ connection.isClosed());
			qBuilder.append("select * from TAB_XN_EMPLOYEE E inner join TAB_XN_COMPANY C on C.COMPANY_ID= E.COMPANY_ID");
			// TODO Auto-generated method stub
			prpStm = connection.prepareStatement(qBuilder.toString());
			System.out.println(qBuilder.toString());

			rs = prpStm.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					EmployeeCompanyBean ecb = new EmployeeCompanyBean();
					// private String employeeName;
					ecb.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
					// private String setEmployeeNo;
					ecb.setEmployeeNo(rs.getString("EMPLOYEE_NO"));
					// private String setEmployeePwd;
					ecb.setEmployeePwd(rs.getString("EMPLOYEE_PWD"));
					// private int employeeStatus;
					ecb.setEmployeeStatus(Integer.parseInt(rs
							.getLong("EMPLOYEE_STATUS") + ""));
					// private String mobilePhone;
					ecb.setMobilePhone(rs.getString("MOBILE_PHONE"));
					// private Date setRegDateEmp;
					// 2014-11-18
					// System.out.println("employee" + rs.getDate("REG_DATE"));
					if (rs.getDate("REG_DATE") != null) {
						ecb.setRegDateEmp(DateUtil.convertStringToDate(rs
								.getDate("REG_DATE").toString()));
					}
					// private Date setUnregDateEmp;
					if (rs.getDate("UNREG_DATE") != null) {
						ecb.setUnregDateEmp(DateUtil.convertStringToDate(rs
								.getDate("UNREG_DATE").toString()));
					}

					// /**
					// * Company
					// */

					// private BigDecimal companyId;
					ecb.setAddress(rs.getString("ADDRESS"));
					// private String setAddress;
					ecb.setCompanyName(rs.getString("COMPANY_NAME"));
					// private String setCompanyMobile;
					ecb.setCompanyMobile(rs.getString("COMPANY_MOBILE"));
					// private String setCompanyName;
					ecb.setCompanyName(rs.getString("COMPANY_NAME"));
					// private String setCompanyPwd;
					ecb.setCompanyPwd(rs.getString("COMPANY_PWD"));
					// private int setCompanyStatus;
					ecb.setEmployeeStatus(Integer.parseInt(rs
							.getLong("COMPANY_STATUS") + ""));
					// private String setContactMobile;
					ecb.setContactMobile(rs.getString("CONTACT_MOBILE"));
					// private String setContactName;
					ecb.setContactName(rs.getString("CONTACT_NAME"));
					// private String setContactPhone;
					ecb.setContactPhone(rs.getString("CONTACT_PHONE"));
					// private Date setRegDateComp;
					if (rs.getDate("REG_DATE") != null) {
						ecb.setRegDateComp(DateUtil.convertStringToDate(rs
								.getDate("REG_DATE").toString()));
					}
					// private Date setUnregDateComp;
					if (rs.getDate("UNREG_DATE") != null) {
						ecb.setUnregDateComp(DateUtil.convertStringToDate(rs
								.getDate("UNREG_DATE").toString()));
					}
					list.add(ecb);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (prpStm != null) {
					prpStm.close();
				}
				if (connection != null) {
					connection.close();
				}
				if (session != null) {
					session.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
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
