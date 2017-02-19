/*
 * Program3
 * Created by jeffrey hammond on 2/18/17.
 */
import java.io.*;

public class TeeOutput extends StreamOutputDecorator {
    private Output decoratedOutput;
    private File stream2;

    public TeeOutput (Output decoratedOutput, String fileName) {
        this.decoratedOutput = decoratedOutput;
        stream2 = new File(fileName);
        if(stream2.exists()) {
            stream2.delete();
        }
        try {
            stream2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Object o) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(stream2, true))) {
            String content = o.toString();
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        decoratedOutput.write(o.toString());
    }
}


