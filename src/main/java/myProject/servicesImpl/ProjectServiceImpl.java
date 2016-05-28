package myProject.servicesImpl;

import myProject.entities.ProjectEntity;
import myProject.repository.ProjectRepository;
import myProject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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

    public List<ProjectEntity> findByName(String name){
        return projectRepository.findByName(name);
    }

    public List<ProjectEntity> findByEndDateBetween(Date date1, Date date2){
        return projectRepository.findByEndDateBetween(date1, date2);
    }

    public List<ProjectEntity> findByCustomer(long customer_id){
        return projectRepository.findByCustomerId(customer_id);
    }

    @Override
    public List<ProjectEntity> findByNameAndCustomer(String name, long customer_id) {
        return projectRepository.findByNameAndCustomerId(name, customer_id);
    }

    @Override
    public List<ProjectEntity> findByNameAndEndDateBetween(String name, Date date1, Date date2) {
        return projectRepository.findByNameAndEndDateBetween(name, date1, date2);
    }

    @Override
    public List<ProjectEntity> findByCustomerAndEndDateBetween(long customer_id, Date date1, Date date2) {
        return projectRepository.findByCustomerIdAndEndDateBetween(customer_id, date1, date2);
    }

    @Override
    public List<ProjectEntity> findByNameAndCustomerAndEndDateBetween(String name, long customer_id, Date date1, Date date2) {
        return projectRepository.findByNameAndCustomerIdAndEndDateBetween(name, customer_id, date1, date2);
    }

    public List<ProjectEntity> findById(long id){
        return projectRepository.findById(id);
    }
}
