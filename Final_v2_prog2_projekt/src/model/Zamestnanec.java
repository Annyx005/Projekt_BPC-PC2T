
package model;

import java.io.Serializable;
import java.util.*;

public abstract class Zamestnanec implements Serializable {

    protected int id;
    protected String meno;
    protected String priezvisko;
    protected int rok;

    protected List<Spolupraca> spoluprace = new ArrayList<>();

    public Zamestnanec(int id, String meno, String priezvisko, int rok){
        this.id = id;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.rok = rok;
    }

    public int getId(){ return id; }
    public String getPriezvisko(){ return priezvisko; }
    public List<Spolupraca> getSpoluprace(){ return spoluprace; }

    public void pridajSpolupracu(Zamestnanec z, String kvalita){
        spoluprace.add(new Spolupraca(z, kvalita));
    }
    	public void vypis(){
    	    System.out.println(id + " " + meno + " " + priezvisko + " (" + this.getClass().getSimpleName() + ")");
    	    System.out.println("Spoluprace: " + spoluprace.size());

    }

    public abstract void schopnost();
}
