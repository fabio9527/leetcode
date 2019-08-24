package cfx20190822;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        return findPeak(nums,0,nums.length-1);
    }

    private int findPeak(int[] nums,int start,int end){
        int mid=(start+end)/2;
        if(mid<end && mid>start && nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
            return mid;
        }else if(end==start+1) {
            return nums[start] > nums[end] ? start : end;
        }else if(start==end){
            return start;
        }else if(mid<end && mid>start && nums[mid]> nums[mid+1]){
            return findPeak(nums,0,mid);
        }else if(mid<end && mid>start && nums[mid]> nums[mid-1]){
            return findPeak(nums,mid,end);
        }else {
            return findPeak(nums,0,mid-1);
        }
    }

    public static void main(String[] args) {
        Solution162 solution162=new Solution162();
        int[] nums={1,2,3,4,4,3,2,1};
        System.out.print(solution162.findPeakElement(nums));
    }
}
