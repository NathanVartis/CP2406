public class Card {

    private static CardList cardlist = new CardList();
    private int id;
    private String name, hardness, specificGravity, cleavage, crystalAbundance, economicValue, type;
    private int cleavageNum, crystalNum, economicNum;

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

        //Sets numeric values for cleavage, crystal abundance and economic value for comparisons when played
        switch (cleavage){
            case "none":{
                cleavageNum = 0;
                break;
            }
            case "poor/none":{
                cleavageNum = 1;
                break;
            }
            case "1 poor":{
                cleavageNum = 2;
                break;
            }
            case "2 poor":{
                cleavageNum = 3;
                break;
            }
            case "1 good":{
                cleavageNum = 4;
                break;
            }
            case "1 good, 1 poor":{
                cleavageNum = 5;
                break;
            }
            case "2 good":{
                cleavageNum = 5;
                break;
            }
            case "3 good":{
                cleavageNum = 7;
                break;
            }
            case "1 perfect":{
                cleavageNum = 8;
                break;
            }
            case "1 perfect, 1 good":{
                cleavageNum = 9;
                break;
            }
            case "1 perfect, 2 good":{
                cleavageNum = 10;
                break;
            }
            case "2 perfect, 1 good":{
                cleavageNum = 11;
                break;
            }
            case "3 perfect":{
                cleavageNum = 12;
                break;
            }
            case "4 perfect":{
                cleavageNum = 13;
                break;
            }
            case "6 perfect":{
                cleavageNum = 14;
                break;
            }

        }

        switch (crystalAbundance){
            case "ultratrace":{
                crystalNum = 0;
                break;
            }
            case "trace":{
                crystalNum = 1;
                break;
            }
            case "low":{
                crystalNum = 2;
                break;
            }
            case "moderate":{
                crystalNum = 3;
                break;
            }
            case "high":{
                crystalNum = 4;
                break;
            }
            case "very high":{
                crystalNum = 5;
                break;
            }

        }

        switch (economicValue){
            case "trivial":{
                economicNum = 0;
                break;
            }
            case "low":{
                economicNum = 1;
                break;
            }
            case "moderate":{
                economicNum = 2;
                break;
            }
            case "high":{
                economicNum = 3;
                break;
            }
            case "very high":{
                economicNum = 4;
                break;
            }

            case "I'm rich!":{
                economicNum = 5;
                break;
            }

        }

    }

    @Override
    public String toString() {
        return "\nName: "+ name + "\nHardness: " + hardness + "\nSpecific Gravity: " + specificGravity
                + "\nCleavage: " + cleavage + "\nCrystal Abundance: " + crystalAbundance
                + "\nEconomic Value: " + economicValue + "\nType: " + type + "\n";
    }


    public String getHardness() {
        return hardness;
    }

    public String getSpecificGravity() {
        return specificGravity;
    }

    public int getCleavageNum() {
        return cleavageNum;
    }

    public int getCrystalNum() {
        return crystalNum;
    }

    public int getEconomicNum() {
        return economicNum;
    }

    public String getType() {
        return type;
    }
}



