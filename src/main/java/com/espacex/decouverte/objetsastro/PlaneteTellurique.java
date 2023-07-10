package com.espacex.decouverte.objetsastro;


import com.espacex.decouverte.enginsspatiaux.Vaisseau;
import com.espacex.decouverte.enginsspatiaux.VaisseauDeGuerre;

public class PlaneteTellurique extends Planete implements Habitable {
    int totalVisiteurs;
    Vaisseau[][] vaisseauxAccostes;
    int tailleBaie;
//    int placeDisponible = tailleBaie;


    public PlaneteTellurique(String nom, int tailleBaie) {
        super(nom);
        this.vaisseauxAccostes = new Vaisseau[2][tailleBaie];
    }

    public boolean restePlaceDisponible(Vaisseau vaisseau) {
        int indexZone = 0;
        switch (vaisseau.type){
            case CARGO :
            case VAISSEAUMONDE :
                indexZone = 1;
        }
        for (int i = 0; i < vaisseauxAccostes[indexZone].length; i++) {
            if (vaisseauxAccostes[indexZone][i] == null) {
                return true;
            }
        }
        return false;
    }


    public void accueillirVaisseaux(Vaisseau... nouveauVaisseau) {

        for (int i = 0; i < nouveauVaisseau.length; i++) {
            int indexZone = 0;
            switch (nouveauVaisseau[i].type){
                case CARGO :
                case VAISSEAUMONDE :
                    indexZone = 1;
            }

            for (int j = 0; j < vaisseauxAccostes[indexZone].length; j++) {
                if(vaisseauxAccostes[indexZone][j] == null){
                    vaisseauxAccostes[indexZone][j] = nouveauVaisseau[i];
                    break;
                }
            }
            if (nouveauVaisseau[i] instanceof VaisseauDeGuerre) {
                ((VaisseauDeGuerre) nouveauVaisseau[i]).desactiverArmes();
            }

            totalVisiteurs += nouveauVaisseau[i].nbPassagers;
        }
//        placeDisponible--;
    }
}

