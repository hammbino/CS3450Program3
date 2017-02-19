/*
 * Program3
 * Created by jeffrey hammond on 2/18/17.
 */

public class LineOutput extends StreamOutputDecorator {
    private Output decoratedOutput;

    public LineOutput (Output decoratedOutput) {
        this.decoratedOutput = decoratedOutput;
    }

    @Override
    public void write(Object o) {
        decoratedOutput.write(o.toString());
        System.out.println();
    }
}
