/**
 * 
 */
package org.oni.webapp.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.oni.webapp.bean.EmployeeCompanyBean;
import org.oni.webapp.dao.EmployeeCompanyBeanDao;
import org.oni.webapp.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Admin
 *
 */
@Repository
public class EmployeeCompanyBeanImpl implements EmployeeCompanyBeanDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<EmployeeCompanyBean> getResultList(String employeeName,
			String employeeNo, String mobilePhone, String companyMobile,
			String companyName) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("deprecation")
		Connection connection = session.connection();
		List<EmployeeCompanyBean> list = new ArrayList<EmployeeCompanyBean>();
		PreparedStatement prpStm = null;
		ResultSet rs = null;
		StringBuilder qBuilder = new StringBuilder();
		try {
			qBuilder.append("select * from TAB_XN_EMPLOYEE E inner join TAB_XN_COMPANY C on C.COMPANY_ID= E.COMPANY_ID where ");
			// TODO Auto-generated method stub
			if (!employeeName.trim().isEmpty()) {
				qBuilder.append("and  EMPLOYEE_NAME like '%" + employeeName
						+ "%' ");
			} else if (!employeeNo.trim().isEmpty()) {
				qBuilder.append("and  EMPLOYEE_NO like '%" + employeeNo + "%' ");
			} else if (!mobilePhone.trim().isEmpty()) {
				qBuilder.append("and  MOBILE_PHONE like '%" + mobilePhone
						+ "%' ");
			} else if (!companyMobile.trim().isEmpty()) {
				qBuilder.append("and  COMPANY_MOBILE like '%" + companyMobile
						+ "%' ");
			} else if (!companyMobile.trim().isEmpty()) {
				qBuilder.append("and  COMPANY_NAME like '%" + companyMobile
						+ "%' ");
			}
			prpStm = connection.prepareStatement(qBuilder.toString());
			System.out.println(qBuilder.toString());

			rs = prpStm.executeQuery();
			if (rs == null) {
				return null;
			} else {
				while (rs.next()) {
					EmployeeCompanyBean ecb = new EmployeeCompanyBean();
					// private String employeeName;
					ecb.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
					// private String setEmployeeNo;
					ecb.setEmployeeNo(rs.getString("EMPLOYEE_NO"));
					// private String setEmployeePwd;
					ecb.setCompanyPwd(rs.getString("EMPLOYEE_PWD"));
					// private int employeeStatus;
					ecb.setEmployeeStatus(Integer.parseInt(rs
							.getLong("EMPLOYEE_STATUS") + ""));
					// private String mobilePhone;
					ecb.setMobilePhone(rs.getString("MOBILE_PHONE"));
					// private Date setRegDateEmp;
					ecb.setRegDateEmp(rs.getDate("E.REG_DATE"));
					// private Date setUnregDateEmp;
					ecb.setUnregDateEmp(rs.getDate("E.UNREG_DATE"));
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
					ecb.setRegDateComp(rs.getDate("C.REG_DATE"));
					// private Date setUnregDateComp;
					ecb.setUnregDateComp(rs.getDate("C.UNREG_DATE"));
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
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

	public static void main(String[] args) {
		EmployeeCompanyBeanImpl beanImpl = new EmployeeCompanyBeanImpl();
		List<EmployeeCompanyBean> list = beanImpl.getResultList("Hoan", "304",
				"0975", "304", "VNPGT");
		System.out.println("Size : " + (list.isEmpty() ? 0 : list.size()));
		System.out.println("Completed !");
	}

	public EmployeeCompanyBeanImpl() {
		// TODO Auto-generated constructor stub
	}
}
