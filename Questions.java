import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of Question objects with CRUD operations.
 */
public class Questions {
    private List<Question> questionsList;
    
    public Questions() {
        questionsList = new ArrayList<>();
    }
    
    /**
     * Adds a new question if the text is not empty and is not a duplicate.
     * @param q the Question to add
     * @return true if added successfully, false otherwise
     */
    public boolean addQuestion(Question q) {
        if (q.getText() == null || q.getText().trim().isEmpty()) {
            System.out.println("Error: Question text cannot be empty.");
            return false;
        }
      
        for (Question existing : questionsList) {
            if (existing.getText().equalsIgnoreCase(q.getText())) {
                System.out.println("Error: Duplicate question.");
                return false;
            }
        }
        questionsList.add(q);
        System.out.println("Question added successfully.");
        return true;
    }
    
    /**
     * Updates an existing question’s text and category.
     * @param id the Question ID to update
     * @param newText the new question text
     * @param newCategory the new category
     * @return true if update succeeds, false otherwise
     */
    public boolean updateQuestion(int id, String newText, String newCategory) {
        for (Question q : questionsList) {
            if (q.getId() == id) {
                if (newText == null || newText.trim().isEmpty()) {
                    System.out.println("Error: Question text cannot be empty.");
                    return false;
                }
                for (Question other : questionsList) {
                    if (other.getId() != id && other.getText().equalsIgnoreCase(newText)) {
                        System.out.println("Error: Duplicate question text.");
                        return false;
                    }
                }
                q.setText(newText);
                q.setCategory(newCategory);
                System.out.println("Question updated successfully.");
                return true;
            }
        }
        System.out.println("Error: Question not found.");
        return false;
    }
    
    /**
     * Removes a question by its ID.
     * @param id the Question ID to remove
     * @return true if removal is successful, false otherwise
     */
    public boolean removeQuestion(int id) {
        for (Question q : questionsList) {
            if (q.getId() == id) {
                questionsList.remove(q);
                System.out.println("Question removed successfully.");
                return true;
            }
        }
        System.out.println("Error: Question not found.");
        return false;
    }
    
    /**
     * Returns all questions.
     * @return list of all Question objects
     */
    public List<Question> getAllQuestions() {
        return new ArrayList<>(questionsList);
    }
    
    /**
     * Retrieves a question by its ID.
     * @param id the Question ID
     * @return the matching Question object, or null if not found
     */
    public Question getQuestionById(int id) {
        for (Question q : questionsList) {
            if (q.getId() == id)
                return q;
        }
        return null;
    }
    
    /**
     * Searches for questions that contain a keyword.
     * @param keyword the keyword to search for
     * @return list of matching Question objects
     */
    public List<Question> searchQuestions(String keyword) {
        List<Question> result = new ArrayList<>();
        for (Question q : questionsList) {
            if (q.getText().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(q);
            }
        }
        return result;
    }
}

