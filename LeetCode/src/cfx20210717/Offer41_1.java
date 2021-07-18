package cfx20210717;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer41_1 {

    // 最大堆
    PriorityQueue<Integer> left;
    // 最小堆
    PriorityQueue<Integer> right;
    /**
     * 如何得到一个数据流中的中位数？
     * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     *
     * 思路：使用Java自带API 优先队列   PriorityQueque
     */
    public Offer41_1() {
        left = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        right = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    public void addNum(int num) {
        if(left.size()==right.size()){
            if(left.size()==0){
                left.add(num);
            }else {
                if(num>right.peek()){
                    right.add(num);
                }else {
                    left.add(num);
                }
            }
        }else if(left.size()>right.size()){
            if(num<left.peek()){
                right.add(left.remove());
                left.add(num);
            }else {
                right.add(num);
            }
        }else {
            if(num>right.peek()){
                left.add(right.remove());
                right.add(num);
            }else {
                left.add(num);
            }
        }
        System.out.println();
    }

    public double findMedian() {
        if(left.size()==right.size()){
            return (double) (left.peek()+right.peek())/2;
        }else if(left.size()>right.size()){
            return left.peek();
        }else {
            return right.peek();
        }
    }

    public static void main(String[] args) {
        Offer41_1 offer41_1 = new Offer41_1();
        ArrayList<Integer> heap = new ArrayList<>();

        offer41_1.addNum(1);
        offer41_1.addNum(2);
        System.out.print(offer41_1.findMedian()+",");
        offer41_1.addNum(3);
        offer41_1.addNum(4);
        System.out.print(offer41_1.findMedian()+",");
    }

}
