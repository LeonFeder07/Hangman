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
    private JTextField versuchefeld;


    public hangman() {
        String wort ="Halllo";
        String[] buchstabe;
        buchstabe = new String [wort.length()];
        knopf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                b1.setText("");
               for(int i=0;i<wort.length();i++){

                  buchstabe[i]= "_";
                  b1.setText(b1.getText()+" " +buchstabe[i]);
                   versuchefeld.setText("");
               }

            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String versuch= buchstabenchecker.getText();
                String versuchgroß=versuch.toUpperCase();
                String versuchklein=versuch.toLowerCase();
                if(wort.indexOf(versuchgroß)==-1 && wort.indexOf(versuchklein)==-1){
                    versuchefeld.setText(versuchefeld.getText()+" "+versuch);
                }
                if(versuch.length()==1) {
                    for (int i = 0; i < wort.length(); i++) {
                        String wortplatzhalter = String.valueOf(wort.charAt(i));
                        if (wortplatzhalter.equals(versuchklein)) {
                            buchstabe[i] = versuchklein;

                        }
                        if (wortplatzhalter.equals(versuchgroß)) {
                            buchstabe[i] = versuchgroß;

                        }

                    }
                }


                b1.setText("");
                for(int i=0;i<wort.length();i++){

                    b1.setText(b1.getText()+" " +buchstabe[i]);
                    buchstabenchecker.setText("");
                }
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}