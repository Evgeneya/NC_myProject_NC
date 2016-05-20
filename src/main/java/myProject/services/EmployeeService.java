package myProject.services;

import myProject.entities.EmployeeEntity;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface EmployeeService {
    List<EmployeeEntity> findAll();
    EmployeeEntity save(EmployeeEntity employee);
    void delete(Long id);
}
