package cfx20190717;
public class MinStack {
    private static class Node{
        int num;
        Node next,previous;
        public Node() {
        }
        public Node(int num) {
            this.num = num;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    private Node head,tail;

    public MinStack() {

    }

    public void push(int x) {
        Node node=new Node(x);
        if(head==null){
            head=node;
            tail=node;
        }else {
            tail.next=node;
            node.previous=tail;
            tail=node;
        }
    }

    public void pop() {
        Node top;
        if(tail==head && tail!=null){
            tail=null;
            head=null;
        }else if(tail!=head && tail!=null){
            top=tail;
            tail=top.previous;
            tail.next=null;
            top.previous=null;
            top=null;
        }
    }

    public int top() {
        if(tail!=null)
            return tail.getNum();
        else
            throw new RuntimeException("栈中无元素");
    }

    public int getMin() {
        if(head==null){
            throw new RuntimeException("栈中无元素");
        }
        int standard=Integer.MAX_VALUE;
        Node point=head;
        while (point!=null){
            if(standard>point.getNum()){
                standard=point.getNum();
            }
            point=point.next;
        }
        return standard;
    }

    public static void main(String[] args) {
        MinStack minStack=new MinStack();

        minStack.push(-2);
        minStack.push(2);
        minStack.push(0);
        minStack.push(-8);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        minStack.pop();
//        System.out.println(minStack.top());
    }
}
