package level1_task_2;
import javax.swing.JOptionPane;

public class PalindromeChecker {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Enter a word or phrase to check for palindrome:");
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No input provided.");
            return;
        }
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = true;
        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            JOptionPane.showMessageDialog(null, input + "' is a palindrome!");
        } else {
            JOptionPane.showMessageDialog(null, input + "' is NOT a palindrome.");
        }
    }
}
