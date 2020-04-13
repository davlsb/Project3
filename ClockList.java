public abstract class ClockList {

    //Instance Variables for ClockList
    protected ClockNode first,last;
    protected int length;

    /**
     * Default constructor for a ClockList
     * Creates an empty list
     */
    public ClockList() {
        ClockNode node = new ClockNode();
        first = node;
        last = node;
        length = 0;
    }//ClockList Constructor

    /**
     * Adds a ClockNode to the ClockList
     * @param c a Clock object with a hours, minutes, and seconds
     */
    public void append(Clock c) {
        // create new ListNode with string d.
        ClockNode newNode= new ClockNode(c);
        last.next = newNode;
        last = newNode;
        length++;
    }//append


}//ClockList



