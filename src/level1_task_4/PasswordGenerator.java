package level1_task_4;
import javax.swing.JOptionPane;
import java.security.SecureRandom;

public class PasswordGenerator {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();

		String lengthInput = JOptionPane.showInputDialog(null, "Enter desired password length:");

		if (lengthInput == null || lengthInput.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No input provided. Exiting.");
			return;
		}

		int length;
		try {
			length = Integer.parseInt(lengthInput);
			if (length <= 0) {
				JOptionPane.showMessageDialog(null, "Length must be greater than 0.");
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid length input.");
			return;
		}

		int includeLower = JOptionPane.showConfirmDialog(null, "Include lowercase letters (a-z)?");
		int includeUpper = JOptionPane.showConfirmDialog(null, "Include uppercase letters (A-Z)?");
		int includeNumbers = JOptionPane.showConfirmDialog(null, "Include numbers (0-9)?");
		int includeSymbols = JOptionPane.showConfirmDialog(null, "Include special characters (!@#$...) ?");

		String lower = "abcdefghijklmnopqrstuvwxyz";
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*()-_=+[]{};:,.<>?/";

		StringBuilder characterPool = new StringBuilder();

		if (includeLower == JOptionPane.YES_OPTION)
			characterPool.append(lower);
		if (includeUpper == JOptionPane.YES_OPTION)
			characterPool.append(upper);
		if (includeNumbers == JOptionPane.YES_OPTION)
			characterPool.append(numbers);
		if (includeSymbols == JOptionPane.YES_OPTION)
			characterPool.append(symbols);

		if (characterPool.length() == 0) {
			JOptionPane.showMessageDialog(null, "You must select at least one character type.");
			return;
		}

		StringBuilder password = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characterPool.length());
			password.append(characterPool.charAt(index));
		}
		JOptionPane.showMessageDialog(null, "Generated Password:\n" + password.toString());
	}

}
