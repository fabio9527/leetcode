package cfx20190606;

public class Solution12 {
    public String intToRoman(int num) {
        if(num<=0 || num>3999)
            return "";
        int temp;
        StringBuilder sb=new StringBuilder();

        if(num/1000>=1){
            for(int i=1;i<=num/1000;i++){
                sb.append("M");
            }
            return sb+intToRoman(num%1000);
        }else if((temp=num/500)>=1){
            if(num>=900) {
                sb.append("CM");
                return sb+intToRoman(num%900);
            }else{
                sb.append("D");
                return sb+intToRoman(num%500);
            }
        }else if((temp=num/100)>=1){
            if(temp==4)
                sb.append("CD");
            else{
                for(int i=1;i<=temp;i++){
                    sb.append("C");
                }
            }
            return sb+intToRoman(num%100);
        }else if((temp=num/50)>=1){
            if(num>=90) {
                sb.append("XC");
                return sb + intToRoman(num % 90);
            }else {
                sb.append("L");
                return sb + intToRoman(num % 50);
            }
        }else if((temp=num/10)>=1){
            if(temp==4)
                sb.append("XL");
            else{
                for(int i=1;i<=temp;i++){
                    sb.append("X");
                }
            }
            return sb+intToRoman(num%10);
        }else if((temp=num/5)>=1){
            if(num>=9) {
                sb.append("IX");
                return sb.toString();
            }else {
                sb.append("V");
                return sb+intToRoman(num%5);
            }
        }else {
            if(num==4)
                sb.append("IV");
            else{
                for(int i=1;i<=num;i++){
                    sb.append("I");
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution12 solution12=new Solution12();
        System.out.println(solution12.intToRoman(40));
    }
}
