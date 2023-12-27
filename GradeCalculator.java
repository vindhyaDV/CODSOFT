import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.println("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        char grade;
        if (averagePercentage >= 95) {
            grade = 'A';
        } else if (averagePercentage >= 70) {
            grade = 'B';
        } else if (averagePercentage >=65) {
            grade = 'C';
        } else if (averagePercentage >= 50) {
            grade = 'D';
        } else if(averagePercentage>=30){
            grade = 'E';
        }else{
              grade  ='F';
   }

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}