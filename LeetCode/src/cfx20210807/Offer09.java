package cfx20210807;

import java.util.Stack;

public class Offer09 {

    Stack<Integer> pushStack;
    Stack<Integer> getStack;

    /**
     * 用两个栈实现一个队列。
     *
     * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
     * (若队列中没有元素，deleteHead操作返回 -1 )
     */
    public Offer09() {
        pushStack = new Stack<>();
        getStack = new Stack<>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if(getStack.empty()){
            if(pushStack.empty()){
                return -1;
            }
            while (!pushStack.empty()){
                getStack.push(pushStack.pop());
            }
        }
        return getStack.pop();
    }

    public static void main(String[] args) {
        Offer09 offer09 = new Offer09();
        offer09.appendTail(1);
        System.out.print(offer09.deleteHead());
    }
}
