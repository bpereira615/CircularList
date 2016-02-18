/********************************************************************
 * Benjamin Hoertnagl-Pereira bhoertn1 631-488-7197 bhoertn1@jhu.edu 
 * Lydia Carroll lcarro12 240-994-8355 lcarro12@jhu.edu
 *
 * 600.226.02 CS226 Data Structures Project 1 - CircularList
 *
 * NOTE: this file was taken from the assignment page
 *******************************************************************/

public class CookingStation extends CList<CookingItem> implements CookingStationInterface {
    /**
     * Name of the cooking station.
     */
    private String name;


    /**
     * Constructor for CookingStation.
     *
     * @param n name of station
     */
    public CookingStation(String n) {
        this.name = n;
        this.clear();
    }

    /**
     * Put a new dish at the end of the staStion.
     * 
     * @param it
     *            the dish to add
     */
    public void addItem(CookingItem it) {
        this.append(it);
    }

    /**
     * Simulate one minute time passing for this station.
     */
    public void tick() {
        //TODO: iterate through list and tick all of the items
        // this will likely happen at the interface level b/c need to iterate
        // through each station

        //TODO: this is an issue
        if (this.length() == 0){
            return;
        }

        int index = this.currPos();

        this.moveToStart();
        while(!(this.isAtEnd())){
            this.getValue().tick(); // I don't think this line has meaning
            this.next();
        }
        this.getValue().tick();

        this.moveToPos(index);
    }

    /**
     * Tend the current item (original version) 
     * 
     * @param removeThreshold
     *            the number of minutes that may be used to determine if an item
     *            should be removed from the station.
     * @param penaltyThreshold
     *            the limit on the penalty value that may be used to determine
     *            if an item should be removed from the station. 
     *           
     * @return the item if you decide to remove it, or null otherwise
     */
    public CookingItem tend(int removeThreshold, int penaltyThreshold) {
   
        // not sure how to select which threshold to use
        // check how much time is left in the current item
        
        // take item off stove to check it
        CookingItem temp = this.getValue();
        
        // zero case, don't return anything if nothing in station
        if (temp == null) {
            return null;
        }
       
        // if item's remaining time is too low, return it
        if (temp.timeRemaining() <= removeThreshold){
            this.remove();
            return temp;
        // if it needs more time, put it back on stove   
        } else {
            this.circularNext();
            return null;
        }
       
    }



    /**
     * Tend the current item (our version) 
     * 
     * @param removeThreshold
     *            the number of minutes that may be used to determine if an item
     *            should be removed from the station.
     * @param penaltyThreshold
     *            the limit on the penalty value that may be used to determine
     *            if an item should be removed from the station. If this value
     *            if non-negative, it will be used to determine when items are 
     *            removed.  
     * @param numItems
     *            number of items currently in the list
     *            ie number of dishes in all stations 
     * @return the item if you decide to remove it, or null otherwise
     */

    /*
    public CookingItem tend(int removeThreshold, int penaltyThreshold, int numItems) {
        //TODO: thresholds??
        // not sure how to select which threshold to use
        // check how much time is left in the current item
        
        // take item off stove to check it
        CookingItem temp = this.getValue();
        
        // zero case, don't return anything if nothing in station
        if (temp == null) {
            return null;
        }
        // if we're using penaltyThreshold, run through those calculations
        if (penaltyThreshold >= 0) {
            // find current penalties
            int nowPen = temp.penalty();
            // find penalties after one full rotation through all stations/items
            int nextPen = temp.penalty(numItems);
            // take item off if nowPen < nextPen
            if (nowPen <= nextPen){
                this.remove();
                return temp;
            } else {
                this.circularNext();
                return null;
            }
        } else {
        // use time threshold
        
            // if item's remaining time is too low, return it
            if (temp.timeRemaining() <= removeThreshold){
                this.remove();
                return temp;
            // if it needs more time, put it back on stove   
            } else {
                this.circularNext();
                return null;
            }
        }
    }
    */



    /**
     * Prints a list of the items in the station.
     *
     * @return the string form of item list
     */
    
    public String toString() {
        return this.name + super.toString();
    }
    
}
