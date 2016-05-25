package myProject.repository;

import myProject.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findById(long id);
    List<EmployeeEntity> findByName(String name);
    List<EmployeeEntity> findByPositionId(long position_id);
    List<EmployeeEntity> findByNameAndPositionId(String name, long position_id);
    List<EmployeeEntity> findByExperienceBetween(int exp1, int exp2);
    List<EmployeeEntity> findBySalaryBetween(int sal1, int sal2);
    List<EmployeeEntity> findByExperienceBetweenAndSalaryBetween(int exp1, int exp2, int sal1, int sal2);
    List<EmployeeEntity> findByNameAndExperienceBetweenAndSalaryBetween(String name, int exp1, int exp2, int sal1, int sal2);
    List<EmployeeEntity> findByPositionIdAndExperienceBetweenAndSalaryBetween(long position_id, int exp1, int exp2, int sal1, int sal2);
    List<EmployeeEntity> findByNameAndPositionIdAndExperienceBetweenAndSalaryBetween(String name, long position_id, int exp1, int exp2, int sal1, int sal2);

}
