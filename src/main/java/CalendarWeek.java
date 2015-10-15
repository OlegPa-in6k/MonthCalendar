import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 14.10.2015.
 */
public class CalendarWeek {
    public static final DayOfWeek FIRST_DAY_OF_WEEK = DayOfWeek.MONDAY;
    private LocalDate weekCalendar;
    private List<CalendarDay> daysList = new ArrayList<CalendarDay>();


    public CalendarWeek(LocalDate firstDayOfWeek) {
        this.weekCalendar = firstDayOfWeek;
        fillWeek(firstDayOfWeek);
    }


    public List<CalendarDay> getDaysList() {
        return daysList;
    }



    public void fillWeek(LocalDate weekCalendar) {
        do {
            daysList.add(new CalendarDay(weekCalendar));
            weekCalendar = weekCalendar.plusDays(1);
        } while (!weekCalendar.getDayOfWeek().equals(FIRST_DAY_OF_WEEK));
    }


}
