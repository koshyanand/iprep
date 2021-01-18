// Link: https://leetcode.com/problems/custom-sort-string/

// Time Complexity : O(S + T)
// Space Complexity : O(T)

class Solution {
    public String customSortString(String S, String T) {
        
        if (S.length() == 0 || T.length() == 0)
            return T;
        StringBuilder sb = new StringBuilder();
        int[] order = new int[26];    
        
        for (int i = 0; i < T.length(); i++) {
            order[T.charAt(i) - 'a']++;
        }
        for (int i = 0; i < S.length(); i++) {

            for (int j = 0; j < order[S.charAt(i) - 'a']; j++) {
                sb.append(S.charAt(i));
            }
            order[S.charAt(i) - 'a'] = 0;
            
        }
        
        for (char c ='a'; c <= 'z'; c++) {
            
            for (int i = 0; i < order[c - 'a']; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
        
    }
}
