package myProject.controllers;

import myProject.entities.CustomerEntity;
import myProject.entities.EmployeeEntity;
import myProject.entities.EmploymentEntity;
import myProject.entities.ProjectEntity;
import myProject.services.CustomerService;
import myProject.services.EmployeeService;
import myProject.services.EmploymentService;
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
public class ControllerEmployment {
    @Autowired
    ApplicationContext context;

    @RequestMapping(value = "/listEmployment", method = RequestMethod.GET)
    public String listEmployment(ServletRequest request) {
        EmploymentService employmentService = context.getBean("jpaEmploymentService", EmploymentService.class);
        List<EmploymentEntity> listEmpl = employmentService.findAll();
        request.setAttribute("listEmpl", listEmpl);
        return "listEmployment";
    }

    @RequestMapping(value = "/findEmployment", method = RequestMethod.GET)
    public String findEmployment(ServletRequest request) {
        EmployeeService employeeService = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = employeeService.findAll();
        request.setAttribute("listEmp", listEmp);
        ProjectService projectService = context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro = projectService.findAll();
        request.setAttribute("listPro", listPro);
        if (request.getParameter("res").equals("true")){
            return resultFindEmployment(request);
        }
        else {
            request.setAttribute("res", "false");
            return "findEmployment";
        }
    }

    public String resultFindEmployment(ServletRequest request) {
        String employee = request.getParameter("employee");
        String project = request.getParameter("project");
        EmploymentService employmentService = context.getBean("jpaEmploymentService", EmploymentService.class);
        List<EmploymentEntity> listEmpl;
        if (employee.equals("")){
            if (project.equals("")){
                listEmpl = employmentService.findAll();
            }else{
                listEmpl = employmentService.findByProjectName(project);
            }
        }
        else {
            if (project.equals("")){
                listEmpl = employmentService.findByEmployeeName(employee);
            }else{
                listEmpl = employmentService.findByEmployeeNameAndProjectName(employee, project);
            }
        }
        request.setAttribute("employee", employee);
        request.setAttribute("project", project);
        request.setAttribute("listEmpl", listEmpl);
        request.setAttribute("res", "true");
        return "findEmployment";
    }

    @RequestMapping(value = "/new_updateEmployment", method = RequestMethod.GET)
    public String newEmployment(ServletRequest request) {
        EmployeeService employeeService = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = employeeService.findAll();
        request.setAttribute("listEmp", listEmp);
        ProjectService projectService = context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro = projectService.findAll();
        request.setAttribute("listPro", listPro);
        if (request.getParameter("new").equals("true")) {
            if (request.getParameter("res").equals("true")) {
                return resultNewEmployment(request);
            } else {
                request.setAttribute("new", "true");
                request.setAttribute("res", "false");
                return "new_updateEmployment";
            }
        } else {
            return updateEmployment(request);
        }
    }

    public String resultNewEmployment(ServletRequest request) {
        String employee = request.getParameter("employee");
        String project = request.getParameter("project");
        String hour = request.getParameter("hour");
        EmploymentService employmentService = context.getBean("jpaEmploymentService", EmploymentService.class);
        EmploymentEntity employment = new EmploymentEntity();
        EmployeeService employeeService = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = employeeService.findByName(employee);
        ProjectService projectService = context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro = projectService.findByName(project);
        employment.setEmployee(listEmp.get(0));
        employment.setProject(listPro.get(0));
        employment.setCount_hour(Integer.parseInt(hour));
        employment = employmentService.save(employment);
        List<EmploymentEntity> listEmpl = employmentService.findById(employment.getId());
        request.setAttribute("listEmpl", listEmpl);
        request.setAttribute("employee", employee);
        request.setAttribute("project", project);
        request.setAttribute("hour", hour);
        request.setAttribute("new", "true");
        request.setAttribute("res", "true");
        return "new_updateEmployment";
    }

    public String updateEmployment(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        EmploymentService employmentService = context.getBean("jpaEmploymentService", EmploymentService.class);
        List<EmploymentEntity> listEmpl = employmentService.findById(id);
        String employee = listEmpl.get(0).getEmployee().getName();
        String project = listEmpl.get(0).getProject().getName();
        Integer hour = listEmpl.get(0).getCount_hour();
        request.setAttribute("employee", employee);
        request.setAttribute("project", project);
        request.setAttribute("hour", hour.toString());
        request.setAttribute("listEmpl", listEmpl);
        request.setAttribute("new", "false");
        return "new_updateEmployment";
    }

    @RequestMapping(value = "/resultEmployment", method = RequestMethod.GET)
    public String resultEmployment(ServletRequest request){
        if (request.getParameter("del").equals("true")) {
            return resultDeleteEmployment(request);
        }
        else {
            return resultUpdateEmployment(request);
        }
    }

    public String resultDeleteEmployment(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        EmploymentService employmentService = context.getBean("jpaEmploymentService", EmploymentService.class);
        employmentService.delete(id);
        request.setAttribute("del", "true");
        return "resultEmployment";
    }

    public String resultUpdateEmployment(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        EmploymentService employmentService = context.getBean("jpaEmploymentService", EmploymentService.class);
        EmploymentEntity employment = new EmploymentEntity();

        EmployeeService employeeService = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listEmp = employeeService.findByName(request.getParameter("employee"));
        ProjectService projectService = context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro = projectService.findByName(request.getParameter("project"));

        employment.setId(id);
        employment.setEmployee(listEmp.get(0));
        employment.setProject(listPro.get(0));
        employment.setCount_hour(Integer.parseInt(request.getParameter("hour")));

        employmentService.save(employment);
        request.setAttribute("del", "false");
        return "resultEmployment";
    }
}

