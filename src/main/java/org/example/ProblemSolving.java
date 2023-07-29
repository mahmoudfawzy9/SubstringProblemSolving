package org.example;

import java.lang.String;
import java.util.Stack;
import java.util.logging.Logger;

public class ProblemSolving {

    private static final Logger logger = Logger.getLogger("ProblemSolving");

    // Main method to test the function
    public static void main(String[] args) {

        String s = "abd(jnb)asdf";
        System.out.print("Test 1: ");
        System.out.println(reverseParentheses(s));

         s = "abdjnbasdf";
        System.out.print("Test 2: ");
        System.out.println(reverseParentheses(s));

         s = "dd(df)a(ghhh)";
        System.out.print("Test 3: ");
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {

        // Initialize a stack to keep track of the indices of the opening parentheses encountered
        Stack<Integer> stack = new Stack<Integer>();

        // Convert the input string to a character array for easier manipulation
        char[] arr = s.toCharArray();

        // Iterate through the character array
        for (int i = 0; i < arr.length; i++) {
            // If an opening parenthesis is encountered, push its index onto the stack
            if (arr[i] == '(') {
                stack.push(i);
            }
            // If a closing parenthesis is encountered, reverse the substring between the corresponding opening parenthesis and closing parenthesis
            else if (arr[i] == ')') {
                reverse(arr, stack.pop() + 1, i - 1);
            }
        }
        // Convert the modified character array back to a string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void reverse(char[] arr, int left, int right) {
        // Reverse the substring by swapping the characters at the left and right indices while incrementing left and decrementing right until they meet
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}