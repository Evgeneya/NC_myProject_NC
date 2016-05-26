package myProject.controllers;

import myProject.entities.CustomerEntity;
import myProject.entities.ProjectEntity;
import myProject.services.CustomerService;
import myProject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 1 on 26.05.2016.
 */
@Controller
public class ControllerCustomer {
    @Autowired
    ApplicationContext context;

    @RequestMapping(value = "/listCustomer", method = RequestMethod.GET)
    public String listCustomer(ServletRequest request) {
        CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
        List<CustomerEntity> listCust = customerService.findAll();
        request.setAttribute("listCust", listCust);
        return "listCustomer";
    }

    @RequestMapping(value = "/findCustomer", method = RequestMethod.GET)
    public String findCustomer(ServletRequest request) {
        if (request.getParameter("res").equals("true")){
            return resultFindCustomer(request);
        }
        else {
            request.setAttribute("res", "false");
            return "findCustomer";
        }
    }

    public String resultFindCustomer(ServletRequest request) {
        String name = request.getParameter("name");
        CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
        List<CustomerEntity> listCust = customerService.findByName(name);
        request.setAttribute("listCust", listCust);
        request.setAttribute("name", name);
        request.setAttribute("res", "true");
        return "findCustomer";
    }

    @RequestMapping(value = "/new_updateCustomer", method = RequestMethod.GET)
    public String newCustomer(ServletRequest request) {
        if (request.getParameter("new").equals("true")) {
            if (request.getParameter("res").equals("true")) {
                return resultNewCustomer(request);
            } else {
                request.setAttribute("new", "true");
                request.setAttribute("res", "false");
                return "new_updateCustomer";
            }
        } else {
            return updateCustomer(request);
        }
    }

    public String resultNewCustomer(ServletRequest request) {
        CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
        CustomerEntity customer = new CustomerEntity();
        customer.setName(request.getParameter("name"));
        customer.setPhone(request.getParameter("phone"));
        customer = customerService.save(customer);
        List<CustomerEntity> listCust = customerService.findById(customer.getId());
        request.setAttribute("listCust", listCust);
        request.setAttribute("new", "true");
        request.setAttribute("res", "true");
        return "new_updateCustomer";
    }

    public String updateCustomer(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
        List<CustomerEntity> listCust = customerService.findById(id);
        request.setAttribute("listCust", listCust);
        request.setAttribute("new", "false");
        return "new_updateCustomer";
    }

    @RequestMapping(value = "/resultCustomer", method = RequestMethod.GET)
    public String resultCustomer(ServletRequest request){
        if (request.getParameter("del").equals("true")) {
            return resultDeleteCustomer(request);
        }
        else {
            return resultUpdateCustomer(request);
        }
    }

    public String resultDeleteCustomer(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
        List<CustomerEntity> listCust = customerService.findById(id);
        ProjectService projectService = context.getBean("jpaProjectService", ProjectService.class);
        Collection<ProjectEntity> projects = listCust.get(0).getProjects();
        for (Iterator i = projects.iterator(); i.hasNext();) {
            projectService.delete(((ProjectEntity)i.next()).getId());
        }
        customerService.delete(id);
        request.setAttribute("del", "true");
        return "resultCustomer";
    }

    public String resultUpdateCustomer(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
        CustomerEntity customer = new CustomerEntity();
        customer.setId(id);
        customer.setName(request.getParameter("name"));
        customer.setPhone(request.getParameter("phone"));
        customerService.save(customer);
        request.setAttribute("del", "false");
        return "resultCustomer";
    }
}

