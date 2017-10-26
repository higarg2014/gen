package reports.generator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import reports.generator.model.CalendarElement;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/view")
public class TestController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/calendar")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, ModelMap model) {
        model.addAttribute("name", name);
           List<CalendarElement> list=new ArrayList<CalendarElement>();

           for(int i=1;i<=31;i++) {

               CalendarElement calendarElement = new CalendarElement();
               calendarElement.setCalKey(i+"");
               calendarElement.setCalValue("$"+i+100);
               calendarElement.setCalId(i+""+10+2017);

               list.add(calendarElement);

           }
           model.addAttribute("data", list);
           model.addAttribute("monthData","10/1/2017}");
           model.addAttribute("mon","102017");
           model.addAttribute("currentDay","26");

        return "welcome";
    }

    @RequestMapping("/ajax")
    public String helloAjaxTest(ModelMap model, HttpServletRequest request) {

        String str="ajax";
        String month=request.getParameter("month");
        String year=request.getParameter("year");
        String path=request.getParameter("path");
        List<CalendarElement> list=new ArrayList<CalendarElement>();
        for(int i=1;i<=31;i++) {

            CalendarElement calendarElement = new CalendarElement();
            calendarElement.setCalKey(i+"");
            calendarElement.setCalValue("$ "+i+100);
            calendarElement.setCalId(i+""+month+year);

            list.add(calendarElement);

        }
        model.addAttribute("data", list);
        model.addAttribute("monthData",month+"/1/"+year+"}");
        model.addAttribute("mon",month+""+year);

        if(path.equals("return")){
            str="ajax1";
        }

        return str;
    }



}