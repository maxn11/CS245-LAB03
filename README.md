# CS245-LAB03

INSERTION SORT
Runtime Complexity: O(n^2)
- This is because it runs through a nested while loop under the for loop of n length
- the best case is O(n) if it's already sorted, since it won't need to run the while loop
Performance:
- For dataset of 10000 numbers firstAlgoPerformance = 4ms
- For dataset of 100000 numbers firstAlgoPerformance = 262ms
- For dataset of 1000000 numbers firstAlgoPerformance = 8801ms

MERGE SORT
Runtime Complexity: O(nlogn)
- This is because the amount of layers (new arrays made for left and right) has a nlogn relation
  size of the array.
- best case is also O(nlogn), but space is demanding, this is show by the performance timing.
Performance:
- For dataset of 10000 numbers secondAlgoPerformance = 1ms
- For dataset of 100000 numbers secondAlgoPerformance = 6ms
- For dataset of 1000000 numbers secondAlgoPerformance = 60ms
