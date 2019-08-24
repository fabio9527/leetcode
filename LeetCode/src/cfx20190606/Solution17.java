package cfx20190606;

import java.util.ArrayList;
import java.util.List;

public class Solution17<sta> {

    public List<String> letterCombinations(String digits) {

        String[] nums={"","","abc","edf","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int[] current=new int[digits.length()];
        int[] length={0,0,3,3,3,3,3,4,3,4};
        int index;
        int count;
        StringBuilder temp;
        List<String> list=new ArrayList<>();
        if(digits==null)
            return null;
        if(digits=="" || digits.equals(""))
            return list;
        int j=0;
        while (true){
            temp=new StringBuilder();
            for (int i = 0; i < digits.length(); i++) {
                index = Integer.valueOf(digits.substring(i, i + 1));
                if (current[i] < length[index]) {
                    temp = temp.append(nums[index].substring(current[i], current[i] + 1));
                }
            }
            list.add(temp.toString());
            if(current[j]<length[j]-1)
                current[j]++;
            else {
                while(j<digits.length() && current[j]==length[Integer.valueOf(digits.substring(j, j + 1))]-1) {
                    current[j]=0;
                    j++;
                }
                if(j==digits.length())
                    break;
                else {
                    current[j]++;
                    j=0;
                }

            }
        }

        return list;
    }

//    private String[] combinations(String digits,int total){
//        if(digits.length()==1) {
//            int index = Integer.valueOf(digits);
//            String string=nums[index];
//            String[] strings=new String[(int) Math.pow(3,total)];
//            System.out.println(strings.length);
//            int length=(index==6 || index==8) ? 4:3;
//            for(int i=0;i<length;i++){
//                strings[i]=string.substring(i,i+1);
//            }
//            return strings;
//        }else {
//            String[] strings=combinations(digits.substring(1),total);
//            System.out.println(strings.length);
//            int index=Integer.valueOf(digits.substring(0,1));
//            String string=nums[index];
//            int j=0;
//            int count=Math.pow(3,)
//            int length=(index==6 || index==8) ? 4:3;
//            String temp;
//            for (int i=0;i<length;i++){
//                while (j<){
//                    strings[j]=strings[j]+string.substring(i,i+1);
//                    j++;
//                }
//            }
//            return strings;
//        }
//    }

    public static void main(String[] args) {
        Solution17 solution17=new Solution17();
        List<String> list=solution17.letterCombinations("22");
        System.out.println(list);
    }
}
