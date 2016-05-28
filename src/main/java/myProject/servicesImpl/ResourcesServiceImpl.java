package myProject.servicesImpl;

import myProject.entities.ProjectEntity;
import myProject.entities.Resources_planEntity;
import myProject.repository.Resources_planRepository;
import myProject.services.Resources_planService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
@Service("jpaResources_planService")
@Repository
@Transactional
public class ResourcesServiceImpl implements Resources_planService {
    @Autowired
    Resources_planRepository resources_planRepository;

    public ProjectEntity findByProjectId(long id){
        return resources_planRepository.findByProjectId(id);
    }

    public List<Resources_planEntity> findAll(){
        return (List<Resources_planEntity>) resources_planRepository.findAll();
    }

    public List<Resources_planEntity> findByProjectName(String name){
        return resources_planRepository.findByProjectName(name);
    }

    public List<Resources_planEntity> findByPositionName(String name){
        return resources_planRepository.findByPositionName(name);
    }

    public List<Resources_planEntity> findByProjectNameAndPositionName(String proName, String posName){
        return resources_planRepository.findByProjectNameAndPositionName(proName, posName);
    }

    public Resources_planEntity save(Resources_planEntity plan){
        return resources_planRepository.save(plan);
    }

    public List<Resources_planEntity> findById(long id){
        return resources_planRepository.findById(id);
    }

    public void delete(long id){
        resources_planRepository.delete(id);
        return;
    }
}
