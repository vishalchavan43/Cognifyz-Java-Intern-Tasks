package level1_task_1;
import javax.swing.JOptionPane;

public class TemperatureConverter {

    public static void main(String[] args) {
        try {
            String tempInput = JOptionPane.showInputDialog(null, "Enter the temperature value:");

            if (tempInput == null) {
                JOptionPane.showMessageDialog(null, "Program cancelled.");
                return;
            }

            double temperature = Double.parseDouble(tempInput);
            String unitInput = JOptionPane.showInputDialog(null, "Enter the unit (C for Celsius, F for Fahrenheit):");
            if (unitInput == null) {
                JOptionPane.showMessageDialog(null, "Program cancelled.");
                return;
            }
            unitInput = unitInput.trim().toUpperCase();

            if (!unitInput.equals("C") && !unitInput.equals("F")) {
                JOptionPane.showMessageDialog(null, "Invalid unit! Please enter C or F.");
                return;
            }
            double convertedTemp;
            String result;
            if (unitInput.equals("C")) {
                convertedTemp = (temperature * 9 / 5) + 32;
                result = String.format("%.2f°C is %.2f°F", temperature, convertedTemp);
            } else {
                convertedTemp = (temperature - 32) * 5 / 9;
                result = String.format("%.2f°F is %.2f°C", temperature, convertedTemp);
            }
            JOptionPane.showMessageDialog(null, result);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a numeric temperature.");
        }
    }
}
