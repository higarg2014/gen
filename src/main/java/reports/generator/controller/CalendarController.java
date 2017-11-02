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

        List<CalendarFare> data=new ArrayList<CalendarFare>();

        Calendar calendar=Calendar.getInstance();

        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH)+1;
        int currentYear = calendar.get(Calendar.YEAR);
        int startCurrentMonth=calendar.get(Calendar.DAY_OF_WEEK);
        int maxCurrentMonth =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendar.add(Calendar.MONTH,1);

        int nextDay = calendar.get(Calendar.DAY_OF_MONTH);
        int nextMonth = calendar.get(Calendar.MONTH)+1;
        int nextYear = calendar.get(Calendar.YEAR);
        int startNextMonth=calendar.get(Calendar.DAY_OF_WEEK);
        int maxNextMonth =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);



        CalendarFare fareCalendar=new CalendarFare();

        Map<String,CalendarElement> map=new HashMap<String,CalendarElement>();

        for(int i=1;i<=maxCurrentMonth;i++) {
            CalendarElement calendarElement = new CalendarElement();
            //calendarElement.setCalValue("$"+i+100);


            /*if(i>=currentDay) {
                calendarElement.setCalValue("$" +new Random().nextInt(10000));
                calendarElement.setContent(true);
                if(i==currentDay+1){
                    calendarElement.setCalClass("active");
                }

            }
            else{
                calendarElement.setContent(false);
                calendarElement.setCalClass("disabled");
            }*/
            calendarElement.setCalValue("$" +new Random().nextInt(10000));
            calendarElement.setCalId(Integer.parseInt(currentYear+(currentMonth<10?"0":"")+currentMonth+(i<10?"0":"")+i));
            map.put("cal"+i,calendarElement);
        }

        //model.addAttribute("startMonthId",currentYear+(currentMonth<10?"0":"")+currentMonth+"01");
        fareCalendar.setDataMap(map);
        fareCalendar.setCurrentMonth(true);
        fareCalendar.setDateString(currentDay+"-"+currentMonth+"-"+currentYear);
        fareCalendar.setNumberOfDays(maxCurrentMonth);
        fareCalendar.setStartDayOfMonth(startCurrentMonth);


        data.add(fareCalendar);

        CalendarFare fareCalendar1=new CalendarFare();

        Map<String,CalendarElement> map1=new HashMap<String,CalendarElement>();

        for(int i=1;i<=maxNextMonth;i++) {
            CalendarElement calendarElement = new CalendarElement();
            calendarElement.setCalValue("$" +new Random().nextInt(10000));
            calendarElement.setCalId(Integer.parseInt(nextYear+(nextMonth<10?"0":"")+nextMonth+(i<10?"0":"")+i));
            map1.put("cal"+i,calendarElement);
        }


        fareCalendar1.setDataMap(map1);

        fareCalendar1.setDateString(nextDay+"-"+nextMonth+"-"+nextYear);
        fareCalendar1.setNumberOfDays(maxNextMonth);
        fareCalendar1.setStartDayOfMonth(startNextMonth);

        data.add(fareCalendar1);

        model.addAttribute("dataMap",data);




        return "calendar";
    }

    @RequestMapping("/ajax")
    public String helloAjaxTest(ModelMap model, @RequestParam("count") int count ) {

if(count>=0 && count<6) {
    count = count * 2;

    List<CalendarFare> data = new ArrayList<CalendarFare>();

    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, count);

    int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
    int currentMonth = calendar.get(Calendar.MONTH) + 1;
    int currentYear = calendar.get(Calendar.YEAR);
    int startCurrentMonth = calendar.get(Calendar.DAY_OF_WEEK);
    int maxCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    calendar.add(Calendar.MONTH, 1);

    int nextDay = calendar.get(Calendar.DAY_OF_MONTH);
    int nextMonth = calendar.get(Calendar.MONTH) + 1;
    int nextYear = calendar.get(Calendar.YEAR);
    int startNextMonth = calendar.get(Calendar.DAY_OF_WEEK);
    int maxNextMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);


    CalendarFare fareCalendar = new CalendarFare();

    Map<String, CalendarElement> map = new HashMap<String, CalendarElement>();

    for (int i = 1; i <= maxCurrentMonth; i++) {
        CalendarElement calendarElement = new CalendarElement();
        //calendarElement.setCalValue("$"+i+100);


   /*     if (i >= currentDay) {
            calendarElement.setCalValue("$" +new Random().nextInt(10000));
            calendarElement.setContent(true);
            if (i == currentDay + 1) {
                calendarElement.setCalClass("active");
            }

        } else {
            calendarElement.setContent(false);
            calendarElement.setCalClass("disabled");
        }*/
        calendarElement.setCalValue("$" +new Random().nextInt(10000));
        calendarElement.setCalId(Integer.parseInt(currentYear+(currentMonth<10?"0":"")+currentMonth+(i<10?"0":"")+i));
        map.put("cal" + i, calendarElement);
    }

    fareCalendar.setDataMap(map);
    fareCalendar.setCurrentMonth(true);
    fareCalendar.setDateString(currentDay + "-" + currentMonth + "-" + currentYear);
    fareCalendar.setNumberOfDays(maxCurrentMonth);
    fareCalendar.setStartDayOfMonth(startCurrentMonth);


    data.add(fareCalendar);

    CalendarFare fareCalendar1 = new CalendarFare();

    Map<String, CalendarElement> map1 = new HashMap<String, CalendarElement>();

    for (int i = 1; i <= maxNextMonth; i++) {
        CalendarElement calendarElement = new CalendarElement();
        calendarElement.setCalValue("$" +new Random().nextInt(10000));
        calendarElement.setCalId(Integer.parseInt(nextYear+(nextMonth<10?"0":"")+nextMonth+(i<10?"0":"")+i));

        map1.put("cal" + i, calendarElement);
    }


    fareCalendar1.setDataMap(map1);

    fareCalendar1.setDateString(nextDay + "-" + nextMonth + "-" + nextYear);
    fareCalendar1.setNumberOfDays(maxNextMonth);
    fareCalendar1.setStartDayOfMonth(startNextMonth);

    data.add(fareCalendar1);

    model.addAttribute("dataMap", data);


}

        return "calendarSub";
    }
}