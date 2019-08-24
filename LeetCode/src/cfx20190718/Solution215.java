package cfx20190718;

import javax.swing.*;
import java.util.Arrays;

public class Solution215 {
    public static void main(String[] args) {
        int[] nums={2,4,1,87,34,67,32,56,89,43,34,4};
//        int[] nums={3,2,3,1,2,4,5,5,6};
        Solution215 solution215=new Solution215();
        System.out.println(solution215.findKthLargest(nums,4));

        System.out.println("排序之前的数组：");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+",");
        }
        for(int i=nums.length-1;i>0;i--){

            System.out.println();
            solution215.heapSort(nums,0,i);
            System.out.println("排序"+i);
            for(int j=0;j<nums.length;j++){
                System.out.print(nums[j]+",");
            }
            solution215.exchange(nums,0,i);
        }
        System.out.println();
        System.out.println("排序之后的数组：");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+",");
        }
    }
    //进项堆排序
    public void heapSort(int[] nums,int start,int end){
        //首先创建最大堆
        for (int i=(end-1)/2;i>=start;i--){
           checkHeap(nums,i,end);
        }
    }
    private void checkHeap(int[] nums,int rootIndex,int end){
        int left=rootIndex*2 + 1;
        int right=rootIndex*2 + 2;
        if(right<end) {
            int maxIndex = getMaxIndex(nums, left, right);
            if (nums[maxIndex] > nums[rootIndex]) {
                exchange(nums, maxIndex, rootIndex);
                checkHeap(nums,maxIndex,end);
            }
        }
        else if(right==end){
            int maxIndex = getMaxIndex(nums, left, right);
            if (nums[maxIndex] > nums[rootIndex]) {
                exchange(nums, maxIndex, rootIndex);
            }
        } else if(left==end) {
            if(nums[left]>nums[rootIndex]) {
                exchange(nums,left,rootIndex);
            }
        }
    }

    private int getMaxIndex(int[] nums,int i,int j){
        return nums[i]>=nums[j]?i:j;
    }

    private void exchange(int[] nums,int i,int j){
        int temp;
        temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k-1];

    }
}
