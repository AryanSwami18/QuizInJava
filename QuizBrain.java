public class QuizBrain {
    private Question[] questions;
    private int currentQuestionIndex;

    public QuizBrain() {
        questions = new Question[5];
        
        questions[0] = new Question("What is the capital of France?", "Paris");
        questions[1] = new Question("Which planet is known as the Red Planet?", "Mars");
        questions[2] = new Question("What is the largest mammal?", "Blue Whale");
        questions[3] = new Question("Who painted the Mona Lisa?", "Leonardo da Vinci");
        questions[4] = new Question("What is the largest planet in our solar system?", "Jupiter");
        
        currentQuestionIndex = 0;
    }

    public String fetchQuestion() {
        return questions[currentQuestionIndex].getQuestion();
    }
    
    public String getCorrectAnswer() {
        return questions[currentQuestionIndex].getAnswer();
    }
    
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(questions[currentQuestionIndex].getAnswer());
    }

    public void nextQuestion(){
        currentQuestionIndex++;
    }
}

