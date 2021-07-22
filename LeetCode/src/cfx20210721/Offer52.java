package cfx20210721;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Offer52 {

    /**
     * 输入两个链表，找出它们的第一个公共节点。
     *
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(null == headA || null == headB){
            return null;
        }

        // 获取LastNodeA最后一个节点
        ListNode nextNodeA = headA;
        ListNode nextNodeB = headB;
        int lengthA = 1;
        int lengthB = 1;

        while (null != nextNodeA.next){
            nextNodeA = nextNodeA.next;
            lengthA++;
        }
        // 获取LastNodeB最后一个节点
        while (null != nextNodeB.next){
            nextNodeB = nextNodeB.next;
            lengthB++;
        }

        if(nextNodeA != nextNodeB){
            return null;
        }

        // 链表长者先行，保持两边长度一致
        if(lengthA > lengthB){
            headA = stepNext(lengthA - lengthB, headA);
        }else {
            headB = stepNext(lengthB -lengthA, headB);
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }

    public ListNode stepNext(int stepNum, ListNode node){
        while (stepNum>0){
            node= node.next;
            stepNum--;
        }
        return node;
    }

}
