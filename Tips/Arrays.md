1.  Extract part of the array
```
    - Arrays.copyOfRange(res, startIndex(inclusive), endIndex(inclusive));
```

2. Copy one array into another
```
- int[] newArr = Arrays.copyOf(arr, arr.length);
```

3.  When working with arrays containing negative numbers check if Math.abs(val) helps simplify the problem

4. Reverse an array
```
- Collections.reverse(Arrays.asList(arr));
```

5. Print an array
```
- Arrays.toString(arr);
```

6. Converting arrays to Stream
```
    - Stream<String> stream = Arrays.stream(arr);
```

7. Using built-in binary search
```
- int index = Arrays.binarySearch(arr, 57);
```

8. Search objects in array
```
- int index = Arrays.asList(arr).indexOf("Item");
```

9. Array of unknown size can't be initialized. List is the best solution for such cases.

10. Array manipulation problems need not involve in-place changes, we can put the result in a new array. 

11. Think of using 2 indexes one from the beginning one from the end.

12. Try if HashTables/HashMap can be used.

13. If array elements have some pattern then summation,xor or using hashmap might help.

14. Using character as an index to an integer array (array[char]) gives the ascii index of that array. 

15. str.chatAt(i) 
	- if stored in int var, gives the string's ith character's ascii value.
	- if stored in char var, gives the string's ith character value.
    
16. Check if sorting helps	

17. If a sorted array is rotated, 
	- finding pivot point might help find the solution
	- Either low to pivot or pivot+1 to high will always be sorted
    
18. Initialize to Max and Min value
```
- int a = Integer.MAX_VALUE 
- int b = Integer.MIN_VALUE
```

19. Shift array elements and move the last element out
```
class Solution {
    public void shiftElements(int[] arr) {
        for(int j = arr.length - 1; j > 0; j--) {
            arr[j] = arr[j-1];
        }
    }
}
```

