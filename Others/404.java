// Link: https://leetcode.com/problems/sum-of-left-leaves/

// Time Complexity: O(N)
// Space Complexity: O(log(N))

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum;

    public void helper(TreeNode node, boolean isLeft) {

        if (node == null)
            return;
        if (isLeft && node.right == null && node.left == null)
            sum += node.val;
        helper(node.right, false);
        helper(node.left, true);
   
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) 
            return 0;

        sum = 0;

        helper(root, false);
        return sum;
    }
}