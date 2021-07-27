package cfx20210727;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Offer34 {

    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
     * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     *
     * 思路：深度优先遍历
     *
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == root){
            return result;
        }
        List<Integer> path = new ArrayList<>();
        getPathByDFS(root, target, result, path, 0);
        return result;
    }

    private void getPathByDFS(TreeNode currentNode, int target, List<List<Integer>> result, List<Integer> path, int currentSum){
        // 叶节点操作
        if(null == currentNode.left && null == currentNode.right){
            if(currentSum+currentNode.val == target){
                List<Integer> targetPath = new ArrayList<>();
                targetPath.addAll(path);
                targetPath.add(currentNode.val);
                result.add(targetPath);
            }else {
                return;
            }
        }
        // 非叶节点操作

        path.add(currentNode.val);
        if(null != currentNode.left){
            getPathByDFS(currentNode.left, target, result, path, currentSum+currentNode.val);
        }
        if(null != currentNode.right){
            getPathByDFS(currentNode.right, target, result, path, currentSum+currentNode.val);
        }
        path.remove(path.size()-1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        Offer34 offer34 = new Offer34();
        List<List<Integer>> lists = offer34.pathSum(root, -1);
        for(List<Integer> path : lists){
            for(int i : path){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
}
