package cfx20190726;


public class Solution206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

/*    //迭代
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode next=null;
        ListNode current=head;
        ListNode temp=null;
        while (current!=null){
            temp=new ListNode(current.val);
            temp.next=next;
            next=temp;
            current=current.next;
        }
        return next;
    }*/

    //递归
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode root=null;
        return reverse(head,head.next);
    }

    private ListNode reverse(ListNode current,ListNode next){
        if(next==null){
            return current;
        }
        ListNode root = reverse(next, next.next);
        next.next=current;
        current.next=null;
        return root;
    }

    public static void main(String[] args) {
        ListNode node0=new ListNode(0);
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node0.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode current=node0;
        System.out.println("为逆转之前：");
        while (current !=null){
            System.out.print(current.val+",");
            current=current.next;
        }
        Solution206 solution206=new Solution206();
        ListNode node = solution206.reverseList(node0);
        current=node;
        System.out.println();
        System.out.println("逆转之后：");
        while (current !=null){
            System.out.print(current.val+",");
            current=current.next;
        }

    }
}
