package myProject.servicesImpl;

import myProject.services.Resources_planService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 1 on 27.04.2016.
 */
@Service("jpaResources_planService")
@Repository
@Transactional
public class ResourcesServiceImpl implements Resources_planService {
}
