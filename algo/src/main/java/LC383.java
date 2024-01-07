/**
 * @author qxlx
 * @date 2024/1/7 11:49 AM
 */
public class LC383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int [] ans = new int [26];
        char[] chars = ransomNote.toCharArray();
        char[] chars1 = magazine.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ans[chars[i]]+=1;
        }

        for (int i = 0; i < chars1.length; i++) {
            ans[chars1[i]]-=1;
            if (ans[i] < 0) {
                return false;
            }
        }
       return true;
    }

}
