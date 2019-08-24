package cfx20190606;

public class Solution29 {
    public int divide(int dividend, int divisor) {
        if(dividend==0)
            return 0;
//        if(dividend==Integer.MIN_VALUE && divisor==-1)
//            return Integer.MAX_VALUE;
//        if(dividend==Integer.MIN_VALUE && divisor==1)
//            return Integer.MIN_VALUE;
        int num1,num2;
        if(divisor==Integer.MIN_VALUE )
            return dividend==Integer.MIN_VALUE ? 1:0;
        //处理被除数为整型最小值
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE){
            num2 = divisor < 0 ? -divisor : divisor;
            num1 = -1-dividend;

            int hightDend = 0;
            int hightSor = 0;

            while (num1 != 0) {
                num1 = num1 >>> 1;
                hightDend++;
            }
            while (num2 != 0) {
                num2 = num2 >>> 1;
                hightSor++;
            }

            int minHight = hightDend - hightSor;
            num1 = -1-dividend;
            num2 = divisor < 0 ? -divisor : divisor;
            num2 = num2 << minHight;
            int div = 0;
            while (minHight >= 0) {
                if (num1 - num2 >= 0) {
                    div = (div << 1) + 1;
                    num1 = num1 - num2;
                } else {
                    div = div << 1;
                }
                num2 = num2 >> 1;
                minHight--;
            }
            num2 = divisor < 0 ? -divisor : divisor;
            if(num1+1==num2)
                div=div+1;
            return (dividend >>> 31) + (divisor >>> 31) == 1 ? 0 - div : div;
        } else {
            num2 = divisor < 0 ? -divisor : divisor;
            num1 = dividend < 0 ? -dividend : dividend;
            int hightDend = 0;
            int hightSor = 0;

            while (num1 != 0) {
                num1 = num1 >>> 1;
                hightDend++;
            }
            while (num2 != 0) {
                num2 = num2 >>> 1;
                hightSor++;
            }

            int minHight = hightDend - hightSor;
            num1 = dividend < 0 ? -dividend : dividend;
            num2 = divisor < 0 ? -divisor : divisor;
            num2 = num2 << minHight;
            int div = 0;
            while (minHight >= 0) {
                if (num1 - num2 >= 0) {
                    div = (div << 1) + 1;
                    num1 = num1 - num2;
                } else {
                    div = div << 1;
                }
                num2 = num2 >> 1;
                minHight--;
            }
            return (dividend >>> 31) + (divisor >>> 31) == 1 ? 0 - div : div;
        }
    }
    public static void main(String[] args) {
        Solution29 solution29=new Solution29();
        System.out.println(solution29.divide(-2147483648,-4));
    }
}
