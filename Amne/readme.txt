
How to run Solution.java?
* make folders like below:
	src
	  - inputs
	    - input.txt
	    - input2.txt
	    - input3.txt
            - input200000.txt
	    - largeInput.txt
	  - Amne
	    - Solution.java
* run main function
* you can see start time and end time in console
* you can find result in output.txt in src folder


How does my solution work?
* the idea is to find the length of each longest increasing and decreasing array
  then use math to compute number of their subarrays
  e.g. length of array[2,4,6,7] = 4, then number of subarray = 1/2 * 4 * (4 - 1) = 6
* this idea works for base case: first window. Just using two pointers is enough.
* for other windows, i use doubly linked list to reduce complexity
* each time we move window, we must refresh index information in linked list and result array as well
* time complexity: O(n) 

