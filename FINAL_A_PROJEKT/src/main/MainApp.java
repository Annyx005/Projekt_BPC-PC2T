package main;

import service.ZamestnanecService;
import java.util.Scanner;

public class MainApp {
public static void main(String[] args){
try(Scanner sc=new Scanner(System.in)){
ZamestnanecService s=new ZamestnanecService();
while(true){
System.out.println("1-Pridat 2-Vypisat 3-Vyhladat 4-Spolupraca 5-Ulozit 6-Nacitat 7-Statistika 0-Koniec");
int c=sc.nextInt();
switch(c){
case 1:

    String typ;
    while (true) {
        System.out.print("Zadaj poziciu (analytik/bezpecnost): ");
        typ = sc.next().toLowerCase();

        if (typ.equals("analytik") || typ.equals("bezpecnost")) break;
        else System.out.println("Neplatna pozicia!");
    }

    String meno;
    while (true) {
        System.out.print("Zadaj meno: ");
        meno = sc.next();

        if (meno.matches("[a-zA-Z]+")) break;
        else System.out.println("Len pismena!");
    }

    String priezvisko;
    while (true) {
        System.out.print("Zadaj priezvisko: ");
        priezvisko = sc.next();

        if (priezvisko.matches("[a-zA-Z]+")) break;
        else System.out.println("Len pismena!");
    }

    int rok;
    while (true) {
        System.out.print("Zadaj rok narodenia: ");

        if (sc.hasNextInt()) {
            rok = sc.nextInt();

            if (rok > 1900 && rok < 2026) break;
            else System.out.println("Neplatny rok!");
        } else {
            System.out.println("Musis zadat cislo!");
            sc.next();
        }
    }

    s.pridaj(typ, meno, priezvisko, rok);
    break;
case 2:
s.vypisVsetkych();
break;
case 3:
System.out.print("Zadaj ID: ");
s.vyhladaj(sc.nextInt());
break;
case 4:
    System.out.print("Zadaj ID zamestnanca: ");
    int id1 = sc.nextInt();

    System.out.print("Zadaj ID kolegu: ");
    int id2 = sc.nextInt();

    System.out.print("Zadaj kvalitu (dobra/priemerna/zla): ");
    String kvalita = sc.next();

    s.pridajSpolupracu(id1, id2, kvalita);
    break;
case 5:
s.uloz();
break;
case 6:
s.nacitaj();
break;
case 7:
    System.out.println("DEBUG: spustam statistiku");
    s.statistika();
    break;
case 0:
return;
}}}}
}