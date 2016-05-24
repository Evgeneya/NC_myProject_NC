package myProject.repository;

import myProject.entities.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
    List<ProjectEntity> findByName(String name);
    List<ProjectEntity> findByEndDateBetween(Date date1, Date date2);
    List<ProjectEntity> findByCustomer(long customer_id);

}
