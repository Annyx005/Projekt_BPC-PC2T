
package model;

import java.io.Serializable;

public class Spolupraca implements Serializable {

    private Zamestnanec kolega;
    private String kvalita;

    public Spolupraca(Zamestnanec k, String kvalita){
        this.kolega = k;
        this.kvalita = kvalita;
    }

    public String getKvalita(){ return kvalita; }
}
