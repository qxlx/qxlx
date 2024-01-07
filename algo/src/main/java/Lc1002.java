import java.util.ArrayList;
import java.util.List;

/**
 * @author qxlx
 * @date 2024/1/1 4:13 PM
 */
public class Lc1002 {

    public static List<String> commonChars(String[] words) {
        int [] nums = new int [26];

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (char ch : chars) {
                nums[ch - 'a']++;
            }
        }
        System.out.println(nums);

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= words.length) {
                if (nums[i] > words.length) {

                }
                strings.add(String.valueOf((char) (i + 'a')));
            }
        }
        System.out.println(strings);
        return strings;
    }

    public static void main(String[] args) {
//        commonChars(new String[]{"bella","label","roller"});
        commonChars(new String[]{"cool","lock","cook"});
    }
}
