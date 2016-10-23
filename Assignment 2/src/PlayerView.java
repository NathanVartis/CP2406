import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerView extends JPanel {
    private Player player;
    JPanel playerHandPanel = new JPanel();
    JPanel lastCardPlayedPanel = new JPanel();
    JPanel yourCardLabelPanel = new JPanel();
    JLabel cardPlayed = new JLabel("Last Card Played:");

    public PlayerView(Player player){
        this.player = player;
        setLayout(new BorderLayout());
        add(yourCardLabelPanel,BorderLayout.NORTH);
        yourCardLabelPanel.add(new JLabel("Your Cards:"));
        add(playerHandPanel, BorderLayout.CENTER);
        add(lastCardPlayedPanel, BorderLayout.SOUTH);
        showCards();

    }

    public void showCards(){
        playerHandPanel.removeAll();
        ArrayList<Card> cards = player.getCards();
        for (int i=0; i < player.numCardsLeft();i++){
            //Displays the cards in the players hand
            Card card = cards.get(i);
            CardView cardView = new CardView(card);
            cardView.setCardNum(i+1);
            playerHandPanel.add(cardView);

        }
        playerHandPanel.revalidate();
        playerHandPanel.repaint();
    }

    public void showCardPlayed(){
        //Shows previously played card
        lastCardPlayedPanel.removeAll();
        lastCardPlayedPanel.add(cardPlayed);
        CardView cardView = new CardView(CP2406_Assignment2.game.getCardPlayedLastTurn());
        cardView.setCardNum(0);
        lastCardPlayedPanel.add(cardView);
        lastCardPlayedPanel.revalidate();
        lastCardPlayedPanel.repaint();
    }
}
