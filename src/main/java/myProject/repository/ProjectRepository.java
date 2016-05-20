package myProject.repository;

import myProject.entities.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 1 on 27.04.2016.
 */
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

}
