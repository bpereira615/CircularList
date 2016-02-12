/********************************************************************
 * Benjamin Hoertnagl-Pereira bhoertn1 631-488-7197 bhoertn1@jhu.edu
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
 * 
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
        this.head = null; //new Node(null, null, null);
        this.curr = null; //this.head; // because insert will insert after curr
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
    		this.prev = this.head;
    		// also set next to current b/c only one node
    		this.next = this.head;
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
    		this.curr = this.head.prev; // move to the last node (preceding head)
    		this.insert(t); // code reuse!
    		this.curr = temp; // restore cursor to original position
    		this.size++;
    		return true;
    	}
    }

    /**
     * Remove current item and return it
     * Set cursor to next item (one to right of removed).
     * 
     * @return the value of the element removed, null if list is empty
     */
    public T remove() {
    	// do we have a tail?
    	// f this
        // if (this.curr.next == this.tail) {
        //    return null;
        //}
    	if (this.size == 0){
    		return null;
    	} else {
	        T val = this.curr.data;
	        this.curr.next.prev = this.curr.prev; // bypass node being deleted
	        this.curr.prev.next = this.curr.next; // bypass it in other direction
	        this.size--;
	        this.curr = this.curr.next; // set cursor to next node
	        return val;
    	}
    }

    /**
     * Return the current element (data to right of cursor).
     * 
     * @return the value of the current element, null if none
     */
    public T getValue() {
        if (this.curr.next == this.tail) {
            return null;
        }
        return this.curr.next.data;
    }

    /**
     * Return the number of elements in the list.
     * 
     * @return the length of the list
     */
    public int length() {
        return this.size;
    }

    /* ---------- METHODS BELOW THIS LINE ARE NOT IMPLEMENTED ------------ */

    /**
     * Set the current position to the start of the list.
     */
    public void moveToStart() {
    }

    /**
     * Set the current position to the end of the list.
     */
    public void moveToEnd() {
    }

    /**
     * Move the current position one step left, no change if already at
     * beginning.
     */
    public void prev() {
    }

    /**
     * Move the current position one step right, no change if already at end.
     */
    public void next() {
    }

    /**
     * Return the position of the current element.
     * 
     * @return the current position in the list
     */
    public int currPos() {
        // dummy implementation
        return 0;
    }

    /**
     * Set the current position.
     * 
     * @param pos
     *            the value to set the position to
     * @return true if successfully changed position, false otherwise
     */
    public boolean moveToPos(int pos) {
        // dummy implementation
        return false;
    }

    /**
     * Return true if current position is at end of the list.
     * 
     * @return true if the current position is the end of the list
     */
    public boolean isAtEnd() {
        // dummy implementation
        return false;
    }

}
