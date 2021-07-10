package cfx20210710;

import java.util.LinkedList;

public class Offer34_1 {

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     *
     * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     *
     * 思路：深度优先遍历
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       return poppedNums(pushed, popped, new LinkedList<Integer>(), 0, 0);
    }

    private boolean poppedNums(int[] pushed, int[] poped, LinkedList<Integer> stack, int currentPushIndex, int currentPopedIndex) {
        if(currentPopedIndex==poped.length){
            return true;
        }

        // 如果当前栈的最后一个值等于要出栈的值，则出栈
        if(stack.size()>0 && poped[currentPopedIndex] == stack.getLast()){
            stack.removeLast();
            if(poppedNums(pushed, poped, stack, currentPushIndex, currentPopedIndex+1)){
                return true;
            }
        }

        if(currentPushIndex==pushed.length){
            return false;
        }

        // 如果上面情况都不成立，则将当前的数压栈直到当前压栈的数等于要出栈的数
        while (currentPushIndex<pushed.length){
            if(pushed[currentPushIndex]==poped[currentPopedIndex]){
                if(poppedNums(pushed, poped, stack, currentPushIndex+1, currentPopedIndex+1)){
                    return true;
                }else {
                    break;
                }
            }else {
                stack.addLast(pushed[currentPushIndex]);
                currentPushIndex++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Offer34_1 offer341 = new Offer34_1();
        /*int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};*/
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,1,2};
        /*int[] pushed = new int[]{1,0};
        int[] popped = new int[]{0,1};*/
        System.out.println(offer341.validateStackSequences(pushed, popped));
    }
}
