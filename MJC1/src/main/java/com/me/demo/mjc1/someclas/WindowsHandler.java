package com.me.demo.mjc1.someclas;

import javax.swing.*;
import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class WindowsHandler extends StreamHandler {

    private JFrame frame;

    public WindowsHandler(){
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) {
            }
            @Override
            public void write(byte[] b, int off, int len)
            {
                output.append(new String(b, off, len));
            }
        });
    }

    @Override
    public void publish(LogRecord record){
        if (!frame.isVisible()) return ;
        super.publish(record);
        flush();
    }
}
