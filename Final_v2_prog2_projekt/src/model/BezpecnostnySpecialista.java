
package model;

public class BezpecnostnySpecialista extends Zamestnanec {

    public BezpecnostnySpecialista(int id, String m, String p, int r){
        super(id, m, p, r);
    }

    public void schopnost(){
        System.out.println("Typ: Bezpecnostny specialista");
        System.out.println("Vyhodnocujem riziko...");
        System.out.println("Pocet spoluprac: " + spoluprace.size());
    }
}
