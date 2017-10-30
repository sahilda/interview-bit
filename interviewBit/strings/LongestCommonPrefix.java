public class LongestCommonPrefix {

	public String longestCommonPrefix(ArrayList<String> a) {
		int shortestWordLength = Integer.MAX_VALUE;
		for (String word : a) {
			if (word.length() < shortestWordLength) {
				shortestWordLength = word.length();
			}
		}

		String prefix = "";		
		for (int i = 0; i < shortestWordLength; i++) {
			char next = a.get(0).charAt(i);
			for (String word : a) {
				if (word.charAt(i) != next) {
					return prefix;
				}
			}
			prefix += next;
		}
		return prefix;
	}

}
