package kadry;

import java.util.Scanner;

class Kadry{

    private Pracownik [] pracownicy;
    private int zatrudnienie;

    Kadry(){
        pracownicy = new Pracownik[100];
        zatrudnienie = 0;
    }

    public void dodajPracownika(Pracownik pracownik){

        if(zatrudnienie < 100){
            pracownicy[zatrudnienie] = pracownik;
            zatrudnienie++;

        }
    }

    public void dodajPracownikaInteraktywnie(){

        //Pracownik tmp = new Pracownik();

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
            return suma / counter;
        }else {
            return 0.0;
        }
    }


    //public int[] dajDzialy(){
    //    int[] listaDzialow = new int[20];
    //}
}
