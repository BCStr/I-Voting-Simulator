import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingService {
    private Question question;
    private Map<String, String> studentResponses;
    private Map<String, Integer> answerCounts;

    public void configureQuestion(Question question) {
        this.question = question;
        studentResponses = new TreeMap<>(); // TreeMap for sorting by student IDs hash doesnt maintain order
        answerCounts = new HashMap<>();
        for (String answer : question.getStudentAnswers()) {
            answerCounts.put(answer, 0);
        }
    }

    public synchronized void submitAnswer(Student student) {
        if (question.getStudentAnswers().contains(student.getAnswer())) {
            studentResponses.put(student.getId(), student.getAnswer());
            answerCounts.merge(student.getAnswer(), 1, Integer::sum);
        }
    }

    public String getStudentResponse(String studentId) {
        return studentResponses.get(studentId);
    }

    public void printResults() {
        System.out.println("Results from the Question: What type of phone do you use?");
        for (String answer : question.getStudentAnswers()) {
            System.out.println(answer + " : " + answerCounts.getOrDefault(answer, 0));
        }
    }
}