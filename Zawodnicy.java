public class Zawodnicy extends Osoba{
    private String klub;

    public Zawodnicy(String imie, int wiek, String klub){
        super(imie, wiek);
        this.klub = klub;
    }

    public void wyswietlInfo(){
        System.out.println("Imie: " + imie + " wiek: " + wiek + " klub: " + klub);
    }
}