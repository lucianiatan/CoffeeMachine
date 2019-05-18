import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoffeeMachineShould {

    @Test
    public void brewCoffeeGivenProperStock ()
    {
        //Given
        CoffeeMachine m = new CoffeeMachine();

        //When
        Coffee c = m.brew(CoffeeType.ESPRESSO);

        //Then
        //assertTrue(c.isThisTypeMine, CoffeeType.ESPRESSO);
        assertEquals( CoffeeType.ESPRESSO, c.getType());
    }
    //then
    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenBrewEspressoGivenMissingWater ()
    {
        //Given
        CoffeeMachine m = new CoffeeMachine(0,100,100);

        //When
        Coffee c = m.brew(CoffeeType.ESPRESSO);

        //Then este mai sus, inainte de @Test
    }

    @Test
    public void updateStockAfterBrewCappuccino ()
    {
        //Given
        int apa = 1000;
        int boabe = 1000;
        int lapte = 1000;
        CoffeeMachine m = new CoffeeMachine(apa,boabe,lapte);

        //When
        Coffee c = m.brew(CoffeeType.CAPPUCCINO);

        //Then
        assertTrue(apa>m.getStocApa());
        assertTrue(boabe>m.getStocBoabe());
        assertTrue(lapte>m.getStocLapte());
    }

    @Test
    public void persistMachineIntoFileWhenPoweringOff ()
    {
        CoffeeMachine m = new CoffeeMachine(2019,2019,2019);
        Coffee latte = m.brew(CoffeeType.LATTE_MACHIATTO);
        Coffee cappuccino = m.brew(CoffeeType.CAPPUCCINO);
        Coffee espressoLung = m.brew(CoffeeType.ESPRESSO_LUNG);
        m.powerOff();

        //When
        CoffeeMachine x = new CoffeeMachine();
        CoffeeMachine mFromFile = m.powerOn();

        //Then
        assertEquals(m.getStocApa(),mFromFile.getStocApa());
        assertEquals(m.getStocBoabe(),mFromFile.getStocBoabe());
        assertEquals(m.getStocLapte(),mFromFile.getStocLapte());
    }

}
