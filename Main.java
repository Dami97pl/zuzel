import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Kluby> kluby = new ArrayList<>();
        ArrayList<Mecze> mecze = new ArrayList<>();
        ArrayList<Sponsor> sponsorzy = new ArrayList<>();

        while(true){
            System.out.println("-- MENU --");
            System.out.println("1 - Dodaj zawodnika");
            System.out.println("2 - Dodaj klub");
            System.out.println("3 - Wyświetl wszystkich zawodników w danym klubie");
            System.out.println("4 - Wyświetl wszystkie kluby");
            System.out.println("5 - Dodaj mecz");
            System.out.println("6 - Wyświetl rozegrane mecze");
            System.out.println("7 - Dodaj sponsora");
            System.out.println("8 - Wyświetl sponsorów");
            System.out.println("0 - Zakończ program");
            System.out.print("Wybierz opcję: ");
            int wybierz = sc.nextInt();
            sc.nextLine();

            switch(wybierz){
                case 1: //dodawanie zawodnika
                    if(kluby.isEmpty()){
                        System.out.println("Najpierw dodaj jakiś klub!!!");
                        break;
                    }

                    System.out.println("Dostępne kluby: ");
                    for(int i = 0; i < kluby.size(); i++){
                        System.out.println((i + 1) + " . " + kluby.get(i).getNazwa());
                    }

                    System.out.print("Wybierz numer klubu: ");
                    int wyborKlubu = sc.nextInt();
                    sc.nextLine();

                    if(wyborKlubu < 1 || wyborKlubu > kluby.size()){
                        System.out.println("Nieprawidłowy numer klubu ");
                        break;
                    }

                    Kluby wybranyKlub = kluby.get(wyborKlubu - 1);

                    System.out.println("Imię i nazwisko zawodnika ");
                    String imie = sc.nextLine();
                    System.out.println("Wiek: ");
                    int wiek = sc.nextInt();
                    Zawodnicy zawodnik = (new Zawodnicy(imie, wiek, wybranyKlub.getNazwa()));
                    wybranyKlub.dodajZawodnika(zawodnik);
                    System.out.println("Zawodnik dodany! " + wybranyKlub.getNazwa());
                    break;
                case 2: //dodawanie klubu
                    System.out.print("Podaj nazwę klubu: ");
                    String klubNazwa = sc.nextLine();
                    System.out.println("Podaj miasto: ");
                    String miasto = sc.nextLine();
                    kluby.add(new Kluby(klubNazwa, miasto));
                    System.out.println("Dodano klub: " + klubNazwa);
                    break;
                case 3: //zawodnicy
                    if(kluby.isEmpty()){
                        System.out.println("Brak klubów");
                        break;
                    }
                    System.out.println("Wybierz klub, którego zawodników chcesz zobaczyć: ");
                    for(int i = 0; i < kluby.size(); i++){
                        System.out.println((i + 1) + ". " + kluby.get(i).getNazwa());
                    }
                    int numerKlubu = sc.nextInt();
                    sc.nextLine();
                    if(numerKlubu < 1 || numerKlubu > kluby.size()){
                        System.out.println("Nieprawidłowy numer!!");
                        break;
                    }
                    kluby.get(numerKlubu - 1).pokazZawodnikow();
                    break;
                case 4: //kluby
                    if(kluby.isEmpty()){
                        System.out.println("Brak klubów.");
                    }else{
                        System.out.println("-- Lista klubów --");
                        for(Kluby k : kluby){
                            k.wyswietlKluby();
                        }
                    }
                    break;
                case 5: //dodawanie meczu
                    if(kluby.size() < 2){
                        System.out.println("Potrzebujesz minimum 2 klubów!");
                        break;
                    }

                    System.out.println("Wybierz klub gospodarzy: ");
                    for(int i = 0; i < kluby.size(); i++){
                        System.out.println((i + 1) + ". " + kluby.get(i).getNazwa());
                    }
                    int gosp = sc.nextInt();

                    System.out.println("Wybierz klub gości:");
                    for(int i = 0; i < kluby.size(); i++){
                        if(i != gosp - 1){
                            System.out.println((i + 1) + ". " + kluby.get(i).getNazwa());
                        }
                    }
                    int gosc = sc.nextInt();

                    if(gosp == gosc || gosp < 1 || gosc < 1 || gosp > kluby.size() || gosc > kluby.size()){
                        System.out.println("Nieprawidłowy wybór klubów!");
                        break;
                    }

                    System.out.print("Punkty gospodarzy: ");
                    int pktGosp = sc.nextInt();
                    System.out.print("Punkty gości: ");
                    int pktGosc = sc.nextInt();

                    mecze.add(new Mecze(kluby.get(gosp - 1), kluby.get(gosc - 1), pktGosp, pktGosc));
                    System.out.println("Dodano mecz!");
                    break;
                case 6: //spis meczy
                    if(mecze.isEmpty()){
                        System.out.println("Brak rozegranych meczów.");
                    }else{
                        System.out.println("Rozegrane mecze: ");
                        for(Mecze m : mecze){
                            m.pokazMecz();
                        }
                    }
                    break;
                case 7: //dodawanie sponsora
                    if(kluby.isEmpty()){
                        System.out.println("Najpierw dodaj klub!");
                        break;
                    }
                    System.out.println("Dostępne kluby:");
                    for(int i = 0; i < kluby.size(); i++){
                        System.out.println((i + 1) + ". " + kluby.get(i).getNazwa());
                    }
                    System.out.print("Wybierz numer klubu: ");
                    int wybor = sc.nextInt();
                    sc.nextLine();

                    if(wybor< 1 || wybor > kluby.size()){
                        System.out.println("Nieprawidłowy numer!");
                        break;
                    }

                    Kluby klubSpo = kluby.get(wybor - 1);

                    System.out.print("Podaj nazwę sponsora: ");
                    String nazwaS = sc.nextLine();
                    System.out.print("Podaj kwotę wsparcia: ");
                    double kwota = sc.nextDouble();

                    Sponsor sponsor = new Sponsor(nazwaS, kwota, klubSpo.getNazwa(), klubSpo.getMiasto());
                    sponsorzy.add(sponsor);
                    System.out.println("Dodano sponsora: " + nazwaS + " dla klubu " + klubSpo.getNazwa());
                    break;
                case 8: //lista sponsorow
                    if(sponsorzy.isEmpty()){
                        System.out.println("Brak sponsorów.");
                    }else{
                        System.out.println("-- Lista sponsorów --");
                        for(Sponsor s : sponsorzy){
                            s.wyswietlSponsor();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Koniec programu.");
                    sc.close();
                    return;
                default:
                    System.out.println("Źle wprowadziłeś opcje, wpisz ponownie.");
            }
        }
    }
}