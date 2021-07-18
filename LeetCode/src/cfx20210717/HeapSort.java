package cfx20210717;

import java.awt.dnd.InvalidDnDOperationException;
import java.beans.EventHandler;

public class HeapSort {

    public static void buildHeap(int[] nums){
        if(nums.length==1){
            return;
        }
        int length = nums.length;
        int left,right;
        int lastLeafIndex = (nums.length-2)>>>1;
        while (lastLeafIndex>=0){
            left = (lastLeafIndex<<1)+1;
            right = (lastLeafIndex<<1)+2;
            // 右边存在，并且大于左边
            if(right<nums.length && nums[right]<nums[left] && nums[right]<nums[lastLeafIndex]){
                exchange(nums, lastLeafIndex, right);
                // 交换下来的较大数下沉
                shiftDown(nums, right);
            }else if(nums[left]<nums[lastLeafIndex]){
                exchange(nums,lastLeafIndex, left);
                shiftDown(nums, left);
            }
            lastLeafIndex--;
        }
    }

    public static void exchange(int[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }

    /**
     * 以index为根，将大数下沉
     * @param nums
     * @param index
     */
    public static void shiftDown(int[] nums, int index){
        int left;
        int right;
        int tempLeafIndex;
        int i = (nums.length - 2) >>> 1;
        while (index<= i){
            left = (index<<1)+1;
            right = (index<<1)+2;
            // 假如右边存在，并且右边比左边小
            if(right<nums.length && nums[left]>nums[right] && nums[right]<nums[index]){
                exchange(nums, index, right);
                tempLeafIndex = right;
            }else if(nums[left]<nums[index]){
                exchange(nums, index, left);
                tempLeafIndex = left;
            }else {
                break;
            }
            index = tempLeafIndex;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 6, 8, 5, 4, 9, 10, 1, 2, 3, 0, 11, 12};
        HeapSort.buildHeap(nums);
        int j = 2;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
            if(i+2==j){
                System.out.println();
                j=j*2;
            }

        }
    }
}
