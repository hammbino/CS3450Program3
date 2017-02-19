import java.io.IOException;

/**
 * Program3
 * Created by jeffreyhammond on 2/18/17.
 */


public abstract class StreamOutputDecorator implements Output {
    //wrapped component
    Output decoratedOutput;
}