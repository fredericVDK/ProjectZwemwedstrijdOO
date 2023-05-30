package presentatie;

import datalaag.DataLayer;
import logica.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ZwemwedstijdGUI {
    private JTextField textFieldNaam;
    private JTextField textFieldStraat;
    private JTextField textFieldGemeente;
    private JTextField textFieldPostcode;
    private JComboBox comboBoxLengte;
    private JComboBox comboBoxAantalBanen;
    JPanel mainPanel;
    private JButton toevoegenButton;
    private JLabel labelZwembadToevogen;
    private JTextField textFieldNummer;
    private JButton terugButton;
    private JLabel lblNaam;

    public ZwemwedstijdGUI(JFrame surroundingFrame) {
        for (Aantal_banen aantalBanen : Aantal_banen.values()) {
            comboBoxAantalBanen.addItem(aantalBanen.toString().replace("_",""));
        }
        for (Lengte lengte: Lengte.values()) {
            comboBoxLengte.addItem(lengte.toString().replace("_",""));
        }

        toevoegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Aantal_banen aantal = Aantal_banen.valueOf(comboBoxAantalBanen.getSelectedItem().toString().replaceFirst("","_"));
                Lengte lengte = Lengte.valueOf(comboBoxLengte.getSelectedItem().toString().replaceFirst("","_"));
                try{
                     Adres adres = new Adres(textFieldStraat.getText(),textFieldNummer.getText(),textFieldGemeente.getText(),Integer.parseInt(textFieldPostcode.getText()));
                     Zwembad zwembad = ZwembadAanmaken(textFieldNaam.getText(),adres,aantal,lengte);
                     DataLayer datalaag = new DataLayer();

                     datalaag.adresToevoegen(adres);
                     datalaag.zwembadToevoegen(zwembad,datalaag.adresChecker(adres));

                     labelZwembadToevogen.setText("Zwembad toegevoegd");
                }catch (Exception exception){
                    labelZwembadToevogen.setText(exception.getMessage());
                }

            }
        });
        terugButton.addActionListener(e ->  {
            JFrame frame = new JFrame("MainForm");
            frame.setContentPane(new MainFormGUI(frame).mainMainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
    }


    public Zwembad ZwembadAanmaken(String naam, Adres adres , Aantal_banen aantalBanen, Lengte lengte ){
        Zwembad zwembad = new Zwembad(naam,adres,aantalBanen,lengte);
        return zwembad;
    }
    public void Adres(String straat, String huisnummer, String gemeente, int postcode){
        Adres adres = new Adres(straat,huisnummer,gemeente,postcode);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ZwemwedstijdGUI");
        frame.setContentPane(new ZwemwedstijdGUI(frame).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
