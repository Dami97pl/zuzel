public class Osoba{
    protected String imie;
    protected int wiek;

    public Osoba(String imie, int wiek){
        this.imie = imie;
        this.wiek = wiek;
    }

    public void wyswietlInfo(){
        System.out.println("Imię: " + imie + ", Wiek: " + wiek);
    }
}