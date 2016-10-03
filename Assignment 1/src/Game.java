import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

public class Game {

    private int numPlayers;
    private int dealerNum;
    private Player[] players;
    private Deck deck = new Deck();
    private int playerTurn;
    private Card cardPlayedLastTurn = null;
    private String category = null;
    private boolean categoryChosen = false;
    private int numPlayersPassed =0;
    private boolean magnetiteInstantWin = false;

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
        int cardsToDeal = 8;
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
        if (moveChosen == 0){
            //Player draws new card if they choose to pass.
            players[playerTurn-1].setTurnPassed(true);
            if(deck.numCardsLeftInDeck() > 0) {
                ArrayList<Card> card = deck.dealCards(1);
                players[playerTurn - 1].addCard(card);
            }
            numPlayersPassed++;
        }
        else {
            cardPlayedLastTurn = players[playerTurn-1].playCard(moveChosen);
        }
    }

    public boolean checkGameWon() {

        //Checks if a player has won
        if (players[playerTurn - 1].numCardsLeft() == 0 || magnetiteInstantWin) {
            return true;
        } else {
            return false;
        }
    }

    public int computerSelectMove(){
        //Tries all cards before passing
        int moveSelected;
        ArrayList<Integer> cardPlayOrder = new ArrayList<Integer>();
        for(int i = 1; i <= getNumCardsLeft(playerTurn);i++){
            cardPlayOrder.add(i);
        }
        Collections.shuffle(cardPlayOrder);

        for (Integer aCardPlayOrder : cardPlayOrder) {
            if (isMoveValid(aCardPlayOrder)) {
                moveSelected = aCardPlayOrder;
                return moveSelected;
            }
        }
        return 0;
    }

    public int computerSelectCategory() {
        int categorySelected;
        Random rand = new Random();
        categorySelected = rand.nextInt(5)+1;
        return categorySelected;
    }

    public boolean isMoveValid(int moveSelected){
        //Checks if the card chosen is valid
        boolean validMove = false;
        //Pass turn
        if(moveSelected == 0){
            validMove = true;
        }
        else{
            Card cardChosen = players[playerTurn-1].checkCard(moveSelected);
            if(cardChosen.getType().equals("trump")){
                //Supertrump card
                playTrumpCard(cardChosen);
                validMove = true;
            }
            else if(cardPlayedLastTurn != null) {
                //Normal card
                switch (category) {
                    case "Hardness": {
                        if (Float.valueOf(cardChosen.getHardness()) > Float.valueOf(cardPlayedLastTurn.getHardness())) {
                            validMove = true;
                        } else {
                            validMove = false;
                        }
                        break;
                    }
                    case "Specific Gravity": {
                        if (Float.valueOf(cardChosen.getSpecificGravity()) > Float.valueOf(cardPlayedLastTurn.getSpecificGravity())) {
                            validMove = true;
                        } else {
                            validMove = false;
                        }
                        break;
                    }
                    case "Cleavage": {
                        if (cardChosen.getCleavageNum() > cardPlayedLastTurn.getCleavageNum()) {
                            validMove = true;
                        } else {
                            validMove = false;
                        }
                        break;
                    }
                    case "Crystal Abundance": {
                        if (cardChosen.getCrystalNum() > cardPlayedLastTurn.getCrystalNum()) {
                            validMove = true;
                        } else {
                            validMove = false;
                        }
                        break;
                    }
                    case "Economic Value": {
                        if (cardChosen.getEconomicNum() > cardPlayedLastTurn.getEconomicNum()) {
                            validMove = true;
                        } else {
                            validMove = false;
                        }
                        break;
                    }
                }
            }
            //Start of game, no card played yet
            else{
                validMove = true;
            }
        }
        return validMove;
    }

    private void playTrumpCard(Card cardChosen) {
        //Supertrump effects
        switch(cardChosen.getId()){
            case 55:{
                category = "Economic Value";
                break;
            }
            case 56:{
                category = "Crystal Abundance";
                break;
            }
            case 57:{
                category = "Hardness";
                break;
            }
            case 58:{
                category = "Cleavage";
                break;
            }
            case 59:{
                //Checks if player has magnetite, if they do they win, otherwise sets category
                for (int i = 1; i <= getNumCardsLeft(playerTurn); i++){
                    if(players[playerTurn-1].checkCard(i).getId() == 46){
                        magnetiteInstantWin = true;
                    }
                }
                category = "Specific Gravity";
                break;
            }
            case 60:{
                CP2406_Assignment1.selectCategory(playerTurn);
                break;
            }
        }
    }

    public void showCardsInHand(int i) {
        players[i-1].showHand();
    }

    public int getNumCardsLeft(int i){
        return players[i-1].numCardsLeft();
    }

    public boolean haveAllPlayersPassed() {
        //Resets the passed variables and category to start a new round
        boolean allPlayersPassed;
        if(numPlayersPassed == numPlayers-1){
            allPlayersPassed = true;
            numPlayersPassed = 0;
            categoryChosen = false;
            for(int i =0; i < numPlayers; i++){
                if(!players[i].isTurnPassed()){
                    playerTurn = i+1;
                }
                players[i].setTurnPassed(false);
            }
            cardPlayedLastTurn = null;
        }
        else {
            allPlayersPassed = false;
        }
        return allPlayersPassed;
    }

    public boolean hasPlayerPassed(){
        return players[playerTurn-1].isTurnPassed();
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

    public Card getCardPlayedLastTurn() {
        return cardPlayedLastTurn;
    }

    public String getCategory() {
        return category;
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

    public boolean isMagnetiteInstantWin() {
        return magnetiteInstantWin;
    }
}
