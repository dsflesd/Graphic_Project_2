import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;


class DrawPanel extends JPanel implements MouseListener {
    private int clickCounter=0;
    private Deck deck;
    private Card[][] cards;
    private int numCardsLeft;
    private long startTime = System.currentTimeMillis();
    private long elapsedTime =0;
    public DrawPanel() {

        cards = new Card[3][3];
        deck = new Deck();
        numCardsLeft=deck.getDeck().size();
        for (int r = 0; r < cards.length; r++) {
            for (int c = 0; c < cards.length; c++) {
                cards[r][c] = deck.getRandomCard();
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

        g.drawString("Number of cards left: " + numCardsLeft +" Num of clicks: "+clickCounter+" Elapsed Time: "+elapsedTime, x, y + 100);
    }

    public void mousePressed(MouseEvent e) {
        clickCounter++;
        Point p=e.getPoint();
        int button=e.getButton();
        if (deck.getDeck().size() > 9) {
            if (deck.getDeck().get(2).getHitbox().getBounds().contains(p)) {

            }
        }
        if (deck.getDeck().size() > 9) {
            System.out.println(button);
            for (int r = 0; r < cards.length; r++) {
                for (int c = 0; c < cards.length; c++) {
                    cards[r][c] = deck.getRandomCard();
                }
            }
        }


        elapsedTime = System.currentTimeMillis() - startTime;
        elapsedTime=elapsedTime/1000;

    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}