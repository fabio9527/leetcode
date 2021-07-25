package cfx20210724;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Offer68_1 {

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 一个节点也可以是它自己的祖先
     * <p>
     * 思路：两个链表的公共节点
     */
    public <Lis> TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || null == p || null == q) {
            return null;
        }

        List<TreeNode> pParentNodes = getParent(root, p);
        List<TreeNode> qParentNodes = getParent(root, q);

        int i = 0;

        while (i < pParentNodes.size() && i < qParentNodes.size() && pParentNodes.get(i) == qParentNodes.get(i)) {
            i++;
        }
        return pParentNodes.get(i - 1);

    }

    private List<TreeNode> getParent(TreeNode root, TreeNode target) {
        List<TreeNode> parentNodeList = new ArrayList<>();
        while (root != target) {
            parentNodeList.add(root);
            if (target.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        parentNodeList.add(root);
        return parentNodeList;
    }
}
