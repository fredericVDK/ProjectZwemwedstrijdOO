/**
 * User : frederic
 * Date : 02/06/2023
 * Project Name : ProjectZwemwedstrijdOO
 */

package presentatie;

import datalaag.DataLayer;
import logica.Deelnames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ZwemmerToevoegenGUI {
    private JTextField textFieldZwemmerID;
    private JTextField textFieldBaan;
    private JTextField textFieldSerieId;
    private JButton terugButton;
    private JButton zwemmerToevoegenButton;
    public JPanel mainPanelZwemmer;
    private JLabel lblErrorMessage;

    public ZwemmerToevoegenGUI(JFrame surroundingFrame) {
        DataLayer datalaag = new DataLayer();
        terugButton.addActionListener(e -> {
            JFrame frame = new JFrame("MainForm");
            frame.setContentPane(new MainFormGUI(frame).mainMainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500, 200);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
        zwemmerToevoegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int zwemmerID = Integer.parseInt(textFieldZwemmerID.getText());
                int serieID = Integer.parseInt(textFieldSerieId.getText());
                int baan = Integer.parseInt(textFieldBaan.getText());
                Deelnames deelnames = new Deelnames(zwemmerID,serieID,baan);
                try {
                    datalaag.deelnameAanmaken(deelnames);
                    lblErrorMessage.setText("Zwemmer toegevoegd");
                } catch (Exception ex) {
                    lblErrorMessage.setText(ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ZwemmerToevoegenGUI");
        frame.setContentPane(new ZwemmerToevoegenGUI(frame).mainPanelZwemmer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
