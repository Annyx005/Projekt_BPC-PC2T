
package main;

import service.Service;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Service s = new Service();

        while(true){
        	System.out.println("Vyber moznost:");
        	System.out.println("1 - Pridat zamestnanca");
        	System.out.println("2 - Vypisat zamestnancov");
        	System.out.println("3 - Vyhladat zamestnanca (zadaj ID)");
        	System.out.println("4 - Pridat spolupracu");
        	System.out.println("5 - Ulozit");
        	System.out.println("6 - Nacitat");
        	System.out.println("7 - Statistika");
        	System.out.println("8 - Zmazat zamestnanca (zadaj ID)");
        	System.out.println("9 - Spustit schopnost (zadaj ID)");
        	System.out.println("0 - Koniec");
            int c = sc.nextInt();

            switch(c){
            case 1:
                System.out.print("Zadaj typ (analytik/bezpecnost): ");
                String typ = sc.next();

                System.out.print("Zadaj meno: ");
                String meno = sc.next();

                System.out.print("Zadaj priezvisko: ");
                String priezvisko = sc.next();

                System.out.print("Zadaj rok narodenia: ");
                int rok = sc.nextInt();

                s.pridaj(typ, meno, priezvisko, rok);
                break;
                case 2:
                    s.vypis();
                    break;
                case 3:
                    System.out.print("Zadaj ID: ");
                    int id = sc.nextInt();
                    s.vyhladaj(id);
                    break;
                case 4:
                    System.out.print("Zadajte ID zamestnanca: ");
                    int a = sc.nextInt();

                    System.out.print("Zadajte ID kolegu: ");
                    int b = sc.nextInt();

                    System.out.print("Zadajte kvalitu (dobra/priemerna/zla): ");
                    String kvalita = sc.next();

                    s.spolupraca(a, b, kvalita);
                    break;
                case 5:
                    s.uloz();
                    break;
                case 6:
                    s.nacitaj();
                    break;
                case 7:
                    s.statistika();
                    break;
                case 8:
                    System.out.print("Zadajte ID zamestnanca na vymazanie: ");
                    int id8 = sc.nextInt();
                    s.vymaz(id8);
                    break;
                case 9:
                    System.out.print("Zadajte ID zamestnanca: ");
                    int id9 = sc.nextInt();
                    s.schopnost(id9);
                    break;
                case 0:
                    return;
            }
        }
    }
}
