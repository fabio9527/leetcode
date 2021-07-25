package cfx20210724;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer68_2 {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 一个节点也可以是它自己的祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> parentNodes = new ArrayList<>();
        getParent(root, p, q, parentNodes);
        return parentNodes.get(0);

    }

    private boolean getParent(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> parentNodes){
        if(null == root.left && null == root.right){
            if(root == p || root == q){
                return true;
            }else {
                return false;
            }
        }

        boolean lParent = false, rParent = false;
        if(null != root.left && (lParent = getParent(root.left, p, q, parentNodes))){
            if(root == p || root == q){
                parentNodes.add(root);
                return true;
            }
        }
        if(null != root.right && (rParent = getParent(root.right, p, q, parentNodes))){
            if(root == p || root== q){
                parentNodes.add(root);
                return true;
            }
        }
        if(lParent && rParent){
            parentNodes.add(root);
        }
        if(root == p || root == q){
            return true;
        }else {
            return lParent || rParent;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        Offer68_2 offer68_2 = new Offer68_2();
        System.out.println(offer68_2.lowestCommonAncestor(root, root.left, root.right).val);
    }
}
