package myProject.servicesImpl;

import myProject.entities.ProjectEntity;
import myProject.repository.ProjectRepository;
import myProject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
@Service("jpaProjectService")
@Repository
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectEntity> findAll() {
        return (ArrayList<ProjectEntity>)projectRepository.findAll();
    }

    @Override
    public ProjectEntity save(ProjectEntity project) {
        return projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        projectRepository.delete(id);
        return;
    }
}
