package presentatie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFormGUI {
    private JButton zwembadToevoegenButton;
    private JButton wedstrijdToevoegenButton;
    private JButton jurySamenstellenButton;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    JPanel mainMainPanel;



    public MainFormGUI(JFrame surroundingFrame) {
        zwembadToevoegenButton.addActionListener(e -> {
            JFrame frame = new JFrame("ZwemwedstijdGUI");
            frame.setContentPane(new ZwemwedstijdGUI(frame).mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            surroundingFrame.dispose();
        });
        wedstrijdToevoegenButton.addActionListener(e -> {
            JFrame frame = new JFrame("WedstrijdGUI");
            frame.setContentPane(new WedstrijdGUI(frame).mainPanelWedstrijd);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,400);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });

        jurySamenstellenButton.addActionListener(e ->  {
            JFrame frame = new JFrame("JurySamenstellenGUI");
            frame.setContentPane(new JurySamenstellenGUI(frame).mainJuryPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(600,1000);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainFormGUI(frame).mainMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,150);
        frame.setVisible(true);
    }

}
