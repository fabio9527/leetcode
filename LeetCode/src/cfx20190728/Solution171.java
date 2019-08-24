package cfx20190728;

public class Solution171 {
    public int titleToNumber(String s) {
        if(s==null || s.length()==0)
            return 0;
        int current;
        int length=s.length();
        int num=0;
        for(int i=length-1;i>=0;i--){
            current=s.charAt(i);
            num= num+(current-64)*(int) Math.pow(26,length-i-1);
        }
        return num;
    }

    public static void main(String[] args) {
        Solution171 solution171=new Solution171();
        System.out.println(solution171.titleToNumber("AS"));
    }
}
