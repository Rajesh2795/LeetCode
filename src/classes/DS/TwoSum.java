package classes.DS;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int otherNumber = target - current;
            if (map.containsKey(otherNumber)) {
                result[0] = map.get(otherNumber);
                result[1] = i;
            } else {
                map.put(current, i);
            }
        }

        return result;
    }
}
