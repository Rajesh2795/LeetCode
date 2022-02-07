package classes.DS;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int currMax = nums[0], maxSoFar =  nums[0];

        //int[] nums = {8, -19, 5, -4, 20};
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(currMax, currMax + nums[i]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }

        return maxSoFar;
    }
}
