package cfx20190606;

public class Solution6 {
    public String convert(String s, int numRows) {
        if(s==null)
            return null;
        if(numRows==1)
            return s;
        char[] chars=s.toCharArray();
        StringBuilder sb=new StringBuilder();

        int count=2*numRows-2;
        //计算有几个折
        int step=chars.length/count;
        int leftCount=chars.length%count;

        int j;

        for(int i=0;i<numRows;i++){
            //第一
            if(i==0 || i==numRows-1){
                j=0;
                while(j<step){
                    sb.append(chars[i+count*j]);
                    j++;
                }
                if(leftCount>=i+1)
                    sb.append(chars[i+count*j]);
            }
            //中间行
            if(i>0 && i<(numRows-1)){
                j=0;
                while(j<step){
                    sb.append(chars[i+count*j]);
                    sb.append(chars[2*numRows-i-2+count*j]);
                    j++;
                }
                if(leftCount>=(2*numRows-i-1)){
                    sb.append(chars[i+count*j]);
                    sb.append(chars[2*numRows-i-2+count*j]);
                }else if(leftCount>=i+1)
                    sb.append(chars[i+count*j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution6 solution6=new Solution6();
        System.out.println(solution6.convert("ABCDE",4));
    }

}
