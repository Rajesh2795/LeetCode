package classes.Algo;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) {
            nums[0] = (int) Math.pow(nums[0], 2);
            return nums;
        }

        int i = 0, j = nums.length - 1, availablePosition = nums.length - 1;
        int[] result = new int[nums.length];

        while (i < j) {
            int a = (int) Math.pow(nums[i], 2);
            int b = (int) Math.pow(nums[j], 2);

            if (a > b) {
                result[availablePosition--] = a;
                i++;
            } else {
                result[availablePosition--] = b;
                j--;
            }
        }

        if (availablePosition >= 0) {
            if (i > j) result[availablePosition] = (int) Math.pow(nums[j], 2);
            else result[availablePosition] = (int) Math.pow(nums[i], 2);
        }

        return result;
    }
}
