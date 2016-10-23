import java.util.ArrayList;

public class Player {

    private ArrayList<Card> cards;
    private boolean turnPassed = false;

    public void setCards(ArrayList<Card> cards) {
        //Sets the cards drawn into the player array
        this.cards = cards;
    }


    public void addCard(ArrayList<Card> card) {
        //Sets the card drawn into the player array
        this.cards.addAll(card);
    }

    public int numCardsLeft(){
        //Returns the number of cards the player has left
        int cardsLeft = cards.size();
        return cardsLeft;
    }

    public Card playCard(int cardNumber) {
        Card cardPlayed;
        //Removes the card chosen from the players hand.
        cardPlayed = cards.remove(cardNumber-1);
        return cardPlayed;
    }

    public void showHand(){
        System.out.println(cards);
    }

    public boolean isTurnPassed() {
        return turnPassed;
    }

    public void setTurnPassed(boolean turnPassed) {
        this.turnPassed = turnPassed;
    }

    public Card checkCard(int cardNumber){
        return cards.get(cardNumber-1);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

}
