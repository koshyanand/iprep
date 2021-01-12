// Link : https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

// Time Complexity : O(log(T)) Index of the search element
// Space Complexity : O(1)

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int i = 0;
        
        int left = 0, right = 1;
        
        while (reader.get(right) < target) {
            left = right;
            i++;
            right = (int)Math.pow(2, i);
        }
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            int midVal = reader.get(mid);
            if(midVal == target)
                return mid;
            
            if (midVal < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}