// Link: https://leetcode.com/problems/evaluate-division/

// Time Complexity: O(EQ + Q(E + V))
// Space Complexity: O(Q + (E + V))
// More optimal union find approach is there

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        double[] result = new double[queries.size()];
        Arrays.fill(result, -1.0);
        
        if (equations.size() == 0 || queries.size() == 0)
            return result;
            
        HashMap<String, List<Pair<String, Double>>> map = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> edge = equations.get(i);
            
            if (!map.containsKey(edge.get(0)))
                map.put(edge.get(0), new ArrayList<Pair<String, Double>>());
            
            if (!map.containsKey(edge.get(1)))
                map.put(edge.get(1), new ArrayList<Pair<String, Double>>());
            
            map.get(edge.get(0)).add(new Pair<>(edge.get(1), values[i]));
            map.get(edge.get(1)).add(new Pair<>(edge.get(0), 1 / values[i]));
                        
        }
        
        for (int i = 0; i < queries.size(); i++) {
            List<String> edge = queries.get(i);
            
            if (!map.containsKey(edge.get(0)) || !map.containsKey(edge.get(1)))
                continue;
            
            LinkedList<Pair<String, Double>> queue = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();
            queue.add(new Pair<>(edge.get(0), 1.0));
            
            while(queue.size() > 0) {
                
                Pair<String, Double> curr = queue.poll();
                
                if (curr.getKey().equals(edge.get(1))) {
                    result[i] = curr.getValue();
                    break;
                }
                
                if (visited.contains(curr.getKey()) || !map.containsKey(curr.getKey()))
                    continue;
                
                visited.add(curr.getKey());
                
                for (Pair<String, Double> child : map.get(curr.getKey())) {
                    
                    queue.add(new Pair<String, Double>(child.getKey(), curr.getValue() * child.getValue()));
                    
                } 
            }
            
        }
        
        return result;
        
    }
}

