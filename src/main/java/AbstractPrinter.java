import java.io.PrintStream;

/**
 * Created by Oleg on 14.10.2015.
 */
public abstract class AbstractPrinter {

    protected CalendarMonth calendarMonth;
    protected PrintStream output;
    Colors color;


    String textFormat;



    public AbstractPrinter(CalendarMonth calendarMonth, PrintStream output) {
        this.calendarMonth = calendarMonth;
        this.output = output;
    }


    public void printCalendar() {
        beginPrint();
        printTitle();
        printMonth();
        printWeekdayNames();
        printDayNumbers();
        endPrint();
    }

    protected abstract void beginPrint();


    protected abstract void endPrint();

    protected void printWeekdayNames() {
        newLine();

        for (CalendarDay day : calendarMonth.getWeeksList().get(0).getDaysList()) {
            if (day.isWeekend()) {
                textFormat = color.getWeekendColor();
            } else {
                textFormat = color.getDefaultColor();
            }

            printWeekdayName(day);
        }

        newLine();
    }





    protected void printDayNumbers() {
        for (CalendarWeek week : calendarMonth.getWeeksList()) {
            setDefaultColorFormat();

            for (CalendarDay day : week.getDaysList()) {
                setDefaultColorFormat();

                if (day.isSameDate(calendarMonth.getCurrentDay(), calendarMonth.getCurrentMonth())) {
                    textFormat = color.getCurrentDayColor();
                }

                if (day.isWeekend()) {
                    textFormat = color.getWeekendColor();
                }

                if (!day.isInMonth(calendarMonth.getCurrentMonth())) {
                    textFormat = color.getFromOtherMonthColor();
                }

                printDayNumber(day);
            }

            endWeek();
        }
    }

    protected void setDefaultColorFormat(){
        textFormat = color.getDefaultColor();
      //  backgroundFormat = color.getDefaultBackgroundFormat();

    }




    protected abstract void printDayNumber(CalendarDay day);




    protected abstract void printWeekdayName(CalendarDay day);

    protected abstract void printMonth();


    protected abstract void printTitle();

    protected abstract void newLine();

    protected abstract void endWeek();


}
