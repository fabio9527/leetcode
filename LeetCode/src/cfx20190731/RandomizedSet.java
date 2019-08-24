package cfx20190731;


import java.util.*;

public class RandomizedSet {
/*  设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
    insert(val)：当元素 val 不存在时，向集合中插入该项。
    remove(val)：元素 val 存在时，从集合中移除该项。
    getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
*/

    Map<Integer,Integer> map1=new HashMap<>();
    Map<Integer,Integer> map2=new HashMap<>();
    int index;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.index=0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map1.get(val)==null){
            map1.put(val,index);
            map2.put(index,val);
            index++;
            return true;
        }else
            return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer currentIndex;
        Integer temp;

        //如果有值，则使得当前
        if((currentIndex=map1.get(val))!=null){
            map2.remove(currentIndex);
            map1.remove(val);
            index--;
            temp = map2.get(index);
            map1.put(temp,currentIndex);
            map2.remove(index);
            map2.put(currentIndex,temp);
            return true;
        }else
            return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random=new Random();
        int i = random.nextInt(map2.size());
        return map2.get(i);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
    }
}
