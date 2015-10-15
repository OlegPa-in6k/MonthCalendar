import java.io.PrintStream;

/**
 * Created by Oleg on 14.10.2015.
 */
public abstract class AbstractPrinter {

    protected CalendarMonth calendarMonth;
    protected PrintStream output;

    protected String textColor;

    protected String defaultColor;
    protected String weekendColor;
    protected String fromOtherMonthColor;
    protected String currentDayColor;


    public AbstractPrinter(CalendarMonth calendarMonth, PrintStream output) {
        this.calendarMonth = calendarMonth;
        this.output = output;
    }


    public void printCalendar() {
        beginPrint();
        printTitle();
        printMonth();
        printWeekdayNames();
        printMonthDays();
        endPrint();
    }

    protected abstract void beginPrint();


    protected abstract void endPrint();

    protected void printWeekdayNames() {
        newLine();

        for (CalendarDay day : calendarMonth.getWeeksList().get(0).getDaysList()) {
            textColor = day.isWeekend() ? getWeekendColor() : getDefaultColor();

            printWeekdayName(day);
        }

        endWeek();
    }


    protected void printMonthDays() {
        for (CalendarWeek week : calendarMonth.getWeeksList()) {
            setDefaultColorFormat();

            printWeek(week);

            endWeek();
        }
    }

    private void printWeek(CalendarWeek week) {
        for (CalendarDay day : week.getDaysList()) {
            printDay(day);
        }
    }

    private void printDay(CalendarDay day) {
        setDayColor(day);

        printDayNumber(day);
    }

    private void setDayColor(CalendarDay day) {
        setDefaultColorFormat();

        if (day.isSameDate(calendarMonth.getCurrentDay(), calendarMonth.getCurrentMonth())) {
            textColor = getCurrentDayColor();
        }

        if (day.isWeekend()) {
            textColor = getWeekendColor();
        }

        if (!day.isInMonth(calendarMonth.getCurrentMonth())) {
            textColor = getFromOtherMonthColor();
        }
    }

    protected void setDefaultColorFormat() {
        textColor = getDefaultColor();


    }


    protected abstract void printDayNumber(CalendarDay day);


    protected abstract void printWeekdayName(CalendarDay day);

    protected abstract void printMonth();


    protected abstract void printTitle();

    protected abstract void newLine();

    protected abstract void endWeek();

    public  String getDefaultColor() {
        return defaultColor;
    }

    public String getWeekendColor() {
        return weekendColor;
    }

    public String getFromOtherMonthColor() {
        return fromOtherMonthColor;
    }

    public String getCurrentDayColor() {
        return currentDayColor;
    }


}
