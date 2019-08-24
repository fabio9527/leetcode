package cfx20190606;

public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        int temp=0;
        String charString=null;
        String sb=null;
        int j;
        for(int i=0;i<s.length();i++){
            j=i;
            sb=new String();
            while (j<s.length()){
                charString=s.substring(j,j+1);
                if(sb.indexOf(charString)==-1) {
                    sb=sb+charString;
                    j++;
                }else
                    break;
            }
            if(sb.length()>temp)
                temp=sb.length();
        }
        return temp;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
