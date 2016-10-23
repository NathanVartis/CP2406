import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CP2406_Assignment2 extends JFrame{
    JButton newGame = new JButton("New Game");
    JButton passButton = new JButton("Pass Turn");
    JLabel welcome = new JLabel("Welcome to Mineral SuperTrumps.   ");
    JLabel playerQuestion = new JLabel("Number of players?");
    JLabel playerTurn = new JLabel();
    JLabel currentCategory = new JLabel();
    String[] players = {"3","4","5"};
    JComboBox numPlayersSelect = new JComboBox(players);
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    public static Game game;
    private PlayerView view;
    public static  CP2406_Assignment2 mainFrame;

    public static void main(String[] args) {
        CP2406_Assignment2 frame = new CP2406_Assignment2();
        frame.setSize(1800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(1800,800));
      }

      public CP2406_Assignment2(){
          mainFrame = this;
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          add(panel1,BorderLayout.NORTH);
          add(panel2,BorderLayout.CENTER);
          add(panel3,BorderLayout.SOUTH);
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
                  panel1.removeAll();
                  panel2.removeAll();
                  selectCategory(game.getPlayerTurn());
                  Player humanPlayer = game.getHumanPlayer();
                  view = new PlayerView(humanPlayer);
                  panel1.add(view);
                  panel2.add(passButton);
                  mainFrame.revalidate();
                  repaint();
                  //Initial turn if computer goes first.
                  game.play(-1);
              }
          });

          passButton.addActionListener(new ActionListener() {
              //Passes player's turn
              @Override
              public void actionPerformed(ActionEvent e) {
                  if(game.getPlayerTurn() ==1){
                      System.out.println("pass");
                      game.play(0);
                  }
              }
          });
      }


    public void selectCategory(int playerTurn) {
        //Player/Computer selects category. Uses dropdown menu for selection
        int category = 0;
        String[] categories = {"Hardness","Specific Gravity", "Cleavage", "Crystal Abundance", "Economic Value"};
        JComboBox categorySelect = new JComboBox(categories);
        JButton catSelect = new JButton("Select Category");
        if (game.getPlayerTurn() != 1){
            category = game.computerSelectCategory();
        }
        else{
            //TODO implement player selection of category
//            mainFrame.panel1.removeAll();
//            mainFrame.panel2.removeAll();
//            mainFrame.panel1.add(categorySelect);
//            mainFrame.panel2.add(catSelect);
//            catSelect.addActionListener(new ActionListener() {
//                //Passes player's turn
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    //category = categorySelect.getSelectedIndex()+1;
//                    System.out.println(categorySelect.getSelectedIndex()+1);
//                }
//            });
            category = 1;
        }
        game.setCategoryChosen(true);
        game.setCategory(category);
    }


    public void updateUI() {
        //Updates the UI after every turn
        view.showCards();
        //Updates card played last turn
        if(game.getCardPlayedLastTurn() != null) {
            view.showCardPlayed();
        }
        panel2.remove(playerTurn);
        panel2.remove(currentCategory);
        //Updates player turn and category
        playerTurn = new JLabel("Player " + game.getPlayerTurn() + "'s Turn. ");
        panel2.add(playerTurn);
        currentCategory = new JLabel("Current Category is "+ game.getCategory() + ".");
        panel2.add(currentCategory);
        panel3.removeAll();
        //Updates number of cards left for each player
        JLabel cardsLeft1 = new JLabel("Player 1 has " + game.getNumCardsLeft(1)+ " cards left. ");
        panel3.add(cardsLeft1);
        JLabel cardsLeft2 = new JLabel("Player 2 has " + game.getNumCardsLeft(2)+ " cards left. ");
        panel3.add(cardsLeft2);
        JLabel cardsLeft3 = new JLabel("Player 3 has " + game.getNumCardsLeft(3)+ " cards left. ");
        panel3.add(cardsLeft3);
        if(game.getNumPlayers() > 3) {
            JLabel cardsLeft4 = new JLabel("Player 4 has " + game.getNumCardsLeft(4) + " cards left. ");
            panel3.add(cardsLeft4);
        }
        if(game.getNumPlayers() > 4) {
            JLabel cardsLeft5 = new JLabel("Player 5 has " + game.getNumCardsLeft(5) + " cards left. ");
            panel3.add(cardsLeft5);
        }
        //TODO fix this not updating GUI on CPU turn for some reason;
        repaint();
        revalidate();
    }

    public void gameWon(int playerTurn) {
        //Game won screen. Lets play start a new game
        panel1.removeAll();
        panel2.removeAll();
        JLabel winner = new JLabel("Player " + playerTurn + " wins!");
        panel1.add(winner);
        panel2.add(newGame);
        panel1.repaint();
        repaint();
        revalidate();
    }
}
