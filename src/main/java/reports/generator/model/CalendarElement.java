package reports.generator.model;

/**
 * Created by higarg on 10/19/17.
 */
public class CalendarElement {

    private String calKey;

    private String calValue;

    private String calId;

    private String calClass;

    private boolean content;



    public String getCalKey() {
        return calKey;
    }

    public void setCalKey(String calKey) {
        this.calKey = calKey;
    }

    public String getCalValue() {
        return calValue;
    }

    public void setCalValue(String calValue) {
        this.calValue = calValue;
    }

    public String getCalId() {
        return calId;
    }

    public void setCalId(String calId) {
        this.calId = calId;
    }

    public String getCalClass() {
        return calClass;
    }

    public void setCalClass(String calClass) {
        this.calClass = calClass;
    }

    public boolean isContent() {
        return content;
    }

    public void setContent(boolean content) {
        this.content = content;
    }
}
