package hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
    String wort;
    String[] buchstabe;
    int fehleranzahl=0;


    public hangman() throws IOException {
        BufferedReader ausleser = new BufferedReader(new FileReader("src/hangman/wortliste.txt"));

        String ausgesuchteswort="";


        try {
            ausgesuchteswort= ausleser.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String finalAusgesuchteswort = ausgesuchteswort;

         wort =ausgesuchteswort;


        knopf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(finalAusgesuchteswort);
                int zeile=0;
                double zufallszahld=Math.random()*100000+5*Math.random()*200-10*Math.random()*100;
                int zufallszahl =(int) zufallszahld;

                       try {
                           for (String aktuellesWort = ausleser.readLine(); aktuellesWort != null; aktuellesWort = ausleser.readLine()) {
                               while (zeile != zufallszahl) {
                                   zeile = zeile + 1;
                                   wort = ausleser.readLine();

                               }}
                           } catch(IOException ex){
                               throw new RuntimeException(ex);
                           }
                buchstabe = new String [wort.length()];



                b1.setText("");
               for(int i=0;i<wort.length();i++){

                  buchstabe[i]= "_";
                  b1.setText(b1.getText()+" " +buchstabe[i]);
                   versuchefeld.setText("");
                   buchstabenchecker.setText("");
                   versuchsanzahl=0;
                   zeile=0;
                   zufallszahl=0;
                   fehleranzahl=0;
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
                         fehleranzahl=fehleranzahl +1;
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
                if(versuchefeld.getText().length()==19){
                    buchstabenchecker.setText("Du hast "+ fehleranzahl +" Fehler gemacht. Probier es nochmal.");
                }


            }
        });
    }

    public static void main(String[] args) throws IOException{
        JFrame frame = new JFrame("hangman");
        frame.setContentPane(new hangman().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
