package cfx20210624;

import java.util.ArrayList;
import java.util.List;

public class Offer16_2 {

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     *
     * 快速幂+位运算
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }

        double result = 1;
        int position = 1;
        int temp_n;
        if (n < 0) {
            temp_n = -1 ^ n;
        } else {
            temp_n = n;
        }
        for (int i = 0; i <= 31; i++) {
            if ((position & temp_n) != 0) {
                double temp = x;
                for (int j = 1; j <= i; j++) {
                    temp = temp * temp;
                }
                result = result * temp;
            }
            position = position << 1;
        }
        if (n < 0) {
            return 1 / result / x;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        Offer16_2 offer16_2 = new Offer16_2();
        System.out.println(offer16_2.myPow(-2, -2));
    }
}
