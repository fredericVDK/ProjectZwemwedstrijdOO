/**
 * User : frederic
 * Date : 31/05/2023
 * Project Name : ProjectZwemwedstrijdOO
 */

package presentatie;

import datalaag.DataLayer;
import logica.Functie;
import logica.Offiacial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class JurySamenstellenGUI {
    public JPanel mainJuryPanel;
    private JTextField textFieldWedstrijd_id;
    private JTextField textFieldOfficial_id;
    private JComboBox comboBoxFunctie;
    private JButton terugButton;
    private JButton buttonToevoegen;
    private JLabel lblErrorMessage;
    private JButton juryVerwijderenButton;
    private JTextArea textAreaJuryLijst;
    private JButton selectButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("JurySamenstellenGUI");
        frame.setContentPane(new JurySamenstellenGUI(frame).mainJuryPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 1000);
        frame.setVisible(true);
    }

    public Offiacial offiacialAanmaken(int official_id, Functie functie) {
        Offiacial offiacial = new Offiacial(official_id, functie);
        return offiacial;
    }

    public JurySamenstellenGUI(JFrame surroundingFrame) {
        for (Functie fun : Functie.values()) {
            comboBoxFunctie.addItem(fun);
        }
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataLayer datalaag = new DataLayer();
                try {
                    textAreaJuryLijst.setText("");
                    ArrayList<Offiacial> lijst = datalaag.officialLijst(Integer.parseInt(textFieldWedstrijd_id.getText()));
                    for (Offiacial a : lijst) {
                        textAreaJuryLijst.append(a.toString());
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonToevoegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataLayer datalaag = new DataLayer();
                int official_id = Integer.parseInt(textFieldOfficial_id.getText());
                Functie functie = Functie.valueOf(comboBoxFunctie.getSelectedItem().toString());
                try {
                    datalaag.juryToevoegen(offiacialAanmaken(official_id, functie), Integer.parseInt(textFieldWedstrijd_id.getText()));
                    lblErrorMessage.setText("Jury toegevoegd");
                    textAreaJuryLijst.setText("");
                    ArrayList<Offiacial> lijst = datalaag.officialLijst(Integer.parseInt(textFieldWedstrijd_id.getText()));
                    for (Offiacial a : lijst) {
                        textAreaJuryLijst.append(a.toString());
                    }
                } catch (Exception ex) {
                    lblErrorMessage.setText(ex.getMessage());
                    throw new RuntimeException(ex);
                }
            }
        });
        juryVerwijderenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataLayer datalaag = new DataLayer();
                try {
                    datalaag.juryVerwijderen(Integer.parseInt(textFieldWedstrijd_id.getText()), Integer.parseInt(textFieldOfficial_id.getText()));
                    lblErrorMessage.setText("Jury verwijderd");
                    textAreaJuryLijst.setText("");
                    ArrayList<Offiacial> lijst = datalaag.officialLijst(Integer.parseInt(textFieldWedstrijd_id.getText()));
                    for (Offiacial a : lijst) {
                        textAreaJuryLijst.append(a.toString());
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        terugButton.addActionListener(e -> {
            JFrame frame = new JFrame("MainForm");
            frame.setContentPane(new MainFormGUI(frame).mainMainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500, 150);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
    }
}
