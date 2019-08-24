package cfx20190610;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean[] isSelect=new boolean[nums.length];

        if(nums==null || nums.length==0)
            return lists;

        tranverse(lists,list,nums,isSelect);
        return lists;

    }

    private void tranverse(List<List<Integer>> lists,List<Integer> list,int[] nums,boolean[] isSelect){

        List<Integer> temp=new ArrayList<>();
        temp.addAll(list);
        if(temp.size()==nums.length) {
            lists.add(temp);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!isSelect[i]){
                temp.add(nums[i]);
                isSelect[i]=true;
                tranverse(lists,temp,nums,isSelect);
                temp.remove(temp.size()-1);
                isSelect[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        Solution46 solution46=new Solution46();
        int[] nums={1};
        List<List<Integer>> permute = solution46.permute(nums);
        System.out.println(permute);
    }
}
