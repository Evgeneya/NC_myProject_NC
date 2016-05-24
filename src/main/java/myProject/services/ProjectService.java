package myProject.services;

import myProject.entities.ProjectEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface ProjectService {
    List<ProjectEntity> findAll();
    ProjectEntity save(ProjectEntity project);
    void delete(Long id);
    List<ProjectEntity> findByName(String name);
    List<ProjectEntity> findByEndDateBetween(Date date1, Date date2);
    List<ProjectEntity> findByCustomer(long customer_id);

}
