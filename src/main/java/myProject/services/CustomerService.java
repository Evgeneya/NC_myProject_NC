package myProject.services;

import myProject.entities.CustomerEntity;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface CustomerService {
    List<CustomerEntity> findAll();
    CustomerEntity save(CustomerEntity customer);
    void delete(Long id);
}
