import java.util.ArrayList;

public class Deck {
    private  ArrayList<Card> cards=new ArrayList<>();
    public Deck() {
        for (int x=0; x<4;x++){
            String suit = "";
            if (x==0){
                suit="diamonds";
            }
            else if(x==1){
                suit="clubs";
            }
            else if(x==2){
                suit="hearts";
            }
            else if(x==3){
                suit="spades";
            }
            for (int i=1; i<14; i++) {
                String value = "0" + i;
                if (i == 1) {
                    value = "A";
                }
                if (i == 10) {
                    value = "10";
                }
                if (i == 11) {
                    value = "J";
                }
                if (i == 12) {
                    value = "Q";
                }
                if (i == 13) {
                    value = "K";
                }
                Card card = new Card(suit,value );
                cards.add(card);
            }
        }
    }
    public void getRandomCard() {
        int random=(int)(Math.random()*52);
        System.out.println(cards.get(random));
    }
}