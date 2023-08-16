import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Quiz App");

        User currentUser = null;

        while (true) {
            System.out.println("\nMenu:");
            if (currentUser == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
            } else {
                System.out.println("Logged in as: " + currentUser.getUsername());
                System.out.println("3. Play Quiz");
                System.out.println("4.Logout");
            }
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String  choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (currentUser == null) {
                        System.out.print("Enter a username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter a password: ");
                        String password = scanner.nextLine();
                        currentUser = new User(username, password);
                        System.out.println("Registration successful!");
                        currentUser.setIsloggedIn();
                    } else {
                        System.out.println("You are already logged in.");
                    }
                    break;

                case "2":
                    if (currentUser == null) {
                        System.out.print("Enter your username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter your password: ");
                        String password = scanner.nextLine();
                        currentUser = new User(username, password);
                        currentUser.login(username, password);
                        if (currentUser.isLoggedIn()) {
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Login failed. Invalid username or password.");
                            currentUser = null; 
                        }
                    } else {
                        System.out.println("You are already logged in.");
                    }
                    break;

                case "3":
                    if (currentUser != null && currentUser.isLoggedIn()) {
                        playQuiz(scanner);
                    } else {
                        System.out.println("You must be logged in to play the quiz.");
                    }
                    break;
                
                    
                case "4":
                    if (currentUser != null && currentUser.isLoggedIn()) {
                        currentUser.logout();
                        currentUser = null;
                        System.out.println("Logout successful.");
                    } else {
                        System.out.println("You are not logged in.");
                    }
                    break;

                case "5":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void playQuiz(Scanner scanner) {
        QuizBrain quizBrain = new QuizBrain();

        System.out.println("Quiz Starts NOW!!!!");
        System.out.println("You have a total of 5 Questions. Each question has 1 point");

        int start = 0;
        while (start < 5) {
            System.out.println("Question " + (start + 1) + ": " + quizBrain.fetchQuestion());
            String userAnswer = scanner.nextLine();

            if (quizBrain.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is: " + quizBrain.getCorrectAnswer());
            }

            start++;
            quizBrain.nextQuestion();
        }
    }
}
