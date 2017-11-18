How to run the code:
- Set command line: input.txt
- Then run main function
- See output in console


Solution explanation:
- The basic idea is to build up a TreeMap first to save information for ascending timestamp. O(L)
- Then for each timestamp, we build up a HashMap to save website name and hit count(ascending). O(MN)
- To get timestamp string ascending in TreeMap, we should change format to yyyy/MM/dd. O(1)
- To print out website information according to hit count, we restore each map in heap.

Assuming
L: # of lines in input.txt
N: # of unique websites for each timestamp, 1 <= N <= L
M: # of timestamps, 1 <= M <= L

Then the time complexity is O(LMN). 
In the worst case, M = L, N = 1, then T(L) = O(L^2).
In the best case, M = 1, N = L, then T(L) = O(L)

