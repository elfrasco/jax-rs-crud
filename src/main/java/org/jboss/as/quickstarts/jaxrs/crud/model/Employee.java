package org.jboss.as.quickstarts.jaxrs.crud.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Adrian M. Paredes
 *
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = 7508514925096459529L;
	
	private Long id;
	private String name;
	private String middleName;
	private String lastName;
	private Long fileNumber;
	private List<Payslip> payslips;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Long getFileNumber() {
		return fileNumber;
	}
	
	public void setFileNumber(Long fileNumber) {
		this.fileNumber = fileNumber;
	}
	
	public List<Payslip> getPayslips() {
		return payslips;
	}
	
	public void setPayslips(List<Payslip> payslips) {
		this.payslips = payslips;
	}
	
	public void addPayslip(Payslip payslip) {
		if (payslips == null) {
			payslips = new ArrayList<Payslip>();
		}
		payslips.add(payslip);
	}
}
