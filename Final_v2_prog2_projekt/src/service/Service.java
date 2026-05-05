
package service;
import java.util.*;
import model.*;
import java.util.*;
import java.io.*;

public class Service {

    private Map<Integer, Zamestnanec> zamestnanci = new HashMap<>();
    private int id = 1;

    public void pridaj(String typ, String m, String p, int r){
        Zamestnanec z;

        if(typ.equals("analytik"))
            z = new Analytik(id++, m, p, r);
        else
            z = new BezpecnostnySpecialista(id++, m, p, r);

        zamestnanci.put(z.getId(), z);
        System.out.println("Pridany zamestnanec, ID: " + z.getId());
    }

    public void vymaz(int id){
        if(zamestnanci.remove(id) != null)
        	System.out.println("Zamestnanec bol vymazany");
        else
            System.out.println("Neexistuje");
    }

    public void vypis(){

        List<Zamestnanec> list = new ArrayList<>(zamestnanci.values());

        list.sort((a, b) -> a.getPriezvisko().compareTo(b.getPriezvisko()));

        for(Zamestnanec z : list){
            z.vypis();
        }
    }

    public void vyhladaj(int id){
        Zamestnanec z = zamestnanci.get(id);
        if(z != null) z.vypis();
        else System.out.println("Nenasiel sa");
    }

    public void schopnost(int id){
        Zamestnanec z = zamestnanci.get(id);
        if(z != null) z.schopnost();
        else System.out.println("Nenasiel sa");
    }

    public void spolupraca(int a, int b, String kvalita){

        if(a == b){
            System.out.println("Nemozes pridat spolupracu sam so sebou!");
            return;
        }

        if(zamestnanci.get(a)!=null && zamestnanci.get(b)!=null){
            zamestnanci.get(a).pridajSpolupracu(zamestnanci.get(b), kvalita);
            System.out.println("Pridana spolupraca");
        } else {
            System.out.println("Zle ID");
        }
    }

    public void statistika(){
        Zamestnanec max = null;
        int maxP = -1;

        int dobra=0, priemerna=0, zla=0;

        for(Zamestnanec z : zamestnanci.values()){
            int p = z.getSpoluprace().size();

            if(p > maxP){
                maxP = p;
                max = z;
            }

            for(Spolupraca s : z.getSpoluprace()){
                if(s.getKvalita().equals("dobra")) dobra++;
                else if(s.getKvalita().equals("priemerna")) priemerna++;
                else zla++;
            }
        }

        if(max != null){
            System.out.println("Najviac spoluprac: " + max.getPriezvisko());
        }

        if(dobra >= priemerna && dobra >= zla)
            System.out.println("Najcastejsia kvalita: dobra");
        else if(priemerna >= dobra && priemerna >= zla)
            System.out.println("Najcastejsia kvalita: priemerna");
        else
            System.out.println("Najcastejsia kvalita: zla");
    }

    public void uloz(){
        try{
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("data.ser"));
            o.writeObject(zamestnanci);
            o.close();
            System.out.println("Ulozene");
        }catch(Exception e){
            System.out.println("Chyba");
        }
    }

    public void nacitaj(){
        try{
            ObjectInputStream i = new ObjectInputStream(new FileInputStream("data.ser"));
            zamestnanci = (Map<Integer, Zamestnanec>) i.readObject();
            i.close();
            System.out.println("Nacitane");
        }catch(Exception e){
            System.out.println("Subor nenajdeny");
        }
    }
}
