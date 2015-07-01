package org.oni.webapp.dao;

import java.util.List;

import org.oni.webapp.bean.EmployeeCompanyBean;

public interface EmployeeCompanyBeanDao {
	public List<EmployeeCompanyBean> getResultList(String employeeName,
			String employeeNo, String mobilePhone, String companyMobile,
			String companyName);

	public List<EmployeeCompanyBean> getResultListAll();

}
