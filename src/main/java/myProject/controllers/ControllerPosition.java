package myProject.controllers;

import myProject.entities.EmployeeEntity;
import myProject.entities.PositionEntity;
import myProject.services.EmployeeService;
import myProject.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * Created by 1 on 25.05.2016.
 */
@Controller
public class ControllerPosition {
    @Autowired
    ApplicationContext context;

    @RequestMapping(value = "/listPosition", method = RequestMethod.GET)
    public String listPosition(ServletRequest request) {
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = pos.findAll();
        request.setAttribute("listPos", listPos);
        return "listPosition";
    }

    @RequestMapping(value = "/findPosition", method = RequestMethod.GET)
    public String findPosition(ServletRequest request) {
        return "findPosition";
    }


    @RequestMapping(value = "/resultFindPosition", method = RequestMethod.GET)
    public String resultFindPosition(ServletRequest request) {
        String name = request.getParameter("name");
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = pos.findByName(name);
        request.setAttribute("listPos", listPos);
        request.setAttribute("name", name);
        return "resultFindPosition";
    }

    /*@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public String newEmployee(ServletRequest request){
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = pos.findAll();
        request.setAttribute("listPos", listPos);
        return "newEmployee";
    }*/

    /*@RequestMapping(value = "/resultNewEmployee", method = RequestMethod.GET)
    public String resultNewEmployee(ServletRequest request) {
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = pos.findAll();
        request.setAttribute("listPos", listPos);
        EmployeeEntity emp =new EmployeeEntity();
        emp.setName(request.getParameter("name"));
        PositionEntity empPos =  (pos.findByName((String) request.getParameter("position"))).get(0);
        emp.setPosition(empPos);
        emp.setExperience(Integer.parseInt(request.getParameter("exp")));
        emp.setSalary(Integer.parseInt(request.getParameter("sal")));
        emp.setEmail(request.getParameter("email1") + "@" + request.getParameter("email2"));
        emp.setPhone(request.getParameter("phone"));
        emp.setAge(Integer.parseInt(request.getParameter("age")));
        emp.setStatus(request.getParameter("status"));
        EmployeeService empService = context.getBean("jpaEmployeeService", EmployeeService.class);
        emp = empService.save(emp);
        List<EmployeeEntity> listEmp = empService.findById(emp.getId());
        request.setAttribute("listEmp", listEmp);
        return "resultNewEmployee";
    }*/

    /*@RequestMapping(value = "/resultDeleteEmployee", method = RequestMethod.GET)
    public String deleteEmployee(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        //EmploymentService employmentService = context.getBean("jpaEmploymentService", EmploymentService.class);
        //employmentService.deleteEmploymentByEmployeeId(id);
        EmployeeService empService = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = empService.findById(id);
        empService.delete(listEmp.get(0));
        return "resultDeleteEmployee";
    }*/

    /*@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
    public String updateEmployee(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        EmployeeService empService = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = empService.findById(id);
        request.setAttribute("listEmp", listEmp);
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = pos.findAll();
        request.setAttribute("listPos", listPos);
        return "updateEmployee";
    }*/

    /*@RequestMapping(value = "/resultUpdateEmployee", method = RequestMethod.GET)
    public String resultUpdateEmployee(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        EmployeeService empService = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = empService.findById(id);
        empService.delete(listEmp.get(0));
        EmployeeEntity emp =new EmployeeEntity();
        emp.setId(id);
        emp.setName(request.getParameter("name"));
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        PositionEntity empPos =  (pos.findByName((String) request.getParameter("position"))).get(0);
        emp.setPosition(empPos);
        emp.setExperience(Integer.parseInt(request.getParameter("exp")));
        emp.setSalary(Integer.parseInt(request.getParameter("sal")));
        emp.setEmail(request.getParameter("email1") + "@" + request.getParameter("email2"));
        emp.setPhone(request.getParameter("phone"));
        emp.setAge(Integer.parseInt(request.getParameter("age")));
        emp.setStatus(request.getParameter("status"));
        emp = empService.save(emp);
        return "resultUpdateEmployee";
    }*/
}
