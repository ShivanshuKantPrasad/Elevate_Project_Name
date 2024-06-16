import java.util.Scanner;

public class SimpleCalculator {
    static double getNumber(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    static double add(double a, double b) {
        return a + b;
    }
    static double multiply(double a, double b) {
        return a * b;
    }
    static double divide(double a, double b) {
        return a / b;
    }
    static double subtract(double a, double b) {
        return a - b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter first number: ");
            double a = getNumber(sc);

            System.out.println("Enter second number: ");
            double b = getNumber(sc);

            double res = 0;
            boolean validOperation = true;

            System.out.println("Enter the operator (+, -, *, /):");
            String operation = sc.next();
            operation = operation.trim();

            switch (operation.charAt(0)) {
                case '+':
                    res = add(a, b);
                    break;
                case '-':
                    res = subtract(a, b);
                    break;
                case '*':
                    res = multiply(a, b);
                    break;
                case '/':
                    while (b == 0) {
                        System.out.println("Divisor cannot be zero. Enter valid divisor: ");
                        b = getNumber(sc);
                    }
                    res = divide(a, b);
                    break;
                default:
                    System.out.println("Incorrect operator " + operation);
                    validOperation = false;
            }

            if (validOperation)
                System.out.println(a + " " + operation.charAt(0) + " " + b + " = " + res);

            System.out.println("Do you want to perform another calculation? (yes/no)");
        } while (sc.next().equalsIgnoreCase("yes"));

        sc.close();
    }
}