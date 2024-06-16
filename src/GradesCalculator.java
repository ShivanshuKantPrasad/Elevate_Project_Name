import java.util.ArrayList;
import java.util.Scanner;

public class GradesCalculator {

    private ArrayList<Integer> grades;

    public GradesCalculator() {
        grades = new ArrayList<>();
    }

    // Method to add a grade to the list
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // Method to calculate the average grade
    public double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Method to find the highest grade
    public int getHighestGrade() {
        int highest = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest grade
    public int getLowestGrade() {
        int lowest = Integer.MAX_VALUE;
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradesCalculator calculator = new GradesCalculator();

        System.out.println("Enter the grades. Type '-1' to stop entering grades.");
        while (true) {
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            if (grade == -1) {
                break;
            }
            calculator.addGrade(grade);
        }

        if (!calculator.grades.isEmpty()) {
            double average = calculator.calculateAverage();
            int highest = calculator.getHighestGrade();
            int lowest = calculator.getLowestGrade();

            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        } else {
            System.out.println("No grades were entered.");
        }

        scanner.close();
    }
}
