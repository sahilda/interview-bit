import java.util.ArrayList;

public class Rotate {

    public Rotate() {

    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int layers = n / 2;
        for (int layer = 0; layer < layers; layer++) {
            int first = layer;
            int last = n - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - layer;
                int top = a.get(first).get(i);
                swap(a, new int[]{first, i}, new int[]{last - offset, first});
                swap(a, new int[]{last - offset, first}, new int[]{last, last - offset});
                swap(a, new int[]{last, last - offset}, new int[]{i, last});
            }
        }
    }

    private void swap(ArrayList<ArrayList<Integer>> a, int[] p1, int[] p2) {
        Integer temp = a.get(p2[0]).get(p2[1]);
        a.get(p2[0]).set(p2[1], a.get(p1[0]).get(p1[1]));
        a.get(p1[0]).set(p1[1], temp);
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        ArrayList<ArrayList<Integer>> a = HelperMethods.make2DList(new Integer[] {27, 35, 36, 47, 94, 133, 163, 164, 235, 253, 280, 310, 339, 352, 46, 72, 77, 95, 144, 149, 158, 174, 242, 243, 317, 371, 378, 386, 13, 14, 80, 83, 121, 157, 158, 163, 215, 220, 308, 325, 388, 397, 11, 38, 45, 84, 105, 132, 134, 145, 184, 219, 282, 298, 380, 381, 23, 27, 42, 118, 120, 139, 168, 225, 243, 271, 274, 349, 393, 395, 22, 27, 49, 85, 103, 167, 175, 234, 241, 258, 283, 296, 352, 385, 24, 78, 117, 119, 137, 147, 173, 189, 193, 216, 281, 304, 332, 358, 27, 71, 108, 109, 112, 133, 137, 145, 150, 171, 195, 225, 260, 336, 5, 56, 65, 114, 123, 200, 220, 222, 248, 264, 285, 317, 350, 367, 2, 20, 60, 72, 75, 130, 136, 149, 189, 254, 264, 295, 315, 349, 23, 35, 68, 77, 104, 129, 153, 165, 248, 253, 290, 316, 321, 394, 34, 127, 129, 154, 186, 202, 203, 210, 235, 269, 331, 344, 376, 387, 11, 98, 99, 118, 119, 183, 250, 252, 277, 280, 291, 307, 360, 368, 42, 74, 93, 119, 178, 186, 198, 221, 234, 295, 296, 319, 322, 335}, 14);
        rotate.rotate(a);
        System.out.print(a);
    }
}