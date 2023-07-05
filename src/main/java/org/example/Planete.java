package org.example;

public class Planete {
    String nom;
    long diametre;
    String matiere;
    int totalVisiteurs;
    Atmosphere atmosphere;

    int revolution(int degres) {
        System.out.println("Je suis la planète " + nom + " et je tourne autour de mon étoile de " + degres + " degrés.");
        return degres / 360;
    }

    int rotation(int degres) {
        System.out.println("Je suis la planète " + nom + " et je tourne sur moi-même de " + degres + " degrés.");
        return degres / 360;
    }

    void accueillirVaisseau(int newHuman) {
        totalVisiteurs += newHuman;
    }

    void accueillirVaisseau(String vaisseau) {
        if (vaisseau.equalsIgnoreCase("CHASSEUR")) {
            totalVisiteurs += 3;
        } else if (vaisseau.equalsIgnoreCase("FREGATE")) {
            totalVisiteurs += 12;
        } else if (vaisseau.equalsIgnoreCase("CROISEUR")) {
            totalVisiteurs += 50;
        }
    }
}
