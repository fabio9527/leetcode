package cfx20190606;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

 public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node;
        if(l1==null && l2==null)
            return null;
        else if(l1==null) {
            node = new ListNode(l2.val%10);
            if(l2.val>=10){
                if(l2.next==null)
                    l2.next=new ListNode(1);
                else
                    l2.next.val++;
            }
            node.next = addTwoNumbers(null, l2.next);
        }
        else if(l2==null) {
            node = new ListNode(l1.val%10);
            if(l1.val>=10){
                if(l1.next==null)
                    l1.next=new ListNode(1);
                else
                    l1.next.val++;
            }
            node.next = addTwoNumbers(l1.next,null);
        }
        else {
            node=new ListNode((l1.val+l2.val)%10);
            if(l1.val+l2.val>=10){
                if(l1.next==null)
                    l1.next=new ListNode(1);
                else
                    l1.next.val++;
            }
            node.next=addTwoNumbers(l1.next,l2.next);
        }
        return node;

    }
}