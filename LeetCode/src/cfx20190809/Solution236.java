package cfx20190809;


public class Solution236 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*
    * 找公共祖先有两种情况：
    * 1、其中一个节点的祖先是另一个节点
    * 2、两个节点的祖先分别是一个节点的左右节点
    * 怎样只是遍历一次树就可以找出最小公共节点，中序遍历
    *
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        return midLast(root,p,q);
    }

    //后序遍历，返回当前遍历遇到目标节点的最小祖先，如遇到两个中的一个则返回自己，两个都已经遇到则返回最小公共祖先
    public TreeNode midLast(TreeNode node,TreeNode p,TreeNode q){
        TreeNode leftParent=null;
        TreeNode rightParent=null;
        if(node.left!=null){
            leftParent=midLast(node.left,p,q);
        }
        if(node.right!=null){
            rightParent=midLast(node.right,p,q);
        }
        //
        if(leftParent!=null && rightParent!=null){
            return node;
        } else {
            if(node.val==p.val || node.val==q.val){
                return node;
            }else {
                return leftParent==null? rightParent:leftParent;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(2);
        root.left=new TreeNode(3);
        TreeNode right=new TreeNode(4);
        root.right=right;
        right.left=new TreeNode(10);
        right.right=new TreeNode(20);
        Solution236 solution236=new Solution236();
        TreeNode treeNode = solution236.lowestCommonAncestor(root, root, right.left);
        System.out.println(treeNode.val);
    }
}
