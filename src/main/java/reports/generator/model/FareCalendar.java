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


    private int departDay;

    private int departMonth;

    private int departYear;


    private int returnDay;

    private int returnMonth;

    private int returnYear;



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

    public int getDepartDay() {
        return departDay;
    }

    public void setDepartDay(int departDay) {
        this.departDay = departDay;
    }

    public int getDepartMonth() {
        return departMonth;
    }

    public void setDepartMonth(int departMonth) {
        this.departMonth = departMonth;
    }

    public int getDepartYear() {
        return departYear;
    }

    public void setDepartYear(int departYear) {
        this.departYear = departYear;
    }

    public int getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(int returnDay) {
        this.returnDay = returnDay;
    }

    public int getReturnMonth() {
        return returnMonth;
    }

    public void setReturnMonth(int returnMonth) {
        this.returnMonth = returnMonth;
    }

    public int getReturnYear() {
        return returnYear;
    }

    public void setReturnYear(int returnYear) {
        this.returnYear = returnYear;
    }
}
