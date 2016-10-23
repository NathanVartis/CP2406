import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CP2406_Assignment2 extends JFrame{
    private static Game game;
    JButton newGame = new JButton("New Game");
    JLabel welcome = new JLabel("Welcome to Mineral SuperTrumps.   ");
    JLabel playerQuestion = new JLabel("Number of players?");
    String[] players = {"3","4","5"};
    JComboBox numPlayersSelect = new JComboBox(players);

    public static void main(String[] args) {
        CP2406_Assignment2 frame = new CP2406_Assignment2();
        frame.setSize(500,500);
        frame.setVisible(true);
      }

      public CP2406_Assignment2(){
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLayout(new FlowLayout());
          add(welcome);
          add(playerQuestion);
          add(numPlayersSelect);
          add(newGame);

          newGame.addActionListener(new ActionListener() {
              //Starts new game when new game button pressed
              @Override
              public void actionPerformed(ActionEvent e) {
                  game = new Game(Integer.parseInt(numPlayersSelect.getSelectedItem().toString()));
                  game.chooseDealer();
                  game.dealCardsToPlayers();
                  getContentPane().removeAll();

                  Player humanPlayer = game.getHumanPlayer();
                  PlayerView view = new PlayerView(humanPlayer);
                  add(view,BorderLayout.SOUTH);
                  revalidate();
                  repaint();
              }
          });
      }


}
