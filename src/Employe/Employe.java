package Employe;

import java.io.ObjectStreamClass;
import java.util.Objects;

public class Employe {

    private final String nom;
    private double salairehoraire;
    private double horairehebdo;
    private static final double CONST=1.5;

    public Employe(String nom, double salairehoraire,double horairehebdo)throws RuntimeException {
        Objects.requireNonNull(nom);
        Objects.requireNonNull(salairehoraire);
        Objects.requireNonNull(horairehebdo);

        if(salairehoraire<13) throw new IllegalArgumentException("Salaire horaire trop bas");
        if(horairehebdo>60) throw new IllegalArgumentException("60 heures dépassées");
        this.nom = nom;
        this.salairehoraire = salairehoraire;
        this.horairehebdo = horairehebdo;
    }

    public double salairehebdomadaire() {
        double salaire = 0;
        if (horairehebdo > 40) {
            salaire = salairehoraire * 40 + CONST * (horairehebdo - 40);
        } else {
            salaire = salairehoraire * horairehebdo;
        }
        return salaire;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Double.compare(employe.salairehoraire, salairehoraire) == 0 &&
                Double.compare(employe.horairehebdo, horairehebdo) == 0 &&
                Objects.equals(nom, employe.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, salairehoraire, horairehebdo);
    }

    public double getSalairehoraire() {
        return salairehoraire;
    }

    public double getHorairehebdo() {
        return horairehebdo;
    }
}
