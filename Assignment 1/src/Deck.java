import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deckCards;
    private static final int initialCards = 60;

    public Deck(){
        deckCards = new ArrayList<>(initialCards);

        for (int i = 0; i < initialCards; i++){
            deckCards.add(new Card(i));
        }
    }
    public ArrayList<Card> dealCards(int cardsToDeal){
        //Shuffles the deck and deals cards
        ArrayList<Card> hand = new ArrayList<>();
        Collections.shuffle(deckCards);
        for (int i=0; i<cardsToDeal;i++){
            Card card = deckCards.remove(i);
            hand.add(card);
            System.out.println("Card id: "+ card);
        }
        return hand;
    }
}
