package org.oni.webapp.dao.entity;

import javax.persistence.*;
import org.oni.webapp.dao.entity.base.EntityBaseImpl;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the TAB_XN_EMPLOYEE database table.
 * 
 */
@Entity
@Table(name = "TAB_XN_EMPLOYEE")
@NamedQuery(name = "TabXnEmployee.findAll", query = "SELECT t FROM TabXnEmployee t")
public class TabXnEmployee extends EntityBaseImpl<TabXnEmployeeKey> {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	TabXnEmployeeKey id;

	/**
	 * @return the employeeId
	 */
	public TabXnEmployeeKey getId() {
		return id;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setId(TabXnEmployeeKey employeeId) {
		this.id = employeeId;
	}

	@Column(name = "ACCEPT_TYPE")
	private BigDecimal acceptType;

	@Column(name = "ADC_ID")
	private String adcId;

	@Column(name = "ADC_OPERATION")
	private BigDecimal adcOperation;

	@Column(name = "BOSS_EMPLOYEE_ID")
	private String bossEmployeeId;

	@Column(name = "BOSS_ID")
	private String bossId;

	@Column(name = "BOSS_OPERATION")
	private BigDecimal bossOperation;

	@Column(name = "CALL_PERMISSION")
	private BigDecimal callPermission;

	@Column(name = "COMPANY_ID")
	private BigDecimal companyId;

	private String coverage;

	@Column(name = "DEPART_ID")
	private BigDecimal departId;

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECT_DATE")
	private Date effectDate;

	private String email;

	@Column(name = "EMPLOYEE_ACTION")
	private BigDecimal employeeAction;

	@Column(name = "EMPLOYEE_BYNAME")
	private String employeeByname;

	// @Column(name="EMPLOYEE_ID")
	// private BigDecimal employeeId;

	@Column(name = "EMPLOYEE_LEVEL")
	private BigDecimal employeeLevel;

	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	@Column(name = "EMPLOYEE_NO")
	private String employeeNo;

	@Column(name = "EMPLOYEE_PERMISSION")
	private String employeePermission;

	@Column(name = "EMPLOYEE_PWD")
	private String employeePwd;

	@Column(name = "EMPLOYEE_STATUS")
	private BigDecimal employeeStatus;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXP_DATE")
	private Date expDate;

	@Column(name = "FEE_CONTROL")
	private BigDecimal feeControl;

	@Column(name = "FEE_TYPE")
	private String feeType;

	@Column(name = "FUN_PACKAGE")
	private String funPackage;

	@Column(name = "HOME_PHONE")
	private String homePhone;

	@Column(name = "MOBILE_PHONE")
	private String mobilePhone;

	@Column(name = "OFFICE_PHONE")
	private String officePhone;

	@Column(name = "ORDER_NO")
	private BigDecimal orderNo;

	@Column(name = "OTHER_PHONE")
	private String otherPhone;

	@Column(name = "PARENT_ID")
	private String parentId;

	@Temporal(TemporalType.DATE)
	@Column(name = "PAUSE_DATE")
	private Date pauseDate;

	@Column(name = "PCM_FILE")
	private String pcmFile;

	private String priority;

	@Temporal(TemporalType.DATE)
	@Column(name = "REG_DATE")
	private Date regDate;

	private String remark;

	@Column(name = "RESIST_REASON")
	private String resistReason;

	@Column(name = "SERVICE_ID")
	private String serviceId;

	@Column(name = "SRTBOSS_ID")
	private String srtbossId;

	private String title;

	@Column(name = "TITLE_ID")
	private BigDecimal titleId;

	@Temporal(TemporalType.DATE)
	@Column(name = "UNREG_DATE")
	private Date unregDate;

	@Column(name = "VOX_NAME")
	private String voxName;

	private String vpmn;

	@Column(name = "WAV_FILE")
	private String wavFile;

	public TabXnEmployee() {
	}

	public BigDecimal getAcceptType() {
		return this.acceptType;
	}

	public void setAcceptType(BigDecimal acceptType) {
		this.acceptType = acceptType;
	}

	public String getAdcId() {
		return this.adcId;
	}

	public void setAdcId(String adcId) {
		this.adcId = adcId;
	}

	public BigDecimal getAdcOperation() {
		return this.adcOperation;
	}

	public void setAdcOperation(BigDecimal adcOperation) {
		this.adcOperation = adcOperation;
	}

	public String getBossEmployeeId() {
		return this.bossEmployeeId;
	}

	public void setBossEmployeeId(String bossEmployeeId) {
		this.bossEmployeeId = bossEmployeeId;
	}

	public String getBossId() {
		return this.bossId;
	}

	public void setBossId(String bossId) {
		this.bossId = bossId;
	}

	public BigDecimal getBossOperation() {
		return this.bossOperation;
	}

	public void setBossOperation(BigDecimal bossOperation) {
		this.bossOperation = bossOperation;
	}

	public BigDecimal getCallPermission() {
		return this.callPermission;
	}

	public void setCallPermission(BigDecimal callPermission) {
		this.callPermission = callPermission;
	}

	public BigDecimal getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}

	public String getCoverage() {
		return this.coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public BigDecimal getDepartId() {
		return this.departId;
	}

	public void setDepartId(BigDecimal departId) {
		this.departId = departId;
	}

	public Date getEffectDate() {
		return this.effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getEmployeeAction() {
		return this.employeeAction;
	}

	public void setEmployeeAction(BigDecimal employeeAction) {
		this.employeeAction = employeeAction;
	}

	public String getEmployeeByname() {
		return this.employeeByname;
	}

	public void setEmployeeByname(String employeeByname) {
		this.employeeByname = employeeByname;
	}

	public BigDecimal getEmployeeLevel() {
		return this.employeeLevel;
	}

	public void setEmployeeLevel(BigDecimal employeeLevel) {
		this.employeeLevel = employeeLevel;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeNo() {
		return this.employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeePermission() {
		return this.employeePermission;
	}

	public void setEmployeePermission(String employeePermission) {
		this.employeePermission = employeePermission;
	}

	public String getEmployeePwd() {
		return this.employeePwd;
	}

	public void setEmployeePwd(String employeePwd) {
		this.employeePwd = employeePwd;
	}

	public BigDecimal getEmployeeStatus() {
		return this.employeeStatus;
	}

	public void setEmployeeStatus(BigDecimal employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public BigDecimal getFeeControl() {
		return this.feeControl;
	}

	public void setFeeControl(BigDecimal feeControl) {
		this.feeControl = feeControl;
	}

	public String getFeeType() {
		return this.feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getFunPackage() {
		return this.funPackage;
	}

	public void setFunPackage(String funPackage) {
		this.funPackage = funPackage;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public BigDecimal getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(BigDecimal orderNo) {
		this.orderNo = orderNo;
	}

	public String getOtherPhone() {
		return this.otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Date getPauseDate() {
		return this.pauseDate;
	}

	public void setPauseDate(Date pauseDate) {
		this.pauseDate = pauseDate;
	}

	public String getPcmFile() {
		return this.pcmFile;
	}

	public void setPcmFile(String pcmFile) {
		this.pcmFile = pcmFile;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResistReason() {
		return this.resistReason;
	}

	public void setResistReason(String resistReason) {
		this.resistReason = resistReason;
	}

	public String getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getSrtbossId() {
		return this.srtbossId;
	}

	public void setSrtbossId(String srtbossId) {
		this.srtbossId = srtbossId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getTitleId() {
		return this.titleId;
	}

	public void setTitleId(BigDecimal titleId) {
		this.titleId = titleId;
	}

	public Date getUnregDate() {
		return this.unregDate;
	}

	public void setUnregDate(Date unregDate) {
		this.unregDate = unregDate;
	}

	public String getVoxName() {
		return this.voxName;
	}

	public void setVoxName(String voxName) {
		this.voxName = voxName;
	}

	public String getVpmn() {
		return this.vpmn;
	}

	public void setVpmn(String vpmn) {
		this.vpmn = vpmn;
	}

	public String getWavFile() {
		return this.wavFile;
	}

	public void setWavFile(String wavFile) {
		this.wavFile = wavFile;
	}

}