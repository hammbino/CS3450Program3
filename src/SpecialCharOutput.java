/**
 * Program3
 * Created by jeffreyhammond on 2/19/17.
 */
public class SpecialCharOutput extends StreamOutputDecorator implements Predicate {
    public SpecialCharOutput (Output decoratedOutput) {
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
        if (o.toString().matches("^(.*[^\\w\\s\\,\\.\\(\\)\\:\\-\\'\\\"\\+].*)$")) {
            return true;
        }
        return false;
    }
}