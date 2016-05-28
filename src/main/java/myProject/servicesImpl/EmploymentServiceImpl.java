package myProject.servicesImpl;

import myProject.entities.EmployeeEntity;
import myProject.entities.EmploymentEntity;
import myProject.repository.EmploymentRepository;
import myProject.services.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
@Service("jpaEmploymentService")
@Repository
@Transactional
public class EmploymentServiceImpl implements EmploymentService {

    @Autowired
    private EmploymentRepository employmentRepository;

    public void delete(long id) {
        employmentRepository.delete(id);
        return;
    }

    public EmploymentEntity findByEmployeeIdAndProjectId(long employee_id, long project_id){
        return employmentRepository.findByEmployeeIdAndProjectId(employee_id, project_id);
    }

    public List<EmploymentEntity> findAll(){
        return (List<EmploymentEntity>) employmentRepository.findAll();
    }

    public List<EmploymentEntity> findByProjectName(String name){
        return employmentRepository.findByProjectName(name);
    }

    public List<EmploymentEntity> findByEmployeeName(String name){
        return employmentRepository.findByEmployeeName(name);
    }

    public List<EmploymentEntity> findByEmployeeNameAndProjectName(String ename, String pname){
        return employmentRepository.findByEmployeeNameAndProjectName(ename, pname);
    }

    public EmploymentEntity save(EmploymentEntity employment){
        return  employmentRepository.save(employment);
    }

    public List<EmploymentEntity> findById(long id){
        return employmentRepository.findById(id);
    }
}
