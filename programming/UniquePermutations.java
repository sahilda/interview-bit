public class UniquePermutations {

    private ArrayList<Integer> a;
    private ArrayList<ArrayList<Integer>> permutations;
    private int size;
    
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        this.a = a;
        this.permutations = new ArrayList<ArrayList<Integer>>();
        this.size = a.size();
        permutation(0, new ArrayList<Integer>(), new ArrayList<Integer>(a), size);
        return permutations;
    }

    private void permutation(int index, ArrayList<Integer> array, ArrayList<Integer> options, int optionsSize) {
        if (index == size) {
            if (!permutations.contains(array)) {
                permutations.add(new ArrayList<Integer>(array));
            }
            return;
        }

        ArrayList<Integer> ops = new ArrayList<Integer>(options);
        for (Integer temp : ops) {
            array.add(temp);
            options.remove(temp);
            permutation(index + 1, array, options, options.size());
            options.add(temp);
            array.remove(array.lastIndexOf(temp));
        }
    }

}
