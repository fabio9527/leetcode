package cfx20210711;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer32_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(null == root){
            return new ArrayList<>();
        }

        LinkedList<TreeNode> curentNodeList = new LinkedList();
        curentNodeList.addLast(root);

        int i =0;
        List<List<Integer>> result = new ArrayList<>();
        while (curentNodeList.size()>0){
            LinkedList<TreeNode> tempNodeList = new LinkedList<>();
            List<Integer> currentResult = new ArrayList<>();
            while (curentNodeList.size()>0){
                TreeNode node;
                if(i%2==0){
                    node = curentNodeList.removeFirst();
                }else {
                    node = curentNodeList.removeLast();
                }
                currentResult.add(node.val);
                if(i%2==0){
                    if(null != node.left){
                        tempNodeList.addLast(node.left);
                    }
                    if(null != node.right){
                        tempNodeList.addLast(node.right);
                    }
                }else {
                    if(null != node.right){
                        tempNodeList.addFirst(node.right);
                    }
                    if(null != node.left){
                        tempNodeList.addFirst(node.left);
                    }
                }
            }
            i++;
            curentNodeList.addAll(tempNodeList);
            result.add(currentResult);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Offer32_2 offer32_2 = new Offer32_2();
        List<List<Integer>> lists = offer32_2.levelOrder(root);
        for(List<Integer> nums : lists){
            for(Integer num : nums){
                System.out.print(num+",");
            }
            System.out.println();
        }
    }
}
