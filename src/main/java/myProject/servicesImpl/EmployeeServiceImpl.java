package myProject.servicesImpl;

import myProject.entities.EmployeeEntity;
import myProject.repository.EmployeeRepository;
import myProject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
@Service("jpaEmployeeService")
@Repository
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> findAll() {
        return (ArrayList<EmployeeEntity>)employeeRepository.findAll();
    }

    public EmployeeEntity save(EmployeeEntity employee){
        return employeeRepository.save(employee);
    }

    public void delete(long id){
        employeeRepository.delete(id);
        return;
    }

    public List<EmployeeEntity> findById(long id){
        return employeeRepository.findById(id);
    }

    public List<EmployeeEntity> findByName(String name){
        return employeeRepository.findByName(name);
    }

    public List<EmployeeEntity> findByPosition(long position_id){
        return employeeRepository.findByPositionId(position_id);
    }

    public List<EmployeeEntity> findByNameAndPositionId(String name, long position_id){
        return employeeRepository.findByNameAndPositionId(name, position_id);
    }

    public List<EmployeeEntity> findByExperienceBetween(int exp1, int exp2){
        return employeeRepository.findByExperienceBetween(exp1, exp2);
    }

    public List<EmployeeEntity> findBySalaryBetween(int sal1, int sal2){
        return employeeRepository.findBySalaryBetween(sal1, sal2);
    }

    public List<EmployeeEntity> findByExperienceBetweenAndSalaryBetween(int exp1, int exp2, int sal1, int sal2){
        return employeeRepository.findByExperienceBetweenAndSalaryBetween(exp1, exp2, sal1, sal2);
    }
    public List<EmployeeEntity> findByNameAndExperienceBetweenAndSalaryBetween(String name, int exp1, int exp2, int sal1, int sal2){
        return employeeRepository.findByNameAndExperienceBetweenAndSalaryBetween(name, exp1, exp2, sal1, sal2);
    }
    public List<EmployeeEntity> findByPositionIdAndExperienceBetweenAndSalaryBetween(long position_id, int exp1, int exp2, int sal1, int sal2){
        return employeeRepository.findByPositionIdAndExperienceBetweenAndSalaryBetween(position_id, exp1, exp2, sal1, sal2);
    }

    public List<EmployeeEntity> findByNameAndPositionIdAndExperienceBetweenAndSalaryBetween(String name, long position_id, int exp1, int exp2, int sal1, int sal2){
        return employeeRepository.findByNameAndPositionIdAndExperienceBetweenAndSalaryBetween(name, position_id, exp1, exp2, sal1, sal2);
    }

    public List<EmployeeEntity> findByPositionIdAndEmploymentsProjectIdOrderByEmploymentsCountHourAsc(long position_id, long project_id){
        return employeeRepository.findByPositionIdAndEmploymentsProjectIdOrderByEmploymentsCountHourAsc(position_id, project_id);
    }

    public List<EmployeeEntity> findByPositionIdAndEmploymentsProjectIdOrPositionIdOrderByEmploymentsCountHourAsc(long position_id, long project_id, long position_id2){
        return employeeRepository.findByPositionIdAndEmploymentsProjectIdOrPositionIdOrderByEmploymentsCountHourAsc(position_id, project_id, position_id2);
    }

    public List<EmployeeEntity> findByPositionIdOrderByEmploymentsCountHourAsc(long position_id){
        return employeeRepository.findByPositionIdOrderByEmploymentsCountHourAsc(position_id);
    }

    public List<EmployeeEntity> findSortEmployee(long position_id){
        return employeeRepository.findSortEmployee();
    }
}
