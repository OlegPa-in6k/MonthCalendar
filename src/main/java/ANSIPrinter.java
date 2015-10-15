import java.io.PrintStream;
import java.time.format.TextStyle;
import java.util.Locale;
/**
 * Created by Oleg on 14.10.2015.
 */
public class ANSIPrinter extends AbstractPrinter {


    public static final String CODING_IDENTIFICATION = "ANSI";

    public ANSIPrinter(CalendarMonth month, PrintStream output) {
        super(month, output);
        color = new Colors(CODING_IDENTIFICATION);
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
                 textFormat, day.getDayOfMonth(), color.getDefaultColor());
    }



    @Override
    protected void printWeekdayName(CalendarDay day) {
        output.printf("%s%s ",
                textFormat, day.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.CANADA));
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




