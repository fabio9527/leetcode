package cfx20190606;

public class Solution5 {
    //取出最长回文子串
    public String longestPalindrome(String s) {
        if(s==null)
            return null;
        if(s.length()==0)
            return "";
        char[] chars=s.toCharArray();
        //控制步长
        for(int step=chars.length;step>1;step--){
            int j=0;
            while(j+step<=chars.length){
                if(isPalindrome(j,j+step-1,chars)){
                    return new String(chars,j,step);
                }

                j++;
            }

        }
        return s.substring(0,1);
    }

    //判断是否是回文串
    public boolean isPalindrome(int startIndex,int endIndex,char...chars){
        boolean flag=true;
        int binaryIndex=(startIndex+endIndex)/2;
        for(int i=startIndex;i<=binaryIndex;i++){
            if(chars[i]!=chars[endIndex-i+startIndex]){
                flag=false;
                break;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        Solution5 solution5=new Solution5();
        String str=solution5.longestPalindrome("njhpojo");
        System.out.println(str);
    }
}
