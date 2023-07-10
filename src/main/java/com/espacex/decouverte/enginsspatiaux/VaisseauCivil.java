package com.espacex.decouverte.enginsspatiaux;

import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CARGO;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.VAISSEAUMONDE;

public class VaisseauCivil extends Vaisseau {

    public int tonnageMax;
    public int tonnageEnExces;


    public VaisseauCivil(TypeVaisseau type) {
        super(type);
        if (type == CARGO) {
            tonnageMax = 500;
        } else if (type == VAISSEAUMONDE) {
            tonnageMax = 2000;
        }
    }


    public void emporterCargaison(int cargaison) throws DepassementTonnageException {
        int tonnageRestant = tonnageMax - tonnageActuel;
        if(cargaison > tonnageRestant){
            tonnageEnExces =  cargaison - tonnageRestant;
            throw new DepassementTonnageException(tonnageEnExces);
        } else {
            tonnageActuel += cargaison;
        }
    }
}
