package cfx20210803;

import java.util.LinkedList;

public class Offer58_1 {

    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String trim = s.trim();
        char[] chars = trim.toCharArray();
        StringBuilder result = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = chars.length-1;i>=0;i--){
            while (i>=0 && ' ' == chars[i]){
                i--;
            }
            while (i>=0 && ' ' != chars[i]){
                stack.addLast(chars[i]);
                i--;
            }
            while (stack.size()>0){
                result.append(stack.removeLast());
            }
            if(i>=0){
                result.append(chars[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Offer58_1 offer58_1 = new Offer58_1();
        String s =" the sky        is blue ";
        System.out.print(offer58_1.reverseWords(s));
    }
}
