import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string containing only '(' and ')': ");
        String input = sc.nextLine();

        Solution solver = new Solution();
        int result = solver.longestValidParentheses(input);

        System.out.println("Longest valid parentheses substring length: " + result);

        sc.close();
        }

    public int longestValidParentheses(String s) {
        int maxLen = 0, left = 0, right = 0;

        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++; 
            }
            else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            }
            else if (right > left) {
                left = right = 0; 
            }
        }

        left = 0;
        right = 0;
       
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            }

            else if (left > right) {
                left = right = 0; 
            }
        }

        return maxLen;
    }
}