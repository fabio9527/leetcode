package cfx20210711;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Offer32_1 {

    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * <p>
     * 思路：广度优先遍历
     *
     * @param root
     * @return
     */
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        Offer32_1 offer32_1 = new Offer32_1();
        int[] ints = offer32_1.levelOrder(root);
        for(int num : ints){
            System.out.println(num);
        }
    }
}
