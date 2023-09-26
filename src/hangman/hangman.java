package hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class hangman {
    private JPanel panel;
    private JLabel hangman;
    private JButton knopf;
    private JTextField buchstabenchecker;
    private JTextField b1;
    private JButton check;
    private JLabel h;
    private JTextField versuchefeld;
    private JLabel label;
    int versuchsanzahl=0;




    public hangman() {
        String[] wortliste;
        wortliste= new String [50];
        wortliste[1]="Oberfläche";
        wortliste[2]="einloggen";
        wortliste[3]="einloggen";

        String wort =wortliste[2];
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
                   buchstabenchecker.setText("");
                   versuchsanzahl=0;
               }

            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    versuchsanzahl=versuchsanzahl+1;
                String versuch= buchstabenchecker.getText();
                String versuchgroß=versuch.toUpperCase();
                String versuchklein=versuch.toLowerCase();
                if(versuchklein.equals(wort.toLowerCase())) {
                    b1.setText(wort);
                    buchstabenchecker.setText("Du hast nur "+versuchsanzahl+" Versuch(e) gebraucht");

                }else {
                    if (wort.indexOf(versuchgroß) == -1 && wort.indexOf(versuchklein) == -1) {
                        String platzhalter2 = versuchefeld.getText();
                        if (!platzhalter2.equals("")) {
                            versuchefeld.setText(versuchefeld.getText() + "," + versuch);
                        } else {
                            versuchefeld.setText(versuch);
                        }
                    }
                    if (versuch.length() == 1) {
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

                    for (int i = 0; i < wort.length(); i++) {

                        b1.setText(b1.getText() + " " + buchstabe[i]);
                        buchstabenchecker.setText("");
                    }
                    if(b1.getText().indexOf("_")==-1){
                        b1.setText(wort);
                        buchstabenchecker.setText("Du hast nur "+versuchsanzahl+" Versuch(e) gebraucht");

                    }
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
