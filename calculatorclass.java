import java.util.Scanner;

class calculatorclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained in each subject
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;

        // Input and Calculate Total Marks
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Grade Calculation
        char grade = calculateGrade(averagePercentage);

        // Display Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Function to calculate grade based on average percentage
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

}

/* OUTPUT:
Enter the number of subjects: 5
Enter marks obtained in subject 1 (out of 100): 75
Enter marks obtained in subject 2 (out of 100): 85
Enter marks obtained in subject 3 (out of 100): 75
Enter marks obtained in subject 4 (out of 100): 85
Enter marks obtained in subject 5 (out of 100): 75

Results:
Total Marks: 395
Average Percentage: 79.0%
Grade: C */