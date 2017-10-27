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
import reports.generator.model.FareCalendar;

import javax.servlet.http.HttpServletRequest;
import java.time.YearMonth;
import java.util.*;

@Controller
@RequestMapping("/view")
public class TestController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/calendar")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, ModelMap model) {
        model.addAttribute("name", name);
           List<CalendarElement> list=new ArrayList<CalendarElement>();
        int month=10;
        int year=2017;
        Calendar monthStart = new GregorianCalendar(year, month-1, 1);
        int max=monthStart.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day=monthStart.get(Calendar.DAY_OF_WEEK);

        Map<String,CalendarElement> map=new HashMap<String,CalendarElement>();

        for(int i=1;i<=max;i++) {
            CalendarElement calendarElement = new CalendarElement();
            calendarElement.setCalKey(i+"");
            calendarElement.setCalValue("$"+i+100);
            calendarElement.setCalId(i+""+10+2017);
            map.put("cal"+i,calendarElement);
        }

        FareCalendar fareCalendar=new FareCalendar();
        fareCalendar.setYear(year);
        fareCalendar.setMonth(month);
        fareCalendar.setDayOfMonth(day);
        fareCalendar.setNumberOfDays(max);
        fareCalendar.setDataMap(map);

           model.addAttribute("fareCalendar", fareCalendar);
           model.addAttribute("monthData",month+"/1/"+year+"}");
           model.addAttribute("mon",month+""+year);
           model.addAttribute("currentDay","27");
           model.addAttribute("map",map);
        return "welcome";
    }

    @RequestMapping("/ajax")
    public String helloAjaxTest(ModelMap model, HttpServletRequest request) {

        String str="ajax";
        int month=Integer.parseInt(request.getParameter("month"));
        int year=Integer.parseInt(request.getParameter("year"));
        String path=request.getParameter("path");

        Calendar monthStart = new GregorianCalendar(year,month-1, 1);
        int max=monthStart.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day=monthStart.get(Calendar.DAY_OF_WEEK);

        Map<String,CalendarElement> map=new HashMap<String,CalendarElement>();

        for(int i=1;i<=max;i++) {
            CalendarElement calendarElement = new CalendarElement();
            calendarElement.setCalKey(i+"");
            calendarElement.setCalValue("$"+i+100);
            calendarElement.setCalId(i+""+10+2017);
            map.put("cal"+i,calendarElement);
        }

        FareCalendar fareCalendar=new FareCalendar();
        fareCalendar.setYear(year);
        fareCalendar.setMonth(month);
        fareCalendar.setDayOfMonth(day);
        fareCalendar.setNumberOfDays(max);
        fareCalendar.setDataMap(map);

        model.addAttribute("monthData",month+"/1/"+year+"}");
        model.addAttribute("mon",month+""+year);
        model.addAttribute("fareCalendar", fareCalendar);
        if(path.equals("return")){
            str="ajax1";
        }

        return str;
    }



}