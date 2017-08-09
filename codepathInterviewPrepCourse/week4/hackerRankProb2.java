// Is Possible to get (a, b) -> (c, d) where you can do (a, a + b) or (a + b, b)

public class IsPossible {

/*
 * Complete the function below.
 */

    static String isPossible(int a, int b, int c, int d) {
        if (helper(a, b, c, d)) {
            return "Yes";
        }
        return "No";
    }

    private static boolean helper(int a, int b, int c, int d) {
        if (a == c && b == d) {
            return true;
        } else if (a > c || b > d) {
            return false;
        }
        
        return (helper(a + b, b, c, d) || helper(a, a + b, c, d));        
    }

}