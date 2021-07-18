package cfx20210717;

public class Offer42 {

    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * <p>
     * 要求时间复杂度为O(n)。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            // 只有大于0的值才可以累加
            if (sum + num > 0) {
                sum = sum + num;
                if (sum > max) {
                    max = sum;
                }
            } else {
                sum = 0;
                // 否则直接和当前遍历值比较即可
                if (num > max) {
                    max = num;
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Offer42 offer42 = new Offer42();
        int[] nums = new int[]{1,-1,1};
        System.out.println(offer42.maxSubArray(nums));
    }
}
