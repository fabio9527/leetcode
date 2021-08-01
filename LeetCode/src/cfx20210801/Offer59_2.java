package cfx20210801;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Offer59_2 {

    /**
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
     * <p>
     * 若队列为空，pop_front 和 max_value需要返回 -1
     */

    LinkedList<Integer> timeSort = new LinkedList();
    PriorityQueue<Integer> numSort = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public Offer59_2() {
    }

    public int max_value() {
        if (numSort.size() == 0) {
            return -1;
        } else {
            return numSort.peek();
        }
    }

    public void push_back(int value) {
        timeSort.addLast(value);
        numSort.add(value);
    }

    public int pop_front() {
        if (timeSort.size() == 0) {
            return -1;
        } else {
            int num = timeSort.removeFirst();
            numSort.remove(num);
            return num;
        }
    }
}
