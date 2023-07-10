package com.espacex.decouverte.objetsastro;

import java.util.Objects;

public abstract class Planete implements Comparable<Planete> {
    public String nom;
    public int diametre;
    public Atmosphere atmosphere;
    public float distanceEtoile;

    public static String forme="Sphérique";
    public static int nbPlanetesDecouvertes = 0;

    public Planete(String nom) {
        this.nom = nom;
        nbPlanetesDecouvertes++;
    }

    public static String expansion(double distance){
        if(distance < 14){
            return "Oh la la mais c'est super rapide !";
        } else {
            return "Je rêve ou c'est plus rapide que la lumière ?";
        }
    }

    public final int revolution(int degres){
        System.out.println("Je suis la planète "+nom+" et je tourne autour de mon étoile de "+degres+" degrés.");
        return degres/360;
    }

    public final int rotation(int degres){
        System.out.println("Je suis la planète "+nom+" et je tourne sur moi-même de "+degres+" degrés.");
        return degres/360;
    }

    @Override
    public int compareTo(Planete p) {
        Planete autreDistance = p;
        int result = 0;
        if (this.distanceEtoile > autreDistance.distanceEtoile) result = 1;
        if(this.distanceEtoile < autreDistance.distanceEtoile) result = -1;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planete planete = (Planete) o;

        if (diametre != planete.diametre) return false;
        if (Float.compare(planete.distanceEtoile, distanceEtoile) != 0) return false;
        if (!Objects.equals(nom, planete.nom)) return false;
        return Objects.equals(atmosphere, planete.atmosphere);
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + diametre;
        result = 31 * result + (atmosphere != null ? atmosphere.hashCode() : 0);
        result = 31 * result + (distanceEtoile != +0.0f ? Float.floatToIntBits(distanceEtoile) : 0);
        return result;
    }
}
