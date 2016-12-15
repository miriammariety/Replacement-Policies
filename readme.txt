DATA STRUCTURES USED:
LinkedList
List
Array

WHAT IS A PAGE FAULT? 
A page fault happens when the alloted frame has no more available space for a new element. 


FIFO REPLACEMENT POLICY
Data Structure: LinkedList
Basically, FIFO replacement policy is compatible with the QUEUE data structure because they have the same concept in accessing, removing, and inserting elements. A LinkedList is an implementation of QUEUE.

In this algorithm, I am able to remove the very first element and set a new head (head.next) every time I add (to the last) a new element in to the queue. In every run, I will first check if the frame's size is already equivalent to the limit. If so, it will check if the element to be added into the queue already exists. Given it's true, it will not do anything but display the elements inside the queue. If the element doesn't exist, it would prompt a page fault by displaying a message. It would then remove the head of the queue, then add the element in the end (last) of the queue and increase the page fault counter by one (1).

This will continue to execute until the elements from the reference string are all visited.

====================================================================

LRU REPLACEMENT POLICY
Data Structure: List and Array
In this algorithm, I store all the elements inside the frame into an ArrayList. In a different array which I call as "time", I am able store the time as to when the element was accessed/inserted by assigning it with the index of the element from the reference string. 

Every time there would be a page fault, it would get the "index" of the element with the smallest value in "time" array. The algorithm will then access the element from the list with the same index, and replace the current element with a new element and update the page fault counter by increasing it by one. If the element already exists in the list, it would just update the corresponding "time" of the element.
 
This will continue to execute until the elements from the reference string are all visited.

====================================================================

LFU REPLACEMENT POLICY
Data Structure: List and Array
In this algorithm, I store all the elements inside the frame into an ArrayList. In a different array which I call as "count", I am able store the time as to how many times the element was used (access/insert).

Every time there would be a page fault, it would get the "index" of the element with the smallest value in "count" array. The algorithm will then access the element from the list with the same index, and replace the current element with a new element and update the page fault counter by increasing it by one. If the element already exists in the list, it would just update the "count" of the corresponding element by increasing it by one (1).

This will continue to execute until the elements from the reference string are all visited.
