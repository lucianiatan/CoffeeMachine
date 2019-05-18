public enum CoffeeType {

    ESPRESSO(100, 10, 0) {
        @Override
        public String toString()
        {
            return "Espresso";
        }
    },
    ESPRESSO_LUNG(200, 10, 0){
        @Override
        public String toString()
        {
            return "Espresso Long";
    }
    },
    LATTE_MACHIATTO(100, 10, 200) {
        @Override
        public String toString()
        {
            return "Latte Machiatto";
        }
    },
    CAPPUCCINO(100, 10, 100) {
        @Override
        public String toString()
        {
            return "Cappuccino";
        }
    };

    public int getCantitateApa() {
        return cantitateApa;
    }

    public int getCantitateBoabe() {
        return cantitateBoabe;
    }

    public int getCantitateLapte() {
        return cantitateLapte;
    }

    private final int cantitateApa;
    private final int cantitateBoabe;
    private final int cantitateLapte;

    CoffeeType(int apa, int boabe, int lapte) {
        cantitateApa = apa;
        cantitateBoabe = boabe;
        cantitateLapte = lapte;


    }
}
