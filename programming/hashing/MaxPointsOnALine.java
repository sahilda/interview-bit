public class MaxPointsOnALine {

    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() != b.size() || a.size() == 0) {
            return 0;
        }
        HashMap<String, Set<Integer>> map = new HashMap<>();
        int size = a.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                String slope = getLine(j, i, a, b);
                if (map.containsKey(slope)) {
                    Set<Integer> set = map.get(slope);
                    set.add(i);
                    set.add(j);
                    map.put(slope, set);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    map.put(slope, set);
                }
            }
        }

        int max = 1;
        for (String key : map.keySet()) {
            if (map.get(key).size() > max) {
                max = map.get(key).size();
            }
        }
        return max;
    }
    
    private String getLine(int i, int j, ArrayList<Integer> a, ArrayList<Integer> b) {
        int xi = a.get(i);
        int yi = b.get(i);
        int xj = a.get(j);
        int yj = b.get(j);
        int y = yj - yi;
        int x = xj - xi;
        
        String slope;
        if (x == 0) {
            slope = "x=" + xi;
        } else if (y == 0) {
            slope = "y=" + yi;
        } else {
            double m = (double) y / (double) x;
            double intercept = yi - m * xi;
            slope = "y=" + String.valueOf(m) + "x+" + String.valueOf(intercept); 
        }
        
        return slope;
    }

}
