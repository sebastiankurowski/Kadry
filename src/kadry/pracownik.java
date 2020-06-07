package kadry;

import java.text.DecimalFormat;

class Pracownik{
    private String imie;
    private String nazwisko;
    private double placa; //8 bajtów - max ok 15 cyfr po przecinku (posiadają przyrostek D, lub d)
    private char plec; //pojedynczy znak w apostrofach ' '
    private int dzial; //4 bajty - zakres od -2 147 483 648 do 2 147 483 647

    //konstruktor umożliwiający przypisanie wartości wszystkim polom klasy
    Pracownik(String imie, String nazwisko, double placa, char plec, int dzial){

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.placa = placa;
        this.plec = plec;
        this.dzial = dzial;

    }

    //metodę toString (nadpisanie metody z klasy Object), która zwraca łańcuch zawierający dane pracownika;
    @Override
    public String toString(){

        DecimalFormat pln = new DecimalFormat("####0.00zł");
        return String.format("******** Wyświetlam dane pracownika: ********\nImię i nazwisko, (płeć): "
                + this.imie + " " + this.nazwisko
                + " (" + this.plec + ")"
                + "\nPracuje w dziale: " + this.dzial
                + " i zarabia: " + pln.format(this.placa) + "\n*********************************************\n");

    }

    public boolean czyPracujeWDziale(int nrDzialu){
        System.out.println("Czy pracownik o imieniu: " + this.imie + " pracuje w dziale numer: " + nrDzialu + "?");
        return this.dzial == nrDzialu;
    }

    public double placa(){
        return this.placa;

    }

    public double dzial(){
        return this.dzial;

    }

}
