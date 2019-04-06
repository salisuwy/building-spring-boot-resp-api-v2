package berkholtz.advancedjava.util;

/**
 * An enumeration that represents a of unit of time
 */
public enum Interval {

    MINUTE(1), HOUR(60), DAY(60 * 24);

    private int minutes;

    /**
     * Create a new  Interval enumeration.
     * @param minutes the number of minutes in the interval
     */
    private Interval(int minutes) {
        this.minutes = minutes;
    }

    /**
     *
     * @return the number of minutes in the interval
     */
    public int getMinutes() {
        return minutes;
    }
}
