package org.oni.webapp.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TabXnEmployeeKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "EMPLOYEE_ID")
	private BigDecimal employeeId;

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

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}