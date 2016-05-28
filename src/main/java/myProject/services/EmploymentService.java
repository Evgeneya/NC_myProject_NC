package myProject.services;

import myProject.entities.EmployeeEntity;
import myProject.entities.EmploymentEntity;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface EmploymentService {
    void delete(long id);
    EmploymentEntity findByEmployeeIdAndProjectId(long employee_id, long project_id);
    EmploymentEntity save(EmploymentEntity employment);
    List<EmploymentEntity> findAll();
    List<EmploymentEntity> findByProjectName(String name);
    List<EmploymentEntity> findByEmployeeName(String name);
    List<EmploymentEntity> findByEmployeeNameAndProjectName(String ename, String pname);
    List<EmploymentEntity> findById(long id);
}
