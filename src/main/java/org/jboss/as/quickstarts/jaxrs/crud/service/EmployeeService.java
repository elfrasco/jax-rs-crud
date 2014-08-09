package org.jboss.as.quickstarts.jaxrs.crud.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.as.quickstarts.jaxrs.crud.model.Employee;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EmployeeService {

	@GET
	List<Employee> getAll();

	@GET
	@Path("{id}")
	Employee get(@PathParam("id") Long id);

	@POST
	Response add(Employee employee);

	@PUT
	@Path("{id}")
	Response update(@PathParam("id") Long id, Employee employee);

	@DELETE
	@Path("{id}")
	Response remove(@PathParam("id") Long id);

}