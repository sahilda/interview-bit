import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class GenerateAllParentheses {

	public GenerateAllParentheses() {

	}

	public int isValid(String a) {
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> map = getMappping();
		for (char c : a.toCharArray()) {
			if (map.containsKey(c)) {
				if (stack.size() == 0) {
					return 0;
				}
				if (!stack.pop().equals(map.get(c))) {
					return 0;
				}
			} else {
				stack.push(c);
			}			
		}
		if (stack.size() == 0) {
			return 1;
		}		
		return 0;
	}

	private Map<Character, Character> getMappping() {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		return map;
	}

	public static void main(String args[]) {
		GenerateAllParentheses gap = new GenerateAllParentheses();
		String input = "{([()])}()";
		gap.isValid(input);
	}

}
