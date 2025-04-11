import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a question in the application.
 */
public class Question {
    private static AtomicInteger idCounter = new AtomicInteger(1);
    
    private int id;
    private String text;
    private String category;
    
    public Question(String text, String category) {
        this.id = idCounter.getAndIncrement();
        this.text = text;
        this.category = category;
    }
    
    public int getId() {
        return id;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
        return "Question ID: " + id + " | Category: " + category + " | Text: " + text;
    }
}
