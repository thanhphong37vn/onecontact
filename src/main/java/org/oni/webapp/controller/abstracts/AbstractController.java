package org.oni.webapp.controller.abstracts;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.oni.webapp.components.ExceptionLogger;
import org.oni.webapp.utils.DateUtil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * This is an abstract class for each controller in the application. <br>
 * You need to inherit from this class to each controller in the application.
 * 
 * @author DungTV
 */
public abstract class AbstractController {

	/**
	 * Date type the will convert the date and time that is input from the form.
	 * 
	 * @param binder
	 *            binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		DateFormat format = DateUtil.createDateFormat();
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,
				true));
	}

	/**
	 * handle the exception that occurred in the controller.
	 * 
	 * @param ex
	 *            exception
	 * @return view name
	 */
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex) {

		ExceptionLogger.log(ex, this.getClass());

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		request.setAttribute("exception", ex);

		return "Error";
	}

}
