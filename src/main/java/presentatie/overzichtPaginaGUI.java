/**
 * User : frederic
 * Date : 02/06/2023
 * Project Name : ProjectZwemwedstrijdOO
 */

package presentatie;

import datalaag.DataLayer;
import logica.*;

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
    private JComboBox comboBoxProgramma;
    private JComboBox comboBoxSerie;


    public overzichtPaginaGUI(JFrame surroundingFrame) throws SQLException {
        DataLayer datalaag = new DataLayer();
        String [] keuze = {"Zwembad","Wedstrijd","Jurysamenstelling","Zwemmers"};
        for (String keus:keuze){
            comboBoxKeuze.addItem(keus);
        }
        for (Wedstrijd wed : datalaag.wedstrijdLijst()){
            comboBoxWedstrijd.addItem(wed.toString());
        }


        terugButton.addActionListener(e -> {
            JFrame frame = new JFrame("MainForm");
            frame.setContentPane(new MainFormGUI(frame).mainMainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500, 200);
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
                    textAreaLijst.setText("");
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
                if (comboBoxKeuze.getSelectedItem().toString().equals("Zwemmers")){
                    textAreaLijst.setText("");
                    ArrayList<Zwemmer> lijst = null;
                    lijst = datalaag.zwemmerLijst(Integer.parseInt(comboBoxSerie.getSelectedItem().toString().substring(0,3).replace(".","")));
                    for (Zwemmer a : lijst) {
                        textAreaLijst.append(a.toString());
                    }
                }
            }
        });
        comboBoxWedstrijd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxProgramma.removeAllItems();
                for (WedstrijdProgramma prog : datalaag.wedstrijdProgrammaLijst(comboBoxWedstrijd.getSelectedIndex()+1)){
                    comboBoxProgramma.addItem(prog);
                    System.out.println(comboBoxWedstrijd.getSelectedIndex()+1);                }
            }
        });
        comboBoxProgramma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxSerie.removeAllItems();
                for (Serie serie : datalaag.serieLijst(Integer.parseInt(comboBoxProgramma.getSelectedItem().toString().substring(0,2).replace(".","")))){
                    comboBoxSerie.addItem(serie);
                }
            }
        });
    }
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("overzichtPaginaGUI");
        frame.setContentPane(new overzichtPaginaGUI(frame).mainPanelOverzichtPagina);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(650,1250);
        frame.setVisible(true);
    }
}
