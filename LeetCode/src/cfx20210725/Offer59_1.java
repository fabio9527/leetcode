package cfx20210725;

public class Offer59_1 {
    /**
     * 滑动窗口的最大值
     *
     * 思路：动态规划
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int[] temp = new int[nums.length];
        if(nums == null || nums.length == 0){
            return temp;
        }

        while (i < nums.length){
            temp[i] = nums[i];
            i++;
        }
        int j = 2;
        while (j <= k){
            i = nums.length-1;
            while (i >= j-1){
                temp[i] = temp[i-1]>nums[i] ? temp[i-1]:nums[i];
                i--;
            }
            j++;
        }
        int[] result = new int[nums.length-k+1];
        i = 0;
        while (i < result.length){
            result[i] = temp[i+k-1];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Offer59_1 offer59_1 = new Offer59_1();
        int[] nums = new int[]{7,2,4};
        int[] result = offer59_1.maxSlidingWindow(nums, 2);
        for(int i : result){
            System.out.print(i+",");
        }
    }
}
