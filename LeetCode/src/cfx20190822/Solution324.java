package cfx20190822;

import java.util.Arrays;

public class Solution324 {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length==0){
            return;
        }
        int length=nums.length;
        int[] target=new int[length];
        for(int i=0;i<length;i++){
            target[i]=nums[i];
        }
        Arrays.sort(target);
        for(int i=0;i<length;i++){
            if(i%2==0){
               nums[i]=target[(length-i-1)/2];
            }
            if(i%2==1){
                nums[i]=target[length-i/2-1];
            }
        }
    }

    public static void main(String[] args) {
        Solution324 solution324=new Solution324();
        int[] ints={1,2,4,4,4,6};
        solution324.wiggleSort(ints);
        for (int i=0;i<ints.length;i++){
            System.out.print(ints[i]+",");
        }
    }
}
