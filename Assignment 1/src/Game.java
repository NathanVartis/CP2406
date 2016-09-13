import java.util.ArrayList;
import java.util.Random;

public class Game {

    private int numPlayers;
    private int dealerNum;
    private Player[] players;
    private Deck deck = new Deck();
    private static int cardsToDeal = 8;


    public Game(int numOfPlayers){
        numPlayers = numOfPlayers;
    }

    public void chooseDealer() {
        Random rand = new Random();
        dealerNum = rand.nextInt(numPlayers) +1;
        System.out.println("The Dealer is Player " + dealerNum + ".");

    }

    public void dealCardsToPlayers() {
        //Creates the player array and deals initial cards to each player
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            players[i] = new Player();
        }
        for(int i = 0; i < numPlayers; i++){
            ArrayList<Card> cards = deck.dealCards(cardsToDeal);
            players[i].setCards(cards);
        }
    }
}
