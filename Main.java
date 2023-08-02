import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Quiz APP");
        
        // QuizBrain initialization
        QuizBrain quizBrain = new QuizBrain();
        
        // Quiz Start Here
        System.out.println("Quiz Starts NOW!!!!");
        System.out.println("You have a total of 5 Questions. Each question has 1 point");
        
        int start = 0;
        while (start < 5) {
            System.out.println("Question " + (start + 1) + ": " + quizBrain.fetchQuestion());
            String userAnswer = s.nextLine();
            
            if (quizBrain.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is: " + quizBrain.getCorrectAnswer());
            }
            
            start++;
            quizBrain.nextQuestion();
        }
        
        // Quiz End here
        s.close();
    }
}
