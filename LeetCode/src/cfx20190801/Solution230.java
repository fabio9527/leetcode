package cfx20190801;

public class Solution230 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*
    //解法1
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        midVist(root,k,list);
        return list.get(k-1);
    }

    //中序遍历
    private void midVist(TreeNode root, int k, ArrayList<Integer> list){
        int j=0;
        if(list.size()<k || root.val<list.get(k-1)){
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext() && j<k){
                if(iterator.next()<root.val)
                    ++j;
            }
            list.add(j,root.val);
        }
        if(root.left==null && root.right==null)
            return;
        if(root.left!=null){
            midVist(root.left,k,list);
        }
        if(root.right!=null){
            midVist(root.right,k,list);
        }
    }*/

    //解法2：二叉搜索树，两边有序，
    public int kthSmallest(TreeNode root, int k) {
        TreeNode count=new TreeNode(0);
        return leftFirst(root,count,k).val;
    }

    //左序遍历，计数即可
    public TreeNode leftFirst(TreeNode node,TreeNode count,int k){
        TreeNode target=null;
        //如果
        if(node.left!=null){
            target=leftFirst(node.left,count,k);
        }
        if(target!=null){
            return target;
        }else if((++count.val)==k){
            return node;
        }
        if(node.right!=null){
            return leftFirst(node.right,count,k);
        }
        return null;
    }


    public static void main(String[] args) {
        TreeNode root =new TreeNode(2);
        root.left=new TreeNode(3);
        TreeNode right=new TreeNode(4);
        root.right=right;
        right.left=new TreeNode(10);
        right.right=new TreeNode(20);
        Solution230 solution230=new Solution230();
        System.out.println(solution230.kthSmallest(root,2));
    }
}
