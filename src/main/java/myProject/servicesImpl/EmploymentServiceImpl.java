package myProject.servicesImpl;

import myProject.services.EmploymentService;
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
}
