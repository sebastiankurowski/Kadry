package kadry;

import java.util.Arrays;
import java.util.Scanner;

class Kadry{

    private Pracownik [] pracownicy;
    private int zatrudnienie;
    private int limitZatrudnienia = 100;


    Kadry(){
        pracownicy = new Pracownik[100];
        zatrudnienie = 5;
        pracownicy[0] = new Pracownik("Sebastian", "Kurowski", 5000, 'M', 3);
        pracownicy[1] = new Pracownik("Jakub", "Mrozowski", 4000.99, 'M', 2);
        pracownicy[2] = new Pracownik("Adrian", "Palich", 4200, 'M', 1);
        pracownicy[3] = new Pracownik("Jan", "Nowak", 3500, 'M', 1);
        pracownicy[4] = new Pracownik("Katarzyna", "Kowalska", 4100, 'K', 2);

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
        System.out.println("Wprowadź imię: ");
        String imie = myObj.nextLine();
        System.out.println("Wprowadź nazwisko: ");
        String nazwisko = myObj.nextLine();
        System.out.println("Wprowadź płacę: ");
        String placa = myObj.nextLine();
        double placaD = Double.valueOf(placa);
        System.out.println("Wprowadź płeć [M/K]: ");
        String plec = myObj.nextLine();
        char plecC = plec.charAt(0);
        System.out.println("Wprowadź dział [1-10]: ");
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

    public int[] dajDzialy(){
        int[] listaDzialow = new int[100];

        if(this.zatrudnienie > 0){
            for(int i=0; i<zatrudnienie; i++)
                    listaDzialow[i] = pracownicy[i].dzial();
        }
        Arrays.sort(listaDzialow);
        return listaDzialow;
    }

    public int[] dajDzialyUnikalne(){
        int[] listaDzialowSorted = this.dajDzialy();
        int[] listaDzialowUnikalnych = new int[10];
        if(listaDzialowSorted.length > 0){
            int j = 0;
            for(int i=1; i<listaDzialowSorted.length; i++)
                if (listaDzialowSorted[i] == 0){
                    continue;
                }
                else if (listaDzialowSorted[i-1] != listaDzialowSorted[i]){
                    listaDzialowUnikalnych[j] = listaDzialowSorted[i];
                    j++;
                }
        }
        return listaDzialowUnikalnych;
    }
}
