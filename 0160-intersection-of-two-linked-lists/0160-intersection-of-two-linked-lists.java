/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummy1=headA;
        ListNode dummy2=headB;
        while(dummy1!=null && dummy2!=null){
            dummy1=dummy1.next;
            dummy2=dummy2.next;
        }
        while(dummy2!=null){
            headB=headB.next;
            dummy2=dummy2.next;
        }
        while(dummy1!=null){
            headA=headA.next;
            dummy1=dummy1.next;
        }
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        
        return headA;
    }
}