// Link: https://leetcode.com/problems/employee-importance/

// Time Complexity: O(N)
// Space Complexity: O(N)

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
        
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        if (!map.containsKey(id))
            return 0;
        
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(id);
        int total = 0;
        
        while(queue.size() > 0) {
            Employee e = map.get(queue.poll());
            
            total += e.importance;
            
            for (int i : e.subordinates)
                queue.add(i);
        }
        return total;
        
        
    }
}