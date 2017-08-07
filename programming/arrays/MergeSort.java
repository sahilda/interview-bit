import java.util.ArrayList;

public class MergeSort {

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> nums) {
        ArrayList<Integer> result = helper(nums, 0, nums.size() - 1);
        return result;
    }

    private static ArrayList<Integer> helper(ArrayList<Integer> nums, int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        if (start >= end) {
            result.add(nums.get(start));
            return result;
        }
        int mid = (start + end) / 2;
        ArrayList<Integer> left = helper(nums, start, mid);
        ArrayList<Integer> right = helper(nums, mid + 1, end);

        int leftIdx = 0;
        int rightIdx = 0;
        while (leftIdx < left.size() || rightIdx < right.size()) {
            int number;
            if (leftIdx >= left.size()) {
                number = right.get(rightIdx);
                rightIdx++;
            } else if (rightIdx >= right.size()) {
                number = left.get(leftIdx);
                leftIdx++;
            } else if (left.get(leftIdx) <= right.get(rightIdx)) {
                number = left.get(leftIdx);
                leftIdx++;
            } else {
                number = right.get(rightIdx);
                rightIdx++;
            }
            result.add(number);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer ints[] = {80, 97, 78, 45, 23, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90};
        ArrayList<Integer> a = HelperMethods.makeList(ints);
        ArrayList<Integer> result = mergeSort(a);
        System.out.println(result);
    }

}