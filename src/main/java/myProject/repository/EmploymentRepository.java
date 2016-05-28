package myProject.repository;

import myProject.entities.EmployeeEntity;
import myProject.entities.EmploymentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface EmploymentRepository extends CrudRepository<EmploymentEntity, Long> {
    EmploymentEntity findByEmployeeIdAndProjectId(long employee_id, long project_id);
    List<EmploymentEntity> findByProjectName(String name);
    List<EmploymentEntity> findByEmployeeName(String name);
    List<EmploymentEntity> findByEmployeeNameAndProjectName(String ename, String pname);
    List<EmploymentEntity> findById(long id);
}
