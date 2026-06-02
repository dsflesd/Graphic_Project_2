import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.Font;

class DrawPanel extends JPanel implements MouseListener {

    private Deck d;
    private Card[][] cards;

    public DrawPanel() {

        cards = new Card[3][3];
        d = new Deck();
        for (int r = 0; r < cards.length; r++) {
            for (int c = 0; c < cards.length; c++) {
                cards[r][c] = d.getRandomCard();
            }
        }
        this.addMouseListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = 10;
        for (int r = 0; r < cards.length; r++) {
            for (int c = 0; c < cards.length; c++) {
                g.drawImage(cards[r][c].getImage(), x, y, null);
                x += 80;
            }
            y += 100;
            x = 50;
        }

        g.drawString("Number of cards left: " + d.getDeck().size(), x, y + 100);
    }

    public void mousePressed(MouseEvent e) {

        if (d.getDeck().size() > 9) {
            for (int r = 0; r < cards.length; r++) {
                for (int c = 0; c < cards.length; c++) {
                    cards[r][c] = d.getRandomCard();
                }
            }
        }



    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}