package classes.DS;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        if (m == 0) {
            while (k >= 0 && j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }



        while (k >= 0 && i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }

        if (j >= 0) {
            while (k >= 0 && j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
