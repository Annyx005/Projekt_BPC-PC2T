
package model;

import java.io.Serializable;
import java.util.*;

public abstract class Zamestnanec implements Serializable {

    protected int id;
    protected String meno;
    protected String priezvisko;
    protected int rokNarodenia;

    protected List<Spolupraca> spoluprace = new ArrayList<>();

    public Zamestnanec(int id,String m,String p,int r){
        this.id=id;
        this.meno=m;
        this.priezvisko=p;
        this.rokNarodenia=r;
    }

    public int getId(){return id;}
    public String getPriezvisko(){return priezvisko;}

    public List<Spolupraca> getSpoluprace(){
        return spoluprace;
    }

    public abstract void vykonajSchopnost();

    public void pridajSpolupracu(Zamestnanec kolega, String kvalita){
        spoluprace.add(new Spolupraca(kolega, kvalita));
    }

    public void vypisInfo(){
        System.out.println(id+" "+meno+" "+priezvisko);
        System.out.println("Pocet spoluprac: "+spoluprace.size());
    }
}
