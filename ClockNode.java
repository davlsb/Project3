public class ClockNode {

    protected Clock data;
    protected ClockNode next;

    /**
     * One-argument constructor that creates a ClockNode, which stores
     * a Clock object and the location of the next ClockNode
     * @param c a Clock object with a hour, minute, and seconds
     */
    public ClockNode(Clock c) {
        data=c;
        next=null;
    }//ClockNode Constructor

    public ClockNode() {
        data=null;
        next=null;
    }//ClockNode Constructor

}//ClockNode

