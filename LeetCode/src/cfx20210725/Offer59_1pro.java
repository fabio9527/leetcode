package cfx20210725;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Offer59_1pro {

    /**
     * 滑动窗口的最大值
     * <p>
     * 思路：单调队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        Deque<Integer> queue = new LinkedList<>();
        int i = 0;
        while (i < k - 1){
            while (queue.size()>0 && nums[queue.peekLast()] < nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            i++;
        }
        int[] result = new int[nums.length - k + 1];
        while (i < nums.length){
            while (queue.size()>0 && nums[queue.peekLast()] < nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            while (i-queue.peekFirst()>=k){
                queue.removeFirst();
            }
            result[i-k+1] = nums[queue.peekFirst()];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Offer59_1pro offer59_1pro = new Offer59_1pro();
        int[] nums = new int[]{1,-1};
        int[] result = offer59_1pro.maxSlidingWindow(nums, 1);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }
}
