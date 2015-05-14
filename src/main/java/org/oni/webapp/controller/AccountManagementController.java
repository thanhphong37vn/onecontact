package org.oni.webapp.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.oni.webapp.authentication.OniGrantedAuthority;
import org.oni.webapp.components.HttpSessionAccessor;
import org.oni.webapp.controller.abstracts.AbstractController;
import org.oni.webapp.dao.entity.Account;
import org.oni.webapp.dto.ListDto;
import org.oni.webapp.enumeration.ResultType;
import org.oni.webapp.form.AccountForm;
import org.oni.webapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is the controller of the account management page
 * 
 * @author DungTV
 */
@Controller
@RequestMapping(value = "/admin/account/")
public class AccountManagementController extends AbstractController {

	/** View name */
	private static final String VIEW_NAME = "admin/AccountManagement";

	@Autowired
	private AccountService accountService;

	@Autowired
	private HttpSessionAccessor sessionAccessor;

	/**
	 * display the list account screen.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(AccountForm form, ModelMap modelMap) {

		List<Account> list = this.accountService.getAll();
		ListDto<Account> listDto = new ListDto<Account>(list, list.size());
		form.setCommand("list");
		modelMap.addAttribute("listDto", listDto);
		return VIEW_NAME;
	}

	/**
	 * display the add account screen.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(AccountForm form, ModelMap modelMap) {
		form.clear();
		form.setCommand("add");
		modelMap.addAttribute("roleList", OniGrantedAuthority.values());
		return VIEW_NAME;
	}

	/**
	 * the action insert or update account to database
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerAccount(@Valid AccountForm form,
			BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			return edit(form, modelMap, form.getId());
		} else {

			form.setDateCreate(new Date());
			form.setEnable(form.isActive() ? 1 : 0);
			String encodePassword = DigestUtils.md5Hex(form.getPassword());
			form.setPassword(encodePassword);
			Account entity = this.accountService.createEntity();
			try {
				PropertyUtils.copyProperties(entity, form);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.accountService.registerOrUpdate(entity);
			this.sessionAccessor.addProcessResult(ResultType.SUCCESS,
					"admin.account.save.success",
					String.valueOf(form.getUsername()));
			return list(form, modelMap);
		}
	}

	/**
	 * the action delete account from database.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "delete-{accountId}", method = RequestMethod.GET)
	public String delete(AccountForm form, ModelMap modelMap,
			@PathVariable int accountId) {
		this.accountService.deleteByPK(accountId);
		this.sessionAccessor.addProcessResult(ResultType.SUCCESS,
				"admin.account.delete.success", String.valueOf(accountId));
		return list(form, modelMap);
	}

	/**
	 * display the edit account screen.
	 * 
	 * @param form
	 *            form
	 * @param modelMap
	 *            Map is used to store the data to be passed to the view
	 * @return View name
	 */
	@RequestMapping(value = "edit-{accountId}", method = RequestMethod.GET)
	public String edit(AccountForm form, ModelMap modelMap,
			@PathVariable int accountId) {
		form.setCommand("edit");
		Account account = this.accountService.findByPK(accountId);
		if (account != null) {
			try {
				PropertyUtils.copyProperties(form, account);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		modelMap.addAttribute("roleList", OniGrantedAuthority.values());
		return VIEW_NAME;
	}

}
