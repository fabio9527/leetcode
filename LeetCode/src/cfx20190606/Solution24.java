package cfx20190606;

public class Solution24 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        //第一次交换
        ListNode first=head;
        ListNode second=head.next;
        first.next=second.next;
        second.next=first;
        head=second;
        first=head;
        second=first.next;

        //第二次后的交换
        ListNode previous=first;
        first=second;
        second=second.next;
        int i=1;

        while(second!=null){
            //交换
            if(i%2==0){
                //交换前后节点位置
                first.next=second.next;
                second.next=first;
                previous.next=second;
                //将first和second位置互换
                first=previous.next;
                second=first.next;
            }
            previous=first;
            first=second;
            second=second.next;
            i++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(0);
        ListNode current=head;
        for(int i=1;i<3;i++){
            current.next=new ListNode(i);
            current=current.next;
        }
        //测试链表
        System.out.println("未排序之前链表");
        current=head;
        while (current!=null){
            System.out.print(current.val+",");
            current=current.next;
        }

        //重排序链表
        System.out.println();
        System.out.println("排序之后链表");
        Solution24 solution24=new Solution24();
        ListNode newHead=solution24.swapPairs(head);
        while (newHead!=null){
            System.out.print(newHead.val+",");
            newHead=newHead.next;
        }

    }
}
