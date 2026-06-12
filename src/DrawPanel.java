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
                Rectangle cardHitBox = new Rectangle(x, y, cards[r][c].getImage().getWidth(), cards[r][c].getImage().getHeight());
                cards[r][c].setHitbox(cardHitBox);
                if (cards[r][c].getHighlight()) {
                    g.drawRect(x, y, (int)cardHitBox.getWidth(), (int)cardHitBox.getHeight());
                }
                x += 80;
            }
            y += 100;
            x = 50;

        }  g.drawString("Number of cards left: " + deck.getDeck().size(), x, y + 100);
    }
    public void mousePressed(MouseEvent e) {
        clickCounter++;
        Point p=e.getPoint();
        int button=e.getButton();
        int highlighted=0;
        boolean available=true;
        int sum=0;
        if (!deck.getDeck().isEmpty()) {
            for (int r = 0; r < cards.length; r++) {
                for (int c = 0; c < cards.length; c++) {
                    if (button == 1) {
                        if (cards[r][c].getHitbox().contains(p)) {
                            cards[r][c] = deck.getRandomCard();

                        }
                        else if (cards[r][c].getHighlight()){

                        }
                    }
                    else if (button==3) {
                        if (cards[r][c].getHitbox().contains(p)){
                            cards[r][c].flipHighlight();
                            highlighted++;
                        }}
//                        for (int i=0; i<r*c; i++) {
//                            if (cards[r][c].getHighlight()) {
//                                if (!(cards[r][c].getValue() == "K"||cards[r][c].getValue() == "J"||cards[r][c].getValue() == "Q")){
//                                    sum += Integer.parseInt((cards[r][c].getValue()));
//                                }
//                            }
//                           if(sum==11){
//                               System.out.println("yes");
//
//                           }

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
