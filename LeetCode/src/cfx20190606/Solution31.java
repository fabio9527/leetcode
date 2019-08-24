package cfx20190606;


public class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1)
            return;
        int i=nums.length-2;
        while(i>=0){
            if(nums[i]>=nums[i+1])
                i--;
            else
                break;
        }
        int left;
        int right=nums.length-1;
        int temp;
        if(i<0){
           left=0;
        }else {
            while(nums[right]<=nums[i]){
                right--;
            }
            temp=nums[right];
            nums[right]=nums[i];
            nums[i]=temp;
            left=i+1;
        }
        right=nums.length-1;
        while(left<right){
            temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution31 solution31=new Solution31();
        int[] ints={1,1,3,2,1};
        solution31.nextPermutation(ints);
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i]+",");
        }
    }
}
