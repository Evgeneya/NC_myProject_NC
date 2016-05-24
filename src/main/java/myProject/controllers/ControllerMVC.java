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
import java.util.Locale;

@Controller
public class ControllerMVC {
 
    @Autowired
    ApplicationContext context;
 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        Locale.setDefault(new Locale("EN"));
        PositionService bean = context.getBean("jpaPositionService", PositionService.class);
        StringBuilder sb = new StringBuilder("<br>");
        EmployeeService e = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> emp = e.findByPosition(1);
        bean.findAll().forEach(it->sb.append(it.toString()).append("<br>"));

        return "index";
    }

    @RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
    public String listEmployee(ServletRequest request) {
        EmployeeService emp = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = emp.findAll();
        request.setAttribute("listEmp", listEmp);
        return "listEmployee";
    }

    @RequestMapping(value = "/findEmployee", method = RequestMethod.GET)
    public String findEmployee(ServletRequest request) {
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = pos.findAll();
        request.setAttribute("listPos", listPos);
        return "findEmployees";
    }


    @RequestMapping(value = "/resultFindEmployee", method = RequestMethod.GET)
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
        return "resultFindEmployees";
    }
    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public String newEmployee(ServletRequest request){
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = pos.findAll();
        request.setAttribute("listPos", listPos);
        return "newEmployee";
    }

    @RequestMapping(value = "/resultNewEmployee", method = RequestMethod.GET)
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
        empService.save(emp);
        List<EmployeeEntity> listEmp = empService.findByName(emp.getName());
        request.setAttribute("listEmp", listEmp);
        return "resultNewEmployee";
    }
}