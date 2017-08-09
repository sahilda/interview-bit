public class SetMatrixZeros {
    
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    int firstRow = 1;
	    int firstCol = 1;
	    ArrayList<Integer> firstRowList = a.get(0);
	    
	    for (int x = 0; x < a.size(); x++) {
	        ArrayList<Integer> row = a.get(x);
	        for (int y = 0; y < row.size(); y++) {
	            if (row.get(y) == 0) {
	                if (x == 0) {
	                    firstRow = 0;
	                } else {
	                    row.set(0, 0);
	                }
	                if (y == 0) {
	                    firstCol = 0;
	                } else {
	                    firstRowList.set(y, 0);
	                }
	            }
	        }
	    }
	    
	    for (int x = 1; x < a.size(); x++) {
	        ArrayList<Integer> row = a.get(x);
	        for (int y = 1; y < row.size(); y++) {
	            if (row.get(0) == 0) {
	                row.set(y, 0);
	            }
	            if (firstRowList.get(y) == 0) {
	                row.set(y, 0);
	            }
	        }
	    }
	    
	    if (firstRow == 0) {
	        for (int y = 0; y < firstRowList.size(); y++) {
	            firstRowList.set(y, 0);
	        }
	    }
	    
	    if (firstCol == 0) {
	       for (int x = 0; x < a.size(); x++) {
	           ArrayList<Integer> row = a.get(x);
	           row.set(0, 0);
	       }
	    }
	    
	}
	
}
