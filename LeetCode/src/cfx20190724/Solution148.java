package cfx20190724;/*
 *在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序(升序)。
 */

public class Solution148 {
    public ListNode sortList(ListNode head){
        if(head==null || head.next==null)
            return head;
        int count=1;
        int step=Integer.MAX_VALUE;
        ListNode previous;

        while (step>1) {
            step=0;
            previous=head;
            while (previous != null) {
                previous = sortInStep(previous, count);
                step++;
            }
            count=count*2;
        }
        if(head.val<head.next.val){
            return head;
        }

        previous=head;
        ListNode current=previous.next;
        ListNode root=current;

        while(current!=null){
            if(head.val<current.val){
                previous.next=head;
                head.next=current;
                return root;
            }
            previous=current;
            current=current.next;
        }
        previous.next=head;
        head.next=null;
        return root;
    }


    //在固定步数中进行插排,返回下一个步数的头节点的前一个节点
    public ListNode sortInStep(ListNode previous,int count){
        /*
         * 将后面一个count长度的链表插入到前面的链表中
         * */

        //1、首先获取后一个链表的首节点的前一个节点nextPrevious
        int preLength=count,nextLength=count;
        ListNode nextPrevious= previous;
        while (preLength>=1){
            if(nextPrevious==null){
                return null;
            }
            nextPrevious=nextPrevious.next;
            preLength--;
        }
        //2、将后一个count长度的链表依次插入到前一个链表中
        if(nextPrevious==null){
            return null;
        }
        ListNode current=previous.next;
        ListNode nextCurrent=nextPrevious.next;
        if(nextCurrent==null){
            return null;
        }
        preLength=count;

        //3、在交换过程中，由于两个链表都是有序的，所以即使交换过，直接从交换过的地方开始比较就可以了
        while(nextCurrent!=null && nextLength>=1 && preLength>=1){
            //如果条件成立，将next链表节点插入前一个链表
            if(current.val>nextCurrent.val) {
                insertNode(previous, current, nextPrevious, nextCurrent);
                //令previous=nextCurrent
                previous=nextCurrent;
                nextCurrent=nextPrevious.next;
                nextLength--;
            }else {
                previous=current;
                current=current.next;
                preLength--;
            }
        }
        while (nextCurrent!=null && nextLength>=1){
            nextCurrent=nextCurrent.next;
            nextPrevious=nextPrevious.next;
            nextLength--;
        }
        return nextPrevious;
    }

    //插入节点
    public void insertNode(ListNode previous,ListNode current,ListNode nextPrevious,ListNode nextCurrent){
        nextPrevious.next=nextCurrent.next;
        nextCurrent.next=current;
        previous.next=nextCurrent;
    }

    public static void main(String[] args) {
        ListNode node0=new ListNode(2);
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(9);
        ListNode node3=new ListNode(8);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(1);
        node0.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        Solution148 solution148=new Solution148();
        ListNode current=node0;

        System.out.println("打印排序前的链表：");
        while (current!=null){
            System.out.print(current.val+",");
            current=current.next;
        }
        ListNode sortList = solution148.sortList(node0);
        System.out.println();
        System.out.println("打印排序后的链表：");
        while (sortList!=null){
            System.out.print(sortList.val+",");
            sortList=sortList.next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

