public class MatrixMedian {

    public MatrixMedian() {

    }

    public static int findMedian(int[][] A) {
        int min_median = -1;
        int max_median = -1;
        int rows = A.length;
        int columns = A[0].length;
        for (int i = 0; i < rows; i++) {
            int median = A[i][columns / 2];
            if (i == 0) {
                min_median = median;
                max_median = median;
            } else {
                if (median < min_median) {
                    min_median = median;
                } else if (median > max_median) {
                    max_median = median;
                }
            }
        }

        int desired = (rows * columns + 1) / 2;
        while (min_median < max_median) {
            int mid = min_median + (max_median - min_median) / 2;
            int count = 0;
            for (int i = 0; i < rows; i++) {
                int index = upper_bound(A[i], mid);
                count += index;
            }
            System.out.print(min_median + ", " + max_median + ", " + desired + ", " + count + ", " + mid + "\n");
            if (count < desired) {
                min_median = mid + 1;
            } else {
                max_median = mid;
            }

        }
        return min_median;
    }

    public static int upper_bound(int[] A, int target) {
        int max = A.length - 1, min = 0;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (A[mid] <= target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.print(findMedian(A) + "\n");
        int[][] B = {{9, 10, 10, 13, 14, 15, 16, 16, 16, 17, 18}, {1, 4, 9, 14, 16, 18, 19, 22, 26, 26, 27}, {4, 6, 7, 10, 14, 20, 21, 23, 24, 27, 28}};
        System.out.print(findMedian(B) + "\n");
        int[][] C = {{2}, {1}, {4}, {1}, {2}, {2}, {5}};
        System.out.print(findMedian(C) + "\n");
    }
}
