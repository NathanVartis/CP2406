import java.util.ArrayList;
import java.util.Random;

public class Game {

    private int numPlayers;
    private int dealerNum;
    private Player[] players;
    private Deck deck = new Deck();
    private static int cardsToDeal = 8;
    private int playerTurn;


    public Game(int numOfPlayers){
        numPlayers = numOfPlayers;
    }

    public void chooseDealer() {
        Random rand = new Random();
        dealerNum = rand.nextInt(numPlayers) +1;
        System.out.println("The dealer is Player " + dealerNum + ".");
    }

    public void dealCardsToPlayers() {
        //Creates the player array
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            players[i] = new Player();
        }
        //Deals cards to each player
        for(int i = 0; i < numPlayers; i++){
            ArrayList<Card> cards = deck.dealCards(cardsToDeal);
            players[i].setCards(cards);
        }
    }

    public int play() {
        boolean gameWon = false;
        Card cardPlayedThisTurn;
        Card cardPlayedLastTurn;
        String category = null;
        boolean categoryChosen = false;

        //Player after dealer goes first
        if (dealerNum < numPlayers){
            playerTurn = dealerNum++;
        }
        else {
            playerTurn = 1;
        }
        while (!gameWon){
            System.out.println("Player " + playerTurn + "'s Turn.");
            //Players take their turns
            cardPlayedThisTurn = players[playerTurn-1].selectCard(playerTurn);
            System.out.println("\nPlayer " + playerTurn + " played:\n" + cardPlayedThisTurn);
            //Player chooses category for round
            if(!categoryChosen){
                category = players[playerTurn-1].selectCategory(playerTurn);
            }
            System.out.println("Category is " + category);
            //Checks if a player has won
            if (players[playerTurn-1].numCardsLeft() == 0){
                gameWon = true;
            }
            if (playerTurn < numPlayers){
                playerTurn++;
            }
            else {
                playerTurn = 1;
            }
        }

        return playerTurn;
    }

}
