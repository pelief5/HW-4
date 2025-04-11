import java.util.List;
import java.util.Scanner;

/**
 * Main application class for the HW2 CRUD Application.
 * Provides a menu-driven interface for managing Questions and Answers.
 */
public class HW2 {
    private static Questions questions = new Questions();
    private static Answers answers = new Answers();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addQuestion();
                    break;
                case 2:
                    updateQuestion();
                    break;
                case 3:
                    removeQuestion();
                    break;
                case 4:
                    listQuestions();
                    break;
                case 5:
                    searchQuestions();
                    break;
                case 6:
                    addAnswer();
                    break;
                case 7:
                    updateAnswer();
                    break;
                case 8:
                    removeAnswer();
                    break;
                case 9:
                    listAnswersForQuestion();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
    
    private static void showMenu() {
        System.out.println("\n=== HW2 CRUD Application ===");
        System.out.println("1. Add Question");
        System.out.println("2. Update Question");
        System.out.println("3. Remove Question");
        System.out.println("4. List All Questions");
        System.out.println("5. Search Questions");
        System.out.println("6. Add Answer");
        System.out.println("7. Update Answer");
        System.out.println("8. Remove Answer");
        System.out.println("9. List Answers for a Question");
        System.out.println("0. Exit");
    }
    
    private static void addQuestion() {
        System.out.println("\n--- Add Question ---");
        System.out.print("Enter question text: ");
        String text = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        Question q = new Question(text, category);
        questions.addQuestion(q);
    }
    
    private static void updateQuestion() {
        System.out.println("\n--- Update Question ---");
        int id = getIntInput("Enter question ID to update: ");
        System.out.print("Enter new question text: ");
        String newText = scanner.nextLine();
        System.out.print("Enter new category: ");
        String newCategory = scanner.nextLine();
        questions.updateQuestion(id, newText, newCategory);
    }
    
    private static void removeQuestion() {
        System.out.println("\n--- Remove Question ---");
        int id = getIntInput("Enter question ID to remove: ");
        questions.removeQuestion(id);
    }
    
    private static void listQuestions() {
        System.out.println("\n--- List of Questions ---");
        List<Question> qList = questions.getAllQuestions();
        if (qList.isEmpty()) {
            System.out.println("No questions available.");
        } else {
            for (Question q : qList) {
                System.out.println(q);
            }
        }
    }
    
    private static void searchQuestions() {
        System.out.println("\n--- Search Questions ---");
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine();
        List<Question> results = questions.searchQuestions(keyword);
        if (results.isEmpty()) {
            System.out.println("No questions found with the given keyword.");
        } else {
            for (Question q : results) {
                System.out.println(q);
            }
        }
    }
    
    private static void addAnswer() {
        System.out.println("\n--- Add Answer ---");
        int questionId = getIntInput("Enter question ID for the answer: ");
        if (questions.getQuestionById(questionId) == null) {
            System.out.println("Error: Question does not exist.");
            return;
        }
        System.out.print("Enter answer text: ");
        String text = scanner.nextLine();
        Answer a = new Answer(questionId, text);
        answers.addAnswer(a);
    }
    
    private static void updateAnswer() {
        System.out.println("\n--- Update Answer ---");
        int id = getIntInput("Enter answer ID to update: ");
        System.out.print("Enter new answer text: ");
        String newText = scanner.nextLine();
        answers.updateAnswer(id, newText);
    }
    
    private static void removeAnswer() {
        System.out.println("\n--- Remove Answer ---");
        int id = getIntInput("Enter answer ID to remove: ");
        answers.removeAnswer(id);
    }
    
    private static void listAnswersForQuestion() {
        System.out.println("\n--- List Answers for a Question ---");
        int questionId = getIntInput("Enter question ID: ");
        if (questions.getQuestionById(questionId) == null) {
            System.out.println("Error: Question does not exist.");
            return;
        }
        List<Answer> ansList = answers.getAnswersByQuestionId(questionId);
        if (ansList.isEmpty()) {
            System.out.println("No answers available for this question.");
        } else {
            for (Answer a : ansList) {
                System.out.println(a);
            }
        }
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
