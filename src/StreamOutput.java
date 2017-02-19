/*
 * Program3
 * Created by jeffrey hammond on 2/18/17.
 */

import java.io.*;

class StreamOutput implements Output {
    private Writer sink;

    public StreamOutput(Writer stream) {
        sink = stream;
    }

    public void write(Object o) {
        try {
            sink.write(o.toString());
            sink.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
