package myProject.services;

import myProject.entities.ProjectEntity;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface ProjectService {
    List<ProjectEntity> findAll();
    ProjectEntity save(ProjectEntity project);
    void delete(Long id);
}
