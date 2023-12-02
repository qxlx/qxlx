import java.util.HashMap;
import java.util.Map;

/**
 * @author jiabaobao
 * @date 2023/9/20 8:31 AM
 */
public class lc001 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int [] {};
        }

        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i <= nums.length ; i++) {
            int num = target - nums[i];
            if (hashMap.containsKey(num)) {
                return new int[]{i,hashMap.get(num)};
            }
            hashMap.put(nums[i],i);
        }
        return new int []{};
    }

//    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//        int m = word1.length;
//        int n = word2.length;
//        int i = 0, j = 0, p = 0, q = 0;
//        while (i < m && j < n) {
//            if (word1[i].charAt(p++) != word2[j].charAt()[q++]) return false;
//            if (p == word1[i].length()) { //一个字符串结束
//                i++;
//                p = 0;
//            }
////            if (q == word2[i].length) {
////                j++;
////                q = 0;
////            }
//        }
//        return i == m && j == n; //遍历到最后了
//    }

}
