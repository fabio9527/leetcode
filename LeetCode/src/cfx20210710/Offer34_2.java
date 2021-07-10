package cfx20210710;

public class Offer34_2 {

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     *
     * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     *
     * 思路：最近搜索算法+深度优先遍历
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if(pushed.length==0 || popped.length==0){
            return true;
        }
        int i=0;
        while (i<pushed.length){
            if(pushed[i]==popped[0]){
                break;
            }
            i++;
        }
        boolean[] isPopped = new boolean[pushed.length];
        isPopped[i]=true;
        return searchAround(pushed, popped, i, 1, isPopped);
    }

    /**
     * 在currentPushIndex的两边搜索，若找到对应压入值，则返回index，若找不到则返回-1
     * @param pushed
     * @param poped
     * @param currentPushIndex
     * @param currentPopedIndex
     * @param isPopped
     * @return
     */
    private boolean searchAround(int[] pushed, int[] poped, int currentPushIndex, int currentPopedIndex, boolean[] isPopped){
        if(currentPopedIndex ==poped.length){
            return true;
        }

        // 向左搜索
        int i = currentPushIndex-1;
        while (i>=0){
            if(!isPopped[i]){
                if(pushed[i]==poped[currentPopedIndex]){
                    isPopped[i] = true;
                    if(searchAround(pushed, poped, i, currentPopedIndex+1, isPopped)){
                        return true;
                    }
                }else {
                    break;
                }
            }else {
                i--;
            }
        }

        // 向右搜索
        i = currentPushIndex+1;
        while (i<pushed.length){
            if(!isPopped[i]){
                if(pushed[i]==poped[currentPopedIndex]){
                    isPopped[i] = true;
                    if(searchAround(pushed, poped, i, currentPopedIndex+1, isPopped)){
                        return true;
                    }
                }else {
                    break;
                }
            }else {
                i++;
            }
        }

        // 寻找下一个在压入顺序中为压入值的值
        i= currentPushIndex+1;
        while (i<pushed.length){
            if(!isPopped[i] && pushed[i]==poped[currentPopedIndex]){
                isPopped[i] = true;
                if(searchAround(pushed, poped, i, currentPopedIndex+1, isPopped)){
                    return true;
                }
            }else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Offer34_2 offer342 = new Offer34_2();
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        /*int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,1,2};*/
        /*int[] pushed = new int[]{1,0};
        int[] popped = new int[]{0,1};*/
        /*int[] pushed = new int[]{0};
        int[] popped = new int[]{0};*/
        System.out.println(offer342.validateStackSequences(pushed, popped));
    }
}
