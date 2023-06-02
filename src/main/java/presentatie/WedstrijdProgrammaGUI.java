/**
 * User : frederic
 * Date : 01/06/2023
 * Project Name : ProjectZwemwedstrijdOO
 */

package presentatie;

import datalaag.DataLayer;
import logica.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;

public class WedstrijdProgrammaGUI {
    public JPanel mainPanelWedstijdprogramma;
    private JTextField textFieldwedstijdId;
    private JTextField textFieldProgrammaId;
    private JTextField textFieldProgrammaNr;
    private JComboBox comboBoxLeeftijd;
    private JTextField textFieldAanvangsuur;
    private JButton terugButton;
    private JButton aanmakenButton;
    private JLabel lblErrorMessage;
    private JComboBox comboBoxSlag;
    private JComboBox comboBoxAfstand;
    private JComboBox comboBoxGeslacht;

    public WedstrijdProgrammaGUI(JFrame surroundingFrame) {
        DataLayer datalaag = new DataLayer();
        for (Leeftijd leeftijd : Leeftijd.values()){
            comboBoxLeeftijd.addItem(leeftijd);
        }
        terugButton.addActionListener(e -> {
            JFrame frame = new JFrame("MainForm");
            frame.setContentPane(new MainFormGUI(frame).mainMainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,150);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
        aanmakenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblErrorMessage.setText("");

                int wedstijdId = Integer.parseInt(textFieldwedstijdId.getText());
                int programmaId = Integer.parseInt(textFieldProgrammaId.getText());
                int programmaNr = Integer.parseInt(textFieldProgrammaNr.getText());
                Leeftijd geselecteerdeLeeftijd = (Leeftijd) comboBoxLeeftijd.getSelectedItem();
                String geselecteerdeLeeftijdLabel = geselecteerdeLeeftijd.toString();
                Time aanvangsuur = Time.valueOf(textFieldAanvangsuur.getText());
                WedstrijdProgramma wedProg = wedProgrammaAanmaken(wedstijdId,programmaId,programmaNr,geselecteerdeLeeftijd,aanvangsuur);
                try {
                    datalaag.wedstijdprogrammaAanmaken(wedProg);
                    lblErrorMessage.setText("Wedstrijdprogramma toegevoegd");
                } catch (Exception ex) {
                    lblErrorMessage.setText(ex.getMessage());
                }
            }
        });
    }

    public WedstrijdProgramma wedProgrammaAanmaken(int wedstrijdId,int programmaId,int programmaNr,Leeftijd leeftijd,Time aanvangsuur){
        WedstrijdProgramma wedstrijdProgramma = new WedstrijdProgramma(wedstrijdId,programmaId,programmaNr,leeftijd,aanvangsuur);
        return wedstrijdProgramma;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("WedstrijdProgrammaGUI");
        frame.setContentPane(new WedstrijdProgrammaGUI(frame).mainPanelWedstijdprogramma);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(650,250);
        frame.setVisible(true);
    }
}
