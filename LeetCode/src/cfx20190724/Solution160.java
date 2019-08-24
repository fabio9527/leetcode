package cfx20190724;

public class Solution160 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        int countA=0;
        int countB=0;
        int step;
        ListNode currentA=headA;
        ListNode currentB=headB;
        //首先判断是否有交点
        while(currentA.next!=null){
            currentA=currentA.next;
            countA++;
        }
        while(currentB.next!=null){
            currentB=currentB.next;
            countB++;
        }
        if(currentA!=currentB)
            return null;
        //如果有交点
        currentA=headA;
        currentB=headB;
        if((step=countA-countB)>0){
            while (step>0){
                currentA=currentA.next;
                step--;
            }
        }else {
            while (step<0){
                currentB=currentB.next;
                step++;
            }
        }
        while (currentA!=currentB){
            currentA=currentA.next;
            currentB=currentB.next;
        }
        return currentA;
    }
}



