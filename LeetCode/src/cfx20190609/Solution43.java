package cfx20190609;

public class Solution43 {

    public String multiply(String num1, String num2) {

        int count=0;
        StringBuilder sb=new StringBuilder();
        if(num1==null || num1.length()==0 || num2==null || num2.length()==0)
            return sb.toString();
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        char[] chars1=num1.toCharArray();
        char[] chars2=num2.toCharArray();
        int ints1,ints2;
        int[] nums=new int[chars1.length+chars2.length+1];
        int index;

        for(int i=0;i<chars1.length;i++){
            ints1=chars1[i]-48;
            for(int j=0;j<chars2.length;j++){
                ints2=chars2[j]-48;
                index=chars1.length-1+chars2.length-1-i-j;
                nums[index]=ints1*ints2+nums[index];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>9) {
                nums[i + 1] = nums[i + 1] + nums[i] / 10;
            }
            if(nums[i]==0)
                count++;
            else
                count=0;
            nums[i]=nums[i]%10;
        }
        for(int i=nums.length-count-1;i>=0;i--)
            sb.append(nums[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution43 solution43=new Solution43();
        System.out.println("字符串计算："+solution43.multiply("6","501"));
        System.out.println("整数计算："+6*501);
    }
}
