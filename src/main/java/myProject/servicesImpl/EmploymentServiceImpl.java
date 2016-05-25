package myProject.servicesImpl;

import myProject.repository.EmploymentRepository;
import myProject.services.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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



}
