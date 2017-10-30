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

    private int currentMonth;

    private int currentYear;

    private int currentDay;

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

    public int getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(int currentMonth) {
        this.currentMonth = currentMonth;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }
}
