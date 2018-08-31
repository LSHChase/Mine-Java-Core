package someClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOpenListener implements ActionListener {

    private static final Logger logger = Logger.getLogger("com.me.demo");
    private JLabel label;

    public FileOpenListener(JLabel label){
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logger.entering("ImageViewer.FileOpenListener", "actionPerformed", e);

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        chooser.setFileFilter(new javax.swing.filechooser.FileFilter(){
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Gif Images";
            }
        });

        try {
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            if (JFileChooser.APPROVE_OPTION == r) {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            } else logger.fine("File open dialog canceled.");
            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
        }
        catch
    }
}
