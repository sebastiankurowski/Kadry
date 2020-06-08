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

        Scanner skaner = new Scanner(System.in);
        Kadry kadry = new Kadry();
        System.out.println("Witaj w programie obsługi Kadr!\nWybierz akcję:");

        int wybranaAkcja = 1;

        do {

            System.out.println(
                    "1 - dodajPracownikaInteraktywnie()\n" +
                    "2 - sredniZarobek()\n" +
                    "3 - sredniZarobek(int dzial)\n" +
                    "4 - dajDzialy()\n" +
                    "5 - pisz()\n" +
                    "0 - zakończ\n");
            wybranaAkcja = Integer.parseInt(skaner.nextLine());

            switch (wybranaAkcja) {
                case 1:
                    kadry.dodajPracownikaInteraktywnie();
                    break;
                case 2:
                    System.out.println("Średnie zarobki w całej firmie wynoszą " + kadry.sredniZarobek() + "\n\n");
                    System.out.println("Wybierz kolejną akcję:\n");
                    break;
                case 3:
                    System.out.println("Podaj numer działu dla którego mam zwrócić średnie zarobki:\n");
                    int numerDzialu = Integer.parseInt(skaner.nextLine());
                    kadry.sredniZarobek(numerDzialu);
                    System.out.println("Średnie zarobki w dziale " + numerDzialu + " wynoszą: " + kadry.sredniZarobek(numerDzialu) + "\n\n");
                    System.out.println("Wybierz kolejną akcję:\n");
                    break;
                case 4:
                    System.out.println(kadry.dajDzialy());
                    System.out.println("Wybierz kolejną akcję:\n");
                    break;
                case 5:
                    kadry.pisz();
                    System.out.println("Wybierz kolejną akcję:\n");
                    break;
                case 0:
                    System.out.println("Zakończono działanie programu. Dziękujemy!\n");
                default:
                    System.out.println("Wprowadzono błędną wartość.\nSpróbuj ponownie:");
            }
        }
        while (wybranaAkcja != 0);
    }
}
