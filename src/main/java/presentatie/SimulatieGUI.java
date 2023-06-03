/**
 * User : frederic
 * Date : 03/06/2023
 * Project Name : ProjectZwemwedstrijdOO
 */

package presentatie;

import javax.management.timer.Timer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SimulatieGUI {
    private JTextField textFieldAfstand;
    private JButton startButton;
    private JLabel lblInfo;
    private JPanel mainPanelSimulatie;
    private JPanel panel1;
    private TekenPanel tekenPanel;

    public SimulatieGUI() {

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tekenPanel.startBeweging();


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SimulatieGUI");
        frame.setContentPane(new SimulatieGUI().mainPanelSimulatie);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1500,600);
        frame.setVisible(true);
    }

    private void createUIComponents() throws IOException {
        tekenPanel = new TekenPanel();
        panel1 = tekenPanel;
    }
}
