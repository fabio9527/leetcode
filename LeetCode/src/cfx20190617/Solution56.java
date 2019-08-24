package cfx20190617;

import java.util.ArrayList;
import java.util.List;

public class Solution56 {

    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length<=1){
            return intervals;
        }
        fastSort(intervals,0,intervals.length-1);
        List<int[]> list=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i-1][1]>=intervals[i][1]){ //前一个区间包含后一个区间
                intervals[i][0]=intervals[i-1][0];
                intervals[i][1]=intervals[i-1][1];
            }else if(intervals[i-1][1]>=intervals[i][0] && intervals[i-1][1]<intervals[i][1]){ //前一个区间和后一个区间有重合,故合并
                intervals[i][0]=intervals[i-1][0];
            }else {
                list.add(intervals[i-1]);
            }
        }
        list.add(intervals[intervals.length-1]);
        int[][] target=new int[list.size()][2];
        for (int i=0;i<list.size();i++) {
            target[i]=list.get(i);
        }
        return target;
    }

    public void fastSort(int[][] intervals,int start,int end){
        int[] temp;
        int left=start,right=end;
        int standard=intervals[start][0];

        while (true){
            while(left<right && intervals[left][0]<=standard){
                left++;
            }
            while (right>=left && intervals[right][0]>=standard){
                right--;
            }
            if(right<=left){//之所以要取到等号是防止右边的树都比基准小
                break;
            }else {
                temp=intervals[left];
                intervals[left]=intervals[right];
                intervals[right]=temp;
            }
        }
        temp=intervals[start];
        intervals[start]=intervals[right];
        intervals[right]=temp;
        if(start<right-1)
            fastSort(intervals,start,right-1);
        if(right+1<end)
            fastSort(intervals,right+1,end);
    }


    public static void main(String[] args) {
//        int[][] ints={{2,3},{4,6},{8,10},{2,5},{11,34},{34,90},{45,78},{35,70}};
        int[][] ints={{2,3},{4,5}};

        Solution56 solution56=new Solution56();
        int[][] merge = solution56.merge(ints);
        for(int i=0;i<merge.length;i++){
            System.out.println(merge[i][0]+","+merge[i][1]);
        }
    }

}