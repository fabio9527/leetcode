package cfx20190722;


/*
* 令fast=head,slow=head,然后fast走1步,然后如果fast继续走下去如果和slow相遇，则为环，否则fast
* */
public class Solution142 {

    /*
    * 判断是否有环
    *
    * */
    public ListNode isCycle(ListNode head){
        if(head==null)
            return null;
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return slow;
            }
        }
        return null;
    }

    //找出节点
    public ListNode detectCycle(ListNode head) {
        ListNode cycleNode = isCycle(head);
        if(cycleNode==null)
            return null;
        ListNode fNode=head;
        ListNode aNode=cycleNode;
        while (fNode!=aNode){
            aNode=aNode.next;
            fNode=fNode.next;
        }
        return aNode;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
