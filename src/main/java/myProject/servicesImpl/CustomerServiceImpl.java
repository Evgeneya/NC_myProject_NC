package myProject.servicesImpl;

import myProject.entities.CustomerEntity;
import myProject.repository.CustomerRepository;
import myProject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
@Service("jpaCustomerService")
@Repository
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> findAll() {
        return (ArrayList<CustomerEntity>)customerRepository.findAll();
    }

    @Override
    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
        return;
    }

    public List<CustomerEntity> findByName(String name){
        return customerRepository.findByName(name);
    }

    public List<CustomerEntity> findById(long id){
        return customerRepository.findById(id);
    }
}
