import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grade Calculator ===");

        // 1. Get student's name
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();

        // 2. Get scores with validation
        double homework = readScore(scanner, "Enter homework average (0 - 100): ");
        double midterm = readScore(scanner, "Enter midterm exam score (0 - 100): ");
        double finalExam = readScore(scanner, "Enter final exam score (0 - 100): ");

        // 3. Calculate weighted final grade
        //    Change weights here if you want different percentages
        double finalNumericGrade = homework * 0.30 + midterm * 0.30 + finalExam * 0.40;

        // 4. Convert numeric to letter grade
        char letterGrade = getLetterGrade(finalNumericGrade);

        // 5. Print result
        System.out.println("\n--- Result ---");
        System.out.printf("Student: %s%n", name);
        System.out.printf("Final numeric grade: %.2f%n", finalNumericGrade);
        System.out.println("Letter grade: " + letterGrade);

        scanner.close();
    }

    // Method to safely read a score between 0 and 100
    private static double readScore(Scanner scanner, String prompt) {
        double score;

        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                score = scanner.nextDouble();

                if (score >= 0 && score <= 100) {
                    break; // valid value
                } else {
                    System.out.println("❌ Please enter a number between 0 and 100.");
                }
            } else {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }

        return score;
    }

    // Method to get letter grade from numeric grade
    private static char getLetterGrade(double score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
