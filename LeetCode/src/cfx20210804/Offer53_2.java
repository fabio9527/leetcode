package cfx20210804;

public class Offer53_2 {

    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * @param nums
     * @return
     */
    public int missingNumber_1(int[] nums) {
        int i = 0;
        while (i< nums.length && nums[i]==i){
            i++;
        }
        return i;
    }
    public int missingNumber(int[] nums) {
        int right = nums.length-1;
        if(nums[right] == right){
            return right+1;
        }
        int left = 0;
        int mid;
        while (left < right){
            mid = (left+right)/2;
            if(nums[mid] == mid){
                left = ++mid;
            }else if(nums[mid] == (mid+1)){
                right = mid;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        Offer53_2 offer53_2 = new Offer53_2();
        int[] nums = new int[]{1,2};
        System.out.print(offer53_2.missingNumber(nums));
    }
}
