package cfx20190730;

import java.util.*;

public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(D.length==0)
            return 0;
        int target;
        int count=0;
        Integer currentCount;
        Map<Integer,Integer> map1=new HashMap<>();
        for(int i=0;i<D.length;i++){
            for(int j=0;j< D.length;j++){
                target=A[i]+B[j];
                currentCount=map1.get(target);
                if(currentCount==null)
                    map1.put(target,1);
                else
                    map1.put(target,currentCount+1);
            }
        }
        for(int i=0;i<D.length;i++){
            for(int j=0;j< D.length;j++){
                target=0-C[i]-D[j];
                currentCount=map1.get(target);
                if(currentCount!=null)
                    count=count+currentCount;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution454 solution454=new Solution454();
        int[] a={0,1,-1};
        int[] b={-1,1,0};
        int[] c={0,0,1};
        int[] d={-1,1,1};
        System.out.println(solution454.fourSumCount(a,b,c,d));
    }
}
