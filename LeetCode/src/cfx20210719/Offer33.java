package cfx20210719;

import java.util.ArrayList;
import java.util.List;

public class Offer33 {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
     * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     *
     * 思路：root为最后一个节点，然后root右边即为右子树root节点，左子树节点为向左遍历第一个小于root的节点
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return checkTree(postorder, 0, postorder.length-1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean checkTree(int[] postorder, int startIndex, int endIndex, int max, int min){

        // 为叶节点
        if(startIndex == endIndex){
            if(postorder[startIndex]<max && postorder[startIndex]>min){
                return true;
            }else {
                return false;
            }
        }

        int leftChild = endIndex;

        // 寻找左子树根节点
        while (leftChild >= startIndex && postorder[endIndex] <= postorder[leftChild]){
            leftChild--;
        }
        // 存在右子树
        if(endIndex - leftChild >1){
            if(!checkTree(postorder, leftChild+1, endIndex-1, max, postorder[endIndex])){
                return false;
            }
        }
        // 存在左子树
        if(leftChild-startIndex>=0){
            if(!checkTree(postorder, startIndex, leftChild, postorder[endIndex], min)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Offer33 offer33 = new Offer33();
        int[] nums = new int[]{1,6,3,2,5};
        System.out.println(offer33.verifyPostorder(nums));
    }
}
