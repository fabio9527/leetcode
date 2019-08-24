package cfx20190610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean[] isSelect=new boolean[nums.length];

        if(nums==null || nums.length==0)
            return lists;

        Arrays.sort(nums);
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
                if(i!=0 && nums[i]==nums[i-1] && isSelect[i-1])
                    continue;
                else {
                    temp.add(nums[i]);
                    isSelect[i] = true;
                    tranverse(lists, temp, nums, isSelect);
                    temp.remove(temp.size() - 1);
                    isSelect[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution47 solution47=new Solution47();
        int[] nums={1,1,2};
        List<List<Integer>> permute = solution47.permuteUnique(nums);
        System.out.println(permute);
    }
}
