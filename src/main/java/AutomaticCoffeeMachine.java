public interface AutomaticCoffeeMachine {

    public Coffee brew (CoffeeType type);
    //Vrem ca aparatul sa tina minte de la o zi la alta, care este stocul lui real
    //pentru asta, metoda powerOff va stinge aparattul dupa va salva stocul actual intru fisier
    //Medoda powerOn va crea o noua instanta de tipul CoffeeMachine cu stocurile citite din fisier
    public CoffeeMachine powerOn();
    public void powerOff();

}
