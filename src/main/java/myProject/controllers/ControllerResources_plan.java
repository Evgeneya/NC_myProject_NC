package myProject.controllers;

import myProject.entities.*;
import myProject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * Created by 1 on 26.05.2016.
 */
@Controller
public class ControllerResources_plan {
    @Autowired
    ApplicationContext context;

    @RequestMapping(value = "/listResources_plan", method = RequestMethod.GET)
    public String listResources_plan(ServletRequest request) {
        Resources_planService resources_planService = context.getBean("jpaResources_planService", Resources_planService.class);
        List<Resources_planEntity> listRes = resources_planService.findAll();
        request.setAttribute("listRes", listRes);
        return "listResources_plan";
    }

    @RequestMapping(value = "/findResources_plan", method = RequestMethod.GET)
    public String findEmployment(ServletRequest request) {
        ProjectService projectService = context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro = projectService.findAll();
        request.setAttribute("listPro", listPro);
        PositionService positionService = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = positionService.findAll();
        request.setAttribute("listPos", listPos);
        if (request.getParameter("res").equals("true")){
            return resultFindResources_plan(request);
        }
        else {
            request.setAttribute("res", "false");
            return "findResources_plan";
        }
    }

    public String resultFindResources_plan(ServletRequest request) {
        String project = request.getParameter("project");
        String position = request.getParameter("position");
        Resources_planService resources_planService = context.getBean("jpaResources_planService", Resources_planService.class);
        List<Resources_planEntity> listRes;
        if (project.equals("")){
            if (position.equals("")){
                listRes = resources_planService.findAll();
            }else{
                listRes = resources_planService.findByPositionName(position);
            }
        }
        else {
            if (position.equals("")){
                listRes = resources_planService.findByProjectName(project);
            }else{
                listRes = resources_planService.findByProjectNameAndPositionName(project, position);
            }
        }
        request.setAttribute("project", project);
        request.setAttribute("position", position);
        request.setAttribute("listRes", listRes);
        request.setAttribute("res", "true");
        return "findResources_plan";
    }

    @RequestMapping(value = "/new_updateResources_plan", method = RequestMethod.GET)
    public String newResources_plan(ServletRequest request) {
        ProjectService projectService = context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro = projectService.findAll();
        request.setAttribute("listPro", listPro);
        PositionService positionService = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = positionService.findAll();
        request.setAttribute("listPos", listPos);
        if (request.getParameter("new").equals("true")) {
            if (request.getParameter("res").equals("true")) {
                return resultNewResources_plan(request);
            } else {
                request.setAttribute("new", "true");
                request.setAttribute("res", "false");
                return "new_updateResources_plan";
            }
        } else {
            return updateResources_plan(request);
        }
    }

    public String resultNewResources_plan(ServletRequest request) {
        String project = request.getParameter("project");
        String position = request.getParameter("position");
        String hour = request.getParameter("hour");
        Resources_planService resources_planService = context.getBean("jpaResources_planService", Resources_planService.class);
        Resources_planEntity resources_plan = new Resources_planEntity();
        ProjectService projectService = context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro = projectService.findByName(project);
        PositionService positionService = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = positionService.findByName(position);
        resources_plan.setProject(listPro.get(0));
        resources_plan.setPosition(listPos.get(0));
        resources_plan.setHour(Integer.parseInt(hour));
        resources_plan = resources_planService.save(resources_plan);


        List<Resources_planEntity> listRes = resources_planService.findById(resources_plan.getId());
        request.setAttribute("listRes", listRes);
        request.setAttribute("project", project);
        request.setAttribute("position", position);
        request.setAttribute("hour", hour);
        request.setAttribute("new", "true");
        request.setAttribute("res", "true");
        return "new_updateResources_plan";
    }

    public String updateResources_plan(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        Resources_planService resources_planService = context.getBean("jpaResources_planService", Resources_planService.class);
        List<Resources_planEntity> listRes = resources_planService.findById(id);
        request.setAttribute("listRes", listRes);
        request.setAttribute("new", "false");
        return "new_updateResources_plan";
    }

    @RequestMapping(value = "/resultResources_plan", method = RequestMethod.GET)
    public String resultResources_plan(ServletRequest request){
        if (request.getParameter("del").equals("true")) {
            return resultDeleteResources_plan(request);
        }
        else {
            return resultUpdateResources_plan(request);
        }
    }

    public String resultDeleteResources_plan(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        Resources_planService resources_planService = context.getBean("jpaResources_planService", Resources_planService.class);
        resources_planService.delete(id);
        request.setAttribute("del", "true");
        return "resultResources_plan";
    }

    public String resultUpdateResources_plan(ServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        Resources_planService resources_planService = context.getBean("jpaResources_planService", Resources_planService.class);
        Resources_planEntity plan = new Resources_planEntity();

        ProjectService projectService = context.getBean("jpaProjectService", ProjectService.class);
        List<ProjectEntity> listPro = projectService.findByName(request.getParameter("project"));
        PositionService positionService = context.getBean("jpaPositionService", PositionService.class);
        List<PositionEntity> listPos = positionService.findByName(request.getParameter("position"));

        plan.setId(id);
        plan.setPosition(listPos.get(0));
        plan.setProject(listPro.get(0));
        plan.setHour(Integer.parseInt(request.getParameter("hour")));

        resources_planService.save(plan);
        request.setAttribute("del", "false");
        return "resultResources_plan";
    }
}

