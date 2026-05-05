package service;

import model.*;
import java.util.*;
import java.io.*;

public class ZamestnanecService {

    private Map<Integer, Zamestnanec> zoznam = new HashMap<>();
    private int id = 1;

    // PRIDANIE
    public void pridaj(String typ, String m, String p, int r){
        Zamestnanec z;

        if(typ.equals("analytik"))
            z = new Analytik(id++, m, p, r);
        else
            z = new BezpecnostnySpecialista(id++, m, p, r);

        zoznam.put(z.getId(), z);
        System.out.println("Pridany zamestnanec s ID: " + z.getId());
    }

    // VYPIS
    public void vypisVsetkych(){
        for(Zamestnanec z : zoznam.values()){
            z.vypisInfo();
        }
    }

    // VYHLADAVANIE
    public void vyhladaj(int id){
        Zamestnanec z = zoznam.get(id);

        if(z != null){
            z.vypisInfo();
        } else {
            System.out.println("Zamestnanec neexistuje");
        }
    }

    // SPOLUPRACA
    public void pridajSpolupracu(int id1, int id2, String kvalita){

        if(id1 == id2){
            System.out.println("Nemozes pridat spolupracu sam so sebou!");
            return;
        }

        if(zoznam.containsKey(id1) && zoznam.containsKey(id2)){
            zoznam.get(id1).pridajSpolupracu(zoznam.get(id2), kvalita);
            System.out.println("Spolupraca pridana");
        } else {
            System.out.println("Zle ID!");
        }
    }

    // ULOZENIE
    public void uloz(){
        try{
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("data.ser"));
            o.writeObject(zoznam);
            o.close();
            System.out.println("Ulozene");
        } catch(Exception e){
            System.out.println("Chyba pri ukladani");
        }
    }

    // NACITANIE
    public void nacitaj(){
        try{
            ObjectInputStream i = new ObjectInputStream(new FileInputStream("data.ser"));
            zoznam = (Map<Integer, Zamestnanec>) i.readObject();
            i.close();
            System.out.println("Nacitane: " + zoznam.size());
        } catch(Exception e){
            System.out.println("Subor neexistuje");
        }
    }

    // STATISTIKA
    public void statistika(){

        if(zoznam.isEmpty()){
            System.out.println("Ziadni zamestnanci");
            return;
        }

        Zamestnanec max = null;
        int maxP = -1;

        int dobra = 0;
        int priemerna = 0;
        int zla = 0;

        for(Zamestnanec z : zoznam.values()){

            int pocet = z.getSpoluprace().size();

            if(pocet > maxP){
                maxP = pocet;
                max = z;
            }

            for(Spolupraca s : z.getSpoluprace()){
                if(s.getKvalita().equals("dobra")) dobra++;
                else if(s.getKvalita().equals("priemerna")) priemerna++;
                else if(s.getKvalita().equals("zla")) zla++;
            }
        }

        System.out.println("Najviac spoluprac ma: " + max.getPriezvisko() + " (" + maxP + ")");

        if(dobra == 0 && priemerna == 0 && zla == 0){
            System.out.println("Ziadne spoluprace");
            return;
        }

        if(dobra >= priemerna && dobra >= zla)
            System.out.println("Najcastejsia kvalita: dobra");
        else if(priemerna >= dobra && priemerna >= zla)
            System.out.println("Najcastejsia kvalita: priemerna");
        else
            System.out.println("Najcastejsia kvalita: zla");
    }
}