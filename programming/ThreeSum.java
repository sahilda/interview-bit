import java.util.Collections.sort;

public class ThreeSum {

    public static int threeSumClosest(ArrayList<Integer> a, int b) {
        int closest = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < a.size() - 2; i++) {
            for (int j = i+1; j < a.size() - 1; j++) {
                for (int k = j+1; k < a.size(); k++) {
                    int total = a.get(i) + a.get(j) + a.get(k);
                    if (absDifference(total, b) < closest) {
                        closest = absDifference(total, b);
                        sum = total;
                    }
                }
            }
        }
        return sum;
    }

    public static int threeSumClosestB(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        int closest = Integer.MAX_VALUE;
        int sum = 0;

        for (int min = 0; min < a.size() - 2; min++) {
            int low = min + 1;
            int high = a.size() - 1;

            while (low < high) {
                int newDiff = absDifference(a.get(low) + a.get(high), b - a.get(min));
                int total = a.get(min) + a.get(low) + a.get(high);
                if (newDiff < closest) {
                    closest = newDiff;
                    sum = total;
                }
                if (total == b) {
                    return sum;
                } else if (total > b) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return sum;
    }

    public static int absDifference(int sum, int target) {
        return Math.abs(sum - target);
    }}

}
