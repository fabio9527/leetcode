package cfx20210624;

public class Offer16_1 {
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     * <p>
     * 思路
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double num = 0;

        if (x < 0 && n > 0) {
            num = getSign(n)*getDoubleWithoutSign(-x, n, true);
        }
        if(x<0&& n<0){
            num = getSign(-n)*getDoubleWithoutSign(-x,-n,false);
        }
        if(x>0 && n<0){
            num = getDoubleWithoutSign(x,-n,false);
        }

        if(x>0 && n>0){
            num = getDoubleWithoutSign(x,n,true);
        }

        return num;
    }

    public double getDoubleWithoutSign(double x, int n, boolean isActiveN) {
        double num = 1;
        if (isActiveN) {
            for (int i = 1; i <= n; i++) {
                num = num * x;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                num = num / x;
            }
        }
        return num;
    }

    public int getSign(int n){
        if(n%2==0){
            return 1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Offer16_1 offer16 = new Offer16_1();
        System.out.print(offer16.myPow(0.00001,2147483647));
    }
}
