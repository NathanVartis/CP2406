import java.util.Scanner;

public class CP2406_Assignment2 {

    private static Game game;

    public static void main(String[] args) {
        showMenu();
        int menuchoice;
        menuchoice = getUserMenuInput();
        switch (menuchoice){
            case 1:{
                newGame();
                playGame();
            }
            case 2:{
                System.out.println("Exiting Game.");
                System.exit(0);
            }
        }
    }

    private static void playGame() {
        //Plays the game and outputs the winner
        int winner;
        boolean gameWon = false;

        //Main Game Loop
        while (!gameWon){
            for(int i= game.getPlayerTurn(); i<=game.getNumPlayers(); i++){
                game.setPlayerTurn(i);
                System.out.println("Player " + i + "'s Turn.");
                //Selects a category if none has been chosen
                if(!game.isCategoryChosen()){
                    selectCategory(i);
                }
                System.out.println("Category is " + game.getCategory() + ".");
                System.out.println("");
                //Player takes turn if they haven't passed
                if(!game.hasPlayerPassed()){
                    game.takeTurn(selectMove(i));
                    System.out.println("Card Played: \n" + game.getCardPlayedLastTurn());
                    //Pauses so human player can see computer players turns.
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("Player " + i + " has passed.");
                }
                System.out.println("Player " + game.getPlayerTurn() + " has " + game.getNumCardsLeft(game.getPlayerTurn()) + " cards left.");
                //Checks if a player has no cards left or has played geophysicist/magnetite combo
                gameWon = game.checkGameWon();
                if(gameWon){
                    break;
                }
                //Checks if all players have passed
                if(game.haveAllPlayersPassed()){
                    System.out.println("All players have passed. Starting new round.");
                }
                else{
                    game.setPlayerTurn(1);
                }
            }
        }
        winner = game.getPlayerTurn();
        if(game.isMagnetiteInstantWin()){
            System.out.println("Geophysicist/Magnetite combo played.");
        }
        System.out.println("Player " + winner + " wins!");
    }

    private static int selectMove(int playerTurn){
        int moveSelected = 0;
        boolean validMove = false;
        while(!validMove){
            if (playerTurn != 1){
                //Computer's Turn, randomly selects card or passes if there are no valid moves
                moveSelected = game.computerSelectMove();
            }
            else{
                //Player selects a card
                System.out.println("Your Cards:");
                game.showCardsInHand(playerTurn);
                moveSelected = (getUserTurnInput(playerTurn));
            }
            validMove = game.isMoveValid(moveSelected);
            if(!validMove && playerTurn == 1){
                System.out.println("Invalid move. Select a card with a higher value in the current category" +
                        " or select a supertrump card.");
                //Pauses so player can see error message.
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Card Played: \n" + game.getCardPlayedLastTurn());
            }
        }
        if (moveSelected == 0){
            System.out.println("Player " + game.getPlayerTurn() + " has passed.");
        }
        return moveSelected;
    }

    public static void selectCategory(int playerTurn) {
        String category = null;
        int categorySelected = 0;
        if (playerTurn != 1){
            //Computer's Turn, randomly selects category
            categorySelected = game.computerSelectCategory();
        }
        else{
            //Player selects a category
            System.out.println("Select a category(Enter number from 1-5):" +
                    "\n1. Hardness" +
                    "\n2. Specific Gravity" +
                    "\n3. Cleavage" +
                    "\n4. Crystal Abundance" +
                    "\n5. Economic Value");
            boolean validInput = false;
            while(!validInput) {
                Scanner input = new Scanner(System.in);
                if (input.hasNextInt()) {
                    categorySelected = input.nextInt();
                }
                if (categorySelected <= 5 && categorySelected >= 1) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Enter number from 1-5");
                }
            }
        }

        switch (categorySelected){
            case 1:{
                category = "Hardness";
                break;
            }
            case 2:{
                category = "Specific Gravity";
                break;
            }
            case 3:{
                category = "Cleavage";
                break;
            }
            case 4:{
                category = "Crystal Abundance";
                break;
            }
            case 5:{
                category = "Economic Value";
                break;
            }
        }
        game.setCategoryChosen(true);
        game.setCategory(category);
    }

    private static void newGame() {
        //Sets up a new game
        int numPlayers;
        numPlayers = getNumberOfPlayers();
        game = new Game(numPlayers);
        game.chooseDealer();
        game.chooseFirstPlayer();
        System.out.println("The dealer is Player " + game.getDealerNum()+ ".");
        game.dealCardsToPlayers();
    }

    private static int getNumberOfPlayers() {
        //Gets the number of players from the user. Accepts 3,4 or 5
        System.out.println("Enter number of players(3-5).");
        int i = 0;
        boolean validInput = false;
        while(!validInput) {
            Scanner input = new Scanner(System.in);
            if(input.hasNextInt()) {
                i = input.nextInt();
            }
            if (i==3 || i==4 || i==5){
                validInput=true;
            }
            else{
                System.out.println("Invalid input. Choose between 3 and 5 players.");
            }
        }
        return i;
    }

    private static int getUserMenuInput() {
        //Gets the user input for the menu. Accepts 1 or 2
        int i = 0;
        boolean validInput = false;
        while(!validInput) {
            Scanner input = new Scanner(System.in);
            if(input.hasNextInt()) {
                i = input.nextInt();
            }
            if (i==1 || i==2){
                validInput=true;
            }
            else{
                System.out.println("Invalid input. Select a valid option.");
            }
        }
        return i;
    }

    private static void showMenu() {
        System.out.println("Welcome to Mineral Supertrumps.");
        System.out.println("Select an option:");
        System.out.println("1. New Game");
        System.out.println("2. Quit Game");
    }

    private static int getUserTurnInput(int playerTurn) {
        //Gets the user to choose a card
        System.out.println("Select a card to play, enter the cards number(1-" + game.getNumCardsLeft(playerTurn)+ ").\n" +
                "To pass your turn enter 0: ");
        int i = -1;
        boolean validInput = false;
        while(!validInput) {
            Scanner input = new Scanner(System.in);
            if(input.hasNextInt()) {
                i = input.nextInt();
            }
            if (i >= 0 && i<=game.getNumCardsLeft(playerTurn)){
                validInput=true;
            }
            else{
                System.out.println("Invalid input. Choose between 0 and "  + game.getNumCardsLeft(playerTurn)+ ".");
            }
        }
        return i;
    }
}

