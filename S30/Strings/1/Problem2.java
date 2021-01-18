// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Time Complexity : O(N)
// Space Complexity : O(min(M, N)) N:Length of S  M: Number of character is Character Set

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0)
            return 0;
        
        int start = 0;
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                maxLen = Math.max(maxLen, i - start);
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(s.charAt(i));
                
            }
        }
        return Math.max(maxLen, i - start);
        
    }
}
