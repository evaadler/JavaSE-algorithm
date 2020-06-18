package cleancode.old.serialdate;

import java.io.Serializable;
import java.util.Calendar;

/**
 * SerialDate
 *
 * @author Alicia
 * @description
 * @date 2020/6/17
 */
public abstract class SerialDate implements Comparable, Serializable{
    public static final int MONDAY = Calendar.MONDAY;
    public static final int TUESDAY = Calendar.TUESDAY;
    public static final int WEDNESDAY = Calendar.WEDNESDAY;
    public static final int THURSDAY = Calendar.THURSDAY;
    public static final int FRIDAY = Calendar.FRIDAY;
    public static final int SATURDAY = Calendar.SATURDAY;
    public static final int SUNDAY = Calendar.SUNDAY;

    public static final int SERIAL_LOWER_BOUND = 2;

    public static boolean isValidWeekdayCode(final int code) {
        switch (code) {
            case SUNDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
            case SATURDAY:
                return true;
            default:
                return false;
        }
    }
}
