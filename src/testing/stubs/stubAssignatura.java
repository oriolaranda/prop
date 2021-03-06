package testing.stubs;

import domini.Assignatura;

public class stubAssignatura extends Assignatura {
    public stubAssignatura() {
        super("Grau en Enginyeria Informatica", "PRO1", "inicial");
    }

    @Override
    public String getNomPlaEstudis() {
        return "Grau en Engineyria Informatica";
    }

    @Override
    public String getNom() {
        return "PRO1";
    }

    @Override
    public String getFase() {
        return "inicial";
    }

    @Override
    public String toString() {
        return "Grau en Enginyeria Informatica: PRO1 (inicial)";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
