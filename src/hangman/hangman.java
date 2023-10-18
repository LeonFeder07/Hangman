package hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;


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
    private JTextArea textArea1;
    int versuchsanzahl = 0;
    String wort;
    String[] buchstabe;
    int fehleranzahl = 0;
    double zufallszahld =0;



    public hangman() throws IOException {
        textArea1.setText ("\n\n\n\n\n\n\n\t\t\t\n\n\n\n\n\n  ==================  ");


        wort = "";


        knopf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    zufallszahlgenerieren();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                b1.setText("");
                for (int i = 0; i < wort.length(); i++) {

                    buchstabe[i] = "_";
                    b1.setText(b1.getText() + " " + buchstabe[i]);
                    versuchefeld.setText("");
                    buchstabenchecker.setText("");
                    versuchsanzahl = 0;

                    fehleranzahl = 0;
                    textArea1.setText ("\n\n\n\n\n\n\n\t\t\t\n\n\n\n\n\n  ==================  ");
                }

                buchstabenchecker.setEditable(true);

            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                versuchsanzahl = versuchsanzahl + 1;
                String versuch = buchstabenchecker.getText();
                String versuchgroß = versuch.toUpperCase();
                String versuchklein = versuch.toLowerCase();

                if (versuchklein.equals(wort.toLowerCase())) {
                    b1.setText(wort);
                    if(versuchsanzahl==1) {
                        buchstabenchecker.setText("Du hast nur " + versuchsanzahl + " Versuch gebraucht");
                        buchstabenchecker.setEditable(false);
                    }else{
                        buchstabenchecker.setText("Du hast nur " + versuchsanzahl + " Versuche gebraucht");
                        buchstabenchecker.setEditable(false);
                    }

                } else {
                    if (wort.indexOf(versuchgroß) == -1 && wort.indexOf(versuchklein) == -1) {
                        String platzhalter2 = versuchefeld.getText();
                        fehleranzahl = fehleranzahl + 1;

                        if (!platzhalter2.equals("")) {
                            versuchefeld.setText(versuchefeld.getText() + "," + versuch);
                        } else {
                            versuchefeld.setText(versuch);
                        }

                    }
                    if(fehleranzahl==1){
                        textArea1.setText ("\n\n\n\n\n\n\n\t\t\t\n\n\n\n \n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==2){
                        textArea1.setText ("\n\n\n\n\n\n\t\t\t\n\n\n\n \n                              |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==3){
                        textArea1.setText ("\n\n\n\n\n\t\t\t\n\n\n\n \n                              |\n                              |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==4){
                        textArea1.setText ("\n\n\n\n\n\t\t\t\n\n\n \n                              |\n                              |\n                              |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==5){
                        textArea1.setText ("\n\n\n\n\n\t\t\t\n\n \n                              |\n                              |\n                              |\n                              |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==6){
                        textArea1.setText ("\n\n\n\n\n\n\t\t\t \n                    +-------+ \n                              |\n                              |\n                              |\n                              |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==7){
                        textArea1.setText ("\n\n\n\n\n\n\t\t\t \n                    +-------+ \n                     |        |\n                              |\n                              |\n                              |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==8){
                        textArea1.setText ("\n\n\n\n\n\n\t\t\t \n                    +-------+ \n                     |        |\n                    o        |\n                              |\n                              |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==9){
                        textArea1.setText ("\n\n\n\n\n\n\t\t\t \n                    +-------+ \n                     |        |\n                    o        |\n                     |        |\n                              |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==10){
                        textArea1.setText ("\n\n\n\n\n\n\t\t\t \n                    +-------+ \n                     |        |\n                    o        |\n                   / |        |\n                              |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==11){
                        textArea1.setText ("\n\n\n\n\n\n\t\t\t \n                    +-------+ \n                     |        |\n                    o        |\n                   / | \\      |\n                              |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==12){
                        textArea1.setText ("\n\n\n\n\n\n\t\t\t \n                    +-------+ \n                     |        |\n                    o        |\n                   / | \\      |\n                    /         |\n                              |   \n  ==================  ");

                    }
                    if(fehleranzahl==13){
                        textArea1.setText ("\n\n\n\n\n\n\t\t\t \n                    +-------+ \n                     |        |\n                    o        |\n                   / | \\      |\n                    /  \\      |\n                              |   \n  ==================  ");

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

//g
                        }

                    }


                    b1.setText("");

                    for (int i = 0; i < wort.length(); i++) {

                        b1.setText(b1.getText() + " " + buchstabe[i]);
                        buchstabenchecker.setText("");
                    }
                    if (b1.getText().indexOf("_") == -1) {
                        b1.setText(wort);
                        if(versuchsanzahl==1) {
                            buchstabenchecker.setText("Du hast nur " + versuchsanzahl + " Versuch gebraucht");
                            buchstabenchecker.setEditable(false);
                        }else{
                            buchstabenchecker.setText("Du hast nur " + versuchsanzahl + " Versuche gebraucht");
                           buchstabenchecker.setEditable(false);
                        }

                    }
                }
                if (fehleranzahl == 13) {
                    buchstabenchecker.setText("Du hast " + fehleranzahl + " Fehler gemacht. Probier ein neues Wort.");
                    b1.setText(wort);
                }


            }
        });
    }
    public void zufallszahlgenerieren() throws IOException{
        BufferedReader ausleser = new BufferedReader(new FileReader("src/hangman/wortliste.txt"));
        zufallszahld = Math.random() * 150000 + 12 * Math.random() * 200 - 10 * Math.random() * 100;
        int zeile = 0;

        int zufallszahl = (int) zufallszahld;

        try {
            for (String aktuellesWort = ausleser.readLine(); aktuellesWort != null; aktuellesWort = ausleser.readLine()) {
                while (zeile != zufallszahl) {
                    zeile = zeile + 1;
                    wort = ausleser.readLine();

                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        buchstabe = new String[wort.length()];
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("hangman");
        frame.setContentPane(new hangman().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
