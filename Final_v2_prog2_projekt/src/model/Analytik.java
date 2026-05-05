
package model;

public class Analytik extends Zamestnanec {

    public Analytik(int id, String m, String p, int r){
        super(id, m, p, r);
    }

    public void schopnost(){
        System.out.println("Typ: Analytik");
        System.out.println("Analyzujem spoluprace...");
        System.out.println("Pocet spoluprac: " + spoluprace.size());
    }
}
