public class LetterPhone {
    
    private HashMap<String, String> mapping;
    private String numbers;
    private ArrayList<String> result;
    private int size;
	
	public ArrayList<String> letterCombinations(String a) {
	    this.mapping = createMapping();
	    this.numbers = a;
	    this.result = new ArrayList<String>();
	    this.size = a.length();
	    combo(0, "");
	    return result;
	}
	
	private void combo(int index, String possibility) {
	    if (index == size) {
	        result.add(possibility);
	        return;
	    }
	    
	    String digit = String.valueOf(numbers.charAt(index));
	    String alpha = mapping.get(digit);
	    for (int i = 0; i < alpha.length(); i++) {
	        possibility = possibility + String.valueOf(alpha.charAt(i));
	        combo(index + 1, possibility);
	        possibility = possibility.substring(0, possibility.length() - 1);
	    }
	    
	}
	
	private HashMap<String, String> createMapping() {
	    HashMap<String, String> mapping = new HashMap<String, String>();
	    mapping.put("0", "0");
	    mapping.put("1", "1");
	    mapping.put("2", "abc");
	    mapping.put("3", "def");
	    mapping.put("4", "ghi");
	    mapping.put("5", "jkl");
	    mapping.put("6", "mno");
	    mapping.put("7", "pqrs");
	    mapping.put("8", "tuv");
	    mapping.put("9", "wxyz");
	    return mapping;
	}
	
}
