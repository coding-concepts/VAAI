import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextEditor {
    private JButton saveButton;
    private JButton editButton;
    private JButton loadButton;
    private JPanel ButtonPanel;
    private JPanel textfieldPanel;
    private JButton closeButton;
    private JPanel Panel;
    private JTextArea textArea1;
    private JButton printButton;

    public static void main(String args[]){
        JFrame frame = new JFrame("Vigg's Text Editor 20000");
        frame.setContentPane(new TextEditor().textfieldPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public TextEditor() {
        saveButton.addActionListener(new ActionListener() {
                                         @Override
                                         public void actionPerformed(ActionEvent e) {
                                             JFileChooser saveFile = new JFileChooser();
                                             int show = saveFile.showSaveDialog(null);
                                             if (show == JFileChooser.APPROVE_OPTION) {
                                                 File chosenfile = new File(saveFile.getSelectedFile().getAbsolutePath());
                                                    try{
                                                        //FileWriter allows the user to write character files. can be closed and more, allows
                                                        //user to write stuff in it; refer to https://www.tutorialspoint.com/java/java_filewriter_class.htm
                                                 FileWriter writer = new FileWriter(chosenfile,true);
                                                 // As pulled from the definition, a buffered writer is  instead of reading one byte at a time, you read 1000
                                                        //bytes at a time, allowing for faster efficiency
                                                        BufferedWriter buffer = new BufferedWriter(writer);
                                                        writer.write(textArea1.getText());
                                                        writer.flush();
                                                        writer.close();
                                                    } catch (IOException e1) {
                                                        e1.printStackTrace();
                                                    }
                                             }
                                         }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obviously the name shown explains the class. It allows the user to choose a directory and presents its own GUI for
                //choosing files
                JFileChooser filer = new JFileChooser();
                //unclear on why a int value is returned, and what the showOpenDialog method does
                int number = filer.showOpenDialog(null);
                if (number == JFileChooser.APPROVE_OPTION) {
                    File fi = new File(filer.getSelectedFile().getAbsolutePath());
                }
        }});
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.setVisible(false);
            }
        });
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea1.print();
                } catch (PrinterException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
