public class Sponsor extends Kluby{
    private String nazwaSponsora;
    private double kwota;

    public Sponsor(String nazwaSponsora, double kwota, String nazwaKlubu, String miasto){
        super(nazwaKlubu, miasto);
        this.nazwaSponsora = nazwaSponsora;
        this.kwota = kwota;
    }

    public void wyswietlSponsor(){
        System.out.println("Sponsor: " + nazwaSponsora + " - Wspiera klub: " + getNazwa() + " (" + kwota + " zł)");
    }
}