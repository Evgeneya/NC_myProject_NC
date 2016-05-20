package myProject.repository;

import myProject.entities.EmploymentEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 1 on 27.04.2016.
 */
public interface EmploymentRepository extends CrudRepository<EmploymentEntity, Long> {

}
