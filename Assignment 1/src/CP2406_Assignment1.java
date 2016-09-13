import java.util.Scanner;

public class CP2406_Assignment1 {

    public static void main(String[] args) {
        showMenu();
        int menuchoice;
        menuchoice = getUserMenuInput();
        switch (menuchoice){
            case 1:{
                newGame();
            }
            case 2:{
                System.out.println("Exiting Game.");
                System.exit(0);
            }
        }
    }

    private static void newGame() {
        int numPlayers;
        numPlayers = getNumberOfPlayers();
        Game game = new Game(numPlayers);
        game.chooseDealer();
        game.dealCardsToPlayers();
    }

    private static int getNumberOfPlayers() {
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
}

