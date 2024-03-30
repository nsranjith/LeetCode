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
    int cnt=0;
    public ListNode reverseKGroup(ListNode head, int k) {
       int c=0;
       ListNode curr=head;
       while(curr!=null){
           curr=curr.next;
           c++;
        }
        int diff=c%k;
        int req=c-diff;
        curr=head;
        
        while(req>0){
            curr=curr.next;
            req--;
        }
        
        if(diff==0){
            return helper(head,k,null,c);
        }else{
            return helper(head,k,curr,c-diff);
        }
    }
    private ListNode helper(ListNode head, int k, ListNode left, int total){
        
        int s=0;
        ListNode curr=head;
        ListNode prev=null;
        while(s!=k && curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            s++;
            total--;
        }
        if(total==0){
            head.next=left;
            return prev;
        }
        
        head.next=helper(curr,k,left,total);
        return prev;
    }   
}