package cfx20190809;

public class Solution297 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /*
    * 使用先序遍历进行序列化
    * */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return null;
        return encodeMidFirst(root).toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null)
            return null;
        String[] split = data.split("\\|");
        int[] ints=new int[1];
        return decodeMidFirst(split,ints);
    }

    //先序遍历编码
    private StringBuilder encodeMidFirst(TreeNode node){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(node.val+"|");
        if(node.left!=null){
            stringBuilder.append(encodeMidFirst(node.left));
        }else {
            stringBuilder.append("%"+"|");
        }
        if(node.right!=null){
            stringBuilder.append(encodeMidFirst(node.right));
        }else {
            stringBuilder.append("%"+"|");
        }
        return stringBuilder;
    }

    //先序遍历解码
    private TreeNode decodeMidFirst(String[] strings,int[] ints){
        TreeNode node=new TreeNode(Integer.parseInt(strings[ints[0]]));
        ints[0]++;
        //左边非等于空
        if(!strings[ints[0]].equals("%")){
            node.left=decodeMidFirst(strings,ints);
        }else {
            ints[0]++;
        }
        if(!strings[ints[0]].equals("%")){
            node.right=decodeMidFirst(strings,ints);
        }else {
            ints[0]++;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(2);
        root.left=new TreeNode(3);
        TreeNode right=new TreeNode(4);
        root.right=right;
        right.left=new TreeNode(10);
        right.right=new TreeNode(20);
        Solution297 solution297=new Solution297();
        String s = solution297.serialize(root);
        System.out.println(s);
        TreeNode deserialize = solution297.deserialize(s);
        System.out.println(deserialize);
    }

}
