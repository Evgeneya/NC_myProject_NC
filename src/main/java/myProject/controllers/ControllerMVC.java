package myProject.controllers;

import myProject.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class ControllerMVC {
 
    @Autowired
    ApplicationContext context;
 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        Locale.setDefault(new Locale("EN"));
        PositionService bean = context.getBean("jpaPositionService", PositionService.class);
        StringBuilder sb = new StringBuilder("<br>");
        bean.findAll().forEach(it->sb.append(it.toString()).append("<br>"));
        map.put("msg", sb.toString());
        return "index";
    }
}