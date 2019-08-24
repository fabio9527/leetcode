package cfx20190722;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution138 {

    /*
    * 基于层数的遍历
    *
    * */
    public Node copyRandomList(Node head) {
        Node current=head;
        HashMap<Node,Integer> hashMap=new HashMap<>();
        int count=0;
        while (current!=null){
            hashMap.put(current,count);
            count++;
            current=current.next;
        }
        hashMap.put(null,count);
        Node[] nodes=new Node[count+1];
        for(int i=0;i<count;i++){
            nodes[i]=new Node();
        }
        current=head;
        count=0;
        while(current!=null){
            Node random = current.random;
            Integer index = hashMap.get(random);
            nodes[count].val=current.val;
            nodes[count].next=nodes[count+1];
            nodes[count].random=nodes[index];
            current=current.next;
            count++;
        }
        return nodes[0];
    }

}
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}