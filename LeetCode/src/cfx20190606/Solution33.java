package cfx20190606;


public class Solution33 {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        if(nums.length==1)
            return nums[0]==target? 0:-1;
        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2;
        int tempIndex=left;

        if(nums[left]<nums[right])
            return binSearch(nums,left,right,target);
        if(nums[left]>target && nums[right]<target)
            return -1;

        //先找到最小值的地址
        while (left<right-1){
            if(nums[left]>nums[mid])
                right=mid;
            else
                left=mid;
            mid=(left+right)/2;
        }
        tempIndex=nums[left]<nums[right] ? left:right;

        if(nums[0]<=target)
            return binSearch(nums,0,tempIndex-1,target);
        else
            return binSearch(nums,tempIndex,nums.length-1,target);
    }


    public int binSearch(int[] nums, int toIndex,int fromIndex,int target) {
        int left=toIndex;
        int right=fromIndex;
        int mid=(toIndex+fromIndex)/2;
        while (left<=right){
            if(target==nums[mid])
                return mid;
            if(nums[mid]<target)
                left=mid+1;
            else
                right=mid-1;
            mid=(left+right)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution33 solution33=new Solution33();
        int[] ints={4,7,8,0,1,3};
        System.out.println(solution33.search(ints,8));
    }
}
