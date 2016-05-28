package myProject.services;

import myProject.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface EmployeeService {
    List<EmployeeEntity> findAll();
    EmployeeEntity save(EmployeeEntity employee);
    void delete(long id);
    List<EmployeeEntity> findById(long id);
    List<EmployeeEntity> findByName(String name);
    List<EmployeeEntity> findByPosition(long position_id);
    List<EmployeeEntity> findByNameAndPositionId(String name, long position_id);
    List<EmployeeEntity> findByExperienceBetween(int exp1, int exp2);
    List<EmployeeEntity> findBySalaryBetween(int sal1, int sal2);
    List<EmployeeEntity> findByExperienceBetweenAndSalaryBetween(int exp1, int exp2, int sal1, int sal2);
    List<EmployeeEntity> findByNameAndExperienceBetweenAndSalaryBetween(String name, int exp1, int exp2, int sal1, int sal2);
    List<EmployeeEntity> findByPositionIdAndExperienceBetweenAndSalaryBetween(long position_id, int exp1, int exp2, int sal1, int sal2);
    List<EmployeeEntity> findByNameAndPositionIdAndExperienceBetweenAndSalaryBetween(String name, long position_id, int exp1, int exp2, int sal1, int sal2);
    List<EmployeeEntity> findByPositionIdAndEmploymentsProjectIdOrderByEmploymentsCountHourAsc(long position_id, long project_id);
    List<EmployeeEntity> findByPositionIdAndEmploymentsProjectIdOrPositionIdOrderByEmploymentsCountHourAsc(long position_id, long project_id, long position_id2);
    List<EmployeeEntity> findByPositionIdOrderByEmploymentsCountHourAsc(long position_id);

    List<EmployeeEntity> findSortEmployee(long position_id);
}
