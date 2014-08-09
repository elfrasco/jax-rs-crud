package org.jboss.as.quickstarts.jaxrs.crud.service;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.as.quickstarts.jaxrs.crud.model.Employee;
import org.jboss.as.quickstarts.jaxrs.crud.model.Money;
import org.jboss.as.quickstarts.jaxrs.crud.model.Payslip;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJacksonProvider;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeServiceTest {
	
	private static final Logger LOGGER = Logger.getLogger("test");
	
	private EmployeeService service;
	
	@BeforeClass
	public static void initStatic() {
		// this initialization only needs to be done once per VM
        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
	}
	
	@Before
	public void init() {
        service = ProxyFactory.create(EmployeeService.class, "http://localhost:8080/jboss-jax-rs-crud/rest/");
        Assert.assertNotNull(service);
        ResteasyProviderFactory.getInstance().addMessageBodyReader(ResteasyJacksonProvider.class);
        ResteasyProviderFactory.getInstance().addMessageBodyWriter(ResteasyJacksonProvider.class);
	}
	
	@Test
	public void getAll() {
		
		List<Employee> employees = service.getAll();
		
		Assert.assertNotNull(employees);
		Assert.assertEquals(3, employees.size());
		
		for (Employee employee : employees) {
			LOGGER.info(MessageFormat.format("Name: {0}, LastName: {1}",
					employee.getName(), employee.getLastName()));			
			for (Payslip payslip : employee.getPayslips()) {
				LOGGER.info(MessageFormat.format("MONTH: {0}, Salary: {1} {2}",
						payslip.getPayMonth(), payslip.getPay().getAmount(), payslip.getPay().getCurrency()));
			}
		}
	}
	
	@Test
	public void add() {
		
		@SuppressWarnings("unchecked")
		ClientResponse<Employee> response = (ClientResponse<Employee>) service.add(createAdrianParedes());
		
		Assert.assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
		
		Employee employee = response.getEntity(Employee.class);
		Assert.assertEquals("Adrian", employee.getName());
		
		Employee adrianParedes = service.get(4L);
		Assert.assertEquals("Adrian", adrianParedes.getName());
		Assert.assertEquals(1, adrianParedes.getPayslips().size());
		
		// Se limpia el repository para poder seguir probando
		Response resp = service.remove(4l);
		Assert.assertEquals(Status.OK.getStatusCode(), resp.getStatus());
	}
	
	private Employee createAdrianParedes() {
		Employee employee = new Employee();
		employee.setId(4L);
		employee.setName("Adrian");
		employee.setMiddleName("Marcelo");
		employee.setLastName("Paredes");
		employee.setFileNumber(981L);
		
		Payslip payslip = new Payslip();
		payslip.setId(25L);
		payslip.setPay(new Money("550000000 ARS"));
		payslip.setPayDate(new Date());
		payslip.setPayMonth(Calendar.AUGUST);
		employee.setPayslips(Arrays.asList(payslip));
		
		return employee;
	}

}
