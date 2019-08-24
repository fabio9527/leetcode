package cfx20190606;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        if(nums==null)
            return null;

        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);

        if(nums.length<4)
            return lists;

        int left;
        int right;
        int temp;

        for(int i=0;i<=nums.length-4;i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<=nums.length-3;j++){
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                left=j+1;
                right=nums.length-1;
                while(left<right){
                    temp=nums[left]+nums[right]+nums[i]+nums[j];
                    if(temp==target){
                        lists.add(Arrays.asList(nums[left],nums[right],nums[i],nums[j]));
                        left++;
                        while(nums[left]==nums[left-1] && left<right){left++;}
                        right--;
                        while (nums[right]==nums[right+1] && left<right){right--;}
                    }

                    else {
                        if(temp>target)
                            right--;
                        else
                            left++;
                    }
                }
            }
        }
        return lists;
    }
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//
//        if(nums==null)
//            return null;
//
//        List<List<Integer>> lists=new ArrayList<>();
//
//        if(nums.length<4)
//            return lists;
//
//        int left=0;
//        int right=nums.length-1;
//        int innerleft;
//        int innerright=right-1;
//        int temp;
//        int dValue=Integer.MAX_VALUE;
//
//        while(left<=right-3){
//            innerleft=left+1;
//            innerright=right-1;
//            while (innerleft<innerright){
//                temp=nums[left]+nums[right]+nums[innerleft]+nums[innerright];
//                if(temp==target)
//                    return
//            }
//
//        }
//
//    }

    public static void main(String[] args) {
        Solution18 solution18=new Solution18();
        int[] nums={5,5,3,5,1,-5,1,-2};
        System.out.println(solution18.fourSum(nums,4));
    }
}
