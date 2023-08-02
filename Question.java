public class Question {
    private String quizQuestion;
    private String questionAnswer;

    public Question(String question, String qAnswer) {
        this.quizQuestion = question;
        this.questionAnswer = qAnswer;
    }

    public String getQuestion() {
        return quizQuestion;
    }

    public String getAnswer() {
        return questionAnswer;
    }
}
