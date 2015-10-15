/**
 * Created by Oleg on 14.10.2015.
 */
public class Colors {

    private String defaultColor;
    private String weekendColor;
    private String fromOtherMonthColor;
    private String currentDayColor;

    Colors(String format) {
        if (format.equals("ANSI")) {
            generateANSIFormats();
        } else if (format.equals("HTML")) {
            generateTEXTFormats();
        }
    }

    private void generateANSIFormats(){
        defaultColor = "\u001b[0m";
        weekendColor = "\u001b[31m";
        fromOtherMonthColor = "\u001b[34m";
        currentDayColor = "\u001B[32m";

    }

    private void generateTEXTFormats(){
        defaultColor = "black";
        weekendColor = "red";
        fromOtherMonthColor = "blue";
        currentDayColor = "Green";

    }

    public String getCurrentDayColor() {
        return currentDayColor;
    }

    public String getWeekendColor() {
        return weekendColor;
    }

    public String getDefaultColor() {
        return defaultColor;
    }

    public String getFromOtherMonthColor() {
        return fromOtherMonthColor;
    }


}
