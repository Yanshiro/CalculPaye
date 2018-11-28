import Employe.Employe;

import java.util.HashSet;
import java.util.Set;

public  class EntrepriseJ {
    private final String name;
    private Set<Employe> employes;

    public EntrepriseJ(String name) {
        this.name = name;
        employes = new HashSet<Employe>();
    }

    public boolean addEmploye(Employe e) {
        return this.employes.add(e);
    }


    public void affichersalaire() {
        employes.stream()
                .forEach(employe -> System.out.println("" + employe.getNom() + ", salaire horaire" +
                        employe.getSalairehoraire() + "euros; heures travaillées "
                        + employe.getHorairehebdo() + ", salaires = " + employe.salairehebdomadaire()));
    }

    public static void main(String[] args) {
        try {
            System.out.println("Hello World!");
            EntrepriseJ entreprise = new EntrepriseJ("BNP");
            entreprise.addEmploye(new Employe("John", 17.5, 35));
            entreprise.addEmploye(new Employe("Cecile", 18.2, 47));
            entreprise.addEmploye(new Employe("Pierre", 15, 50));
            entreprise.addEmploye(new Employe("Laurent", 25, 60));
            entreprise.affichersalaire();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
