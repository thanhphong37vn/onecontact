package org.oni.webapp.service.impl;

import java.util.List;

import org.oni.webapp.bean.EmployeeCompanyBean;
import org.oni.webapp.dao.EmployeeCompanyBeanDao;
import org.oni.webapp.service.EmployeeCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is an implement of service that manages the User account.
 * 
 * @author Admin
 *
 */
@Service
public class EmployeeCompanyServiceImpl implements EmployeeCompanyService {

	@Autowired
	private EmployeeCompanyBeanDao ecbDao;


	@Override
	public List<EmployeeCompanyBean> getResultList(String employeeName,
			String employeeNo, String mobilePhone, String companyMobile,
			String companyName) {
		return ecbDao.getResultList(employeeName, employeeNo, mobilePhone,
				companyMobile, companyName);
	}

}