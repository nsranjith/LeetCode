/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
       Node nHead=null;
       Node curr=head;
       while(curr!=null){
           Node temp=new Node(curr.val);
           Node nTemp=curr.next;
           curr.next=temp;
           temp.next=nTemp;
           curr=curr.next.next;
       }
       curr=head;
       nHead=curr.next;

       while(curr!=null){
           if(curr.random!=null)
           curr.next.random=curr.random.next;
           curr=curr.next.next;
       }
       curr=head;
       Node curr2=nHead;
    //    1 2 3 4
       
    //    1 1 2 2 3 3 4 4 

       while(curr!=null ){
           curr.next=curr.next.next;
           curr2.next=curr2.next!=null ? curr2.next.next : curr2.next;
           curr=curr.next;
           curr2=curr2.next;
       }
       return nHead;
    }
}