package hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hangman {
    private JPanel panel;
    private JLabel hangman;
    private JButton knopf;
    private JTextField buchstabenchecker;
    private JTextField b1;
    private JButton check;
    private JLabel h;
    private JTextField textField1;


    public hangman() {
        knopf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String wort ="hallo";
               for(int i=0;i<wort.length();i++){
                   b1.setText(b1.getText()+" _ ");
               }
            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("hangman");
        frame.setContentPane(new hangman().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
