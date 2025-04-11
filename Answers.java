import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of Answer objects with CRUD operations.
 */
public class Answers {
    private List<Answer> answersList;
    
    public Answers() {
        answersList = new ArrayList<>();
    }
    
    /**
     * Adds an answer if its text is not empty.
     * @param a the Answer to add
     * @return true if added successfully, false otherwise
     */
    public boolean addAnswer(Answer a) {
        if (a.getText() == null || a.getText().trim().isEmpty()) {
            System.out.println("Error: Answer text cannot be empty.");
            return false;
        }
        answersList.add(a);
        System.out.println("Answer added successfully.");
        return true;
    }
    
    /**
     * Updates an existing answer's text.
     * @param id the Answer ID to update
     * @param newText the new text
     * @return true if update succeeds, false otherwise
     */
    public boolean updateAnswer(int id, String newText) {
        for (Answer a : answersList) {
            if (a.getId() == id) {
                if (newText == null || newText.trim().isEmpty()) {
                    System.out.println("Error: Answer text cannot be empty.");
                    return false;
                }
                a.setText(newText);
                System.out.println("Answer updated successfully.");
                return true;
            }
        }
        System.out.println("Error: Answer not found.");
        return false;
    }
    
    /**
     * Removes an answer by its ID.
     * @param id the Answer ID to remove
     * @return true if removal succeeds, false otherwise
     */
    public boolean removeAnswer(int id) {
        for (Answer a : answersList) {
            if (a.getId() == id) {
                answersList.remove(a);
                System.out.println("Answer removed successfully.");
                return true;
            }
        }
        System.out.println("Error: Answer not found.");
        return false;
    }
    
    /**
     * Retrieves all answers for a given question ID.
     * @param questionId the associated question ID
     * @return list of matching Answer objects
     */
    public List<Answer> getAnswersByQuestionId(int questionId) {
        List<Answer> result = new ArrayList<>();
        for (Answer a : answersList) {
            if (a.getQuestionId() == questionId) {
                result.add(a);
            }
        }
        return result;
    }
    
    /**
     * Returns all answers.
     * @return list of all Answer objects
     */
    public List<Answer> getAllAnswers() {
        return new ArrayList<>(answersList);
    }
}

