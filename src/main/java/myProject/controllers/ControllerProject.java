package myProject.controllers;

import myProject.entities.*;
import myProject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 1 on 26.05.2016.
 */
@Controller
public class ControllerProject {
    @Autowired
    ApplicationContext context;

    @RequestMapping(value = "/listProject", method = RequestMethod.GET)
    public String listProject(ServletRequest request) {
        ProjectService projectService= context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro = projectService.findAll();
        request.setAttribute("listPro", listPro);
        return "listProject";
    }


    @RequestMapping(value = "/findProject", method = RequestMethod.GET)
    public String findProject(ServletRequest request) throws ParseException {
        if (request.getParameter("res").equals("true")){
            return resultFindProject(request);
        }
        else {
            CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
            List<CustomerEntity> listCust = customerService.findAll();
            request.setAttribute("listCust", listCust);
            request.setAttribute("d1", "");
            request.setAttribute("d2", "");
            request.setAttribute("m1", "");
            request.setAttribute("m2", "");
            request.setAttribute("y1", "");
            request.setAttribute("y2", "");
            request.setAttribute("res", "false");
            return "findProject";
        }
    }

    public String resultFindProject(ServletRequest request) throws ParseException {
        ProjectService projectService= context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro;
        CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
        List<CustomerEntity> listCust = customerService.findAll();
        String name = request.getParameter("name");
        String customer = request.getParameter("customer");
        String d1 = request.getParameter("d1");
        String d2 = request.getParameter("d2");
        String m1 = request.getParameter("m1");
        String m2 = request.getParameter("m2");
        String y1 = request.getParameter("y1");
        String y2 = request.getParameter("y2");
        String date1, date2;
        if (d1.equals("") || m1.equals("") || y1.equals("")) {
            date1 = "";
        }
        else date1 = d1 + " " + m1 + " " + y1;
        if (d2.equals("") || m2.equals("") || y2.equals("")) {
            date2 = "";
        }
        else date2 = d2 + " " + m2 + " " + y2;

        date1 = date1.equals("")?date2:date1;
        date2 = date2.equals("")?date1:date2;
        DateFormat format = new SimpleDateFormat("dd MM yyyy");

        if (!name.equals("")){
            if (!customer.equals("")){
                long custId = customerService.findByName(customer).get(0).getId();
                if (!date1.equals("")){
                    Date beg = format.parse(date1);
                    Date end = format.parse(date2);
                    listPro = projectService.findByNameAndCustomerAndEndDateBetween(name, custId, beg, end);
                }
                else listPro = projectService.findByNameAndCustomer(name, custId);
            }
            else {
                if (!date1.equals("")) {
                    Date beg = format.parse(date1);
                    Date end = format.parse(date2);
                    listPro = projectService.findByNameAndEndDateBetween(name, beg, end);
                }
                else listPro = projectService.findByName(name);
            }
        }
        else {
            if (!customer.equals("")){
                long custId = customerService.findByName(customer).get(0).getId();
                if (!date1.equals("")){
                    Date beg = format.parse(date1);
                    Date end = format.parse(date2);
                    listPro = projectService.findByCustomerAndEndDateBetween(custId, beg, end);
                }
                else listPro = projectService.findByCustomer(custId);
            }
            else {
                if (!date1.equals("")) {
                    Date beg = format.parse(date1);
                    Date end = format.parse(date2);
                    listPro = projectService.findByEndDateBetween(beg, end);
                }
                else listPro = projectService.findAll();
            }
        }
        request.setAttribute("listCust", listCust);
        request.setAttribute("listPro", listPro);
        request.setAttribute("name", name);
        request.setAttribute("customer", customer);
        request.setAttribute("d1", d1);
        request.setAttribute("d2", d2);
        request.setAttribute("m1", m1);
        request.setAttribute("m2", m2);
        request.setAttribute("y1", y1);
        request.setAttribute("y2", y2);
        request.setAttribute("res", "true");
        return "findProject";
    }


    @RequestMapping(value = "/new_updateProject", method = RequestMethod.GET)
    public String new_updateProject(ServletRequest request) throws ParseException {
        if (request.getParameter("new").equals("true")) {
            if (request.getParameter("res").equals("true")) {
                return resultNewProject(request);
            } else {
                CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
                List<CustomerEntity> listCust = customerService.findAll();
                request.setAttribute("listCust", listCust);
                request.setAttribute("new", "true");
                request.setAttribute("res", "false");
                return "new_updateProject";
            }
        }
        else {
            return updateProject(request);
        }
    }

    public String resultNewProject(ServletRequest request) throws ParseException {
        CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
        List<CustomerEntity> listCust = customerService.findAll();
        ProjectEntity project =new ProjectEntity();
        project.setName(request.getParameter("name"));
        CustomerEntity customer = customerService.findByName(request.getParameter("customer")).get(0);
        project.setCustomer(customer);
        String d1 = request.getParameter("d1");
        String d2 = request.getParameter("d2");
        String m1 = request.getParameter("m1");
        String m2 = request.getParameter("m2");
        String y1 = request.getParameter("y1");
        String y2 = request.getParameter("y2");
        String date1 = d1 + " " + m1 + " " + y1;
        String date2 = d2 + " " + m2 + " " + y2;
        DateFormat format = new SimpleDateFormat("dd MM yyyy");

        project.setBeg_date(format.parse(date1));
        project.setEnd_date(format.parse(date2));

        ProjectService projectService= context.getBean("jpaProjectService", ProjectService.class);
        project = projectService.save(project);

        List<ProjectEntity> listPro = projectService.findById(project.getId());

        request.setAttribute("listCust", listCust);
        request.setAttribute("listPro", listPro);
        request.setAttribute("res", "true");
        request.setAttribute("new", "true");
        return "new_updateProject";
    }

    public String updateProject(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        ProjectService projectService= context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro = projectService.findById(id);
        CustomerService customerService = context.getBean("jpaCustomerService", CustomerService.class);
        List<CustomerEntity> listCust = customerService.findAll();
        request.setAttribute("listPro", listPro);
        request.setAttribute("listCust", listCust);
        request.setAttribute("new", "false");
        request.setAttribute("d1", "");
        request.setAttribute("d2", "");
        request.setAttribute("m1", "");
        request.setAttribute("m2", "");
        request.setAttribute("y1", "");
        request.setAttribute("y2", "");
        return "new_updateProject";
    }

    @RequestMapping(value = "/autoProject", method = RequestMethod.GET)
    public String autoProject(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        ProjectService projectService= context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> project = projectService.findById(id);
        EmployeeService employeeService = context.getBean("jpaEmployeeService", EmployeeService.class);
        List<EmployeeEntity> listNewEmp = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        List<EmployeeEntity> listOldEmp = new ArrayList<>();
        Collection<Resources_planEntity> plans = project.get(0).getPlans();  //все ресурсные планы с данным проектом
        if (plans.size() == 0){  //ресурсный план не назначен!
            request.setAttribute("res", "false");
            return "autoProject";
        }
        else{
            request.setAttribute("res", "true");
            Collection<EmploymentEntity> employments = project.get(0).getEmployments(); //все записи занятости с данным проектом
            for (Iterator<Resources_planEntity> i = plans.iterator(); i.hasNext();){ //просматриваем каждую запись рес. плана
                Resources_planEntity plan = i.next();
                int man_hour = plan.getHour();
                int sum_hour = 0;
                for (Iterator<EmploymentEntity> j = employments.iterator(); j.hasNext();){  //просматриваем каждую запись занятости
                    EmploymentEntity employment = j.next();
                    if (plan.getPosition().getId() == employment.getEmployee().getPosition().getId()){
                        sum_hour += employment.getCount_hour(); //кол-во часов данной должности назначенных на данный проект
                    }
                }
                if (man_hour > sum_hour){
                    int needTime = man_hour - sum_hour;   //время, которое нужно дозаполнить
                    request.setAttribute("full", "false");
                    List<EmployeeEntity> listE = employeeService.findByPosition(plan.getPosition().getId()); //lвсе сотрудники с заданной должностью
                    //EmploymentService employmentService = context.getBean("jpaEmploymentService", EmploymentService.class);
                    //EmploymentEntity employmentEntity;
                    Map<EmployeeEntity, Integer> map = new LinkedHashMap<>();
                    int time = 40;
                    for (int k = 0; k < listE.size(); k++){
                        int sum_time = 0;
                        Collection<EmploymentEntity> listEmployment = listE.get(k).getEmployments(); //вся занятость данного сотрудника
                        for (Iterator<EmploymentEntity> j = listEmployment.iterator(); j.hasNext();) {
                            EmploymentEntity employmentEntity = j.next();
                            sum_time += employmentEntity.getCount_hour();
                        }
                        map.put(listE.get(k), time - sum_time);
                    }
                    List listMap = new ArrayList(map.entrySet());
                    Collections.sort(listMap, new Comparator<Map.Entry>() {

                        @Override
                        public int compare(Map.Entry e1, Map.Entry e2) {
                            if ((Integer)e1.getValue() > (Integer)e2.getValue())
                                return 1;
                            else
                            if (e1.getValue() == e2.getValue())
                                return 0;
                            else return -1;
                        }
                    });

                    for (int j = listMap.size()-1; j >= 0; j--) {
                        // надо дописать!
                    }

                    return "autoProject";
                }
            }
            request.setAttribute("full", "true"); //ресурсный план полностью заполнен!
            return "autoProject";
        }
    }
}
