package cfx20190613;

public class Solution50 {
    public double myPow(double x, int n) {
        if(x==0)
            return 0;
        double result=1;
        double current=x;
        int target=n>=0? n:-1-n;
        int i;

        while (target>0) {
            i=1;
            while (i<=target && i<1073741824){
                if (i*2 <= target) {
                    current = current *current;
                    i=i*2;
                }else {
                    break;
                }
            }
            result = result * current;
            current = x;
            target=target-i;
        }
        return n>=0 ? result:1/(result*x);
    }

    public static void main(String[] args) {

//        0.00001
//        2147483647
        double num=2.00000 ;
        int pow=10;
        Solution50 solution50=new Solution50();
        System.out.println(solution50.myPow(num,pow));
        System.out.println(Math.pow(2,10));
    }
}
