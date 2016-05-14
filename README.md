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