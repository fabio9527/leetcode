package cfx20210711;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Offer32_1 {

    public int[] levelOrder(TreeNode root) {
        if(null == root){
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> currrentNodeList = new LinkedList<>();
        currrentNodeList.add(root);
        while (currrentNodeList.size() > 0) {
            TreeNode node = currrentNodeList.removeFirst();
            result.add(node.val);
            if (null != node.left) {
                currrentNodeList.addLast(node.left);
            }
            if (null != node.right) {
                currrentNodeList.addLast(node.right);
            }

        }
        int[] nums = new int[result.size()];
        for (int i = 0;i<result.size();i++) {
            nums[i] = result.get(i);
        }
        return nums;
    }

}
