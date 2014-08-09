package org.jboss.as.quickstarts.jaxrs.crud.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Produces;

import org.jboss.as.quickstarts.jaxrs.crud.model.Employee;
import org.jboss.as.quickstarts.jaxrs.crud.model.Money;
import org.jboss.as.quickstarts.jaxrs.crud.model.Payslip;

/**
 * 
 * @author Adrian M. Paredes
 *
 */
public class EmployeeMockBuilder {
	
	@Produces
	public Map<Long, Employee> createEmployeesMock() {
		Map<Long,Employee> employees = new HashMap<Long, Employee>();
		employees.put(1L, createGavinKing());
		employees.put(2L, createPeterMuir());
		employees.put(3L, createArunGrupta());
		return employees;
	}

	public Employee createGavinKing() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("Gavin");
		employee.setLastName("King");
		employee.setFileNumber(666L);
		employee.setPayslips(getPayslipsOfGavinKing());
		return employee;
	}

	public Employee createPeterMuir() {
		Employee employee = new Employee();
		employee.setId(2L);
		employee.setName("Peter");
		employee.setLastName("Muir");
		employee.setFileNumber(299L);
		employee.setPayslips(getPayslipsOfPeterMuir());
		return employee;
	}

	public Employee createArunGrupta() {
		Employee employee = new Employee();
		employee.setId(3L);
		employee.setName("Arun");
		employee.setLastName("Grupta");
		employee.setFileNumber(156L);
		employee.setPayslips(getPayslipsOfArunGrupta());
		return employee;
	}
	
	private List<Payslip> getPayslipsOfGavinKing() {
		return Arrays.asList(
				createPayslip(1L, 2014, Calendar.JANUARY, 1, "2500000 USD"),
				createPayslip(2L, 2014, Calendar.FEBRUARY, 1, "2500000 USD"),
				createPayslip(3L, 2014, Calendar.MARCH, 1, "2500000 USD"),
				createPayslip(4L, 2014, Calendar.APRIL, 1, "5000000 USD"),
				createPayslip(5L, 2014, Calendar.MARCH, 1, "5000000 USD"),
				createPayslip(6L, 2014, Calendar.JUNE, 1, "7500000 USD"));
	}

	private List<Payslip> getPayslipsOfPeterMuir() {
		return Arrays.asList(
				createPayslip(7L, 2014, Calendar.JANUARY, 1, "1500000 USD"),
				createPayslip(8L, 2014, Calendar.FEBRUARY, 5, "1500000 USD"),
				createPayslip(9L, 2014, Calendar.MARCH, 1, "2000000 USD"),
				createPayslip(10L, 2014, Calendar.APRIL, 9, "2000000 USD"),
				createPayslip(11L, 2014, Calendar.MARCH, 1, "2000000 USD"),
				createPayslip(12L, 2014, Calendar.JUNE, 1, "5000000 USD"));
	}

	private List<Payslip> getPayslipsOfArunGrupta() {
		return Arrays.asList(
				createPayslip(13L, 2014, Calendar.JANUARY, 1, "13500000 USD"),
				createPayslip(14L, 2014, Calendar.APRIL, 5, "13500000 USD"),
				createPayslip(15L, 2014, Calendar.JUNE, 1, "50000000 USD"));
	}
	
	private Payslip createPayslip(Long id, int payYear, int payMonth, int payDay, String pay) {
		Payslip payslip = new Payslip();
		payslip.setId(id);
		payslip.setPayMonth(payMonth);
		payslip.setPayDate(new GregorianCalendar(payYear, payMonth, payDay).getTime());
		payslip.setPay(new Money(pay));
		return payslip;
	}
	
}
