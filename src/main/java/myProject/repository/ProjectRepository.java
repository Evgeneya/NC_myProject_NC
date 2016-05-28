package myProject.repository;

import myProject.entities.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
    List<ProjectEntity> findById(long id);
    List<ProjectEntity> findByName(String name);
    List<ProjectEntity> findByEndDateBetween(Date date1, Date date2);
    List<ProjectEntity> findByCustomerId(long customer_id);
    List<ProjectEntity> findByNameAndCustomerId(String name, long customer_id);
    List<ProjectEntity> findByNameAndEndDateBetween(String name, Date date1, Date date2);
    List<ProjectEntity> findByCustomerIdAndEndDateBetween(long customer_id, Date date1, Date date2);
    List<ProjectEntity> findByNameAndCustomerIdAndEndDateBetween(String name, long customer_id, Date date1, Date date2);
}
