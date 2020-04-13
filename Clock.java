/**Class for Clock object
 *
 * @author David Slawotsky, section 12D
 * @version Project 1
 */
public class Clock {

    //the instance variables: hours, minutes, and seconds
    private int hours;   //the hours of the clock
    private int minutes; //the minutes of the clock
    private int seconds; //the seconds of the clock


    /** Constructor for the object Clock with 3 parameters
     *
     * @param hours    the hours of the clock object
     * @param minutes  the minutes of the clock object
     * @param seconds the seconds of the clock object
     */
    public Clock(int hours,int minutes,int seconds) throws IllegalClockException {
     
    	 if((hours>24||minutes>60||seconds>60)) throw new IllegalClockException ("No such clock");
    	 else {
    	  	this.hours=hours;
    	  	this.minutes=minutes;
    	  	this.seconds=seconds;
    	 }
    }

    /** Sets the hours of the clock instance
     *
     * @param hours the hours of the clock object
     */

    public void setHours(int hours) {
        this.hours=hours;
    }

    /** Sets the minutes of the clock instance
     *
     * @param minutes the minutes of the clock object
     */
    public void setMinutes(int minutes) {
        this.minutes=minutes;
    }

    /** Sets the seconds of the clock instance
     *
     * @param seconds the seconds of the clock object
     */
    public void setSeconds(int seconds) {
        this.seconds=seconds;
    }

    /** Returns the hours of the clock instance
     *
     * @return the hours of the clock
     */
    public int getHours() {
        return hours;
    }

    /** Returns the minutes of the clock instance
     *
     * @return the minutes of the clock
     */
    public int getMinutes() {
        return minutes;
    }
    /* Returns the seconds of the clock instance
     *
     * @return the seconds of the clock
     */
    public int getSeconds() {
        return seconds;
    }

    /** Returns a string in a clock form of hours:minutes:seconds/XX:XX:XX
     *
     * @return a string in a clock form of hours:minutes:seconds/XX:XX:XX
     */
    public String toString() {
        return (hours+":"+minutes+":"+seconds);

    }


}