package org.oni.webapp.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EmployeeCompanyBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Employee
	 */
	private BigDecimal companyId;
	private BigDecimal employeeId;

	private String employeeName;
	private String employeeNo;
	private String employeePwd;
	private int employeeStatus;
	private String mobilePhone;
	private Date regDateEmp;
	private Date unregDateEmp;
	/**
	 * Company
	 */
	// private BigDecimal companyId;
	private String address;
	private String companyMobile;
	private String companyName;
	private String companyPwd;
	private int companyStatus;
	private String contactMobile;
	private String contactName;
	private String contactPhone;
	private Date regDateComp;
	private Date unregDateComp;

	/**
	 * @return the companyId
	 */
	public BigDecimal getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId
	 *            the companyId to set
	 */
	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo
	 *            the employeeNo to set
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * @return the employeePwd
	 */
	public String getEmployeePwd() {
		return employeePwd;
	}

	/**
	 * @param employeePwd
	 *            the employeePwd to set
	 */
	public void setEmployeePwd(String employeePwd) {
		this.employeePwd = employeePwd;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone
	 *            the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the regDateEmp
	 */
	public Date getRegDateEmp() {
		return regDateEmp;
	}

	/**
	 * @param regDateEmp
	 *            the regDateEmp to set
	 */
	public void setRegDateEmp(Date regDateEmp) {
		this.regDateEmp = regDateEmp;
	}

	/**
	 * @return the unregDateEmp
	 */
	public Date getUnregDateEmp() {
		return unregDateEmp;
	}

	/**
	 * @param unregDateEmp
	 *            the unregDateEmp to set
	 */
	public void setUnregDateEmp(Date unregDateEmp) {
		this.unregDateEmp = unregDateEmp;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the companyMobile
	 */
	public String getCompanyMobile() {
		return companyMobile;
	}

	/**
	 * @param companyMobile
	 *            the companyMobile to set
	 */
	public void setCompanyMobile(String companyMobile) {
		this.companyMobile = companyMobile;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the companyPwd
	 */
	public String getCompanyPwd() {
		return companyPwd;
	}

	/**
	 * @param companyPwd
	 *            the companyPwd to set
	 */
	public void setCompanyPwd(String companyPwd) {
		this.companyPwd = companyPwd;
	}

	/**
	 * @return the contactMobile
	 */
	public String getContactMobile() {
		return contactMobile;
	}

	/**
	 * @param contactMobile
	 *            the contactMobile to set
	 */
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	/**
	 * @return the employeeStatus
	 */
	public int getEmployeeStatus() {
		return employeeStatus;
	}

	/**
	 * @param employeeStatus
	 *            the employeeStatus to set
	 */
	public void setEmployeeStatus(int employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	/**
	 * @return the companyStatus
	 */
	public int getCompanyStatus() {
		return companyStatus;
	}

	/**
	 * @param companyStatus
	 *            the companyStatus to set
	 */
	public void setCompanyStatus(int companyStatus) {
		this.companyStatus = companyStatus;
	}

	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @param contactName
	 *            the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * @return the contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * @param contactPhone
	 *            the contactPhone to set
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * @return the regDateComp
	 */
	public Date getRegDateComp() {
		return regDateComp;
	}

	/**
	 * @param regDateComp
	 *            the regDateComp to set
	 */
	public void setRegDateComp(Date regDateComp) {
		this.regDateComp = regDateComp;
	}

	/**
	 * @return the unregDateComp
	 */
	public Date getUnregDateComp() {
		return unregDateComp;
	}

	/**
	 * @param unregDateComp
	 *            the unregDateComp to set
	 */
	public void setUnregDateComp(Date unregDateComp) {
		this.unregDateComp = unregDateComp;
	}

	/**
	 * @return the employeeId
	 */
	public BigDecimal getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(BigDecimal employeeId) {
		this.employeeId = employeeId;
	}
}
