package cfx20210728;

import java.util.HashSet;
import java.util.Set;

public class Offer03 {
    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber_1(int[] nums) {
        boolean[] checkNum = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!checkNum[nums[i]]) {
                checkNum[nums[i]] = true;
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    public int findRepeatNumber_2(int[] nums) {
        Set<Integer> checkNum = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!checkNum.contains(nums[i])) {
                checkNum.add(nums[i]);
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    public int findRepeatNumber_3(int[] nums) {
        int i = 0;
        int temp;
        while (i<nums.length){
            if(nums[i] == i){
                i++;
                continue;
            }
            if(nums[nums[i]] != nums[i]){
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }else {
                return nums[i];
            }
        }
        return -1;
    }
}
