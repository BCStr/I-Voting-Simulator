import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class SimulationDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> studentsAnswers = new ArrayList<>();
        studentsAnswers.add("Google");
        studentsAnswers.add("Apple");
        studentsAnswers.add("Samsung");
        studentsAnswers.add("Others");

        Question question = new Question(studentsAnswers);

        VotingService votingService = new VotingService();
        votingService.configureQuestion(question);

        // Get the number of students from user input
        System.out.print("Enter the number of students: ");
        int numofStudents = scanner.nextInt();

        scanner.nextLine();

        // Simulate students and their answers in order
        for (int i = 1; i <= numofStudents; i++) {
            String studentId = "Student " + i;
            String randomAnswer = studentsAnswers.get(new Random().nextInt(studentsAnswers.size()));
            Student student = new Student(studentId, randomAnswer);
            votingService.submitAnswer(student);
        }

        // Print each student's responses in order
        for (int i = 1; i <= numofStudents; i++) {
            String studentId = "Student " + i;
            String answer = votingService.getStudentResponse(studentId);
            System.out.println(studentId + " answered: " + answer);
        }

        // Print submission results
        votingService.printResults();

        // Close the scanner
        scanner.close();
    }

}
