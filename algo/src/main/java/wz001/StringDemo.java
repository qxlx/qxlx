package wz001;


import sun.java2d.pipe.SpanClipRenderer;

import java.util.Arrays;

/**
 * @author qxlx
 * @date 2024/3/22 22:46
 */
public class StringDemo {


    public static void main(String[] args) {
//        trim(" abc  de ds ");

//        System.out.println(lengthOfLastWord("day"));
        System.out.println(dynamicPassword3("ABCDE",2));
    }

    public static String dynamicPassword3(String password, int target) {
        if (password == null || password.length() == 0) return password;
        char[] chars = password.toCharArray();

        for (int i = 0; i < target; i++) {
            char tmp = chars[0];
            for (int j = 1; j < chars.length; j++) {
                chars[j - 1] = chars[j];
            }
            chars[chars.length -1] = tmp;
        }
        return new String(chars);
    }

    //ABCDE
    //CDEAB
    public static String dynamicPassword2(String password, int target) {
        if (password == null || password.length() == 0) return password;
        char[] chars = password.toCharArray();
        char [] tmp = new char [target];

        for (int i = 0; i < target; i++) {
            tmp[i] = chars[i];
        }

        for (int i = target; i < chars.length; i++) {
            chars[i - target] = chars[i];
        }

        for (int i = 0; i < tmp.length; i++) {
            chars[ i + (chars.length - target)] = tmp[i];
        }
        return new String(chars);
    }

    //ABCDE
    //CDEAB
    public static String dynamicPassword(String password, int target) {
        if (password == null || password.length() == 0) return password;

        int len = password.length();
        char [] tmp = new char[len];

        for (int i = 0; i < target; i++) {
            tmp[i+(len - target)] = password.charAt(i);
        }
        int k = 0;
        for (int i = target; i < len; i++) {
            tmp[k++] = password.charAt(i);
        }
        password = tmp.toString();
        return password;
    }

    // 从后往前扫描
    public static int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;
        //去除尾部空格
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        if (i < 0) return 0;
        if (i == 1) return 1;

        int len = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }


    private static void trim(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        char [] chs = s.toCharArray();

        int i = 0;
        int length = chs.length;

        //去掉空格
        while (i < length && chs[i] == ' '){
            i++;
        }
        int j = length -1;
        while (j > 0 && chs[j] == ' ') {
            j--;
        }

        // i - j 之间
        int k = 0;
        while (i < j) {
            if (chs[i] == ' ') {
                if ((i + 1) < j && chs[i + 1] == ' ') {
                    chs[k++] = chs[i];
                }
            } else {
                chs[k++] = chs[i];
            }
            i++;
        }
        System.out.println(chs);
        System.out.println(chs);
    }




}
