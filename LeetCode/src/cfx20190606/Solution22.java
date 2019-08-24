package cfx20190606;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        String temp=new String();
        if(n<=0)
            return list;
        else
            backTrace(list,temp,n*2,0,0);
        return list;

    }

    public void backTrace(List<String> list,String temp,int targetCount,int leftCount,int rightCount){
        if(leftCount+rightCount==targetCount){
            list.add(temp);
            return;
        }
        if(temp.length()<targetCount) {
            if (leftCount >=rightCount && leftCount<targetCount/2 ) {
                backTrace(list, temp+"(", targetCount, leftCount + 1, rightCount);
            }
            if (rightCount<leftCount ) {
                backTrace(list, temp+")",targetCount, leftCount, rightCount+1);
            }

        }
    }

    public static void main(String[] args) {
        Solution22 solution22=new Solution22();
//        List<String> list=solution22.generateParenthesis(4);
//        String[] strings={"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
//        List<String> list1=solution22.generateParenthesis(3);
//        System.out.println(list1);
//        int count[]=new int[list.size()];
//        String temp;
//        for(int i=0;i<list.size();i++){
//            temp=strings[i];
//            for (String str:list) {
//                if(temp.equals(str))
//                    count[i]++;
//            }
//        }
//
//        for (int i=0;i<count.length;i++) {
//            if(count[i]==0)
//                System.out.print(i+",");
//        }
//
        System.out.println(solution22.generateParenthesis(4));
    }
}
