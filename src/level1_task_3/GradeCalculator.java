package level1_task_3;
import javax.swing.JOptionPane;

public class GradeCalculator {

	public static void main(String[] args) {
		try {
            String numInput = JOptionPane.showInputDialog(null, "Enter the number of grades:");

            if (numInput == null || numInput.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No input provided. Program exiting.");
                return;
            }

            int numGrades = Integer.parseInt(numInput);

            if (numGrades <= 0) {
                JOptionPane.showMessageDialog(null, "Number of grades must be greater than 0.");
                return;
            }

            double[] grades = new double[numGrades];
            double total = 0;

            for (int i = 0; i < numGrades; i++) {
                String gradeInput = JOptionPane.showInputDialog(null, "Enter grade #" + (i + 1) + ":");

                if (gradeInput == null || gradeInput.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Input cancelled. Program exiting.");
                    return;
                }
                double grade = Double.parseDouble(gradeInput);

                if (grade < 0 || grade > 100) {
                    JOptionPane.showMessageDialog(null, "Grade must be between 0 and 100.");
                    i--; 
                    continue;
                }
                grades[i] = grade;
                total += grade;
            }
            double average = total / numGrades;
            JOptionPane.showMessageDialog(null, String.format("Average grade: %.2f", average));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values only.");
        }
	}

}
