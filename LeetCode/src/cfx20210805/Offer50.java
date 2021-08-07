package cfx20210805;

import java.util.LinkedHashMap;
import java.util.Map;

public class Offer50 {
    /**
     * 在字符串s中找出第一个只出现一次的字符。如果没有，返回一个单空格。
     * s只包含小写字母。
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();
        Integer nums;
        for (char c : chars) {
            if ((nums = count.get(c)) == null) {
                count.put(c, 1);
            } else if (nums == 1) {
                count.put(c, 2);
            }
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
