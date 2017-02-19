/**
 * Program3
 * Created by jeffreyhammond on 2/18/17.
 */
public class EnumeratedOutput extends StreamOutputDecorator {
    private Output decoratedOutput;
    private static int count = 1;

    public EnumeratedOutput (Output decoratedOutput) {
        this.decoratedOutput = decoratedOutput;
    }

    @Override
    public void write(Object o) {
        System.out.printf("%5d: ", count);
        decoratedOutput.write(o.toString());
        System.out.println();
        count++;
    }
}