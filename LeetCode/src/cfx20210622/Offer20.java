package cfx20210622;

import java.util.HashSet;
import java.util.Set;

public class Offer20 {

    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     *
     * 数值（按顺序）可以分成以下几个部分：
     *      若干空格
     *      一个小数或者整数
     *      （可选）一个'e'或'E'，后面跟着一个整数
     *      若干空格
     *
     *
     * 小数（按顺序）可以分成以下几个部分：
     *      （可选）一个符号字符（'+' 或 '-'）
     *      下述格式之一：
     *          至少一位数字，后面跟着一个点 '.'
     *          至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     *          一个点 '.' ，后面跟着至少一位数字
     *
     * 整数（按顺序）可以分成以下几个部分：
     *      （可选）一个符号字符（'+' 或 '-'）
     *      至少一位数字
     *
     * 部分数值列举如下：
     *
     * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
     * 部分非数值列举如下：
     *
     * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public boolean isNumber(String s) {

        Set<Character> numSet = new HashSet<>();
        for(int i = 0; i <= 9; i++){
            numSet.add((char) ('0'+i));
        }
        if(null == s){
            return false;
        }
        char[] chars = s.trim().toCharArray();
        if(chars.length==0){
            return false;
        }
        // 先找出第一个E/e的位置，但第一个不能为E
        if(chars[0]=='E' || chars[0]=='e'){
            return false;
        }
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='E' || chars[i]=='e'){
                return isDecimal(chars,0,i-1,numSet) && i+1<=chars.length-1 && isInteger(chars,i+1,chars.length-1,numSet);
            }
        }
        // 不存在E/e的情况
        return isDecimal(chars,0,chars.length-1,numSet) || isInteger(chars,0,chars.length-1,numSet);
    }

    /**
     * 整数（按顺序）可以分成以下几个部分：
     *      （可选）一个符号字符（'+' 或 '-'）
     *       至少一位数字
     * @param chars
     * @param startIndex
     * @param endIndex
     * @param numSet
     * @return
     */
    public boolean isInteger(char[] chars, int startIndex, int endIndex, Set<Character> numSet){
        if((chars[startIndex]=='+' || chars[startIndex]=='-') && startIndex+1<=endIndex){
            return isAllNum(chars,startIndex+1,endIndex,numSet);
        }else {
            return isAllNum(chars,startIndex,endIndex,numSet);
        }
    }

    /**
     * 小数（按顺序）可以分成以下几个部分：
     *   （可选）一个符号字符（'+' 或 '-'）
     *   下述格式之一：
     *       至少一位数字，后面跟着一个点 '.'
     *       少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     *       一个点 '.' ，后面跟着至少一位数字
     * @param chars
     * @param startIndex
     * @param endIndex
     * @param numSet
     * @return
     */
    public boolean isDecimal(char[] chars, int startIndex, int endIndex, Set<Character> numSet){
        if((chars[startIndex]=='+' || chars[startIndex]=='-') && startIndex+1<=endIndex){
            return isNumWithPoint(chars,startIndex+1,endIndex,numSet);
        }else if(numSet.contains(chars[startIndex])){
            return isNumWithPoint(chars,startIndex,endIndex,numSet);
        }else if(chars[startIndex]=='.' && startIndex+1<=endIndex){
            return isAllNum(chars,startIndex+1,endIndex,numSet);
        }else {
            return false;
        }
    }

    public boolean isNumWithPoint(char[] chars, int startIndex, int endIndex, Set<Character> numSet){
        int i = startIndex;
        while (i<=endIndex && numSet.contains(chars[i])){
            i++;
        }
        if(i>endIndex){
            return true;
        }else if(i!=startIndex && i==endIndex && chars[i]=='.'){
            return true;
        }else if(i<endIndex && chars[i]=='.' && i+1<=endIndex){
            return isAllNum(chars,i+1,endIndex,numSet);
        }else {
            return false;
        }
    }

    public boolean isAllNum(char[] chars, int startIndex, int endIndex, Set<Character> numSet){
        for(int i=startIndex;i<=endIndex;i++){
            if(!numSet.contains(chars[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Offer20 offer20 = new Offer20();
        String[] strings = new String[]{"+100", "5e2", "-123", "3.1416", "-1E-16", "0123"};
//        String[] strings = new String[]{"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"};
//        for(String str : strings){
//            System.out.println(offer20.isNumber(str));
//        }

        System.out.println(offer20.isNumber("+E3"));
    }
}
