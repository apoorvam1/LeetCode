Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

```
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

*My Notes:* In a sorterd rotated array, nums[low]-nums[mid] OR nums[mid]-nums[high] are always sorted  
Use this fact to perform binary search on the section of the array which has the key.

**Solution**
```
class Solution {  
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);   
    }
    
    private int search(int[] nums, int target, int low, int high) {
         // In an array with even number of elements, if target is in nums[mid+1] we do not want to miss it. Because when mid is calculated lower bound is taken. hence we keep low <= high
         while(low <= high) {
             int mid = low + (high-low)/2;
             
             if(target == nums[mid]) {
                 return mid;
             }
             
             // Pick one of the sorted parts as we want to perform binary search to find target
             // Even though there are no duplicates in the array <= OR >= is needed to handle the case when input has only 1 element
             if(nums[low] <= nums[mid]) {
                 // check if the target lies in this part and adjust low/high accordingly
                 if(target >= nums[low] && target < nums[mid]) {
                     high = mid - 1;
                 } else {
                     low = mid + 1;
                 }
             }
             
             if(nums[mid] <= nums[high]) {
                 // Check if the target lies in this part and adjust low/high accordingly
                 if(target > nums[mid] && target <= nums[high]) {
                     low = mid+1;
                 } else {
                     high = mid-1;
                 }
             }
         }
        
        return -1;
    }
}
```
