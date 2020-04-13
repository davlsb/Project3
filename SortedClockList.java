public class SortedClockList extends ClockList {

    public SortedClockList() {
        // uses the constructor from the super class
        super();
    }

    /**
     * Adds a ClockNode to the list in order, it's sorted
     * @param c a Clock object
     */
    public void add(Clock c) {

        ClockNode curNode=first;
        ClockNode nextNode=curNode.next;

        ClockNode temp = new ClockNode(c);

        while(nextNode!=null && nextNode.data.getHours()<c.getHours()) {  /*goes through the list and if the clock in the current node is smaller than
                                                                           the next one, move to the next node*/
            curNode=curNode.next;
            nextNode=nextNode.next;
        }
        temp.next=nextNode;
        curNode.next=temp; //adds the new clock node to the list
        length++;
    }

}

