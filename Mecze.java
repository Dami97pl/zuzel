public class Mecze{
    private Kluby gospodarze;
    private Kluby goscie;
    private int punktyGospodarzy;
    private int punktyGosci;

    public Mecze(Kluby gospodarze, Kluby goscie, int punktyGospodarzy, int punktyGosci){
        this.gospodarze = gospodarze;
        this.goscie = goscie;
        this.punktyGospodarzy = punktyGospodarzy;
        this.punktyGosci = punktyGosci;
    }

    public void pokazMecz(){
        System.out.println(gospodarze.getNazwa() + " " + punktyGospodarzy + " - " + punktyGosci + " " + goscie.getNazwa());
    }
}