/********************************************************************
 * Benjamin Hoertnagl-Pereira bhoertn1 631-488-7197 bhoertn1@jhu.edu 
 * Lydia Carroll lcarro12 240-994-8355 lcarro12@jhu.edu
 *
 * 600.226.02 CS226 Data Structures Project 1 - CircularList
 *
 * NOTE: this file was taken from the assignment page.
 ******************************************************************/

/**
 * Interface for the CookingItem class.
 * 
 * @author Joanne Selinski
 *
 */
interface CookingItemInterface {
    /**
     * Implements a simulation of one minute of time for this item by
     * decrementing cooking time by one minute.
     */
    void tick();

    /**
     * Get the time remaining for cooking this dish.
     * 
     * @return the time in minutes
     */
    int timeRemaining();

    /**
     * Calculate the penalty if this dish were removed now.
     * 
     * @return the penalty
     */
    int penalty();
}
