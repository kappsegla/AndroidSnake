package snowroller.myapplication.events;

/**
 * Created by Martin on 2018-01-19.
 */

public class ShowToastEvent {
    private String text;

    public ShowToastEvent(String text)
    {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
