package classes;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int endIndexAvailable = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[endIndexAvailable]) {
                swap(i, endIndexAvailable, nums);
                endIndexAvailable--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public void swap(int from, int to, int[] nums) {
        if (from != to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
        }
    }
}
