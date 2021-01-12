// Link : https://leetcode.com/problems/search-in-rotated-sorted-array/

// Time Complexity : O(log(N))
// Space Complexity : O(1)
class Solution {
    public int search(int[] nums, int target) {
        
        if (nums.length == 0)
            return -1;
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target)
                return mid;
            
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (nums[right] >= target || nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            
        }
        return -1;
    }
}