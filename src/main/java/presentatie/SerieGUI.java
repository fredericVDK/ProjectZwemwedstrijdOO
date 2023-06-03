/**
 * User : frederic
 * Date : 02/06/2023
 * Project Name : ProjectZwemwedstrijdOO
 */

package presentatie;

import datalaag.DataLayer;
import logica.Serie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;

public class SerieGUI {
    private JTextField textFieldWedstrijdID;
    public JPanel mainPanelSerie;
    private JTextField textFieldAanvangsuur;
    private JButton terugButton;
    private JButton aanmakenEnZwemmerToevoegenButton;
    private JLabel lblErrorMessage;

    public SerieGUI(JFrame surroundingFrame) {
        DataLayer datalaag = new DataLayer();
        aanmakenEnZwemmerToevoegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wedstijdProgId = Integer.parseInt(textFieldWedstrijdID.getText());
                Time aanvangsuur = Time.valueOf(textFieldAanvangsuur.getText());
                Serie serie = new Serie(wedstijdProgId,aanvangsuur);
                try {
                    datalaag.serieAanmaken(serie);
                    lblErrorMessage.setText("Serie toegevoegd");
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
            frame.setSize(500, 200);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SerieGUI");
        frame.setContentPane(new SerieGUI(frame).mainPanelSerie);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700,150);
        frame.setVisible(true);
    }
}
