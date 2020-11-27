package repository;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import model.Employee;

@Repository
public interface EmployeeRepository extends SolrCrudRepository<Employee, Integer> {

	@Query("name:*?0*")
	List<Employee> findByName(String name);

	void deleteById(int employeeId);

}
