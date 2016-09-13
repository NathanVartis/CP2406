public class Card {

    private static CardList cardlist = new CardList();
    private int id;
    private String name, hardness, specificGravity, cleavage, crystalAbundance, economicValue, type;

    public Card(int i) {
        //Creates the cards from the Card List
        id = i;
        name = cardlist.getName(i);
        type = cardlist.getType(i);
        hardness = cardlist.getHardness(i);
        specificGravity = cardlist.getSpecificGravity(i);
        cleavage = cardlist.getCleavage(i);
        crystalAbundance = cardlist.getCrystalAbundance(i);
        economicValue = cardlist.getEconomicValue(i);

    }

    @Override
    public String toString() {
        return "\nName: "+ name + "\nHardness: " + hardness + "\nSpecific Gravity: " + specificGravity
                + "\nCleavage: " + cleavage + "\nCrystal Abundance: " + crystalAbundance
                + "\nEconomic Value: " + economicValue + "\nType: " + type + "\n";
    }
}



