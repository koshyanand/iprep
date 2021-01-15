// Link: https://leetcode.com/problems/middle-of-the-linked-list/

// Time Complexity: O(N)
// Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while(fast.next != null && fast.next.next != null) {
            i += 1;
            slow = slow.next;
            fast = fast.next.next;

        }

        if (fast.next == null)
            return slow;
        else
            return slow.next;

    }
    
}