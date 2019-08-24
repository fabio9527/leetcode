package cfx20190606;

public class Solution8 {
    public int myAtoi(String str) {
        if(str==null)
            return 0;
        String noSpaceString=str.trim();
        if(noSpaceString.length()==0)
            return 0;

        int i=1;
        String nums="0123456789";
        StringBuilder sb=new StringBuilder();
        boolean flag=true;
        char[] chars=noSpaceString.toCharArray();
        //如果第一位是
        if(nums.indexOf(chars[0])<0){
            if(chars[0]!='+' && chars[0]!='-')
                return 0;
            else
                flag=chars[0]=='+' ? true:false;
            while (i < chars.length) {
                if (chars[i] != '0')
                    break;
                i++;
            }
        }else if(nums.indexOf(chars[0])>0) {
            sb.append(chars[0]);
        }else {
            while (i < chars.length) {
                if (chars[i] != '0')
                    break;
                i++;
            }
        }
        for(int j=i;j<chars.length;j++){
            if(nums.indexOf(chars[j])>=0){
                sb.append(chars[j]);
            }else
                break;
        }
        if(sb.length()==0)
            return 0;

        if(flag==true && sb.length()>=10){
            if(sb.length()>10)
                return 2147483647;
            if(sb.length()==10 && sb.toString().compareTo("2147483647")>=0)
                return 2147483647;
        }

        if(flag==false && sb.length()>=10){
            if(sb.length()>10)
                return -2147483648;
            if(sb.length()==10 && sb.toString().compareTo("2147483648")>=0)
                return -2147483648;
        }
        int num=Integer.valueOf(sb.toString());
        return flag==true ? num:-num;
    }

    public static void main(String[] args){
        Solution8 solution8=new Solution8();
        System.out.println(solution8.myAtoi("  0000000000012345678"));
    }

}
