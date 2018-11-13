package domini;

import java.util.Objects;

public class Sessio {
    private String nomAssig;
    private int numG;
    private int numS;


    public Sessio(String nomAssig, int numG,int numS) {
        this.nomAssig = nomAssig;
        this.numG = numG;
        this.numS = numS;
    }

    public Sessio(String id, int num) {
        this.numS = num;
        this.nomAssig = id.split("-")[0];
        this.numG = Integer.parseInt(id.split("-")[1]);
    }

    /* GETTERS */

    public String getNomAssig() {
        return nomAssig;
    }

    public int getNumG() {
        return numG;
    }

    public int getNumS() {
        return numS;
    }


    /*SETTERS */

    public void setId(String nomAssig) {
        this.nomAssig = nomAssig;
    }

    public void setNumG(int num) {
        this.numG = numG;
    }

    public void setNumS(int numS) {
        this.numS = numS;
    }
    @Override
    public String toString() {
        return nomAssig+"-"+numG + "[" + numS + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (! (obj instanceof Sessio)) return false;

        Sessio s = (Sessio) obj;
        return this.nomAssig.equals(s.nomAssig) && this.numG == s.numG && this.numS == s.numS;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomAssig,numG,numS);
    }
}
