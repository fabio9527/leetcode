package cfx20190606;

public class Solution19 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null)
            return null;

        ListNode endNode=head;
        ListNode targetNode=head;
        ListNode previousNode=head;

        int i=1;
        while(i<n){
            endNode=endNode.next;
            i++;
        }
        if(endNode.next!=null){
            endNode=endNode.next;
            targetNode=head.next;
            previousNode=head;
        }else
            return head.next;

        while(endNode.next!=null){
            endNode=endNode.next;
            targetNode=targetNode.next;
            previousNode=previousNode.next;
        }
        previousNode.next=targetNode.next;
        targetNode.next=null;
        targetNode=null;
        return head;
    }

    public static void main(String[] args) {
        ListNode root=new ListNode(0);
        ListNode temp=root;
        int i=1;
        while(i<10){
            temp.next=new ListNode(i);
            temp=temp.next;
            i++;
        }

        ListNode node=root;
        while (node!=null){
            System.out.print(node.val+",");
            node=node.next;
        }

        System.out.println();

        Solution19 solution19=new Solution19();
        ListNode newRoot=solution19.removeNthFromEnd(root,1);
        while (newRoot!=null){
            System.out.print(newRoot.val+",");
            newRoot=newRoot.next;
        }

    }
}


