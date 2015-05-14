package org.oni.webapp.service;

import java.util.List;

import org.oni.webapp.bean.EmployeeCompanyBean;

/**
 * This is an interface of service that manager pass User
 * 
 * @author Admin
 *
 */
public interface EmployeeCompanyService {
	public List<EmployeeCompanyBean> getResultList(String employeeName,
			String employeeNo, String mobilePhone, String companyMobile,
			String companyName);

}
