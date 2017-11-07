package reports.generator.controller;

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
        int startId = 0;
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int maxCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        if (currentDay == maxCurrentMonth) {
            currentDay = 1;
            count = count + 1;
        } else {
            currentDay = currentDay + 1;
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

        startId = Integer.parseInt(year1 + (month1 < 10 ? "0" : "") + month1 + (currentDay < 10 ? "0" : "") + currentDay);


        CalendarFare fareCalendar = new CalendarFare();
        Map<String, CalendarElement> map = new HashMap<String, CalendarElement>();
        for (int i = 1; i <= maxMonth1; i++) {
            int nextId=Integer.parseInt(year1 + (month1 < 10 ? "0" : "") + month1 + (i < 10 ? "0" : "") + i);
            CalendarElement calendarElement = new CalendarElement();
            if(startId<nextId) {
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
            if(startId<nextId) {
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
        model.addAttribute("minDepartureId", startId);


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
        int x=0;
        if (count >= 0 && count < 6) {


            List<CalendarFare> data = new ArrayList<CalendarFare>();

            int day1 = 1, day2 = 1;
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

            System.out.println(endDate);

            CalendarFare fareCalendar = new CalendarFare();
            Map<String, CalendarElement> map = new HashMap<String, CalendarElement>();
            for (int i = 1; i <= maxMonth1; i++) {
                int nextId=Integer.parseInt(year1 + (month1 < 10 ? "0" : "") + month1 + (i < 10 ? "0" : "") + i);
                CalendarElement calendarElement = new CalendarElement();
                if(startId<nextId) {
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
            for (int i = 1; i <= maxMonth2; i++) {
                int nextId=Integer.parseInt(year2 + (month2 < 10 ? "0" : "") + month2 + (i < 10 ? "0" : "") + i);
                CalendarElement calendarElement = new CalendarElement();
                if(startId<nextId) {
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
