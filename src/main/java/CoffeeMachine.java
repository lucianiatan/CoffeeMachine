import java.io.*;

public class CoffeeMachine implements AutomaticCoffeeMachine, Serializable {


    private static final long serialVersionUID = 8574390748709024124L;
    private final String persistentFileName = "Stock.bin";
    // Fiecare aparat de cafea are:
    private int stocApa;
    private int stocBoabe;
    private int stocLapte;

    public int getStocApa() {
        return stocApa;
    }

    public int getStocBoabe() {
        return stocBoabe;
    }

    public int getStocLapte() {
        return stocLapte;
    }

    CoffeeMachine() {
        stocApa = 1500;
        stocBoabe = 250;
        stocLapte = 800;
    }
    CoffeeMachine(int stocApa, int stocBoabe, int stocLapte) {
        this.stocApa = stocApa;
        this.stocBoabe = stocBoabe;
        this.stocLapte = stocLapte;
    }
    @Override
    public Coffee brew(CoffeeType type) {
        Coffee result = null;

        if (stocApa >= type.getCantitateApa() &&
            stocBoabe >= type.getCantitateBoabe() &&
            stocLapte >= type.getCantitateLapte() )
    {
        result = new Coffee(type);
                stocApa -= type.getCantitateApa();
                stocBoabe -= type.getCantitateBoabe();
                stocLapte -= type.getCantitateLapte();
    }
        else {
            throw new IllegalArgumentException("Out of Stock");
        }
        return result;
    }

    public CoffeeMachine powerOn() {

        CoffeeMachine obj = null;
        try{
            FileInputStream file = new FileInputStream(persistentFileName);
            ObjectInputStream in = new ObjectInputStream(file);

            obj = (CoffeeMachine)in.readObject();

            in.close();
            file.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public void powerOff() {
        try{
            FileOutputStream file = new FileOutputStream(persistentFileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this);

            out.close();
            file.close();
        }
        catch (IOException ex){
            System.out.println("IOException is caught");
        }
    }

}
