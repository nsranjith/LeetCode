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
 /*
    revrse second half and merge

 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reverse=slow.next;
        slow.next=null;
        slow=head;

        ListNode prev=null;
        ListNode curr=reverse;
        while(curr!=null){
            ListNode t=curr.next;
            curr.next=prev;
            prev=curr;
            curr=t;
        }

        reverse=prev;
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(slow!=null && reverse!=null){
           tail.next=slow;
           slow=slow.next;
           tail=tail.next;
           tail.next=reverse;
           reverse=reverse.next;
           tail=tail.next;
        }
        if(slow!=null){
            tail.next=slow;
        }
        if(reverse!=null){
            tail.next=reverse;
        }
        head=dummy.next;
    }
}