package cfx20190810;

import java.util.ArrayList;
import java.util.List;

public class Solution218 {

    /*
    * 首先要判断横纵坐标的区间(类似合并区间)，然后再判断高度
    * */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> lists=new ArrayList<>();
        if(buildings==null || buildings.length==0)
            return lists;

        //先找出横坐标
        for(int i=0;i<buildings.length;i++){


        }

        return lists;
    }

    private int getMax(int a,int b){
        return a>=b?a:b;
    }
}
