package myProject.repository;

import myProject.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 1 on 27.04.2016.
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

}
