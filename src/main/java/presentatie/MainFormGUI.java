package presentatie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainFormGUI {
    private JButton zwembadToevoegenButton;
    private JButton wedstrijdToevoegenButton;
    private JButton jurySamenstellenButton;
    private JButton wedstrijdProgrammaAanmakenButton;
    private JButton serieAanmakenButton;
    private JButton zwemmerToevoegenAanSerieButton;
    JPanel mainMainPanel;
    private JButton overzichtPaginaButton;


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
            frame.setSize(500, 400);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });

        jurySamenstellenButton.addActionListener(e -> {
            JFrame frame = new JFrame("JurySamenstellenGUI");
            frame.setContentPane(new JurySamenstellenGUI(frame).mainJuryPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(600, 1000);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
        wedstrijdProgrammaAanmakenButton.addActionListener(e -> {
            JFrame frame = new JFrame("WedstrijdProgrammaGUI");
            frame.setContentPane(new WedstrijdProgrammaGUI(frame).mainPanelWedstijdprogramma);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(650, 250);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
        serieAanmakenButton.addActionListener(e -> {
            JFrame frame = new JFrame("SerieGUI");
            frame.setContentPane(new SerieGUI(frame).mainPanelSerie);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(700, 150);
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
        zwemmerToevoegenAanSerieButton.addActionListener(e -> {
            JFrame frame = new JFrame("ZwemmerToevoegenGUI");
            frame.setContentPane(new ZwemmerToevoegenGUI(frame).mainPanelZwemmer);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            surroundingFrame.dispose();
        });
        overzichtPaginaButton.addActionListener(e -> {
            JFrame frame = new JFrame("overzichtPaginaGUI");
            try {
                frame.setContentPane(new overzichtPaginaGUI(frame).mainPanelOverzichtPagina);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
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
        frame.setSize(500, 150);
        frame.setVisible(true);
    }
}
