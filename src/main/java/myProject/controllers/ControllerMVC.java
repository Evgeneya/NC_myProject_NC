package myProject.controllers;

import myProject.entities.EmployeeEntity;
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


}