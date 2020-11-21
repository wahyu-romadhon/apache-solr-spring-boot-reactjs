package solrapi;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends SolrCrudRepository<Employee, Integer> {

	Employee findByName(String name);

}
