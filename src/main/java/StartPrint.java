import java.io.PrintStream;
/**
 * Created by Oleg on 14.10.2015.
 */
public class StartPrint {
    public static void main(String[] args) {


        CalendarMonth month = new CalendarMonth();

        AbstractPrinter printer = new HTMLCodePrinter(month, new PrintStream(System.out));

        printer.printCalendar();

    }


}
