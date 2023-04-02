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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return helper(list1,list2);
    }
    private ListNode helper(ListNode list1, ListNode list2){
       ListNode dummy=new ListNode(-1);
       ListNode tail=dummy;
       while(list1!=null && list2!=null){
           int val1=list1.val;
           int val2=list2.val;
           if(val1>val2){
               tail.next=list2;
               list2=list2.next;
               tail=tail.next;
           }else if(val2>val1){
               tail.next=list1;
               list1=list1.next;
               tail=tail.next;

           }else{
               tail.next=list1;
               tail=tail.next;
               list1=list1.next;
               tail.next=list2;
               list2=list2.next;
               tail=tail.next;
           }
       }
       if(list1!=null){
            tail.next=list1;
        }
       if(list2!=null){
            tail.next=list2;
        }
        return dummy.next;
    }
}