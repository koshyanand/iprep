// Link: https://leetcode.com/problems/flood-fill/

// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    int[][] image;
    int color;
    int newColor;
    
    int[] xVals = new int[]{0,0,-1,1};
    int[] yVals = new int[]{-1,1,0,0};
    
    public void helper(int i, int j) {
        
        image[i][j] = newColor;
        
        for (int k = 0; k < 4; k++) {
            int x = i + xVals[k];
            int y = j + yVals[k];
            
            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == color)
                helper(x, y);
                
        }
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if ((image.length == 0 && image[0].length == 0) || image[sr][sc] == newColor) 
            return image;
        this.image = image;
        this.color = image[sr][sc];
        this.newColor = newColor;
        
        helper(sr, sc);
        
        return this.image;
    }
}