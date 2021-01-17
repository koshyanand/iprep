// Link: https://leetcode.com/problems/critical-connections-in-a-network/

// Brute Force Approach
// Time Complexity : E(V + E)
// Space Complexity : V + E


class Solution {
    
    public HashMap<Integer, HashSet<Integer>> getMap(List<List<Integer>> connections) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        for (int j = 0; j < connections.size(); j++) {
            List<Integer> edge = connections.get(j);
            addConnection(map, edge);
        }
        
        return map;
    }
    
    public void removeConnection(HashMap<Integer, HashSet<Integer>> map, List<Integer> edge) {
        
        if (map.containsKey(edge.get(0))) {
            if (map.get(edge.get(0)).size() < 2)
                map.remove(edge.get(0));
            else
                map.get(edge.get(0)).remove(edge.get(1));
        }
        if (map.containsKey(edge.get(1))) {
            if (map.get(edge.get(1)).size() < 2)
                map.remove(edge.get(1));
            else
                map.get(edge.get(1)).remove(edge.get(0));
        }
    }
    
    public void addConnection(HashMap<Integer, HashSet<Integer>> map, List<Integer> edge) {
        
        if (!map.containsKey(edge.get(0))) {
            map.put(edge.get(0), new HashSet<Integer>());
        }
        map.get(edge.get(0)).add(edge.get(1));
            
        if (!map.containsKey(edge.get(1))) {
            map.put(edge.get(1), new HashSet<Integer>());
        }
        map.get(edge.get(1)).add(edge.get(0));
    }
    
    public int getVisitedNodes(HashMap<Integer, HashSet<Integer>> map) {
        
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        while(queue.size() > 0) {
            int node = queue.poll();
            visited.add(node);
            if (map.containsKey(node) && map.get(node).size() > 0) {
                for (int adjNode : map.get(node)) {
                    if (!visited.contains(adjNode)) {
                        queue.add(adjNode);
                    }
                }
            }
        }
        
        return visited.size();
        
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n == 0)
            return result;
        if (n == 2)
            return connections;
        HashMap<Integer, HashSet<Integer>> map = getMap(connections);
        
        for (int i = 0; i < connections.size(); i++) {
            removeConnection(map, connections.get(i));
            int nodesVisited = getVisitedNodes(map);
            if (nodesVisited != n) {
                result.add(connections.get(i));
            }
            addConnection(map, connections.get(i));
            
        }
        return result;
        
    }
}