// Link : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Time Complexity : O(log(N))
// Space Complexity : O(1)

class Solution {
    int[] result;
    
    public void find(int[] nums, int target, boolean goLeft) {
        
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                if (goLeft) {
                    result[0] = mid;
                    right = mid - 1;
                } else {
                    result[1] = mid;
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }       
        }
                
    } 
    
    public int[] searchRange(int[] nums, int target) {
        
        result = new int[]{-1, -1};
        if (nums.length == 0)
            return result;
        
        find(nums, target, true);
        find(nums, target, false);
        return result;
    }
}