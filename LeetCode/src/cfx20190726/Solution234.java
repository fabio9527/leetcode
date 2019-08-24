package cfx20190726;

public class Solution234 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//    public boolean isPalindrome(ListNode head) {
//        if(head==null || head.next==null){
//            return true;
//        }
//        ListNode temp=null;
//        ListNode current=head.next,previous=head;
//        previous.next=null;
//        while (current!=null){
//            //先改变结构
//            if(current.val==previous.val && estimate(previous,current)){
//                return true;
//            }
//            if(current.next!=null && current.next.val==previous.val && estimate(previous,current.next))
//                return true;
//            //顺便改变结构
//            temp=previous;
//            previous=current;
//            current=current.next;
//            previous.next=temp;
//        }
//        return false;
//    }
    //判断current是否为回文
    public boolean estimate(ListNode left,ListNode right){
        while (left.val == right.val) {
            left=left.next;
            right=right.next;
            if(left==null && right==null){
                return true;
            }else if(left==null || right==null){
                return false;
            }
        }
        return false;
    }


    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode oneStep=head;
        ListNode right=oneStep.next;
        ListNode temp;
        ListNode twoStep=head.next.next;
        oneStep.next=null;
        while(twoStep!=null && twoStep.next!=null){
            temp=oneStep;
            oneStep=right;
            right=oneStep.next;
            oneStep.next=temp;
            twoStep=twoStep.next.next;
        }
        if(twoStep==null){
            return estimate(oneStep,right);
        }else {
            return estimate(oneStep,right.next);
        }
    }
    public static void main(String[] args) {
        ListNode node0=new ListNode(0);
        ListNode node1=new ListNode(2);
//        ListNode node2=new ListNode(6);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(0);
        node0.next=node1;
//        node1.next=node2;
        node1.next=node3;
        node3.next=node4;
        Solution234 solution234=new Solution234();
        System.out.println(solution234.isPalindrome(node0));

    }
}
