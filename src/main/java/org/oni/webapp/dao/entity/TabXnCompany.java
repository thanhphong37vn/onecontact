package org.oni.webapp.dao.entity;

import javax.persistence.*;
import org.oni.webapp.dao.entity.base.EntityBaseImpl;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the TAB_XN_COMPANY database table.
 * 
 */
@Entity
@Table(name = "TAB_XN_COMPANY")
@NamedQuery(name = "TabXnCompany.findAll", query = "SELECT t FROM TabXnCompany t")
public class TabXnCompany extends EntityBaseImpl<TabXnCompanyKey> {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TabXnCompanyKey id;

	/**
	 * @return the id
	 */
	public TabXnCompanyKey getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(TabXnCompanyKey id) {
		this.id = id;
	}


	@Column(name = "ACCEPT_TYPE")
	private BigDecimal acceptType;

	@Column(name = "ADC_ID")
	private String adcId;

	@Column(name = "ADC_OPERATION")
	private BigDecimal adcOperation;

	@Column(name = "ADC_REMARK")
	private String adcRemark;

	private String address;

	@Column(name = "ADMIN_ID")
	private BigDecimal adminId;

	@Column(name = "ALARM_BALANCE")
	private BigDecimal alarmBalance;

	@Column(name = "BAK_FIELD1")
	private String bakField1;

	@Column(name = "BAK_FIELD2")
	private String bakField2;

	@Column(name = "BAK_FIELD3")
	private String bakField3;

	private BigDecimal balance;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "BANK_NO")
	private String bankNo;

	@Column(name = "BOSS_ID")
	private String bossId;

	@Column(name = "BOSS_OPERATION")
	private BigDecimal bossOperation;

	@Column(name = "BTRADE_ID")
	private BigDecimal btradeId;

	@Column(name = "CERTIFICATION_NO")
	private String certificationNo;

	@Column(name = "CITY_ID")
	private BigDecimal cityId;

	// @Column(name="COMPANY_ID")
	// private BigDecimal companyId;

	@Column(name = "COMPANY_MOBILE")
	private String companyMobile;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "COMPANY_PROPERTY")
	private String companyProperty;

	@Column(name = "COMPANY_PWD")
	private String companyPwd;

	@Column(name = "COMPANY_STATUS")
	private BigDecimal companyStatus;

	@Column(name = "CONTACT_MOBILE")
	private String contactMobile;

	@Column(name = "CONTACT_NAME")
	private String contactName;

	@Column(name = "CONTACT_PHONE")
	private String contactPhone;

	private String coverage;

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECT_DATE")
	private Date effectDate;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXP_DATE")
	private Date expDate;

	@Column(name = "EXT_LANGUAGE")
	private String extLanguage;

	private String fax;

	@Column(name = "FEE_TYPE")
	private String feeType;

	@Column(name = "INTERNATION_CALL")
	private BigDecimal internationCall;

	@Column(name = "IS_ISUP")
	private BigDecimal isIsup;

	private BigDecimal iseds;

	@Column(name = "LIMIT_TYPE")
	private BigDecimal limitType;

	@Column(name = "OLD_CITY")
	private String oldCity;

	private BigDecimal overdraft;

	@Temporal(TemporalType.DATE)
	@Column(name = "PAUSE_DATE")
	private Date pauseDate;

	@Column(name = "PAY_FEE")
	private BigDecimal payFee;

	@Column(name = "PAY_TYPE")
	private BigDecimal payType;

	@Column(name = "PCM_FILE")
	private String pcmFile;

	private String phone;

	@Column(name = "POST_ADDRESS")
	private String postAddress;

	private String principal;

	@Column(name = "PRINCIPAL_PHONE")
	private String principalPhone;

	@Temporal(TemporalType.DATE)
	@Column(name = "REG_DATE")
	private Date regDate;

	private String remark;

	@Column(name = "SEC_NAME")
	private String secName;

	@Column(name = "SERVICE_ID")
	private String serviceId;

	@Column(name = "SRTBOSS_ID")
	private String srtbossId;

	@Column(name = "STRADE_ID")
	private BigDecimal stradeId;

	@Temporal(TemporalType.DATE)
	@Column(name = "UNREG_DATE")
	private Date unregDate;

	@Column(name = "VOX_NAME")
	private String voxName;

	@Column(name = "VOX_STATUS")
	private BigDecimal voxStatus;

	@Column(name = "VOX_TEXT")
	private String voxText;

	@Column(name = "WAV_FILE")
	private String wavFile;

	private String zipcode;

	public TabXnCompany() {
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

	public String getAdcRemark() {
		return this.adcRemark;
	}

	public void setAdcRemark(String adcRemark) {
		this.adcRemark = adcRemark;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getAdminId() {
		return this.adminId;
	}

	public void setAdminId(BigDecimal adminId) {
		this.adminId = adminId;
	}

	public BigDecimal getAlarmBalance() {
		return this.alarmBalance;
	}

	public void setAlarmBalance(BigDecimal alarmBalance) {
		this.alarmBalance = alarmBalance;
	}

	public String getBakField1() {
		return this.bakField1;
	}

	public void setBakField1(String bakField1) {
		this.bakField1 = bakField1;
	}

	public String getBakField2() {
		return this.bakField2;
	}

	public void setBakField2(String bakField2) {
		this.bakField2 = bakField2;
	}

	public String getBakField3() {
		return this.bakField3;
	}

	public void setBakField3(String bakField3) {
		this.bakField3 = bakField3;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNo() {
		return this.bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
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

	public BigDecimal getBtradeId() {
		return this.btradeId;
	}

	public void setBtradeId(BigDecimal btradeId) {
		this.btradeId = btradeId;
	}

	public String getCertificationNo() {
		return this.certificationNo;
	}

	public void setCertificationNo(String certificationNo) {
		this.certificationNo = certificationNo;
	}

	public BigDecimal getCityId() {
		return this.cityId;
	}

	public void setCityId(BigDecimal cityId) {
		this.cityId = cityId;
	}

	// public BigDecimal getCompanyId() {
	// return this.companyId;
	// }
	//
	// public void setCompanyId(BigDecimal companyId) {
	// this.companyId = companyId;
	// }

	public String getCompanyMobile() {
		return this.companyMobile;
	}

	public void setCompanyMobile(String companyMobile) {
		this.companyMobile = companyMobile;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyProperty() {
		return this.companyProperty;
	}

	public void setCompanyProperty(String companyProperty) {
		this.companyProperty = companyProperty;
	}

	public String getCompanyPwd() {
		return this.companyPwd;
	}

	public void setCompanyPwd(String companyPwd) {
		this.companyPwd = companyPwd;
	}

	public BigDecimal getCompanyStatus() {
		return this.companyStatus;
	}

	public void setCompanyStatus(BigDecimal companyStatus) {
		this.companyStatus = companyStatus;
	}

	public String getContactMobile() {
		return this.contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getCoverage() {
		return this.coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
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

	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getExtLanguage() {
		return this.extLanguage;
	}

	public void setExtLanguage(String extLanguage) {
		this.extLanguage = extLanguage;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFeeType() {
		return this.feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public BigDecimal getInternationCall() {
		return this.internationCall;
	}

	public void setInternationCall(BigDecimal internationCall) {
		this.internationCall = internationCall;
	}

	public BigDecimal getIsIsup() {
		return this.isIsup;
	}

	public void setIsIsup(BigDecimal isIsup) {
		this.isIsup = isIsup;
	}

	public BigDecimal getIseds() {
		return this.iseds;
	}

	public void setIseds(BigDecimal iseds) {
		this.iseds = iseds;
	}

	public BigDecimal getLimitType() {
		return this.limitType;
	}

	public void setLimitType(BigDecimal limitType) {
		this.limitType = limitType;
	}

	public String getOldCity() {
		return this.oldCity;
	}

	public void setOldCity(String oldCity) {
		this.oldCity = oldCity;
	}

	public BigDecimal getOverdraft() {
		return this.overdraft;
	}

	public void setOverdraft(BigDecimal overdraft) {
		this.overdraft = overdraft;
	}

	public Date getPauseDate() {
		return this.pauseDate;
	}

	public void setPauseDate(Date pauseDate) {
		this.pauseDate = pauseDate;
	}

	public BigDecimal getPayFee() {
		return this.payFee;
	}

	public void setPayFee(BigDecimal payFee) {
		this.payFee = payFee;
	}

	public BigDecimal getPayType() {
		return this.payType;
	}

	public void setPayType(BigDecimal payType) {
		this.payType = payType;
	}

	public String getPcmFile() {
		return this.pcmFile;
	}

	public void setPcmFile(String pcmFile) {
		this.pcmFile = pcmFile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostAddress() {
		return this.postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPrincipalPhone() {
		return this.principalPhone;
	}

	public void setPrincipalPhone(String principalPhone) {
		this.principalPhone = principalPhone;
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

	public String getSecName() {
		return this.secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
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

	public BigDecimal getStradeId() {
		return this.stradeId;
	}

	public void setStradeId(BigDecimal stradeId) {
		this.stradeId = stradeId;
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

	public BigDecimal getVoxStatus() {
		return this.voxStatus;
	}

	public void setVoxStatus(BigDecimal voxStatus) {
		this.voxStatus = voxStatus;
	}

	public String getVoxText() {
		return this.voxText;
	}

	public void setVoxText(String voxText) {
		this.voxText = voxText;
	}

	public String getWavFile() {
		return this.wavFile;
	}

	public void setWavFile(String wavFile) {
		this.wavFile = wavFile;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}