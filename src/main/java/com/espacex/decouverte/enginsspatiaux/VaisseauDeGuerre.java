package com.espacex.decouverte.enginsspatiaux;

import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CHASSEUR;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.FREGATE;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CROISEUR;


public class VaisseauDeGuerre extends Vaisseau {

    public boolean armesDesactivees;
    private int tonnageEnExces;

    public VaisseauDeGuerre(TypeVaisseau type) {
        super(type);
        if (type == CHASSEUR) {
            tonnageMax = 0;
        } else if (type == FREGATE) {
            tonnageMax = 50;
        } else if (type == CROISEUR) {
            tonnageMax = 100;
        }
    }


    public void activerBouclier() {
        System.out.println("Activation du bouclier d'un vaisseau de type " + type);
        desactiverArmes();
    }


    @Override
    public void emporterCargaison(int cargaison) throws DepassementTonnageException {
        if (type == CHASSEUR) {
            throw new DepassementTonnageException(cargaison);
        } else if (nbPassagers < 12) {
            throw new DepassementTonnageException(cargaison);
        } else {
            int tonnagePassager = 2 * nbPassagers;
            int tonnageRestant = tonnageMax - tonnageActuel;
            int tonnageAConsiderer = (tonnagePassager < tonnageRestant ? tonnagePassager : tonnageRestant);

            if (cargaison > tonnageAConsiderer) {
                tonnageEnExces = cargaison - tonnageRestant;
                throw new DepassementTonnageException(tonnageEnExces);
            } else {
                tonnageActuel += cargaison;
            }
        }
    }


    public void attaque(Vaisseau vaisseauCible, String arme, int duree) {
        if (armesDesactivees) {
            System.out.println("Attaque impossible, l'armement est désactivé");
        } else {
            System.out.println("Un vaisseau de type " + type + " attaque un vaisseau de type " + vaisseauCible.type + " en utilisant l'arme " + arme + " pendant " + duree + " minutes.");
            vaisseauCible.resistanceDuBouclier = 0;
            vaisseauCible.blindage = vaisseauCible.blindage / 2;
        }
    }

    public void desactiverArmes() {
        System.out.println("Désactivation des armes d'un vaisseau de type " + this.type);
        armesDesactivees = !armesDesactivees;
    }
}
