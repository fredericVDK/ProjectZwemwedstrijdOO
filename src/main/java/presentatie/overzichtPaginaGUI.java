/**
 * User : frederic
 * Date : 02/06/2023
 * Project Name : ProjectZwemwedstrijdOO
 */

package presentatie;

import datalaag.DataLayer;
import logica.Offiacial;
import logica.Wedstrijd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class overzichtPaginaGUI {
    public JPanel mainPanelOverzichtPagina;
    private JButton terugButton;
    private JTextArea textAreaLijst;
    private JComboBox comboBoxWedstrijd;
    private JComboBox comboBoxKeuze;


    public overzichtPaginaGUI(JFrame surroundingFrame) throws SQLException {
        DataLayer datalaag = new DataLayer();
        String [] keuze = {"Zwembad","Wedstrijd","Jurysamenstelling","Programma","Serie","Zwemmers"};
        for (String keus:keuze){
            comboBoxKeuze.addItem(keus);
        }

        for (Wedstrijd wed : datalaag.wedstrijdLijst()){
            comboBoxWedstrijd.addItem(wed);
        }


        terugButton.addActionListener(e -> {
            JFrame frame = new JFrame("MainForm");
            frame.setContentPane(new MainFormGUI(frame).mainMainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500, 150);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
        comboBoxKeuze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxKeuze.getSelectedItem().toString().equals("Zwembad")){
                    textAreaLijst.setText(datalaag.zwembadNaam(comboBoxWedstrijd.getSelectedIndex()+1));
                }
                if (comboBoxKeuze.getSelectedItem().toString().equals("Wedstrijd")){
                    textAreaLijst.setText(datalaag.wedNaam(comboBoxWedstrijd.getSelectedIndex()+1));
                }
                if (comboBoxKeuze.getSelectedItem().toString().equals("Jurysamenstelling")){
                    ArrayList<Offiacial> lijst = null;
                    try {
                        lijst = datalaag.officialLijst(comboBoxWedstrijd.getSelectedIndex()+1);
                        for (Offiacial a : lijst) {
                            textAreaLijst.append(a.toString());
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (comboBoxKeuze.getSelectedItem().toString().equals("Programma")){

                }
            }
        });
    }
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("overzichtPaginaGUI");
        frame.setContentPane(new overzichtPaginaGUI(frame).mainPanelOverzichtPagina);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
