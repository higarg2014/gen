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
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;

@Controller
@RequestMapping("/view")
public class TestController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/calendar")
    public String greeting(ModelMap model) {

        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();
        int currentDay = now.getDayOfMonth();


        Calendar monthStart = new GregorianCalendar(currentYear, currentMonth-1, 1);
        int max=monthStart.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day=monthStart.get(Calendar.DAY_OF_WEEK);


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);



        int departDay = calendar.get(Calendar.DAY_OF_MONTH);
        int departMonth = calendar.get(Calendar.MONTH);
        int departYear = calendar.get(Calendar.YEAR);


        Map<String,CalendarElement> map=new HashMap<String,CalendarElement>();

        for(int i=1;i<=max;i++) {
            CalendarElement calendarElement = new CalendarElement();



            if(i>=currentDay) {
                calendarElement.setCalValue("$" + i + 100);
                calendarElement.setContent(true);
                if(i==currentDay+1){
                    calendarElement.setCalClass("active");
                }

            }
            else{
                calendarElement.setContent(false);
                calendarElement.setCalClass("disabled");
            }

            calendarElement.setCalId(i+""+currentMonth+currentYear);
            map.put("cal"+i,calendarElement);
        }

        FareCalendar fareCalendar=new FareCalendar();
        fareCalendar.setYear(currentYear);
        fareCalendar.setMonth(currentMonth);
        fareCalendar.setDayOfMonth(day);
        fareCalendar.setNumberOfDays(max);
        fareCalendar.setDataMap(map);
        fareCalendar.setCurrentDay(currentDay);
        fareCalendar.setCurrentMonth(currentMonth);
        fareCalendar.setCurrentYear(currentYear);

        fareCalendar.setDepartDay(departDay);
        fareCalendar.setDepartMonth(departMonth+1);
        fareCalendar.setDepartYear(departYear);


           model.addAttribute("fareCalendar", fareCalendar);
           model.addAttribute("monthData","01-"+currentMonth+"-"+currentYear);

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

        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();
        int currentDay = now.getDayOfMonth();

        Map<String,CalendarElement> map=new HashMap<String,CalendarElement>();

        for(int i=1;i<=max;i++) {
            CalendarElement calendarElement = new CalendarElement();
            calendarElement.setCalValue("$"+i+100);
            calendarElement.setCalId(i+""+month+year);
            map.put("cal"+i,calendarElement);
        }


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);



        int departDay = calendar.get(Calendar.DAY_OF_MONTH);
        int departMonth = calendar.get(Calendar.MONTH);
        int departYear = calendar.get(Calendar.YEAR);
        FareCalendar fareCalendar=new FareCalendar();
        fareCalendar.setYear(year);
        fareCalendar.setMonth(month);
        fareCalendar.setDayOfMonth(day);
        fareCalendar.setNumberOfDays(max);
        fareCalendar.setDataMap(map);
        fareCalendar.setCurrentDay(currentDay);
        fareCalendar.setCurrentMonth(currentMonth);
        fareCalendar.setCurrentYear(currentYear);


        fareCalendar.setDepartDay(departDay);
        fareCalendar.setDepartMonth(departMonth+1);
        fareCalendar.setDepartYear(departYear);
        model.addAttribute("monthData","01-"+month+"-"+year);
        model.addAttribute("fareCalendar", fareCalendar);

        if(path.equals("return")){
            str="ajax1";
        }

        return str;
    }

    @ResponseBody
    @RequestMapping("/test")
    public FareCalendar test() {

        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();
        int currentDay = now.getDayOfMonth();


        Calendar monthStart = new GregorianCalendar(currentYear, currentMonth-1, 1);
        int max=monthStart.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day=monthStart.get(Calendar.DAY_OF_WEEK);


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);



        int departDay = calendar.get(Calendar.DAY_OF_MONTH);
        int departMonth = calendar.get(Calendar.MONTH);
        int departYear = calendar.get(Calendar.YEAR);


        Map<String,CalendarElement> map=new HashMap<String,CalendarElement>();

        for(int i=1;i<=max;i++) {
            CalendarElement calendarElement = new CalendarElement();
            calendarElement.setCalValue("$"+i+100);
            calendarElement.setCalId(i+""+currentMonth+currentYear);
            map.put("cal"+i,calendarElement);
        }

        FareCalendar fareCalendar=new FareCalendar();
        fareCalendar.setYear(currentYear);
        fareCalendar.setMonth(currentMonth);
        fareCalendar.setDayOfMonth(day);
        fareCalendar.setNumberOfDays(max);
        fareCalendar.setDataMap(map);
        fareCalendar.setCurrentDay(currentDay);
        fareCalendar.setCurrentMonth(currentMonth);
        fareCalendar.setCurrentYear(currentYear);

        fareCalendar.setDepartDay(departDay);
        fareCalendar.setDepartMonth(departMonth+1);
        fareCalendar.setDepartYear(departYear);


/*        model.addAttribute("fareCalendar", fareCalendar);
        model.addAttribute("monthData","01-"+currentMonth+"-"+currentYear);*/

        return fareCalendar;
    }




}