import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;


public class CardView extends JPanel{
    private Card card;
    private int cardNum;
    JLabel cardImage;
    JLabel invalidMove = new JLabel("    Invalid move. Select another card or pass your turn.");
    JLabel invalidTurn = new JLabel("         Not your turn.");
    JFrame error = new JFrame();

    public CardView(Card card){
        this.card = card;
        ImageIcon image = getImage();
        cardImage = new JLabel(image);
        add(cardImage);

        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //Player chooses a card to play, Error window opens if it is not the players turn or a valid move;
                //CardNum !=0 check is to ignore clicks on previously played card
                if(CP2406_Assignment2.game.isMoveValid(cardNum) && CP2406_Assignment2.game.getPlayerTurn() == 1 && cardNum != 0){
                    remove(cardImage);
                    CP2406_Assignment2.game.play(cardNum);
                }
                else if(CP2406_Assignment2.game.getPlayerTurn() != 1  && cardNum != 0) {
                    //Error window for trying to play a card outside of players turn.
                    System.out.println(CP2406_Assignment2.game.getPlayerTurn());
                    error.add(invalidTurn);
                    error.setLocationRelativeTo(null);
                    error.setSize(200,100);
                    error.setVisible(true);
                }
                else if(cardNum != 0){
                    //Error window for invalid move
                    error.add(invalidMove);
                    error.setLocationRelativeTo(null);
                    error.setSize(350,100);
                    error.setVisible(true);
                }
                revalidate();
                repaint();
            }
        });

    }

    private ImageIcon getImage() {
        String path = ".\\images\\Slide"+ card.getId() + ".jpg";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        //Rescales images so they all fit on the screen
        Image img = imageIcon.getImage();
        Image newimg = img.getScaledInstance(178, 250,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        return newIcon;
    }


    public void setCardNum(int cardNum) {
        //Sets the cardNum variable to match the position in the players hand
        this.cardNum = cardNum;
    }

}
