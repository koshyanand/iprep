// Link: https://leetcode.com/problems/container-with-most-water/

// Time Complexity: O(N)
// Time Complexity: O(1)

class Solution {
    public int maxArea(int[] height) {
        
        if (height.length < 2)
            return 0;
        
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        while(left < right) {
            
            maxWater = Math.max(Math.min(height[left], height[right]) * (right - left), maxWater);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxWater;
    }
}