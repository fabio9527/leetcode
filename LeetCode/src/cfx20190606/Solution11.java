package cfx20190606;

public class Solution11 {
    public int maxArea(int[] height) {
        //判断是否是空数组；
        if(height==null || height.length<=1){
            return 0;
        }
        int temp=0;
        int area;
        int j;
        for(int step=height.length-1;step>=1;step--){
            j=0;
           while(j+step<height.length){
               area=getMin(height[j],height[j+step])*step;
               if(area>temp)
                   temp=area;
               j++;
           }
        }
        return temp;
    }

    public int getMin(int a,int b){
        return a>=b ? b:a;
    }

    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        Solution11 solution11=new Solution11();
        int area=solution11.maxArea(height);
        System.out.println(area);
    }
}
