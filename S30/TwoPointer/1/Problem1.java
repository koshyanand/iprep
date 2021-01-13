// Link: https://leetcode.com/problems/sort-colors/

// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    
    public void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    public void sortColors(int[] nums) {
        
        if (nums.length < 2)
            return;
            
        int p1 = 0, p2 = nums.length - 1;
        int curr = 0;
        while(curr <= p2) {
            
            if (nums[curr] == 2) {
                swap(nums, curr, p2);
                p2--;
            }else if (nums[curr] == 0) {
                swap(nums, curr, p1);
                p1++;
                curr++;
            }else
                curr++;
        }
    }
}