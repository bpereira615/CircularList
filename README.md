### Purpose
The goals of this assignment are to deepen your understanding of linked lists by implementing a variation of a doubly linked list, and to applying the List ADT to an application problem.

## Part A - Circular Doubly Linked List
In class, we discussed the use of a doubly linked list to implement a List data structure. The idea was to have two sentinels that maintained the list "between them." A variant on this is the so-called circular (doubly linked) list where the beginning (head) and end (tail) are connected, but there are no sentinel nodes anywhere. Circular lists (CLists) are particularly useful in cases where there is a need to continuously visit list elements in a round-robin fashion, e.g. for allocating CPU time within an OS scheduler. Here are the basic properties of a circular List:

* The empty list is represented by a null list reference.
* A list with a single member would have the list reference to the single node (also the head and the tail), which would have next and prev references pointing to itself.
* A list with n nodes would look like a doubly linked list without sentinels, except the head and tail of the list would reference each other.

You job is to implement the class CList<E> which implements the interface List<E> (from the text) using a circular doubly linked list implementation. You may find it convenient to modify the doubly linked list class in the book or use this partial implementation as a starting point.

## Part B - Cutthroat Kitchen
You've been sabotaged! You are a contestant on Cutthroat Kitchen, and you have to cook while only spending a fixed amount of time at each station. We will use your circular queue to simulate this diabolical challenge.

To do this, you will need to be able to create multiple stations, each of which may have multiple dishes in process. For example, you might have a stove, an oven, and a grill, and each may have 3 items heating. Each item has to cook for a specific amount of time; if it's removed too early it's not fully cooked and the judges will penalize you; too long and it burns - that is even worse! But, you only get a certain amount of time to tend each station, so you can't watch everything!