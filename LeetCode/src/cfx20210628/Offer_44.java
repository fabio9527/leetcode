package cfx20210628;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer_44 {

    /**
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     *
     * 请写一个函数，求任意第n位对应的数字。
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        if(n==0){
            return 0;
        }

        int[] border = new int[]{0,10,190,2890,38890,488890,5888890,68888890,788888890,Integer.MAX_VALUE};
        // 判断对应数字是几位数
        int i=1;
        while (i<=border.length){
            if(n<border[i] ||(n==border[i] && border[i]==Integer.MAX_VALUE)) {
                break;
            }
            i++;
        }
        if(i==1){
            return n;
        }

        int temp = n-border[i-1];
        int radix = temp%i;
        if(radix==0){
            return temp/((int)(i*Math.pow(10,i-1)))+1;
        }
        int j=i;
        while (radix>0){
            temp=temp%((int)(i*Math.pow(10,j-1)));
            radix--;
            j--;
        }
        return temp/((int)(i*Math.pow(10,j-1)));

    }

    public static void main(String[] args) {
        Offer_44 offer_44 = new Offer_44();
        System.out.println(offer_44.findNthDigit(2147483647));
    }
}
