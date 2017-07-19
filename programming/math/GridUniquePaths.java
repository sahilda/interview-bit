public class GridUniquePaths {

	public int uniquePaths(int a, int b) {
		int count = 0;
        int k = b - 1;
        int nMinusK = n - k;
        long top = factorial(n, Math.max(k, nMinusK));
        long bottom = factorial(Math.min(k, nMinusK), 0);
        return Math.toIntExact(top / bottom);
    }

    private long factorial(int k, int stop) {
        long out = 1;
        while (k > stop) {
            out = out * k;
            k--;
        }
        return out;
    }

    public static void main(String[] args) {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        System.out.print(gridUniquePaths.uniquePaths(15, 9));
    }

}
