package algo.base.ch002;

/**
 * @author qxlx
 * @date 2024/8/19 21:17
 */
public class ArrayTest {

    public class Solution {

    }

    public String rotate(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        char[] tmpChars = new char[chars.length];
        for (int i = 0; i < s.length(); i++) {
            tmpChars[(i+k) % s.length()] = chars[i];
        }
        return new String(tmpChars);
    }

}
