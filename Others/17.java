// Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// Time Complexity: O(3^N * 4^M) N: Number of digits with 3 characters in the input
                              // M: Number of digits with 4 characters in the input
// Space Complexity: O(3^N * 4^M)


class Solution {
    
    public void helper(String digits, StringBuilder b, int currDigit) {
        
        if (currDigit == digits.length()) {
            result.add(b.toString());
            return;
        }
        
        String currLetters = map.get(digits.charAt(currDigit));
        
        for (int i = 0; i < currLetters.length(); i++) {
            b.append(currLetters.charAt(i));
            helper(digits, b, currDigit + 1);
            b.deleteCharAt(b.length() - 1);
        }
            
    }
    
    HashMap<Character, String> map;
    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        
        if (digits.length() == 0)
            return result;
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        StringBuilder b = new StringBuilder();
        helper(digits, b, 0);
        return result;
    }
}