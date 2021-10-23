package BracketSorter;
/**
 * This class evaluates string input as to whether the line will evaluate 
 * correctly by checking that brackets have matching pairs.
 * @author Ashley Crawford 
 *
 */
import java.util.Stack;

public class Sorter {
/**
 * Method takes in a string to evaluate if brackets are paired. Returns true or false.
 * @param string
 * @return
 */
	public static boolean Sorter(String string) {
		if (string.isEmpty())
			return true;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < string.length(); i++) {
			char current = string.charAt(i);
			if (current == '{' || current == '(' || current == '[' || current == '<') {
				stack.push(current);
			}

			if (current == '}' || current == ')' || current == ']' || current == '>') {
				if (stack.isEmpty())
					return false;

				char last = stack.peek();
				if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '['
						|| current == '>' && last == '<')
					stack.pop();
				else
					return false;
			}

		}

		return stack.isEmpty();
	}
/**
 * Main which passes string values into the above method
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String stringOne = "{((2x5)+(3*-2+5))}";
		System.out.println(stringOne + " is " + Sorter.Sorter(stringOne));

		String stringTwo = "{(2x5)+(3*-2+5))}";
		System.out.println(stringTwo + " is " + Sorter.Sorter(stringTwo));
		
		String stringThree = "List<list>";
		System.out.println(stringThree + " is " + Sorter.Sorter(stringThree));
		
		String stringFour = "List<list";
		System.out.println(stringFour + " is " + Sorter.Sorter(stringFour));
		
		String stringFive = "{(<>) {}{..}(e(e)e) {hello}}";
		System.out.println(stringFive + " is " + Sorter.Sorter(stringFive));
		
		String stringSix = "{(<eeeek>>) {}{...}e(e)e) {hello}";
		System.out.println(stringSix + " is " + Sorter.Sorter(stringSix));
	}

}
