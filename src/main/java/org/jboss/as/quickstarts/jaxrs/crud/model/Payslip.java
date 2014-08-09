package org.jboss.as.quickstarts.jaxrs.crud.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Adrian M. Paredes
 *
 */
public class Payslip implements Serializable {

	private static final long serialVersionUID = 7742469606786036746L;

	private Long id;
	private int payMonth;
	private Date payDate;
	private Money pay;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getPayMonth() {
		return payMonth;
	}
	
	public void setPayMonth(int payMonth) {
		this.payMonth = payMonth;
	}
	
	public Date getPayDate() {
		return payDate;
	}
	
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	public Money getPay() {
		return pay;
	}
	
	public void setPay(Money pay) {
		this.pay = pay;
	}
}
