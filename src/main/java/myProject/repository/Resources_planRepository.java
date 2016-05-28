package myProject.repository;

import myProject.entities.ProjectEntity;
import myProject.entities.Resources_planEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface Resources_planRepository extends CrudRepository<Resources_planEntity, Long> {
    ProjectEntity findByProjectId(long id);
    List<Resources_planEntity> findByProjectName(String name);
    List<Resources_planEntity> findByPositionName(String name);
    List<Resources_planEntity> findByProjectNameAndPositionName(String proName, String posName);
    List<Resources_planEntity> findById(long id);
}
