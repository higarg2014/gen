package reports.generator.controller;

import io.swagger.models.auth.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reports.generator.model.CalendarElement;
import reports.generator.model.CalendarFare;

import java.util.*;

/**
 * Created by higarg on 11/1/17.
 */
@Controller
public class CalendarController {

    @RequestMapping("/calendar1")
    public String calendar(ModelMap model) {

        List<CalendarFare> data = new ArrayList<CalendarFare>();

        int day1 = 1, day2 = 1;
        int month1, month2;
        int year1, year2;
        int startMonth1, startMonth2;
        int maxMonth1, maxMonth2;
        int count = 0;
        int minDepartureId = 0;
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int maxCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int j = 0;
        if (currentDay == maxCurrentMonth) {
            j = currentDay + 1;
            count = count + 1;
            day1 = 1;
            day2 = 1;
        } else {
            j = currentDay + 1;
            day1 = currentDay;
            day2 = 1;

        }

        calendar.add(Calendar.MONTH, count);
        month1 = calendar.get(Calendar.MONTH) + 1;
        year1 = calendar.get(Calendar.YEAR);
        startMonth1 = calendar.get(Calendar.DAY_OF_WEEK);
        maxMonth1 = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);


        calendar.add(Calendar.MONTH,  1);
        month2 = calendar.get(Calendar.MONTH) + 1;
        year2 = calendar.get(Calendar.YEAR);
        startMonth2 = calendar.get(Calendar.DAY_OF_WEEK);
        maxMonth2 = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        minDepartureId = Integer.parseInt(year1 + (month1 < 10 ? "0" : "") + month1 + (j < 10 ? "0" : "") + j);


        CalendarFare fareCalendar = new CalendarFare();
        Map<String, CalendarElement> map = new HashMap<String, CalendarElement>();
        for (int i = day1 + 1; i <= maxMonth1; i++) {
            CalendarElement calendarElement = new CalendarElement();
            calendarElement.setCalValue("$" + new Random().nextInt(10000));
            calendarElement.setCalId(Integer.parseInt(year1 + (month1 < 10 ? "0" : "") + month1 + (i < 10 ? "0" : "") + i));
            map.put("cal" + i, calendarElement);
        }
        fareCalendar.setDataMap(map);
        fareCalendar.setCurrentMonth(true);
        fareCalendar.setDateString(day1 + "-" + month1 + "-" + year1);
        fareCalendar.setNumberOfDays(maxMonth1);
        fareCalendar.setStartDayOfMonth(startMonth1);
        data.add(fareCalendar);


        CalendarFare fareCalendar1 = new CalendarFare();
        Map<String, CalendarElement> map1 = new HashMap<String, CalendarElement>();
        for (int i = day2; i <= maxMonth2; i++) {
            CalendarElement calendarElement = new CalendarElement();
            calendarElement.setCalValue("$" + new Random().nextInt(10000));
            calendarElement.setCalId(Integer.parseInt(year2 + (month2 < 10 ? "0" : "") + month2 + (i < 10 ? "0" : "") + i));
            map1.put("cal" + i, calendarElement);
        }
        fareCalendar1.setDataMap(map1);
        fareCalendar1.setDateString(day2 + "-" + month2 + "-" + year2);
        fareCalendar1.setNumberOfDays(maxMonth2);
        fareCalendar1.setStartDayOfMonth(startMonth2);
        data.add(fareCalendar1);


        model.addAttribute("dataMap", data);
        model.addAttribute("minDepartureId", minDepartureId);


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
        System.out.println(startDate);
        if (count >= 0 && count < 6) {

            count = count * 2;
            List<CalendarFare> data = new ArrayList<CalendarFare>();

            int day1 = 1, day2 = 1;
            int month1, month2;
            int year1, year2;
            int startMonth1, startMonth2;
            int maxMonth1, maxMonth2;
            // int count=0;
            // int minDepartureId=0;
            Calendar calendar = Calendar.getInstance();
            int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
           // int maxCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            //calendar.set(Calendar.DAY_OF_MONTH, 1);

            /*int j = 0;
            if (currentDay == maxCurrentMonth) {
                j = currentDay + 1;
                count = count + 1;
                day1 = 1;
                day2 = 1;
            } else {
                j = currentDay + 1;
                day1 = currentDay;
                day2 = 1;

            }*/
           /* if(count==0){
                day1 = currentDay;
            }*/

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
            // minDepartureId=Integer.parseInt(year1 + (month1 < 10 ? "0" : "") + month1 + (j < 10 ? "0" : "") + j);
            String endDate=maxMonth2+"-"+month2+"-"+year2;

            System.out.println(endDate);

            CalendarFare fareCalendar = new CalendarFare();
            Map<String, CalendarElement> map = new HashMap<String, CalendarElement>();
            for (int i = day1 + 1; i <= maxMonth1; i++) {
                int nextId=Integer.parseInt(year1 + (month1 < 10 ? "0" : "") + month1 + (i < 10 ? "0" : "") + i);
                CalendarElement calendarElement = new CalendarElement();
                if(startId<=nextId) {
                    calendarElement.setCalValue("$" + new Random().nextInt(10000));
                }
                calendarElement.setCalId(nextId);
                map.put("cal" + i, calendarElement);
            }
            fareCalendar.setDataMap(map);
            fareCalendar.setCurrentMonth(true);
            fareCalendar.setDateString(day1 + "-" + month1 + "-" + year1);
            fareCalendar.setNumberOfDays(maxMonth1);
            fareCalendar.setStartDayOfMonth(startMonth1);
            data.add(fareCalendar);


            CalendarFare fareCalendar1 = new CalendarFare();
            Map<String, CalendarElement> map1 = new HashMap<String, CalendarElement>();
            for (int i = day2; i <= maxMonth2; i++) {
                int nextId=Integer.parseInt(year2 + (month2 < 10 ? "0" : "") + month2 + (i < 10 ? "0" : "") + i);
                CalendarElement calendarElement = new CalendarElement();
                if(startId<=nextId) {
                    calendarElement.setCalValue("$" + new Random().nextInt(10000));
                }
                calendarElement.setCalId(nextId);
                map1.put("cal" + i, calendarElement);
            }
            fareCalendar1.setDataMap(map1);
            fareCalendar1.setDateString(day2 + "-" + month2 + "-" + year2);
            fareCalendar1.setNumberOfDays(maxMonth2);
            fareCalendar1.setStartDayOfMonth(startMonth2);
            data.add(fareCalendar1);


            model.addAttribute("dataMap", data);


        }

        return "calendarSub";
    }
}
