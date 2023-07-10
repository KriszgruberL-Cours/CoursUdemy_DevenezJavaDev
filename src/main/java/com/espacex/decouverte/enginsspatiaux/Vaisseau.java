package com.espacex.decouverte.enginsspatiaux;

public abstract class Vaisseau {
    public final TypeVaisseau type;
    public int nbPassagers;
    public int blindage;
    public int resistanceDuBouclier;
    public int tonnageMax;
    protected int tonnageActuel = 0 ;

    public Vaisseau(TypeVaisseau type) {
        this.type = type;
    }

    public void activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type " + type);
    }

    public abstract void emporterCargaison(int tonnage) throws DepassementTonnageException;

    public void desactiverBouclier(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type " + type);
    }
}
