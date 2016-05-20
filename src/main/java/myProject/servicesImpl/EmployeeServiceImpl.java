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

    public void delete(Long id){
        employeeRepository.delete(id);
        return;
    }
}
