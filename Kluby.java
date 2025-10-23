import java.util.ArrayList;

public class Kluby{
    protected String nazwa;
    protected String miasto;
    private ArrayList<Zawodnicy> zawodnicy = new ArrayList<>();

    public Kluby(String nazwaKlub, String miasto){
        this.nazwa = nazwaKlub;
        this.miasto = miasto;
    }

    public String getNazwa(){
        return nazwa;
    }

    public String getMiasto(){
        return miasto;
    }

    public void dodajZawodnika(Zawodnicy zawodnik){
        zawodnicy.add(zawodnik);
    }

    public ArrayList<Zawodnicy> getZawodnicy(){
        return zawodnicy;
    }

    public void wyswietlKluby(){
        System.out.println("Nazwa Klubu: " + nazwa + " Miasto: " + miasto);
    }

    public void pokazZawodnikow(){
        System.out.println("Zawodnicy klubu " + nazwa + ":");
        if(zawodnicy.isEmpty()){
            System.out.println("Brak zawodników w tym klubie.");
        }else{
            for(Zawodnicy z : zawodnicy){
                z.wyswietlInfo();
            }
        }
    }
}