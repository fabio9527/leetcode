package cfx20210717;

import java.util.ArrayList;
import java.util.ListResourceBundle;

public class Offer41 {

    // 最大堆
    ArrayList<Integer> left;

    // 最小堆
    ArrayList<Integer> right;
    /**
     * 如何得到一个数据流中的中位数？
     * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     */
    public Offer41() {
        left = new ArrayList<>();
        right = new ArrayList<>();
    }

    public void addNum(int num) {
        if(left.size()==right.size()){
            if(left.size()==0){
                left.add(num);
            }else {
                if(num>right.get(0)){
                    right.add(num);
                    shiftUp(right, right.size()-1, true);
                }else {
                    left.add(num);
                    shiftUp(left, left.size()-1, false);
                }
            }
        }else if(left.size()>right.size()){
            if(num<left.get(0)){
                right.add(left.get(0));
                shiftUp(right,right.size()-1,true);
                left.set(0,num);
                shiftDown(left, 0, false);
            }else {
                right.add(num);
                shiftUp(right,right.size()-1,true);
            }
        }else {
            if(num>right.get(0)){
                left.add(right.get(0));
                shiftUp(left,left.size()-1,false);
                right.set(0,num);
                shiftDown(right,0,true);
            }else {
                left.add(num);
                shiftUp(left,left.size()-1,false);
            }
        }
        System.out.println();
    }

    public double findMedian() {
        if(left.size()==right.size()){
            return (double) (left.get(0)+right.get(0))/2;
        }else if(left.size()>right.size()){
            return left.get(0);
        }else {
            return right.get(0);
        }
    }

    public static void buildHeap(ArrayList<Integer> nums, boolean isTrue){
        if(nums.size()==1){
            return;
        }
        int length = nums.size();
        int left,right;
        int lastLeafIndex = (nums.size()-2)>>>1;
        while (lastLeafIndex>=0){
            left = (lastLeafIndex<<1)+1;
            right = (lastLeafIndex<<1)+2;
            // 右边存在，并且大于左边
            if(right<nums.size() && compareTo(nums.get(left), nums.get(right), isTrue) && compareTo(nums.get(lastLeafIndex), nums.get(right), isTrue)){
                exchange(nums, lastLeafIndex, right);
                // 交换下来的较大数下沉
                shiftDown(nums, right, isTrue);
            }else if(compareTo(nums.get(lastLeafIndex), nums.get(left), isTrue)){
                exchange(nums,lastLeafIndex, left);
                shiftDown(nums, left, isTrue);
            }
            lastLeafIndex--;
        }
    }

    public static void exchange(ArrayList<Integer> nums, int indexA, int indexB) {
        int temp = nums.get(indexA);
        nums.set(indexA, nums.get(indexB));
        nums.set(indexB,temp);
    }

    /**
     * 以index为根，将大数下沉
     * @param nums
     * @param index
     */
    public static void shiftDown(ArrayList<Integer> nums, int index, boolean isTrue){
        int left;
        int right;
        int tempLeafIndex;
        int i = nums.size() >>> 1;
        while (index< i){
            left = (index<<1)+1;
            right = (index<<1)+2;
            // 假如右边存在，并且右边比左边小
            if(right<nums.size() && compareTo(nums.get(left), nums.get(right), isTrue) && compareTo(nums.get(index), nums.get(right), isTrue)){
                exchange(nums, index, right);
                tempLeafIndex = right;
            }else if(compareTo(nums.get(index), nums.get(left), isTrue)){
                exchange(nums, index, left);
                tempLeafIndex = left;
            }else {
                break;
            }
            index = tempLeafIndex;
        }
    }

    /**
     * 以index为叶，将小数上浮
     * @param nums
     * @param index
     * @param isTrue
     */
    public static void shiftUp(ArrayList<Integer> nums, int index, boolean isTrue){
        int parent ;
        while (index > 0){
            parent = (index-1)>>>1;
            // 假如右边存在，并且右边比左边小
            if(compareTo(nums.get(parent), nums.get(index), isTrue)){
                exchange(nums, index, parent);
                index = parent;
            }else {
                break;
            }
        }
    }

    /**
     * @param a
     * @param b
     * @param isTrue 如果isTrue为True，则返回真实结果，否则返回相反结果
     * @return
     */
    public static boolean compareTo(int a, int b, boolean isTrue){
        boolean result;
        if(a>b){
            result = true;
        }else {
            result = false;
        }
        if(isTrue){
            return result;
        }else {
            return !result;
        }
    }


    public static void main(String[] args) {
        Offer41 offer41 = new Offer41();
        ArrayList<Integer> heap = new ArrayList<>();

        offer41.addNum(-1);
        System.out.print(offer41.findMedian()+",");
        offer41.addNum(-2);
        System.out.print(offer41.findMedian()+",");
        offer41.addNum(-3);
        System.out.print(offer41.findMedian()+",");
        offer41.addNum(-4);
        System.out.print(offer41.findMedian()+",");
        offer41.addNum(-5);
        System.out.print(offer41.findMedian()+",");
    }
}
