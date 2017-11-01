package reports.generator.model;

import java.util.Map;

/**
 * Created by higarg on 11/1/17.
 */
public class CalendarFare {
    private int day;

    private int year;

    private int month;

    private int numberOfDays;

    private int startDayOfMonth;

    private String dateString;

    private boolean currentMonth;

    private Map<String,CalendarElement> dataMap;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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

    public int getStartDayOfMonth() {
        return startDayOfMonth;
    }

    public void setStartDayOfMonth(int startDayOfMonth) {
        this.startDayOfMonth = startDayOfMonth;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public boolean isCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(boolean currentMonth) {
        this.currentMonth = currentMonth;
    }

    public Map<String, CalendarElement> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, CalendarElement> dataMap) {
        this.dataMap = dataMap;
    }
}
