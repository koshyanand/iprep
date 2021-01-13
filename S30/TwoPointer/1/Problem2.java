// Link: https://leetcode.com/problems/3sum/

// Time Complexity: O(N^2)
// Time Complexity: O(N log(N)) // For the sorting algorithm


class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3)
            return result;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            
            int left = i + 1, right = nums.length - 1, target = -nums[i];
            while(left < right) {
                
                if (left - i >= 2 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }

                int total = nums[left] + nums[right];
                
                if (total == target) {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                } else {
                    if (total > target)
                        right--;
                    else
                        left++;
                }
                
            }
        }
        return result;
    }
}