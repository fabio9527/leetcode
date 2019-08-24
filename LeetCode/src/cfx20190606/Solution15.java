package cfx20190606;

import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] temp) {

        if(temp==null)
            return null;
        List<List<Integer>> comb=new ArrayList();
        List<Integer> list=null;

        if(temp.length<3)
            return comb;
        Arrays.sort(temp);

        if(temp[0]>0 || temp[temp.length-1]<0)
            return comb;

        int fistZeroIndex=0;
        int lastZeroIndex=temp.length-1;

        while(temp[fistZeroIndex]<0){fistZeroIndex++; }
        while(temp[lastZeroIndex]>0){lastZeroIndex--; }



        //考虑0的情况
        if(lastZeroIndex-fistZeroIndex>=2){
            comb.add(Arrays.asList(0,0,0));
        }
        if(lastZeroIndex>=fistZeroIndex) {
            for (int i = 0; i < fistZeroIndex; i++) {
                if (temp[i] != temp[i+1]) {
                    for (int j = temp.length - 1; j > lastZeroIndex; j--) {
                        if (temp[j]!=temp[j-1] && temp[i] +temp[j]==0) {
                            comb.add(Arrays.asList(temp[i], 0, temp[j]));
                            break;
                        }
                    }
                }
            }
        }

        int x,y;

        for(int i=fistZeroIndex-1;i>=0;i--) {
            if (temp[i] != temp[i + 1]) {
                x=i-1;
                y=lastZeroIndex+1;
                while(x>=0 && y<=temp.length-1){
                    if(temp[i]+temp[x]+temp[y]==0){
                        comb.add(Arrays.asList(temp[i],temp[x],temp[y]));
                        x--;
                        y++;
                        while (x>=0 &&  temp[x+1]==temp[x]){x--;}
                        while (y<=temp.length-1 && temp[y-1]==temp[y]){y++;}

                    }else if(temp[i]+temp[x]+temp[y]<0){
                        y++;
                    }else if(temp[i]+temp[x]+temp[y]>0){
                        x--;
                    }
                }
            }
        }
        for(int i=lastZeroIndex+1;i<temp.length;i++) {
            if (temp[i] != temp[i-1]) {
                x = fistZeroIndex - 1;
                y = i+1;
                while (x >= 0 && y <= temp.length - 1) {
                    if (temp[i] + temp[x] + temp[y] == 0) {
                        comb.add(Arrays.asList(temp[i], temp[x], temp[y]));
                        x--;
                        y++;
                        while (x>=0 &&  temp[x+1]==temp[x]){x--;}
                        while (y<=temp.length-1 && temp[y-1]==temp[y]){y++;}
                    } else if (temp[i] + temp[x] + temp[y] < 0) {
                        y++;
                    } else if (temp[i] + temp[x] + temp[y] > 0) {
                        x--;
                    }
                }
            }
        }


//        for(int i=0;i<fistZeroIndex;i++){
//            if(temp[i]!=temp[i+1]){
//                for(int j=lastZeroIndex+1;j<=temp.length-1;j++){
//                    if(temp[j]!=temp[j-1]){
//                        for(int l=temp.length-1;l>j;l--){
//                            if(l==temp.length-1 &&temp[i]+temp[j]+temp[l]==0){
//                                comb.add(Arrays.asList(temp[i], temp[j], temp[l]));
//                                break;
//                            }
//                            if(l!=temp.length-1 && temp[l]!=temp[l+1] &&temp[i]+temp[j]+temp[l]==0) {
//                                comb.add(Arrays.asList(temp[i], temp[j], temp[l]));
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        for(int i=lastZeroIndex+1;i<temp.length;i++){
//            if(temp[i]!=temp[i-1]){
//                for(int j=fistZeroIndex-1;j>=0;j--){
//                    if(temp[j]!=temp[j+1]){
//                        for(int l=0;l<=j-1;l++){
//                            if(l==0 &&temp[i]+temp[j]+temp[l]==0){
//                                comb.add(Arrays.asList(temp[i], temp[j], temp[l]));
//                                break;
//                            }
//                            if(l!=0 && temp[l]!=temp[l-1] &&temp[i]+temp[j]+temp[l]==0) {
//                                comb.add(Arrays.asList(temp[i], temp[j], temp[l]));
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//        }
        return comb;

    }



    public static void main(String[] args) {
        Solution15 solution15=new Solution15();
        int[] nums ={-1,-2,-3,4,1,3,0,3,-2,1,-2,2,-1,1,-5,4,-3};
        int[] ints={-4,-1,-4,0,2,-2,-4,-3,2,-3,2,3,3,-4};
        System.out.println(solution15.threeSum(nums));
        System.out.println(solution15.threeSum(ints));
    }
}
