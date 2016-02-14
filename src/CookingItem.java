/********************************************************************
 * Benjamin Hoertnagl-Pereira bhoertn1 631-488-7197 bhoertn1@jhu.edu Lydia
 * Carroll lcarro12 240-994-8355 lcarro12@jhu.edu
 *
 * 600.226.02 CS226 Data Structures Project 1 - CircularList
 *
 * NOTE: this file was taken from the assignment page
 *******************************************************************/

public class CookingItem implements CookingItemInterface {
    /**
     * Name of the cooking item.
     */
    private String name;


    /**
     * Cooking time of the item.
     */
    private int time;

    /**
     * Last time checked for given item.
     */
    private int lastChecked;

    /**
     * Penalty per minute for overdone and underdone.
     */
    private int penaltyPerMin;


    /**
     * Constructor for the CookingItem class
     *
     * @param n name of the item
     * @param t time needed to cook
     *
    public CookingItem(String n, int t, ) {

    }

    /**
     * Implements a simulation of one minute of time for this item by
     * decrementing cooking time by one minute.
     */
    public void tick() {
        this.lastChecked++;
    }

    /**
     * Get the time remaining for cooking this dish.
     * Negative time remaining indicates over-cooked.
     * 
     * @return the time in minutes
     */
    public int timeRemaining() {
        return this.time - this.lastChecked;
    }

    /**
     * Calculate the penalty if this dish were removed now.
     * 
     * @return the penalty
     */
    public int penalty() {
        // TODO: Math.abs import
        // TODO: this.timeRemaining() or without this
        return Math.abs(this.timeRemaining()) * this.penaltyPerMin;
    }

   
}
