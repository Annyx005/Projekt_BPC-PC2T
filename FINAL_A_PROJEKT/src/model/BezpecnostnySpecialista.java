
package model;

public class BezpecnostnySpecialista extends Zamestnanec{
    public BezpecnostnySpecialista(int id,String m,String p,int r){
        super(id,m,p,r);
    }

    public void vykonajSchopnost(){
        System.out.println("Vyhodnocujem riziko...");
    }
}
