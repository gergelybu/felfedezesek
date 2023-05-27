package felfedezesek;

public class Felfedezes {

    private String ev;
    private String elem;
    private String vegyjel;
    private int rendszam;
    private String felfedezo;

    public Felfedezes(String sor) {
        String[] s = sor.split(";");
        this.ev = s[0];
        this.elem = s[1];
        this.vegyjel = s[2];
        this.rendszam = Integer.parseInt(s[3]);
        this.felfedezo = s[4];
    }

    public Felfedezes(String ev, String elem, String vegyjel, int rendszam, String felfedezo) {
        this.ev = ev;
        this.elem = elem;
        this.vegyjel = vegyjel;
        this.rendszam = rendszam;
        this.felfedezo = felfedezo;
    }

    public String getEv() {
        return ev;
    }

    public String getElem() {
        return elem;
    }

    public String getVegyjel() {
        return vegyjel;
    }

    public int getRendszam() {
        return rendszam;
    }

    public String getFelfedezo() {
        return felfedezo;
    }

    @Override
    public String toString() {
        return "Felfedezes{" + "ev=" + ev + ", elem=" + elem + ", vegyjel=" + vegyjel + ", rendszam=" + rendszam + ", felfedezo=" + felfedezo + '}';
    }
    

}
