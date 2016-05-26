package myProject.repository;

import myProject.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    List<CustomerEntity> findByName(String name);
    List<CustomerEntity> findById(long id);

}
