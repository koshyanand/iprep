// Link: https://leetcode.com/problems/combination-sum/

// Time Complexity: O(N ^ ((T / M) + 1)) M: Smallest value in the array and 1 because the max number of node in an n-array tree is N ^ (Depth + 1)
// Space Complexity: O(T / M)

class Solution {
    List<List<Integer>> result;
    
    public void helper(int index, List<Integer> curr, int[] candidates, int target, int sum) {
        
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        if (index >= candidates.length || sum > target)
            return;
        
        for (int i = index; i < candidates.length; i++) {
            curr.add(candidates[i]);
            sum += candidates[i];
            helper(i,curr, candidates, target, sum);
            curr.remove(curr.size() - 1);
            sum -= candidates[i];
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        if (candidates.length == 0)
            return result;
        
        helper(0, new ArrayList<>(), candidates, target, 0);
        
        return result;
    }
}