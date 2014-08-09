package org.jboss.as.quickstarts.jaxrs.crud.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.as.quickstarts.jaxrs.crud.model.Employee;

/**
 * 
 * @author Adrian M. Paredes
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	private EmployeeRepository repository;
	
	@Override
	public List<Employee> getAll() {
		return repository.getAll();
	}
	
	@Override
	public Employee get(Long id) {
		return repository.get(id);
	}
	
	@Override
	public Response add(Employee employee) {
		Employee result = repository.add(employee);
		return Response.status(Status.CREATED).entity(result).build();
	}
	
	@Override
	public Response update(Long id, Employee employee) {
		Employee original = repository.get(id);
		employee.setId(original.getId());
		Employee result = repository.update(employee);
		return Response.ok(result).build();
	}
	
	@Override
	public Response remove(Long id) {
		repository.remove(id);
		return Response.ok().build();
	}
	
}
