import java.util.List;

public class Question {
    private List<String> studentAnswers;

    public Question(List<String> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public List<String> getStudentAnswers() {
        return studentAnswers;
    }
}
