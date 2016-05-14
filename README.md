### Purpose
The goals of this assignment are to deepen your understanding of linked lists by implementing a variation of a doubly linked list, and to applying the List ADT to an application problem.

## Part A - Circular Doubly Linked List
Circular lists (CLists) are particularly useful in cases where there is a need to continuously visit list elements in a round-robin fashion, e.g. for allocating CPU time within an OS scheduler. Our goal for this project was to implement the class CList<E> which implements the interface List<E> using a circular doubly linked list implementation.The basic properties of this circular List implement include the following:

* The empty list is represented by a null list reference.
* A list with a single member would have the list reference to the single node (also the head and the tail), which would have next and prev references pointing to itself.
* A list with n nodes would look like a doubly linked list without sentinels, except the head and tail of the list would reference each other.

## Part B - Cutthroat Kitchen
You've been sabotaged! You are a contestant on Cutthroat Kitchen, and you have to cook while only spending a fixed amount of time at each station. We will use your circular queue to simulate this diabolical challenge.

To do this, you will need to be able to create multiple stations, each of which may have multiple dishes in process. For example, you might have a stove, an oven, and a grill, and each may have 3 items heating. Each item has to cook for a specific amount of time; if it's removed too early it's not fully cooked and the judges will penalize you; too long and it burns - that is even worse! But, you only get a certain amount of time to tend each station, so you can't watch everything!

***

	Benmin Hoertnagl-Pereira
	bhoertn1
	631-488-7197 
	bhoertn1@jhu.edu

	Lydia Carroll
	lcarrol2
	240-994-8355
	lcarrol2@jhu.edu

	600.226.02 CS226 Data Structures
	Project 1 - CircularList

	Files:
    List.java - a list interface, to be implemented using circular list
    CList.java - a circular, doubly linked list implementation
    CookingItemInterface.java - an interface for CookingItem
    CookingItem.java - represents an item at a given station
    CookingStationInterface.java - an interface for CookingStation
    CookingStation.java - represents a station in the kitchen
    SimDriver.java - a driver for Cutthroat Kitchen Sumulation

    infile.txt - input for simulation in text
    sim0.txt - simulation with removeThreshold = 0
    sim1.txt - simulation with removeThreshold = 1
    sim2.txt - simulation with removeThreshold = 2
    simP.txt - simulation with custom tend function

	Comments:
    Our total penalty output does not seem to match with the expected
    values posted on the course site, perhaps an issue of where the
    simulation begins in the list or an off by 1 tick error?

    To get the various simulation file outputs, one must uncomment the
    code preceeding the simulate() function in SimDriver.   

	NOTE:
    List, CookingItem, and CookingStation taken from course site
    CList.java adopted from DDList.java implementation on course site

***
