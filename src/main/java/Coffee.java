public class Coffee {

    // Fiecare cafea are:

    private CoffeeType type;

    Coffee(CoffeeType type) {

        this.type = type;

    }

    public CoffeeType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Enjoy your " + type.toString();

    }
}

