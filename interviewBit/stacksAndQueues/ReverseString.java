import java.util.Stack;

public class ReverserString {

	public String reverseString(String a) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : a.toCharArray()) {
			stack.push(c);
		}
		StringBuilder sb = new StringBuilder();
		while (stack.size() != 0) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

}
