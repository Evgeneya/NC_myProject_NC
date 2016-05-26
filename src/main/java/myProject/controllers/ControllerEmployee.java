package myProject.controllers;

import myProject.entities.EmployeeEntity;
import myProject.entities.EmploymentEntity;
import myProject.entities.PositionEntity;
import myProject.services.EmployeeService;
import myProject.services.EmploymentService;
import myProject.services.PositionService;
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
 * Created by 1 on 25.05.2016.
 */
@Controller
public class ControllerEmployee {

    @Autowired
    ApplicationContext context;

    @RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
    public String listEmployee(ServletRequest request) {
        EmployeeService emp = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = emp.findAll();
        request.setAttribute("listEmp", listEmp);
        return "listEmployee";
    }

    @RequestMapping(value = "/findEmployee", method = RequestMethod.GET)
    public String findEmployee(ServletRequest request) {
        if (request.getParameter("res").equals("true")){
            return resultFindEmployee(request);
        }
        else {
            PositionService pos = context.getBean("jpaPositionService", PositionService.class);
            List<PositionEntity> listPos = pos.findAll();
            request.setAttribute("listPos", listPos);
            request.setAttribute("res", "false");
            return "findEmployees";
        }
    }

    public String resultFindEmployee(ServletRequest request) {
        String name = request.getParameter("name");
        String posName = request.getParameter("position");
        String exp1 = request.getParameter("exp1");
        String exp2 = request.getParameter("exp2");
        String sal1 = request.getParameter("sal1");
        String sal2 = request.getParameter("sal2");
        int experience1, experience2, salary1, salary2;
        experience1 = (exp1.equals("")) ? 0 : Integer.parseInt(exp1);
        experience2 = (exp2.equals("")) ? 100 : Integer.parseInt(exp2);
        salary1 = (sal1.equals("")) ? 0 : Integer.parseInt(sal1);
        salary2 = (sal2.equals("")) ? 200000 : Integer.parseInt(sal2);
        EmployeeService emp = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp;
        if (!name.equals("")){
            if (!posName.equals("")){
                PositionService pos = context.getBean("jpaPositionService", PositionService.class);
                long posId = pos.findByName(posName).get(0).getId();
                listEmp = emp.findByNameAndPositionIdAndExperienceBetweenAndSalaryBetween(name, posId, experience1, experience2, salary1, salary2);
            }
            else {
                listEmp = emp.findByNameAndExperienceBetweenAndSalaryBetween(name, experience1, experience2, salary1, salary2);
            }
        }
        else {
            if (!posName.equals("")){
                PositionService pos = context.getBean("jpaPositionService", PositionService.class);
                long posId = pos.findByName(posName).get(0).getId();
                listEmp = emp.findByPositionIdAndExperienceBetweenAndSalaryBetween(posId, experience1, experience2, salary1, salary2);
            }
            else {
                listEmp = emp.findByExperienceBetweenAndSalaryBetween(experience1, experience2, salary1, salary2);
            }
        }
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = pos.findAll();
        request.setAttribute("listPos", listPos);
        request.setAttribute("listEmp", listEmp);
        request.setAttribute("name", name);
        request.setAttribute("position", posName);
        request.setAttribute("exp1", exp1);
        request.setAttribute("exp2", exp2);
        request.setAttribute("sal1", sal1);
        request.setAttribute("sal2", sal2);
        request.setAttribute("res", "true");
        return "findEmployees";
    }

    @RequestMapping(value = "/new_updateEmployee", method = RequestMethod.GET)
    public String new_updateEmployee(ServletRequest request){
        if (request.getParameter("new").equals("true")) {
            if (request.getParameter("res").equals("true")) {
                return resultNewEmployee(request);
            } else {
                PositionService pos = context.getBean("jpaPositionService", PositionService.class);
                List<PositionEntity> listPos = pos.findAll();
                request.setAttribute("listPos", listPos);
                request.setAttribute("new", "true");
                request.setAttribute("res", "false");
                return "new_updateEmployee";
            }
        }
        else {
            return updateEmployee(request);
        }
    }

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
        request.setAttribute("res", "true");
        request.setAttribute("new", "true");
        return "new_updateEmployee";
    }

    public String updateEmployee(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        EmployeeService empService = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = empService.findById(id);
        request.setAttribute("listEmp", listEmp);
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = pos.findAll();
        request.setAttribute("listPos", listPos);
        request.setAttribute("new", "false");
        return "new_updateEmployee";
    }

    @RequestMapping(value = "/resultEmployee", method = RequestMethod.GET)
    public String resultEmployee(ServletRequest request){
        if (request.getParameter("del").equals("true")) {
            return resultDeleteEmployee(request);
        }
        else {
            return resultUpdateEmployee(request);
        }
    }


    public String resultDeleteEmployee(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        EmployeeService empService = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = empService.findById(id);
        EmploymentService employmentService = context.getBean("jpaEmploymentService", EmploymentService.class);
        Collection<EmploymentEntity> employment = listEmp.get(0).getEmployments();
        for (Iterator i = employment.iterator(); i.hasNext();){
            employmentService.delete(((EmploymentEntity) i.next()).getId());
        }
        empService.delete(id);
        request.setAttribute("del", "true");
        return "resultEmployee";
    }


    public String resultUpdateEmployee(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        EmployeeService empService = context.getBean("jpaEmployeeService", EmployeeService.class);
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
        empService.save(emp);
        request.setAttribute("del", "false");
        return "resultEmployee";
    }
}
