package cfx20190609;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();

        if(candidates==null || candidates.length==0)
            return lists;
        Arrays.sort(candidates);
        tranverse(target,candidates,0,list,lists);
        return lists;

    }

    public void tranverse(int target,int[] candidaes,int startIndex,List<Integer> list,List<List<Integer>> lists){

        int tempCount;
        List<Integer> tempList=new ArrayList<>();
        tempList.addAll(list);

        for(int i=startIndex;i<candidaes.length;i++) {
            if(i!=startIndex && candidaes[i]==candidaes[i-1])
                continue;
            tempCount=target-candidaes[i];
            tempList.add(candidaes[i]);
            if(tempCount==0){
                lists.add(tempList);
                return;
            }
            if(tempCount>0){
                tranverse(tempCount,candidaes,i+1,tempList,lists);
                tempList.remove(tempList.size()-1);
            }
            if(tempCount<0)
                return;
        }

    }

    public static void main(String[] args) {
        Solution40 solution40=new Solution40();
        int[] nums={2,5,2,1,2};
        List<List<Integer>> lists=solution40.combinationSum2(nums,5);
        System.out.println(lists);
    }
}
