package cfx20210802;

public class Offer21 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (null == nums || nums.length == 0) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        int temp;
        while (true) {
            // 从左往右遇到奇数跳过
            while (left < nums.length && nums[left] % 2 == 1) {
                left++;
            }
            while (right >= 0 && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            } else {
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Offer21 offer21 = new Offer21();
        int[] nums = new int[]{2, 3, 5, 6, 8, 9};
        int[] exchange = offer21.exchange(nums);
        for (int i : exchange) {
            System.out.print(i + ",");
        }
    }
}
