// Link : https://leetcode.com/problems/search-a-2d-matrix/

// Time Complexity : O(log(mn))
// Space Complexity : O(1)
class Solution {
    
    public boolean search(int[][] matrix, int row, int target) {
        int i = 0, j = matrix[0].length - 1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            
            if (matrix[row][mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
        
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length, n = matrix[0].length;
        
        if (m == 1 || matrix[0][n - 1] > target)
            return search(matrix, 0, target);
        
        int top = 0, bottom = m - 1;
        
        while (top <= bottom) {
            
            int mid = top + (bottom - top) / 2;
            
            if (matrix[mid][n - 1] == target)
                return true;
            
            if (matrix[mid][n - 1] > target) {
                if (mid - 1 >= 0 && matrix[mid - 1][n - 1] < target) 
                    return search(matrix, mid, target);
                bottom = mid - 1;
                
            } else if (matrix[mid][n - 1] < target ) {
                if (mid + 1 < m && matrix[mid + 1][n - 1] > target)
                    return search(matrix, mid + 1, target);
                top = mid + 1;  
            }
            
        }
        return false;
    }
}