public class Anagrams {
    
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    HashMap<Integer, HashMap<Character, Integer>> map = new HashMap<>();
	    
	    for (int i = 0; i < a.size(); i++) {
	        String word = a.get(i);
	        HashMap<Character, Integer> wordMap = getMapping(word);
	        map.put(i, wordMap);
	    }
	    
	    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	    for (int i = 0; i < a.size(); i++) {
	        ArrayList<Integer> anagrams = new ArrayList<>();
	        anagrams.add(i + 1);
	        if (map.containsKey(i)) {
	            HashMap<Character, Integer> wordMap = map.get(i);
	            for (int j = i + 1; j < a.size(); j++) {
	                if (map.containsKey(j)) {
	                    HashMap<Character, Integer> otherMap = map.get(j);
	                    if (wordMap.equals(otherMap)) {
	                        anagrams.add(j + 1);
	                        map.remove(j);
	                    }
	                }
	            }
	            list.add(anagrams);
	            map.remove(i);
	        }
	    }
	    
	    return list;
	}
	
	private HashMap<Character, Integer> getMapping(String word) {
	    HashMap<Character, Integer> map = new HashMap<>();
	    for (char c : word.toCharArray()) {
	        if (map.containsKey(c)) {
	            map.put(c, map.get(c) + 1);
	        } else {
	            map.put(c, 1);
	        }
	    }
	    return map;
	}
	
}
