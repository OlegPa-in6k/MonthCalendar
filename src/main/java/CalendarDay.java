import java.time.*;
import java.time.Month;

/**
 * Created by Oleg on 14.10.2015.
 */
public class CalendarDay {

    private int dayOfMonth;
    private DayOfWeek dayOfWeek;
    private java.time.Month monthValue;


    public CalendarDay(LocalDate workCalendar){
        this.dayOfMonth = workCalendar.getDayOfMonth();
        this.dayOfWeek = workCalendar.getDayOfWeek();
        this.monthValue = workCalendar.getMonth();
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public Month getMonthValue() {
        return monthValue;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isWeekend(){
        return getDayOfWeek().equals(DayOfWeek.SUNDAY) || getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }
    public boolean isInMonth(java.time.Month monthValue){
        return getMonthValue() == monthValue;
    }

    public boolean isSameDate(int dayOfMonth, java.time.Month monthValue ) {
        return (getDayOfMonth() == dayOfMonth )&& (getMonthValue() == monthValue);
    }



}
