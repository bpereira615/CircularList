/********************************************************************
 * Benjamin Hoertnagl-Pereira bhoertn1 631-488-7197 bhoertn1@jhu.edu Lydia
 * Carroll lcarro12 240-994-8355 lcarro12@jhu.edu
 *
 * 600.226.02 CS226 Data Structures Project 1 - CircularList
 *
 * NOTE: this file was taken from the assignment page
 *******************************************************************/

public class CookingStation extends CList implements CookingStationInterface {
    /**
     * Name of the cooking station.
     */
    private String name;

    /**
     * Circular list of items at the station.
     */
    private CList<CookingItem> items;

    /**
     * Constructor for CookingStation.
     *
     * @param n name of station
     */
    public CookingStation(String n) {
        this.name = n;
        this.items = new CList<CookingItem>();
    }

    /**
     * Put a new dish at the end of the staStion.
     * 
     * @param it
     *            the dish to add
     */
    public void addItem(CookingItem it) {
        items.append(it);
    }

    /**
     * Simulate one minute time passing for this station.
     */
    public void tick() {
        //TODO: iterate through list and tick all of the items
        while(!(this.items.isAtEnd())){
            this.items.getValue().tick();
            this.items.next();
        }
    }

    /**
     * Tend the current item
     * 
     * @param removeThreshold
     *            the number of minutes that may be used to determine if an item
     *            should be removed from the station.
     * @param penaltyThreshold
     *            the limit on the penalty value that may be used to determine
     *            if an item should be removed from the station.
     * @return the item if you decide to remove it, or null otherwise
     */
    public CookingItem tend(int removeThreshold, int penaltyThreshold) {
        //TODO: thresholds??
        return null;
    }



    /**
     * Prints a list of the items in the station.
     *
     * @return the string form of item list
     */
    
    public String toString() {
        /*
        String str = this.name + "[ ";
        while(!items.isAtEnd()) {
            str += items.getValue().toString() + " ";
            items.next();
        }
        str += items.getValue().toString() + "]"; //the item in the list
        
        return str;
        */
        return this.name + items.toString();
    }
    
}
