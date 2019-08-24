package cfx20190609;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();

        if(candidates==null || candidates.length==0)
            return lists;

        Arrays.sort(candidates);
        traverse(candidates,0,target,list,lists);
        return lists;

    }

    public void traverse(int[] candidates, int startIndex,int target,List<Integer> list,List<List<Integer>> lists){

        List<Integer> temp=new ArrayList();
        temp.addAll(list);
        int tempCount;
        for(int i=startIndex;i<candidates.length;i++){
            tempCount=target-candidates[i];
            temp.add(candidates[i]);
            if(tempCount==0) {
                lists.add(temp);
                return;
            }
            if(tempCount>0){
                traverse(candidates,i,tempCount,temp,lists);
                temp.remove(temp.size()-1);
            }
            if(tempCount<0)
                return;
        }
    }

    public static void main(String[] args) {
        Solution39 solution39=new Solution39();
        int[] nums={2,3,5};
        List<List<Integer>> lists=solution39.combinationSum(nums,8);
        System.out.println(lists);
    }
}
