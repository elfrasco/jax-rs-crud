package org.jboss.as.quickstarts.jaxrs.crud.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author Adrian M. Paredes
 *
 */
public class Money implements Serializable {

	private static final long serialVersionUID = 5378187341109266059L;

	private BigDecimal amount;
	private Currency currency;

	public Money() {
	}
	
	public Money(String money) {
		String[] parts = money.split(" ");
		amount = new BigDecimal(parts[0]);
		currency = Currency.valueOf(parts[1]);
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
}
