package myProject.repository;

import myProject.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 1 on 27.04.2016.
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

}
