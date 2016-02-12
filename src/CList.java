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
     */
    public void clear() {
        this.size = 0;
        this.head = null; // new Node(null, null, null);
        this.curr = null; // this.head; // because insert will insert after curr
    }

    /**
     * Insert a value at (after) the current location. The client must ensure
     * that the list's capacity is not exceeded.
     * 
     * @param t
     *            the value to insert
     * @return true if successfully inserted, false otherwise
     */
    public boolean insert(T t) {
        if (this.size == 0) {
            // need to make an initial node
            this.head = new Node(t, null, null);
            // set prev to current node, aka head
            this.head.prev = this.head;
            // also set next to current b/c only one node
            this.head.next = this.head;
            this.size++;
            this.curr = this.head;
            return true;
        } else {
            Node n = new Node(t, this.curr, this.curr.next);
            n.prev.next = n; // connect left neighbor
            n.next.prev = n; // connect right neighbor
            this.size++;
            this.curr = n; // move cursor
            return true;
        }
    }

    /**
     * Append a value at the end of the list. The client must ensure that the
     * list's capacity is not exceeded.
     * 
     * @param t
     *            the value to append
     * @return true if successfully appended, false otherwise
     */
    public boolean append(T t) {
        if (this.size == 0) {
            this.insert(t); // already built zero case into insert
            this.size++;
            return true;
        } else {
            Node temp = this.curr; // hold onto original position
            this.curr = this.head.prev; // move to the last node (preceding
                                        // head)
            this.insert(t); // code reuse!
            this.curr = temp; // restore cursor to original position
            this.size++;
            return true;
        }
    }

    /**
     * Remove current item and return it Set cursor to next item (one to right
     * of removed).
     * 
     * @return the value of the element removed, null if list is empty
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
            this.curr.prev.next = this.curr.next; // bypass it in other
                                                  // direction
            this.size--;
            this.curr = this.curr.next; // set cursor to next node
            return val;
        }
    }

    /**
     * Return the current element.
     * 
     * @return the value of the current element, null if none
     */
    public T getValue() {
        if (this.size == 0) {
            // TODO: error statement to be added
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
     * Return the position of the current element.
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
            this.curr = this.curr.next;
        }

        return position;
    }

    /**
     * Set the current position, indexing from 0.
     * 
     * @param pos
     *            the value to set the position to
     * @return true if successfully changed position, false otherwise
     */
    public boolean moveToPos(int pos) {
        // TODO: return false case?

        this.moveToStart(); // code reuse!

        for (int i = 0; i < pos; i++) {
            // move the cursor to next position
            this.next(); // code reuse
        }

        return true;
    }

    /**
     * Return true if current position is at end of the list.
     * 
     * @return true if the current position is the end of the list
     */
    public boolean isAtEnd() {
        return (this.curr == this.head.prev);
    }
    /* ---------- METHODS BELOW THIS LINE ARE NOT IMPLEMENTED ------------ */
}
