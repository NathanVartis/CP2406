import java.util.ArrayList;
import java.util.Random;

public class Game {

    private int numPlayers;
    private int dealerNum;
    private Player[] players;
    private Deck deck = new Deck();
    private static int cardsToDeal = 8;
    private int playerTurn;
    private Card cardPlayedThisTurn = null;
    private Card cardPlayedLastTurn = null;
    private String category = "None";
    private boolean categoryChosen = false;
    private int numPlayersPassed =0;

    public Game(int numOfPlayers) {
        numPlayers = numOfPlayers;
    }

    public int chooseDealer() {
        //Chooses Dealer
        Random rand = new Random();
        dealerNum = rand.nextInt(numPlayers) + 1;

        return dealerNum;

    }

    public void chooseFirstPlayer(){
        //Player after dealer goes first
        if (dealerNum < numPlayers) {
            playerTurn = dealerNum + 1;
        } else {
            playerTurn = 1;
        }
    }

    public void dealCardsToPlayers() {
        //Creates the player array
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
        }
        //Deals cards to each player
        for (int i = 0; i < numPlayers; i++) {
            ArrayList<Card> cards = deck.dealCards(cardsToDeal);
            players[i].setCards(cards);
        }
    }

    public void takeTurn(int moveChosen) {
        //Players take their turns
        cardPlayedLastTurn = cardPlayedThisTurn;
        if (moveChosen == 0){
            //Player draws new card if they choose to pass.
            players[playerTurn-1].setTurnPassed(true);
            ArrayList<Card> card = deck.dealCards(1);
            players[playerTurn-1].addCard(card);
            numPlayersPassed++;
        }
        else {
            cardPlayedThisTurn = players[playerTurn - 1].playCard(moveChosen);
        }
    }

    public boolean checkGameWon() {

        //Checks if a player has won
        System.out.println("test " + players[playerTurn - 1].numCardsLeft());
        if (players[playerTurn - 1].numCardsLeft() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void showCardsinHand(int i) {
        players[i-1].showHand();
    }

    public int getNumCardsLeft(int i){
        int cardsLeft;
        cardsLeft = players[i-1].numCardsLeft();
        return cardsLeft;
    }

    public boolean haveAllPlayersPassed() {
        //Resets the passed variables and category to start a new round
        boolean allPlayersPassed;
        if(numPlayersPassed == numPlayers){
            allPlayersPassed = true;
            numPlayersPassed = 0;
            categoryChosen = false;
            for(int i =0; i < numPlayers; i++){
                players[i].setTurnPassed(false);
            }
        }
        else {
            allPlayersPassed = false;
        }
        return allPlayersPassed;
    }

    public boolean hasPlayerPassed(){
        boolean passed = players[playerTurn-1].isTurnPassed();
        return passed;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public int getDealerNum() {
        return dealerNum;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public Card getCardPlayedThisTurn() {
        return cardPlayedThisTurn;
    }

    public boolean isCategoryChosen() {
        return categoryChosen;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCategoryChosen(boolean categoryChosen) {
        this.categoryChosen = categoryChosen;
    }


    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

}
