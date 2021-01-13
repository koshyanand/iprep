// Link: https://leetcode.com/problems/find-the-town-judge/

// Time Compexity : O(E) + O(V)
// Space Complexity : O(V)

class Solution {
    public int findJudge(int N, int[][] trust) {
        if (N == 0)
            return -1;
        
        int[] inDegree = new int[N];
        int[] outDegree = new int[N];
        
        for (int[] t : trust) {
            outDegree[t[0] - 1]++;
            inDegree[t[1] - 1]++;
        }
        
        for(int i = 0; i < N; i++) {
            if (outDegree[i] == 0 && inDegree[i] == N - 1)
                return i + 1;
        }
        return -1;
        
    }
}