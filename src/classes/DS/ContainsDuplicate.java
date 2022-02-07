package classes.DS;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for (int number : nums) {
            if (set.contains(number)) {
                return true;
            }

            set.add(number);
        }

        return false;
    }
}
