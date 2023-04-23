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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        int cnt=0;
        ListNode c=head;
        while(c!=null){
            cnt++;
            c=c.next;
        }
        k=k%cnt;
        if(k==0) return head;
        ListNode fast=head;
        ListNode slow=head;
        while(k>0 && fast!=null){
            fast=fast.next;
            k--;
        }
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode next=temp;
        while(next.next!=null){
            next=next.next;
        }
        next.next=head;           
        return temp;
    }
}