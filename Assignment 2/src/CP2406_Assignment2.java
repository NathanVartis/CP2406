import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CP2406_Assignment2 extends JFrame{
    JButton newGame = new JButton("New Game");
    JButton passButton = new JButton("Pass Turn");
    JLabel welcome = new JLabel("Welcome to Mineral SuperTrumps.   ");
    JLabel playerQuestion = new JLabel("Number of players?");
    String[] players = {"3","4","5"};
    JComboBox numPlayersSelect = new JComboBox(players);
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    public static Game game;
    private PlayerView view;
    public static  CP2406_Assignment2 mainFrame;

    public static void main(String[] args) {
        CP2406_Assignment2 frame = new CP2406_Assignment2();
        frame.setExtendedState(MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(1000,500));
      }

      public CP2406_Assignment2(){
          mainFrame = this;
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          add(panel1,BorderLayout.NORTH);
          add(panel2,BorderLayout.CENTER);
          panel1.add(welcome);
          panel2.add(playerQuestion);
          panel2.add(numPlayersSelect);
          panel2.add(newGame);

          newGame.addActionListener(new ActionListener() {
              //Starts new game when new game button pressed
              @Override
              public void actionPerformed(ActionEvent e) {
                  game = new Game(Integer.parseInt(numPlayersSelect.getSelectedItem().toString()));
                  game.chooseDealer();
                  game.dealCardsToPlayers();
                  selectCategory(game.getPlayerTurn());
                  panel1.removeAll();
                  panel2.removeAll();
                  Player humanPlayer = game.getHumanPlayer();
                  view = new PlayerView(humanPlayer);
                  panel1.add(view);
                  panel2.add(passButton);
                  revalidate();
                  repaint();
                  //Initial turn if computer goes first.
                  game.play(-1);
              }
          });
      }


    public static void selectCategory(int playerTurn) {
        //TODO implement this properly
        game.setCategoryChosen(true);
        game.setCategory(1);
    }


    public void refreshUI() {
        //Refreshes the UI after every turn
        System.out.println("test refresh");
        view.showCards();
        if(game.getCardPlayedLastTurn() != null) {
            System.out.println("test update card");
            view.showCardPlayed();
        }
        panel2.removeAll();
        JLabel playerTurn = new JLabel("Player " + game.getPlayerTurn() + "'s Turn.");
        panel2.add(playerTurn);
        JLabel currentCategory = new JLabel("Current Category is "+ game.getCategory() + ".");
        panel2.add(currentCategory);
        revalidate();
        repaint();
    }
}
