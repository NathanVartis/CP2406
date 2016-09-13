public class Card {

    private int id;

    public Card(int i){
        id = i;
    }

    @Override
    public String toString() {
        return "id = " + id;
    }
}
