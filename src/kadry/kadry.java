package kadry;

import java.util.Arrays;
import java.util.Scanner;

class Kadry{

    private Pracownik [] pracownicy;
    private int zatrudnienie;
    private int limitZatrudnienia = 5;


    Kadry(){
        pracownicy = new Pracownik[100];
        zatrudnienie = 3;
        pracownicy[0] = new Pracownik("Sebastian", "Kurowski", 5000, 'M', 1);
        pracownicy[1] = new Pracownik("Jakub", "Mrozowski", 4000.99, 'M', 2);
        pracownicy[2] = new Pracownik("Adrian", "Palich", 4200, 'M', 2);
    }

    public void dodajPracownika(Pracownik pracownik){

        if (zatrudnienie < limitZatrudnienia) {
            pracownicy[zatrudnienie] = pracownik;
            zatrudnienie++;
            if (zatrudnienie == limitZatrudnienia) {
                System.out.println("To był ostatni możliwy do przyjęcia pracownik.\n Zwiększ aktualny limit zatrudnienia: "
                        + limitZatrudnienia + " jeśli chcesz zatrudnić więcej osób.");
            }
            System.out.println("Dodano pracownika nr: " + zatrudnienie + "\n");
        }
        else {
            System.out.println("Osięgnięto limit pracowników, nie można dodać więcej! Operacja anulowana.\n");
        }
    }

    public void dodajPracownikaInteraktywnie(){

        Scanner myObj = new Scanner(System.in);
        System.out.println("Wprowadz imie: ");
        String imie = myObj.nextLine();
        System.out.println("Wprowadz nazwisko: ");
        String nazwisko = myObj.nextLine();
        System.out.println("Wprowadz place: ");
        String placa = myObj.nextLine();
        double placaD = Double.valueOf(placa);
        System.out.println("Wprowadz plec [M/K]: ");
        String plec = myObj.nextLine();
        char plecC = plec.charAt(0);
        System.out.println("Wprowadz dzial: ");
        String dzial = myObj.nextLine();
        int dzialInt = Integer.valueOf(dzial);

        Pracownik tmp = new Pracownik(imie, nazwisko, placaD, plecC, dzialInt);
        dodajPracownika(tmp);
    }

    public double sredniZarobek(){

        if(this.zatrudnienie > 0){
            int limit = zatrudnienie;
            double suma = 0;

            for(int i=0; i<limit; i++){
                suma += pracownicy[i].placa();
            }
            return suma / zatrudnienie;
        }else {
            return 0.0;
        }
    }

    public double sredniZarobek(int nrDzialu){

        if(this.zatrudnienie > 0){
            int limit = zatrudnienie;
            int counter = 0;
            double suma = 0;

            for(int i=0; i<limit; i++){
                if(pracownicy[i].dzial() == nrDzialu){
                    suma += pracownicy[i].placa();
                    counter++;
                }
            }
            if (counter > 0) {
                return suma / counter;
            } else {
                return 0.0;
            }
        }else {
            return 0.0;
        }
    }

    public void pisz(){
        for ( int i = 0; i < zatrudnienie; i++ ) {
            pracownicy[i].toString();
            System.out.println(pracownicy[i]);
        }
        System.out.println("Średnie zarobki w całej firmie wynoszą: " + this.sredniZarobek() + "\n\n");
    }
//TODO: dokonczyć dajDzialy żeby zwracało unikalne wartości z listy działów, albo wpisać to już w Main
    public int[] dajDzialy(){
        int[] listaDzialow = new int[100];

        if(this.zatrudnienie > 0){
            for(int i=0; i<zatrudnienie; i++)
                    listaDzialow[i] = pracownicy[i].dzial();
        }

        Arrays.sort(listaDzialow);

        return listaDzialow;
    }
}
