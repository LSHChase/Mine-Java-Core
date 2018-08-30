package someClass;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class WindowsHandler extends StreamHandler {
    public WindowsHandler(){
        final JTextArea output = new JTextArea();
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
            public void write(byte[] b, int off, int len){
                output.append(new String(b, off, len));
            }
        });
    }

    public void publish(LogRecord record){
        super.publish(record);
        flush();
    }
}
