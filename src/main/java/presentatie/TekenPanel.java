/**
 * User : frederic
 * Date : 03/06/2023
 * Project Name : ProjectZwemwedstrijdOO
 */

package presentatie;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TekenPanel extends JPanel implements ActionListener {
    private Image afbeelding;
    private int xPosition;
    private Timer timer;

    public TekenPanel() {
        afbeelding = Toolkit.getDefaultToolkit().getImage("src/main/java/resources/images-removebg-preview.png");
        timer = new Timer(75, this);
        xPosition = 10;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        int breedte = this.getWidth();
        int hoogte = this.getHeight();
        int lijnAfstand = hoogte / 10;

        for (int i = 0; i < 10; i++) {
            int y = i * lijnAfstand;
            g.drawLine(0, y, breedte, y);
        }
        int afbeeldingBreedte = 100;
        int afbeeldingHoogte = 30;

        for (int i = 0; i < 10; i++) {
            int y = i * lijnAfstand + (lijnAfstand - afbeeldingHoogte) / 2;
            g.drawImage(afbeelding, xPosition, y, afbeeldingBreedte, afbeeldingHoogte, this);
        }
    }

    public void startBeweging() {
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        xPosition += 10;
        if (xPosition > getWidth()-100) {
            timer.stop();
            xPosition = 10;
        }
        repaint();
    }
}
