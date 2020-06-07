package kadry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Pracownik pracownik1 = new Pracownik("Sebastian", "Kurowski", 5000, 'M', 1);
        System.out.println( pracownik1.toString() );

        Pracownik pracownik2 = new Pracownik("Jakub", "Mrozowski", 4000.99, 'M', 2);
        System.out.println( pracownik2.toString() );

        Pracownik pracownik3 = new Pracownik("Adrian", "Palich", 4200, 'M', 2);
        System.out.println( pracownik3.toString() );

        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj numer działu: ");
        int nrDzialu = Integer.parseInt(skaner.nextLine());

        System.out.println(pracownik1.czyPracujeWDziale(nrDzialu));
        System.out.println(pracownik2.czyPracujeWDziale(nrDzialu));
        System.out.println(pracownik3.czyPracujeWDziale(nrDzialu));
        */

        Kadry kadry = new Kadry();
        kadry.dodajPracownikaInteraktywnie();

    }
}
