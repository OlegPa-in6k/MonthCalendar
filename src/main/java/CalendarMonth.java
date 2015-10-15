import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 14.10.2015.
 */
public class CalendarMonth {


    private int currentDay;
    private java.time.Month currentMonth;
    private int currentYear;


    private List<CalendarWeek> weeksList = new ArrayList<CalendarWeek>();

    public CalendarMonth(){
        settodayDayAtrributes();
        moveOnTheFirstDayOfMonth();
        fillOneMonth();
    }





    private LocalDate localDate = LocalDate.now();

    private LocalDate workCalendar;

    public List<CalendarWeek> getWeeksList() {
        return weeksList;
    }



    private void fillOneMonth(){
        do {
            weeksList.add(new CalendarWeek(workCalendar));
            workCalendar = workCalendar.plusWeeks(1);
        } while (workCalendar.getMonth() == getCurrentMonth());

    }







    protected LocalDate moveOnTheFirstDayOfMonth(){
        workCalendar = localDate.minusDays(localDate.getDayOfMonth()-1);

        while(!isFirstDayOfWeek()){
           workCalendar= workCalendar.minusDays(1);
        }
        return workCalendar;
    }



    private boolean isFirstDayOfWeek() {
        return workCalendar.getDayOfWeek().equals(CalendarWeek.FIRST_DAY_OF_WEEK);
    }



    public void settodayDayAtrributes(){
        setCurrentDay();
        setCurrentMonth();
        setCurrentYear();
    }


    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay( ) {
        this.currentDay = localDate.getDayOfMonth();
    }

    public java.time.Month getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth() {
        this.currentMonth = localDate.getMonth();
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear() {
        this.currentYear = localDate.getYear();
    }





}
