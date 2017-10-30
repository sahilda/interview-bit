public class Sudoku {
    
	private ArrayList<ArrayList<Character>> result;

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        result = new ArrayList<>();
        helper(a);
        a.removeAll(a);
        a.addAll(result);
    }

    private void helper(ArrayList<ArrayList<Character>> a) {
        if (!isValid(a)) {
            return;
        }

        if (isComplete(a)) {
            result = makeCopy(a);
            return;
        }

        // find a value to substitute
        for (int x = 0; x < a.size(); x++) {
            ArrayList<Character> row = a.get(x);
            if (row.contains('.')) {
                int idx = row.indexOf('.');
                for (char i = '1'; i <= '9'; i++) {
                    if (result.size() == 9) {
                        return;
                    }
                    row.set(idx, i);
                    helper(makeCopy(a));
                }
                return;
            }
        }
    }

    private ArrayList<ArrayList<Character>> makeCopy(ArrayList<ArrayList<Character>> a) {
        ArrayList<ArrayList<Character>> copy = new ArrayList<ArrayList<Character>>();
        for (int i = 0; i < 9; i++) {
            ArrayList<Character> row = a.get(i);
            copy.add(new ArrayList<>(row));
        }
        return copy;
    }

    private boolean isComplete(ArrayList<ArrayList<Character>> a) {
        for (ArrayList<Character> row : a) {
            if (row.contains('.')) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(ArrayList<ArrayList<Character>> a) {
        // check size
        if (a.size() != 9) {
            return false;
        }
        for (ArrayList<Character> row : a) {
            if (row.size() != 9) {
                return false;
            }
        }

        // check the rows
        ArrayList<Character> set;
        for (ArrayList<Character> row : a) {
            set = new ArrayList<>();
            for (char c : row) {
                if (!checkValue(c, set)) {
                    return false;
                }
            }
            if (set.size() != 9) {
                return false;
            }
        }

        // check the vertical
        for (int col = 0; col < 9; col++) {
            set = new ArrayList<>();
            for (int row = 0; row < 9; row++) {
                if (!checkValue(a.get(row).get(col), set)) {
                    return false;
                }
            }
            if (set.size() != 9) {
                return false;
            }
        }

        // check each square
        for (int x = 0; x < 9; x = x + 3) {
            for (int y = 0; y < 9; y = y + 3) {
                set = new ArrayList<>();
                for (int i = x; i < x + 3; i++) {
                    ArrayList<Character> row = a.get(i);
                    for (int j = y; j < y + 3; j++) {
                        if (!checkValue(row.get(j), set)) {
                            return false;
                        }
                    }
                }
                if (set.size() != 9) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkValue(char value, ArrayList<Character> list) {
        if (value == '.') {
            list.add(value);
            return true;
        } else if (value < '0' || value > '9') {
            return false;
        }

        if (list.contains(value)) {
            return false;
        }
        list.add(value);
        return true;
    }
	
}
