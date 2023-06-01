package presentatie;

import datalaag.DataLayer;
import logica.Dagdeel;
import logica.Tijdsregistratie;
import logica.Wedstrijd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class WedstrijdGUI {
    private JTextField textFieldZwembadId;
    public JPanel mainPanelWedstrijd;
    private JTextField textFieldNaam;
    private JComboBox comboBoxTijdsregistratie;
    private JComboBox comboBoxDagdeel;
    private JButton terugButton;
    private JButton wedstrijdToevoegenButton;
    private JLabel lblErrorMessage;
    private JTextField textFieldDatum;


    public WedstrijdGUI(JFrame surroundingFrame) {
        for (Dagdeel dagdeel:Dagdeel.values()){
            comboBoxDagdeel.addItem(dagdeel);
        }
        for (Tijdsregistratie tijdReg:Tijdsregistratie.values()){
            comboBoxTijdsregistratie.addItem(tijdReg);
        }

        terugButton.addActionListener(e ->  {
            JFrame frame = new JFrame("MainForm");
            frame.setContentPane(new MainFormGUI(frame).mainMainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,150);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
        wedstrijdToevoegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataLayer datalaag  = new DataLayer();
                try {
                    Wedstrijd wedstrijd = new Wedstrijd(datalaag.zwembadIdChecker(Integer.parseInt(textFieldZwembadId.getText())),textFieldNaam.getText(), Tijdsregistratie.valueOf(comboBoxTijdsregistratie.getSelectedItem().toString()),
                            Dagdeel.valueOf(comboBoxDagdeel.getSelectedItem().toString()), Date.valueOf(textFieldDatum.getText().toString()));
                    lblErrorMessage.setText("Wedstrijd toegevoegd");
                    datalaag.wedstrijdToevoegen(wedstrijd);
                }catch (Exception ex){
                    lblErrorMessage.setText(ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("WedstrijdGUI");
        frame.setContentPane(new WedstrijdGUI(frame).mainPanelWedstrijd);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,400);
        frame.setVisible(true);
    }
}
