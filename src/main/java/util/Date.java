package util;

/**
 * equals method test Model
 * Created by fifi on 2017/5/16.
 */
public final class Date implements Comparable{
    private final int month = 0;
    private final int day = 0;
    private final int year = 0;

    @Override
    public int compareTo(Object o) {
        return 0;
    }



    /*
    public boolean compareTo(Object y) {
        if (y == this) return true;
        if (y == null) return false;

        if (y.getClass() != this.getClass()) return false;

        Date that = (Date)y;

        if (this.day != that.day) return false;
        if (this.year != that.year) return false;
        if (this.month != that.month) return  false;
        return true;
    }*/



}
