import java.io.*;
import java.time.format.TextStyle;
import java.util.Locale;/**
 * Created by Oleg on 14.10.2015.
 */
public class HTMLCodePrinter extends AbstractPrinter{
    public static final String HTML_CODE = "HTML";
    public HTMLCodePrinter(CalendarMonth month, PrintStream output) {
        super(month, output);
        color = new Colors(HTML_CODE);
    }

    @Override
    protected void beginPrint() {
        output.print("<!doctype html> \n" +
                "<html lang=\"en\"> \n" +
                "<head> \n" +
                "<meta charset=\"UTF-8\"> \n" +
                "<title></title> \n" +
                "</head> \n" +
                "<body> <table align=\"center\" border=\"0\">\n<tr>\n" );
    }

    @Override
    protected void endPrint() {
        output.print("\n</table> </body> </html>" );
    }





    @Override
    protected void printDayNumber(CalendarDay day) {
        output.printf("<td align=\"right\"  style=\"border-radius:5px\"><font color=\"%s\">%s </font></td>\n",
                 textFormat, day.getDayOfMonth());
    }


    @Override
    protected void printWeekdayName(CalendarDay day) {
        output.printf("<td align=\"right\"><font color=\"%s\">%s</font></td>\n",
                textFormat, day.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.CANADA));
    }

    @Override
    protected void printMonth() {
        output.printf("<th colspan=\\\"%s\\\"><h1 align = \"center\">%s %s</h1></th></tr>\n",
                calendarMonth.getWeeksList().get(0).getDaysList().size(), calendarMonth.getCurrentMonth(), calendarMonth.getCurrentYear());
    }

    @Override
    protected void printTitle() {

    }

    @Override
    protected void newLine() {
        output.print("<tr>");
    }

    @Override
    protected void endWeek() {
        output.print("</tr>\n");
    }
}
