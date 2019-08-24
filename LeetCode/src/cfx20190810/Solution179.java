package cfx20190810;

import java.util.*;

public class Solution179 {

    /*
    * 从右到左按位找出最大数即可
    * */
    public String largestNumber(int[] nums) {
        if(nums==null)
            return null;
        StringBuilder stringBuilder=new StringBuilder();
        List<String> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(String.valueOf(nums[i]));
        }
        //排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1=o1+o2;
                String str2=o2+o1;
                return str2.compareTo(str1);
            }
        });
        if(list.get(0).equals("0"))
            return "0";
        for (String num: list) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        int[] ints={5,54,52,67,68,5,52,17,93,53};
        Solution179 solution179=new Solution179();
        System.out.println(solution179.largestNumber(ints));
    }
}
