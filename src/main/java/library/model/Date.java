package library.model;

import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;


    public Date(int day, int month, int year) throws Exception {
        setDay(day);
        setMonth(month);
        this.year = year;
    }

    public void setDay(int day) throws Exception {
        if (day <= 30 && day > 0)
            this.day = day;
        else
            throw new Exception("your day invalid!");

    }

    public void setMonth(int month) throws Exception {
        if (month > 0 && month <= 12)
            this.month = month;
        else
            throw new Exception("your month invalid!");
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }
}
