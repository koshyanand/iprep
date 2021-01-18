// Link: https://leetcode.com/problems/find-the-celebrity/

// Time Complexity: O(N)
// Space Complexity: O(1)

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            if (n == 0)
                return -1;
            if (n == 1)
                return 0;
            
            int celeb = 0;
            for (int i = 1; i < n; i++) {
                if (knows(celeb, i))
                    celeb = i;
            }
            
            for (int i = 0; i < n; i++) {
                if (i == celeb)
                    continue;
                if (knows(celeb, i) || !knows(i, celeb))
                    return -1;
            }
            return celeb;
        }
    }
