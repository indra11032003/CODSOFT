import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGame {
    static class Question {
        String question;
        String[] options;
        String correctAnswer;

        Question(String question, String[] options, String correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    private static final int QUESTION_TIME_LIMIT_SECONDS = 10;
    private static Scanner scanner = new Scanner(System.in);
    private static Timer timer = new Timer();
    private static boolean timeExpired;

    public static void main(String[] args) {
        Question[] questions = {
            new Question("What is the capital of France?", new String[]{"A. London", "B. Paris", "C. Berlin", "D. Madrid"}, "B"),
            new Question("Which planet is known as the Red Planet?", new String[]{"A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"}, "B"),
            new Question("What is the largest mammal in the world?", new String[]{"A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Dolphin"}, "B"),
            new Question("Who wrote 'Romeo and Juliet'?", new String[]{"A. Charles Dickens", "B. William Shakespeare", "C. Jane Austen", "D. Mark Twain"}, "B"),
            new Question("What is the chemical symbol for gold?", new String[]{"A. Au", "B. Ag", "C. Fe", "D. Cu"}, "A"),
            new Question("Which country is known as the Land of the Rising Sun?", new String[]{"A. China", "B. Japan", "C. South Korea", "D. Thailand"}, "B"),
            new Question("What is the capital of Australia?", new String[]{"A. Sydney", "B. Canberra", "C. Melbourne", "D. Brisbane"}, "B"),
            new Question("In which year did the Titanic sink?", new String[]{"A. 1905", "B. 1912", "C. 1920", "D. 1931"}, "B"),
            new Question("Who painted the Mona Lisa?", new String[]{"A. Vincent van Gogh", "B. Pablo Picasso", "C. Leonardo da Vinci", "D. Michelangelo"}, "C"),
            new Question("What is the main ingredient in guacamole?", new String[]{"A. Avocado", "B. Tomato", "C. Onion", "D. Garlic"}, "A"),
            new Question("Which gas is most abundant in the Earth's atmosphere?", new String[]{"A. Oxygen", "B. Nitrogen", "C. Carbon Dioxide", "D. Helium"}, "B"),
            new Question("Who is known as the 'Father of Computer Science'?", new String[]{"A. Bill Gates", "B. Alan Turing", "C. Steve Jobs", "D. Mark Zuckerberg"}, "B"),
            new Question("What is the capital of Japan?", new String[]{"A. Tokyo", "B. Beijing", "C. Seoul", "D. Bangkok"}, "A"),
            new Question("Which element has the chemical symbol 'H'?", new String[]{"A. Hydrogen", "B. Helium", "C. Carbon", "D. Oxygen"}, "A"),
            new Question("What is the currency of Brazil?", new String[]{"A. Peso", "B. Real", "C. Baht", "D. Rupee"}, "B"),
            new Question("Who wrote 'To Kill a Mockingbird'?", new String[]{"A. J.K. Rowling", "B. Harper Lee", "C. George Orwell", "D. Ernest Hemingway"}, "B"),
            // Add 1 more question similarly
        };

        int totalScore = 0;

        for (Question question : questions) {
            timeExpired = false;
            displayQuestion(question);
            startTimer();
            String userAnswer = getUserAnswer();
            timer.cancel(); // Cancel the timer when the user answers

            if (!timeExpired && userAnswer.equals(question.correctAnswer)) {
                totalScore++;
            }
        }

        displayResult(totalScore, questions.length);
    }

    private static void startTimer() {
        synchronized (timer) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving on to the next question.");
                    timeExpired = true;
                    timer.cancel();
                }
            }, QUESTION_TIME_LIMIT_SECONDS * 1000);
        }
    }

    private static void displayQuestion(Question question) {
        System.out.println(question.question);
        for (String option : question.options) {
            System.out.println(option);
        }
    }

    private static String getUserAnswer() {
        System.out.print("Enter your answer (A, B, C, or D): ");
        return scanner.next().toUpperCase();
    }

    private static void displayResult(int totalScore, int totalQuestions) {
        System.out.println("Your final score: " + totalScore + "/" + totalQuestions);
    }
}
