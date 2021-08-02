package cfx20210802;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Offer07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        getTree(root, preorder, 0, inorder, 0, inorder.length - 1);
        return root;
    }

    private void getTree(TreeNode root, int[] preorder, int rootIndexPreorder, int[] inorder, int startIndexInorder, int endIndexInorder) {
        // 当前节点没有左右子树
        if (endIndexInorder == startIndexInorder) {
            return;
        }
        // 构建左子树
        int i = startIndexInorder;
        while (i <= endIndexInorder && inorder[i] != root.val) {
            i++;
        }
        if (i > startIndexInorder) {
            TreeNode leftRoot = new TreeNode(preorder[rootIndexPreorder + 1]);
            root.left = leftRoot;
            getTree(leftRoot, preorder, rootIndexPreorder + 1, inorder, startIndexInorder, i - 1);
        }
        if (i < endIndexInorder) {
            TreeNode rightRoot = new TreeNode(preorder[rootIndexPreorder + i - startIndexInorder + 1]);
            root.right = rightRoot;
            getTree(rightRoot, preorder, rootIndexPreorder + i - startIndexInorder +1, inorder, i + 1, endIndexInorder);
        }
    }

    public static void main(String[] args) {
        Offer07 offer07 = new Offer07();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        offer07.buildTree(preorder, inorder);
    }
}
