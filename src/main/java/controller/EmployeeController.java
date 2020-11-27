package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import model.Employee;
import repository.EmployeeRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("employee")
	public Employee addEmployees(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@GetMapping("employee")
	public Iterable<Employee> getEmployees() {
		return this.employeeRepository.findAll();
	}

	@GetMapping("/employee/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name) {
		return employeeRepository.findByName(name);
	}

	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployeeId(@PathVariable(value = "id") int employeeId) {
		this.employeeRepository.deleteById(employeeId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;
	}

}
