package reports.generator.model;

import java.util.Map;

/**
 * Created by higarg on 10/26/17.
 */
public class FareCalendar {

    private int year;

    private int month;

    private int numberOfDays;

    private int dayOfMonth;

    private Map<String,CalendarElement> dataMap;

    public Map<String, CalendarElement> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, CalendarElement> dataMap) {
        this.dataMap = dataMap;
    }



    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
}
