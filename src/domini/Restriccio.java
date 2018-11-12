package domini;

import java.util.Map;

public abstract class Restriccio {
    private String id;

    //Constructoras
    public Restriccio() {
        id = null;
    }

    public Restriccio(String i) {
        id = i;
    }

    //Getters
    public String getId() {
        return id;
    }

    //Setters
    public void setId(String i) {
        id = i;
    }
    /*public void setHorari(String horari) {this.horari=horari;}

     public void afegirHorari(Horari h) throws HorariJaExisteix {
        for(int i =0;i<horari.size();++i){
            if(horari.get(i).equals(h)) horari.add(h);
            //else throw new HorariJaExisteix();
        }
    } */

    public abstract Boolean esCompleix(Map<Classe, Sessio> nou);
}
