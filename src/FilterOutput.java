/*
 * Program3
 * Created by jeffrey hammond on 2/18/17.
 */
public class FilterOutput extends StreamOutputDecorator implements Predicate {
    public FilterOutput (Output decoratedOutput) {
        this.decoratedOutput = decoratedOutput;
    }
    @Override
    public void write(Object o) {
        if(execute(o)) {
            decoratedOutput.write(o.toString());
        }
    }

    @Override
    public boolean execute(Object o) {
        if (o.toString().matches("^(\\d+)|(.*\\d+.*)$")) {
            return true;
        }
        return false;
    }
}
