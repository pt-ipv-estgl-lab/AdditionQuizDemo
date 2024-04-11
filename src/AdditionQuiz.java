import java.util.Random;
import java.util.Scanner;

/**
 * This program administers a ten-question addition quiz to the user. The
 * numbers
 * for the problem are chosen at random. The numbers and the answers are one or
 * two digits. After asking the user the ten questions, the computer grades the
 * quiz, telling the user the correct answer for any problem they got wrong.
 */
public class AdditionQuiz {

    public static void main(String[] args) {
        int[] firstNum = new int[10]; // The first numbers in all ten questions.
        int[] secondNum = new int[10]; // The second numbers in all ten questions.
        int[] userAns = new int[10]; // The user's answers to the ten questions.

        System.out.println();
        System.out.println("Welcome to the addition quiz!");
        System.out.println();
        createQuiz(firstNum, secondNum);
        administerQuiz(firstNum, secondNum, userAns);
        gradeQuiz(firstNum, secondNum, userAns);
    }

    /**
     * Shows all the questions, with their correct answers, and computes a grade
     * for the quiz. For each question, the user is told whether they got
     * it right.
     */
    private static void gradeQuiz(int[] firstNumbers, int[] secondNumbers, int[] userAnswers) {
        System.out.println();
        System.out.println("Here are the correct answers:");
        int numberCorrect = 0;
        int grade;
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            int correctAnswer = firstNumbers[i] + secondNumbers[i];
            System.out.printf("   Question %2d:  %2d + %2d  =  %2d.  ",
                    questionNum, firstNumbers[i], secondNumbers[i], correctAnswer);
            if (userAnswers[i] == correctAnswer) {
                System.out.println("You were CORRECT.");
                numberCorrect++;
            } else {
                System.out.println("You said " + userAnswers[i] + ", which is INCORRECT.");
            }
        }
        grade = numberCorrect * 10;
        System.out.println();
        System.out.println("You got " + numberCorrect + " questions correct.");
        System.out.println("Your grade on the quiz is " + grade);
        System.out.println();
    }

    /**
     * Asks the user each of the ten quiz questions and gets the user's answers.
     * The answers are stored in an array, which is created in this subroutine.
     */
    private static void administerQuiz(int[] firstNumbers, int[] secondNumbers, int[] userAnswers) {
        Scanner stdin = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("Question %2d:  What is %2d + %2d  ? ",
                    questionNum, firstNumbers[i], secondNumbers[i]);
            userAnswers[i] = stdin.nextInt();
        }

        stdin.close();
    }

      /**
     * Creates the arrays that hold the numbers for the questions and fills
     * them with random numbers.  The parameters are arrays that will hold
     * the random numbers for the first and second operands of each addition
     * problem.  The arrays must have already been created when this subroutine
     * is called!
     */
    private static void createQuiz(int[] firstNumbers, int[] secondNumbers) {
        Random nextInt = new Random();

        for (int i = 0; i < 10; i++) {
            // (int)(Math.random() * 50 + 1); // in the range 1 to 50
            firstNumbers[i] = nextInt.nextInt(1, 50);
            // (int)(Math.random() * 50); // in the range 0 to 49
            secondNumbers[i] = nextInt.nextInt(50);
        }
    }
}
