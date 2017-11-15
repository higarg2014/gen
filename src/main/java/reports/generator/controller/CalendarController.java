package reports.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reports.generator.model.CalendarElement;
import reports.generator.model.CalendarFare;

import java.util.*;

/**
 * Created by higarg on 11/1/17.
 */
@Controller
public class CalendarController {
    //@ResponseBody
    @RequestMapping("/calendar1")
    public String calendar(ModelMap model) {
      HashMap m=new HashMap();
        List<CalendarFare> months = new ArrayList<CalendarFare>();

        int month1, month2;
        int year1, year2;
        int startMonth1, startMonth2;
        int maxMonth1, maxMonth2;
        int count = 0;

        Calendar calendar = Calendar.getInstance();
        int departDay = calendar.get(Calendar.DAY_OF_MONTH);
        int maxCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        if (departDay == maxCurrentMonth) {
            departDay = 1;
            count = count + 1;
        } else {
            departDay = departDay + 1;
        }

        calendar.add(Calendar.MONTH, count);
        month1 = calendar.get(Calendar.MONTH) + 1;
        year1 = calendar.get(Calendar.YEAR);
        startMonth1 = calendar.get(Calendar.DAY_OF_WEEK);
        maxMonth1 = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int startId = Integer.parseInt(year1 + (month1 < 10 ? "0" : "") + month1 + (departDay < 10 ? "0" : "") + departDay);

        calendar.add(Calendar.MONTH,  1);
        month2 = calendar.get(Calendar.MONTH) + 1;
        year2 = calendar.get(Calendar.YEAR);
        startMonth2 = calendar.get(Calendar.DAY_OF_WEEK);
        maxMonth2 = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);



        CalendarFare fareCalendar = new CalendarFare();
        fareCalendar.setNumberOfDays(maxMonth1);
        fareCalendar.setStartDayOfMonth(startMonth1);
        fareCalendar.setMonth(month1+"");
        fareCalendar.setYear(year1+"");
        months.add(fareCalendar);


        CalendarFare fareCalendar1 = new CalendarFare();
        fareCalendar1.setNumberOfDays(maxMonth2);
        fareCalendar1.setStartDayOfMonth(startMonth2);
        fareCalendar1.setMonth(month2+"");
        fareCalendar1.setYear(year2+"");
        months.add(fareCalendar1);


        Map<String, CalendarElement> map = new HashMap<String, CalendarElement>();
        for (int i = 1; i <= maxMonth1; i++) {
            int nextId=Integer.parseInt(year1 + (month1 < 10 ? "0" : "") + month1 + (i < 10 ? "0" : "") + i);

            if(startId<nextId) {
                CalendarElement calendarElement = new CalendarElement();
                calendarElement.setPrice("$" + new Random().nextInt(10000));
                calendarElement.setCurrency("USD");
                map.put(nextId+"", calendarElement);
            }

        }
        for (int i = 1; i <= maxMonth2; i++) {
            int nextId=Integer.parseInt(year2 + (month2 < 10 ? "0" : "") + month2 + (i < 10 ? "0" : "") + i);

            if(startId<nextId) {
                CalendarElement calendarElement = new CalendarElement();
                calendarElement.setPrice("$" + new Random().nextInt(10000));
                calendarElement.setCurrency("USD");
                map.put(nextId+"", calendarElement);
            }

        }

        model.addAttribute("months", months);
        model.addAttribute("minDepartureId", startId);
        model.addAttribute("viewStartDepartId", year1 + (month1 < 10 ? "0" : "") + month1 + "01");
        model.addAttribute("viewEndDepartId", year2 + (month2 < 10 ? "0" : "") + month2 + maxMonth2);
        model.addAttribute("calendarData", map);


        m.put("months", months);
        m.put("minDepartureId", startId);
        m.put("viewStartDepartId", year1 + (month1 < 10 ? "0" : "") + month1 + "01");
        m.put("viewEndDepartId", year2 + (month2 < 10 ? "0" : "") + month2 + maxMonth2);
        m.put("calendarData", map);
        return "calendar";
    }

    @RequestMapping("/ajax")
    public String helloAjaxTest(ModelMap model, @RequestParam("count") int count,@RequestParam("departureId") String departureId) {

        int l=departureId.length();
        int day=Integer.parseInt(departureId.substring(6,l));
        int month=Integer.parseInt(departureId.substring(4,6));
        int year=Integer.parseInt(departureId.substring(0,4));

        int startId=Integer.parseInt(departureId);
        String startDate=day+"-"+month+"-"+year;

        if (count >= 0 && count < 6) {


            List<CalendarFare> months = new ArrayList<CalendarFare>();

            int month1, month2;
            int year1, year2;
            int startMonth1, startMonth2;
            int maxMonth1, maxMonth2;

            Calendar calendar = Calendar.getInstance();
            int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
            int maxCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            count = count * 2;
            if (currentDay == maxCurrentMonth) {
                count = count+1;
            }

            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.MONTH, count);
            month1 = calendar.get(Calendar.MONTH) + 1;
            year1 = calendar.get(Calendar.YEAR);
            startMonth1 = calendar.get(Calendar.DAY_OF_WEEK);
            maxMonth1 = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);



            calendar.add(Calendar.MONTH, 1);
            month2 = calendar.get(Calendar.MONTH) + 1;
            year2 = calendar.get(Calendar.YEAR);
            startMonth2 = calendar.get(Calendar.DAY_OF_WEEK);
            maxMonth2 = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            String endDate=maxMonth2+"-"+month2+"-"+year2;

            CalendarFare fareCalendar = new CalendarFare();
            fareCalendar.setNumberOfDays(maxMonth1);
            fareCalendar.setStartDayOfMonth(startMonth1);
            fareCalendar.setMonth(month1+"");
            fareCalendar.setYear(year1+"");
            months.add(fareCalendar);

            CalendarFare fareCalendar1 = new CalendarFare();
            fareCalendar1.setNumberOfDays(maxMonth2);
            fareCalendar1.setStartDayOfMonth(startMonth2);
            fareCalendar1.setMonth(month2+"");
            fareCalendar1.setYear(year2+"");
            months.add(fareCalendar1);


            Map<String, CalendarElement> map = new HashMap<String, CalendarElement>();
            for (int i = 1; i <= maxMonth1; i++) {
                int nextId=Integer.parseInt(year1 + (month1 < 10 ? "0" : "") + month1 + (i < 10 ? "0" : "") + i);
                if(startId<nextId) {
                    CalendarElement calendarElement = new CalendarElement();
                    calendarElement.setPrice("$" + new Random().nextInt(10000));
                    calendarElement.setCurrency("USD");
                    map.put(nextId+"", calendarElement);
                }
            }
            for (int i = 1; i <= maxMonth2; i++) {
                int nextId=Integer.parseInt(year2 + (month2 < 10 ? "0" : "") + month2 + (i < 10 ? "0" : "") + i);
                CalendarElement calendarElement = new CalendarElement();
                if(startId<nextId) {
                    calendarElement.setPrice("$" + new Random().nextInt(10000));
                    calendarElement.setCurrency("USD");
                    map.put(nextId+"", calendarElement);
                }

            }

            model.addAttribute("months", months);
            model.addAttribute("calendarData", map);
            model.addAttribute("viewStartDepartId", year1 + (month1 < 10 ? "0" : "") + month1 + "01");
            model.addAttribute("viewEndDepartId", year2 + (month2 < 10 ? "0" : "") + month2 + maxMonth2);

        }

        return "calendarSub";
    }


}
