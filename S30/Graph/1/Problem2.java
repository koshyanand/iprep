// Link https://leetcode.com/problems/the-maze/

// Time Complexity : O(MN)
// Space Complexity : O(MN)

class Solution {
    
    int[] xVals = new int[]{1,-1,0,0};
    int[] yVals = new int[]{0,0,1,-1};
    int m, n;
    int[][] maze;
    
    public int[] go(int[] vals, int dir) {
        
        int x = vals[0], y = vals[1];
        
        while(true) {
            int x1 = x + xVals[dir];
            int y1 = y + yVals[dir];
            
            if (x1 < 0 || x1 == m || y1 < 0 || y1 == n || maze[x1][y1] == 1)
                break;
            x = x1;
            y = y1;
        }
        
        if (x == vals[0] && y == vals[1])
            return new int[]{-1, -1};
        return new int[]{x, y};
        
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if (maze.length == 0 || maze[0].length == 0)
            return false;
        this.maze = maze;
        this.m = maze.length;
        this.n = maze[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(new int[]{start[0], start[1], -1});
        
        while(q.size() > 0) {
            int[] vals = q.poll();
            
            if (vals[0] == destination[0] && vals[1] == destination[1])
                return true;
            for (int i = 0; i < 4; i++) {
                if (i == vals[2])
                    continue;
                int[] next = go(vals, i);
                
                if (next[0] != -1 && !visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new int[]{next[0], next[1], i});
                }
            }
            
        }
        return false;
        
    }
}