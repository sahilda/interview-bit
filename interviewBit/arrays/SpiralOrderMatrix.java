import java.util.Arrays;

public class SpiralOrderMatrix {

	public SpiralOrderMatrix() {

	}

	public int[] spiralOrder(final int[][] A) {
		int top = 0, bottom = A.length - 1, left = 0, right = A[0].length - 1;
		int dir = 0, counter = 0;
		int[] output = new int[A.length * A[0].length];

		while (top <= bottom && left <= right) {
			if (dir == 0) {
				for(int i=left; i<=right; i++) {
					output[counter] = A[top][i];
					counter++;
				}
				top += 1;
			} else if (dir == 1) {
				for(int i=top; i<= bottom; i++) {
					output[counter] = A[i][right];
					counter++;
				}
				right -= 1;
			} else if (dir == 2) {
				for(int i=right; i>=left; i--) {
					output[counter] = A[bottom][i];
					counter++;
				}
				bottom -= 1;			
			} else if (dir == 3) {
				for(int i=bottom; i>= top; i--) {
					output[counter] = A[i][left];
					counter++;
				}
				left += 1;				
			}

			dir = (dir + 1) % 4;
		}

		return output;
    }

    public static void main(String[] args) {
    	SpiralOrderMatrix spiralOrderMatrix = new SpiralOrderMatrix();
    	int[][] a = {{ 1, 2, 3 },{ 4, 5, 6 },{ 7, 8, 9 }};
		int[][] b = {{1}};

		System.out.print(Arrays.toString(spiralOrderMatrix.spiralOrder(a)));
		System.out.print(Arrays.toString(spiralOrderMatrix.spiralOrder(b)));

    }

}
