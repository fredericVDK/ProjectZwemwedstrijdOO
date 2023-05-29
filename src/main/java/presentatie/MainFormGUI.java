package presentatie;

import javax.swing.*;

public class MainFormGUI {
    private JButton zwembadToevoegenButton;
    private JButton button2;
    private JButton button3;
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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainFormGUI(frame).mainMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
