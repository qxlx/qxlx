/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
 * 短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 *
 * @author qxlx
 * @date 2024/3/17 20:17
 */
public class LC125 {

    //A man, a plan, a canal: Panama
    // 1.空格不要
    // 2.,不要
    // 3.:不要
    // 只留字符和数字
    public static boolean isPalindrome(String s) {
        String toLowerCase = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for (Character ch : toLowerCase.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
        }

        char[] chars = sb.toString().toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return -1;

        final char[] chars = str.toCharArray();
        boolean flag = false;
        int lenth = chars.length, i = 0;

        // 删除空格
        while (i < lenth && chars[i] != ' ') {
            i++;
        }

        //确定数字符号
        if (chars[i] == '-') {
            flag = true;
            i++;
        }

        //非法字符
        if (chars[i] < '0' || chars[i] > '9') {
            return 0;
        }

        // 123
        int sum = 0;
        int intAbsHigh = 214748364;
        //找到数据
        while (i < lenth && chars[i] >= '0' && chars[i] <= '9') {
            int d = chars[i] - '0';
            if (sum > intAbsHigh) {
                if (flag) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            if (sum == intAbsHigh) {
                if (flag && d > 7) return Integer.MAX_VALUE;
                if (!flag && d > 8) return Integer.MIN_VALUE;
            }
            sum = sum * 10 + d;
            i++;
        }
        return flag ? -sum : sum;
    }
}
