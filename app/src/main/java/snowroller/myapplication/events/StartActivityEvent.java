package snowroller.myapplication.events;

/**
 * Created by Martin on 2018-01-19.
 */

public class StartActivityEvent {

    private Class c;

    public StartActivityEvent(Class c)
    {
        this.c = c;
    }

    public Class getC() {
        return c;
    }
}
