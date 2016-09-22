public class CardList {
    //Hardcoded list of cards
    private String[][] list;

    public CardList(){
    list = new String[][]{
            {"Quartz","play","7","2.65","poor/none","high","moderate"},
            {"Plagioclase","play","6.5","2.8","1 perfect, 1 good","very high","moderate"},
            {"Orthoclase","play","6.5","2.6","1 perfect, 1 good","high","moderate"},
            {"Biotite","play","3","3.3","1 perfect","moderate","low"},
            {"Muscovite","play","3","2.9","1 perfect","moderate","moderate"},
            {"Hornblende","play","6","3.5","2 good","moderate","trivial"},
            {"Actinolite","play","6","3.5","2 good","low","low"},
            {"Glaucophane","play","6","3.2","2 good","low","trivial"},
            {"Olivine","play","7","4.4","2 poor","high","low"},
            {"Garnet","play","7.5","4.3","none","moderate","moderate"},
            {"Titanite","play","5.5","3.6","3 good","low","low"},
            {"Zircon","play","7.5","4.7","2 poor","trace","moderate"},
            {"Augite","play","6.5","3.6","2 good","high","trivial"},
            {"Orthopyroxene","play","6","3.9","2 good","high","trivial"},
            {"Chlorite","play","3","4.4","1 perfect","moderate","low"},
            {"Antigorite","play","4","2.6","1 perfect","low","low"},
            {"Talc","play","1","2.8","1 perfect","low","moderate"},
            {"Kaolinite","play","2.5","2.7","1 perfect","moderate","high"},
            {"Andalusite","play","7","3.15","2 good","low","moderate"},
            {"Kyanite","play","7","3.7","1 perfect, 1 good","trace","moderate"},
            {"Sillimanite","play","7.5","3.25","1 perfect, 1 good","low","low"},
            {"Staurolite","play","7","3.8","1 good","trace","low"},
            {"Epidote","play","6.5","3.5","1 perfect","moderate","trivial"},
            {"Tourmaline","play","7.5","3.2","2 poor","trace","moderate"},
            {"Topaz","play","8","3.6","1 perfect","ultratrace","low"},
            {"Beryl","play","8","2.9","1 poor","trace","moderate"},
            {"Pyrite","play","6.5","5","2 poor","low","moderate"},
            {"Pyrrhotite","play","4.5","4.6","none","low","moderate"},
            {"Chalcopyrite","play","4","4.3","2 poor","low","very high"},
            {"Galena","play","2.5","7.6","3 perfect","trace","high"},
            {"Sphalerite","play","4","4.1","6 perfect","trace","high"},
            {"Molybdenite","play","1.5","4.7","1 perfect","trace","high"},
            {"Gold","play","3","19.3","none","ultratrace","I'm rich!"},
            {"Diamond","play","10","3.5","4 perfect","ultratrace","I'm rich!"},
            {"Graphite","play","2","2.2","1 perfect","trace","moderate"},
            {"Halite","play","2.5","2.2","3 perfect","trace","moderate"},
            {"Fluorite","play","4","3.2","4 perfect","trace","moderate"},
            {"Gypsum","play","2","2.3","1 perfect, 2 good","trace","high"},
            {"Barite","play","3.5","4.5","2 perfect, 1 good","trace","moderate"},
            {"Apatite","play","5","3.2","2 poor","low","high"},
            {"Monazite","play","5","5.2","1 good,1 poor","trace","moderate"},
            {"Calcite","play","3","2.7","3 perfect","moderate","high"},
            {"Dolomite","play","4","2.9","3 perfect","low","low"},
            {"Magnesite","play","4","3","3 perfect","low","moderate"},
            {"Siderite","play","4.5","4","3 perfect","trace","moderate"},
            {"Magnetite","play","6","5.2","none","moderate","very high"},
            {"Hematite","play","6","5.3","none","trace","high"},
            {"Chromite","play","5.5","5.1","none","low","high"},
            {"Ilmenite","play","6","4.8","none","low","moderate"},
            {"Rutile","play","6.5","4.3","2 good","low","high"},
            {"Corundum","play","9","4","none","trace","moderate"},
            {"Cassiterite","play","7","7.1","1 good, 1 poor","trace","high"},
            {"Gibbsite","play","3.5","2.4","1 perfect","low","high"},
            {"Goethite","play","5.5","4.3","1 perfect, 1 good","moderate","moderate"},
            {"The Miner","trump","N/A","N/A","N/A","N/A","N/A"},
            {"The Petrologist","trump","N/A","N/A","N/A","N/A","N/A"},
            {"The Gemmologist","trump","N/A","N/A","N/A","N/A","N/A"},
            {"The Mineralogist","trump","N/A","N/A","N/A","N/A","N/A"},
            {"The Geophysicist","trump","N/A","N/A","N/A","N/A","N/A"},
            {"The Geologist","trump","N/A","N/A","N/A","N/A","N/A"}};
    }

    public String getName(int i){
        String s = list[i][0];
        return s;
    }

    public String getType(int i) {
        String s = list[i][1];
        return s;
    }

    public String getHardness(int i) {
        String s = list[i][2];
        return s;
    }

    public String getSpecificGravity(int i) {
        String s = list[i][3];
        return s;
    }

    public String getCleavage(int i) {
        String s = list[i][4];
        return s;
    }

    public String getCrystalAbundance(int i) {
        String s = list[i][5];
        return s;
    }

    public String getEconomicValue(int i) {
        String s = list[i][6];
        return s;
    }
}
