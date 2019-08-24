package cfx20190608;

//思路：执行二分查找
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {

        int[] indexs={-1,-1};
        if(nums==null || nums.length==0)
            return indexs;

        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2;
        boolean flag=false;

        //找出target的其中一个位置
        while(left<=right){
            if(nums[mid]==target) {
                flag=true;
                break;
            }
            else {
                if(nums[mid]>target)
                    right=mid-1;
                else
                    left=mid+1;
            }
            mid=(left+right)/2;
        }
        if(!flag)
            return indexs;

        //对mid的左右处找出target的初始位置和结束位置
        int tempIndex;
        left=0;
        right=nums.length-1;
        indexs[0]=mid;
        tempIndex=(left+indexs[0])/2;
        while (indexs[0]>tempIndex){
            if(nums[tempIndex]==target){
                indexs[0]=tempIndex;
            }else
                left=tempIndex+1;
            tempIndex=(indexs[0]+left)/2;
        }

        indexs[1]=mid;
        tempIndex=(right+indexs[1])/2;
        while (indexs[1]<tempIndex && indexs[1]!=tempIndex){
            if(nums[tempIndex]==target){
                indexs[1]=tempIndex;
            }else
                right=tempIndex-1;
            tempIndex=(indexs[1]+right)/2;
        }
        if(nums[right]==target)
            indexs[1]=right;

        return indexs;
    }

    public static void main(String[] args) {
        Solution34 solution34=new Solution34();
        int[] nums={5};
        int[] indexs=solution34.searchRange(nums,5);
        for (int index:indexs) {
            System.out.print(index+",");
        }
    }
}
