
package model;

public class Analytik extends Zamestnanec{
    public Analytik(int id,String m,String p,int r){
        super(id,m,p,r);
    }

    public void vykonajSchopnost(){
        System.out.println("Analyzujem spoluprace...");
    }
}
