package myProject.services;

import myProject.entities.ProjectEntity;
import myProject.entities.Resources_planEntity;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface Resources_planService {
    ProjectEntity findByProjectId(long id);
    List<Resources_planEntity> findAll();
    List<Resources_planEntity> findByProjectName(String name);
    List<Resources_planEntity> findByPositionName(String name);
    List<Resources_planEntity> findByProjectNameAndPositionName(String proName, String posName);
    Resources_planEntity save(Resources_planEntity plan);
    List<Resources_planEntity> findById(long id);
    void delete(long id);
}
