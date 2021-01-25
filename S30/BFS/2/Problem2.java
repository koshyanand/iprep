// Link: https://leetcode.com/problems/rotting-oranges/

// Time Complexity: O(MN)
// Space Complexity: O(MN)

class Solution {
    public int orangesRotting(int[][] grid) {
        
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        
        Queue<List<int[]>> queue = new LinkedList<>();
        List<int[]> level = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    level.add(new int[]{i,j});
            }
        }
        int[] xVals = new int[]{0,0,1,-1};
        int[] yVals = new int[]{1,-1,0,0};
        
        queue.add(level);
        int mins = 0;
        while(queue.size() > 0) {
            List<int[]> currLevel = queue.poll();
            
            List<int[]> nextLevel = new ArrayList<>();
            
            for (int[] coords : currLevel) {
                int i = coords[0], j = coords[1];
                
                for (int k = 0; k < 4; k++) {
                    int x = i + xVals[k], y = j + yVals[k];
                    
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        nextLevel.add(new int[]{x,y});
                    }
                }
                
            }
            if (nextLevel.size() > 0) {
                mins++;
                queue.add(nextLevel);
            }
            
        }
        
        for (int i = 0; i < grid.length; i++) {
            
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return mins;
    }
}