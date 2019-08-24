package cfx20190611;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> lists=new ArrayList<>();
        if(strs==null || strs.length==0)
            return lists;

        char[] temp;
        boolean flag;
        List<String> list=new ArrayList<>();
        int l;

        for(int i=0;i<strs.length;i++){
            temp=strs[i].toCharArray();
            Arrays.sort(temp);
            String sb=Arrays.toString(temp);
            l=0;
            flag=false;
            while (l<lists.size()){
                //有相同的串就跳出循环，然后进行添加
                if(list.get(l).equals(sb)){
                    flag=true;
                    break;
                }
                l++;
            }
            if(flag){
                List<String> correntList=lists.get(l);
                correntList.add(strs[i]);
            }else {
                list.add(sb);
                List<String> correntList=new ArrayList<>();
                correntList.add(strs[i]);
                lists.add(correntList);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution49 solution49=new Solution49();
        String[] strings={"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strings={"",""};
        System.out.println(solution49.groupAnagrams(strings));
    }
}
