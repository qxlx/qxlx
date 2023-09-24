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

}
