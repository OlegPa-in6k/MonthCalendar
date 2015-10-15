import java.io.PrintStream;
import java.time.format.TextStyle;
import java.util.Locale;
/**
 * Created by Oleg on 14.10.2015.
 */
public class ANSIPrinter extends AbstractPrinter {


    private void setColors() {
        defaultColor = "\u001b[0m";
        weekendColor = "\u001b[31m";
        fromOtherMonthColor = "\u001b[34m";
        currentDayColor = "\u001B[32m";
    }

    public ANSIPrinter(CalendarMonth month, PrintStream output) {
        super(month, output);
        setColors();
    }

    @Override
    protected void beginPrint() {

    }

    @Override
    protected void endPrint() {
        output.print("(c)");
    }


    @Override
    protected void printDayNumber(CalendarDay day) {
        output.printf("%s%3d %s",
                textColor, day.getDayOfMonth(), getDefaultColor());
    }



    @Override
    protected void printWeekdayName(CalendarDay day) {
        output.printf("%s%s ",
                textColor, day.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.CANADA));
    }

    @Override
    protected void printMonth() {
        output.print(calendarMonth.getCurrentMonth());
    }

    @Override
    protected void printTitle() {
        output.println("Month Calendar");
    }

    @Override
    protected void newLine() {
        output.println();
    }

    @Override
    protected void endWeek() {
        output.println();
    }
}




