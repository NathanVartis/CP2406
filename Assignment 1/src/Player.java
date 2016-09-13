import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

    private ArrayList<Card> cards;

    public void setCards(ArrayList<Card> cards) {
        //Sets the cards drawn into the player array
        this.cards = cards;
    }

    public Card selectCard(int playerTurn){
        Card cardSelected;
        if (playerTurn != 1){
            int randNum;
            //Computer's Turn, randomly selects card
            Random rand = new Random();
            randNum = rand.nextInt(numCardsLeft());
            cardSelected = cards.remove(randNum);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            //Player selects a card
            System.out.println("Your Cards:");
            System.out.println(cards);
            cardSelected = cards.remove(getUserMenuInput()-1);
        }
        return cardSelected;
    }

    public int numCardsLeft(){
        int cardsLeft = cards.size();
        return cardsLeft;
    }

    public String selectCategory(int playerTurn) {
        String category;
        int categoryselected;

        if (playerTurn != 1){
            int randNum;
            //Computer's Turn, randomly selects category
            Random rand = new Random();
            categoryselected = rand.nextInt(5);
        }
        else{
            //Player selects a category
            System.out.println("Select a category:" +
            "\n1. Hardness" +
            "\n2. Specific Gravity" +
            "\n3. Cleavage" +
            "\n4. Crystal Abundance" +
            "\n5. Economic Value");
        }
        category = "a";
        return category;
    }

    private int getUserMenuInput() {
        //Gets the user to choose a card
        System.out.println("Select a card to play, enter the cards number(1-" + numCardsLeft()+ "): ");
        int i = 0;
        boolean validInput = false;
        while(!validInput) {
            Scanner input = new Scanner(System.in);
            if(input.hasNextInt()) {
                i = input.nextInt();
            }
            if (i > 0 && i<=numCardsLeft()){
                validInput=true;
            }
            else{
                System.out.println("Invalid input. Choose between 1 and "  + numCardsLeft()+ ".");
            }
        }
        return i;
    }
}
