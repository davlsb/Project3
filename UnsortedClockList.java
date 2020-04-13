public class UnsortedClockList extends ClockList{


    public UnsortedClockList() {
        // uses the constructor from the super class
        super();
    }

    /**
     * Adds a ClockNode to the list, but the list is unsorted
     * @param c a Clock object
     */
    public void add(Clock c) {
        append(c);
    }//add

}
