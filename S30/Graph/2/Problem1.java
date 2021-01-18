// Link: https://leetcode.com/problems/critical-connections-in-a-network/

// Time Complexity : V + E
// Space Complexity : V + E

class Solution {
    List<List<Integer>> result;
    List<List<Integer>> map;
    int[] nodeInfo;
    boolean[] visited;
    
    public List<List<Integer>> getMap(List<List<Integer>> connections, int n) {
        List<List<Integer>> map = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int j = 0; j < connections.size(); j++) {
            List<Integer> edge = connections.get(j);
            
            map.get(edge.get(0)).add(edge.get(1));
            map.get(edge.get(1)).add(edge.get(0));
        }
        
        return map;
    }
    
    public void dfs(int i, int prev, int id) {
        
        visited[i] = true;
        id++;
        nodeInfo[i] = id;
        
        for (int adjNode : map.get(i)) {
            
            if (adjNode == prev)
                continue;
            if (!visited[adjNode]) 
                dfs(adjNode, i, id);
                            
            if (nodeInfo[adjNode] <= nodeInfo[i])
                nodeInfo[i] = nodeInfo[adjNode];
            if (nodeInfo[adjNode] > id)
                result.add(new ArrayList<>(Arrays.asList(i, adjNode)));
            
        }
    }
    
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        result = new ArrayList<List<Integer>>();
        if (n == 0)
            return result;
        if (n == 2)
            return connections;
        
        map = getMap(connections, n);
        nodeInfo = new int[n];
        visited = new boolean[n];
        dfs(0, -1, 0);
        
        return result;
        
    }
}