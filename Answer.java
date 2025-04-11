import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents an answer to a question.
 */
public class Answer {
    private static AtomicInteger idCounter = new AtomicInteger(1);
    
    private int id;
    private int questionId;  
    private String text;
    
    public Answer(int questionId, String text) {
        this.id = idCounter.getAndIncrement();
        this.questionId = questionId;
        this.text = text;
    }
    
    public int getId() {
        return id;
    }
    
    public int getQuestionId() {
        return questionId;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return "Answer ID: " + id + " | For Question ID: " + questionId + " | Text: " + text;
    }
}
