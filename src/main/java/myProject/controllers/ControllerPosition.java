package myProject.controllers;

import myProject.entities.EmployeeEntity;
import myProject.entities.PositionEntity;
import myProject.entities.Resources_planEntity;
import myProject.services.EmployeeService;
import myProject.services.PositionService;
import myProject.services.Resources_planService;
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
        if (request.getParameter("res").equals("true")){
            return resultFindPosition(request);
        }
        else {
            request.setAttribute("res", "false");
            return "findPosition";
        }
    }

    public String resultFindPosition(ServletRequest request) {
        String name = request.getParameter("name");
        PositionService pos = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = pos.findByName(name);
        request.setAttribute("listPos", listPos);
        request.setAttribute("name", name);
        request.setAttribute("res", "true");
        return "findPosition";
    }

    @RequestMapping(value = "/new_updatePosition", method = RequestMethod.GET)
    public String newPosition(ServletRequest request) {
        if (request.getParameter("new").equals("true")) {
            if (request.getParameter("res").equals("true")) {
                return resultNewPosition(request);
            } else {
                request.setAttribute("new", "true");
                request.setAttribute("res", "false");
                return "new_updatePosition";
            }
        } else {
            return updatePosition(request);
        }
    }

    public String resultNewPosition(ServletRequest request) {
        PositionService posService = context.getBean("jpaPositionService", PositionService.class);
        PositionEntity newPos = new PositionEntity();
        newPos.setName(request.getParameter("name"));
        newPos.setMin_salary(Integer.parseInt(request.getParameter("minsal")));
        newPos.setMax_salary(Integer.parseInt(request.getParameter("maxsal")));
        newPos = posService.save(newPos);
        List<PositionEntity> listPos = posService.findById(newPos.getId());
        request.setAttribute("listPos", listPos);
        request.setAttribute("new", "true");
        request.setAttribute("res", "true");
        return "new_updatePosition";
    }

    public String updatePosition(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        PositionService posService = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = posService.findById(id);
        request.setAttribute("listPos", listPos);
        request.setAttribute("new", "false");
        return "new_updatePosition";
    }

    @RequestMapping(value = "/resultPosition", method = RequestMethod.GET)
    public String resultPosition(ServletRequest request){
        if (request.getParameter("del").equals("true")) {
            return resultDeletePosition(request);
        }
        else {
            return resultUpdatePosition(request);
        }
    }

    public String resultDeletePosition(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        PositionService posService = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = posService.findById(id);
        EmployeeService empService = context.getBean("jpaEmployeeService", EmployeeService.class);
        Collection<EmployeeEntity> employees = listPos.get(0).getEmployees();
        for (Iterator i = employees.iterator(); i.hasNext();){
            empService.delete(((EmployeeEntity) i.next()).getId());
        }
        Resources_planService resources_planService = context.getBean("jpaResources_planService", Resources_planService.class);
        Collection<Resources_planEntity> resources_planEntities = listPos.get(0).getPlans();
        for (Iterator<Resources_planEntity> i = resources_planEntities.iterator(); i.hasNext();) {
            resources_planService.delete((i.next()).getId());
        }
        posService.delete(id);
        request.setAttribute("del", "true");
        return "resultPosition";
    }

    public String resultUpdatePosition(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        PositionService posService = context.getBean("jpaPositionService", PositionService.class);
        PositionEntity pos = new PositionEntity();
        pos.setId(id);
        pos.setName(request.getParameter("name"));
        pos.setMin_salary(Integer.parseInt(request.getParameter("minsal")));
        pos.setMax_salary(Integer.parseInt(request.getParameter("maxsal")));
        posService.save(pos);
        request.setAttribute("del", "false");
        return "resultPosition";
    }
}
