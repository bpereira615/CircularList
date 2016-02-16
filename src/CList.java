/********************************************************************
 * Benjamin Hoertnagl-Pereira bhoertn1 631-488-7197 bhoertn1@jhu.edu
 * Lydia Carroll lcarro12 240-994-8355 lcarro12@jhu.edu
 *
 * 600.226.02 CS226 Data Structures
 * Project 1 - CircularList
 *
 * NOTE: this file was taken from the assignment page
 *******************************************************************/

/**
 * Edited Doubly Linked List implementation of the List interface. Variation of
 * Circular, Doubly Linked List.
 *
 * @author Joanne Selinski
 * @author Benjamin Hoertnagl-Pereira
 * @author Lydia Carrol
 * @param <T>
 *            the type of the List
 */
public class CList<T> implements List<T> {

    /**
     * Inner doubly linked Node class for convenience. Note that the generic
     * type is implied since we are within DLList<T>.
     */
    public class Node {

        /** The data in the element. */
        private T data;
        /** The left neighbor node. */
        private Node prev;
        /** The right neighbor node. */
        private Node next;

        /**
         * Constructor for the Node class.
         * 
         * @param item
         *            the data to put in it
         * @param p
         *            the link to the previous node
         * @param n
         *            the link to the next node
         */
        public Node(T item, Node p, Node n) {
            this.data = item;
            this.prev = p;
            this.next = n;
        }
    }

    /** Head node of list. */
    private Node head;
    /** Number of actual data nodes in list. */
    private int size;
    /** Current node (think of as a cursor between nodes). */
    private Node curr;

    /**
     * Create an empty list with a null head pointer.
     */
    public CList() {
        this.clear(); // code reuse!
    }

    /**
     * Remove all contents from the list, so it is once again empty.
     * Cursor should be at position 0.
     */
    public void clear() {
        this.moveToStart(); // need cursor at 0 position
        // trying different sizes for null case, 0 doesn't work
        this.size = 0;
        //this.currPos = 0;
        this.head = null; // new Node(null, null, null); // new Node(null, null, null);
        this.curr = this.head; // this.head; // because insert will insert after curr
        //TODO: is tail required?
    }

    /**
     * Insert a value at the current position. The cursor should
     * remain at that position, meaning that the new value is the
     * current one (would be returned by getValue).  The client must
     * ensure that the list's capacity is not exceeded.
     *
     * @param t the value to insert
     * 
     * @return true if successfully inserted, false otherwise
     */
    public boolean insert(T t) {
        //TODO: adjust this.size when we figure out null case
        if (this.size == 0) {
            // need to make an initial node
            this.head = new Node(t, null, null);
            // set prev to current node, aka head
            this.head.prev = this.head;
            // also set next to current b/c only one node
            this.head.next = this.head;

            //TODO: use tail node as well?
            //TODO: retunr false cases?
            
            this.size = 1;
            this.curr = this.head;
            return true;


        } else {
            int pos = this.currPos();
            Node next = this.curr;
            this.circularPrev();   

            Node n = new Node(t, this.curr, next);
            n.prev.next = n;
            n.next.prev = n;


            this.size++;
            this.curr = n;
            if (pos == 0) {
                this.head = n;
            }
            return true;
        }

    }

    /**
     * Append a value at the end of the list. Cursor does not move.
     * The client must ensure that the list's capacity is not exceeded.
     *
     * @param t the value to append
     *
     * @return true if successfully appended, false otherwise
     */
    public boolean append(T t) {
        //TODO: return false case?
        if (this.size == 0) {
            return this.insert(t); // already built zero case into insert
        } else {
            Node temp = this.curr; // hold onto original position
            moveToEnd(); //code reuse
           // prev();
            Node n = new Node(t, this.curr, this.head);
            n.prev.next = n;
            n.next.prev = n;
            this.curr = temp; // restore cursor to original position
            this.size++;
            return true;
        }
    }

    /**
     * Remove and return the current element. Cursor does not move,
     * unless the last element was removed.  In that case the cursor
     * should be reset to the beginning of the list.
     *
     * @return the value of the element removed, or null if there was
     * no current element.
     */
    public T remove() {
        // do we have a tail?
        // f this
        // if (this.curr.next == this.tail) {
        // return null;
        // }
        if (this.size == 0) {
            return null;
        } else {
            T val = this.curr.data;
            this.curr.next.prev = this.curr.prev; // bypass node being deleted
            this.curr.prev.next = this.curr.next; // bypass it in other direction
            this.size--;

            if(this.curr == this.head.prev) {
                this.curr = this.head; // set cursor to head if curr last element
            } else if (this.curr == this.head){
                this.head = this.curr.next; //corner case for removing head
                this.curr = this.head;
            } else {
                this.curr = this.curr.next; // set cursor to next node
            }
            return val;
        }
    }

    /**
     * Return the data in the current element.
     *
     * @return the value of the current element, null if there isn't one.
     */
    public T getValue() {
        if (this.size == 0) {
            // TODO: error statement to be added
            //TODO: is this even needed? May just return null
            return null;
        }
        return this.curr.data;
    }

    /**
     * Return the number of elements in the list.
     * 
     * @return the length of the list
     */
    public int length() {
        return this.size;
    }

    /**
     * Set the current position to the start of the list.
     */
    public void moveToStart() {
        this.curr = this.head;
    }

    /**
     * Set the current position to the end of the list.
     */
    public void moveToEnd() {
        this.curr = this.head.prev;
    }

    /**
     * Move the current position one step left, no change if already at
     * beginning.
     */
    public void prev() {
        // TODO: check if this is faulty in comparison operation
        if (this.curr != this.head) {
            this.curr = this.curr.prev;
        } else {
            System.out.println("ERROR: At head of list!");
        }
    }

    /**
     * Move the current position one step right, no change if already at end.
     */
    public void next() {
        // TODO: what is defined as end
        if (this.curr != this.head.prev) {
            this.curr = this.curr.next;
        } else {
            System.out.println("ERROR: At end of list!");
        }
    }

    /**
     * Return the position of the current element. (1st element is at
     * position 0, 2nd at position 1, etc.)
     *
     * @return the current position in the list
     */
    public int currPos() {
        // at the head
        int position = 0;

        // temporary variable for current position
        Node temp = this.curr;
        this.moveToStart(); // code reuse!

        // iterate through list until current node matches original current node
        while (this.curr != temp) {
            position++;
            this.next();
        }

        return position;
    }

    /**
     * Set the current position, indexing from 0.
     *
     * @param pos the value to set the position to, 0 through
     * length()-1 inclusive are valid values
     *
     * @return true if successfully changed position, false otherwise
     */
    public boolean moveToPos(int pos) {
        //return false if position is less than 0 or greather than list length - 1        
        if(pos < 0 || pos > (this.size - 1)) {
            return false;
        }
        this.moveToStart(); // code reuse!

        for (int i = 0; i < pos; i++) {
            // move the cursor to next position
            this.next(); // code reuse
        }

        return true;
    }

    /**
     * Return true if current position is at the end of the list,
     * meaning at the last node.
     *
     * @return true if the current position is the last node, false
     * otherwise
     */
    public boolean isAtEnd() {
        return (this.curr == this.head.prev);
    }



    /**
     * Prints the contents of the list.
     *
     * @return contents of list as a String
     */
    public String toString() {
        //TODO: check

        if(this.size == 0) {
            return "ERROR: List is empty!";
        }
        String str = "[ ";

        Node temp = this.curr;  // temporarily save position of curr
        this.moveToStart();

        while (!(this.isAtEnd())) {
            str += this.curr.data.toString() + " ";
            this.next();
        }
        str += this.curr.data.toString() + " ]";

        this.curr = temp;   // move cursor back to original position

        return str;
    }

    /**
     * Moves the cursor to previous node, regardless of if at head or not
     */
    private void circularPrev() {
        this.curr = this.curr.prev;
    }

    /**
     * Moves the cursor to next node, regardless of if at tail or not
     */
    private void circularNext() {
        this.curr = this.curr.next;
    }
}
