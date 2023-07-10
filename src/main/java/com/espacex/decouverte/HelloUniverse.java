package com.espacex.decouverte;

import com.espacex.decouverte.enginsspatiaux.*;
import com.espacex.decouverte.objetsastro.*;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CHASSEUR;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.FREGATE;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CROISEUR;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CARGO;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.VAISSEAUMONDE;

public class HelloUniverse {

    public static void main(String... args) {

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 1);
        mercure.diametre = 4880;
        mercure.distanceEtoile = 57.9f;

        PlaneteTellurique venus = new PlaneteTellurique("Venus", 0);
        venus.diametre = 12100;
        venus.distanceEtoile = 108.2f;


        PlaneteTellurique terre = new PlaneteTellurique("Terre", 10);
        terre.diametre = 12756;
        terre.distanceEtoile = 149.6f;


        PlaneteTellurique mars = new PlaneteTellurique("Mars", 2);
        mars.diametre = 6792;
        mars.distanceEtoile = 227.9f;

        mars.atmosphere = new Atmosphere();
        mars.atmosphere.constituants.put("CO2", 95.00f);
        mars.atmosphere.constituants.put("N2", 3.00f);
        mars.atmosphere.constituants.put("AR", 1.50f);
        mars.atmosphere.constituants.put("NO", 0.013f);

        System.out.println("L'atmosphère de Mars est constituée de :");
        for (Map.Entry<String, Float> entry : mars.atmosphere.constituants.entrySet()) {
            String key = entry.getKey();
            Float value = entry.getValue();
            System.out.println(value + "% de " + key);
        }


        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        jupiter.distanceEtoile = 778.3f;


        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        saturne.distanceEtoile = 1427.0f;


        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.distanceEtoile = 2877.38f;

        uranus.atmosphere = new Atmosphere();
        uranus.atmosphere.hydrogene = 83.0f;
        uranus.atmosphere.helium = 15.0f;
        uranus.atmosphere.methane = 2.5f;
        uranus.atmosphere.azote = 0.0f;

        System.out.println(
                "\n" +
                        "L'atmosphère de " + uranus.nom + " est composée :\n" +
                        "        A " + uranus.atmosphere.hydrogene + "% d'hydrogène\n" +
                        "        A " + uranus.atmosphere.argon + "% d'argon\n" +
                        "        A " + uranus.atmosphere.dioxide + "% de dioxyde de carbone\n" +
                        "        A " + uranus.atmosphere.azote + "% d'azote\n" +
                        "        A " + uranus.atmosphere.helium + "% d'hélium\n" +
                        "        A " + uranus.atmosphere.methane + "% de méthane\n" +
                        "        A " + uranus.atmosphere.sodium + "% de sodium"
        );

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        neptune.distanceEtoile = 4497.07f;


        Galaxie systemeSolaire = new Galaxie();
        systemeSolaire.planetes.add(mercure);
        systemeSolaire.planetes.add(mars);
        systemeSolaire.planetes.add(terre);
        systemeSolaire.planetes.add(venus);
        systemeSolaire.planetes.add(jupiter);
        systemeSolaire.planetes.add(uranus);
        systemeSolaire.planetes.add(saturne);
        systemeSolaire.planetes.add(neptune);

        for (Planete p : systemeSolaire.planetes) {
            System.out.println(p.nom);
            System.out.println(p.distanceEtoile);
        }


        Vaisseau chasseur = new VaisseauDeGuerre(CHASSEUR);
        chasseur.nbPassagers = 3;
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau croiseur = new VaisseauDeGuerre(CROISEUR);
        croiseur.nbPassagers = 35;
        croiseur.blindage = 851;
        croiseur.resistanceDuBouclier = 25;

        Vaisseau fregate = new VaisseauDeGuerre(FREGATE);
        fregate.nbPassagers = 100;
        fregate.blindage = 542;
        fregate.resistanceDuBouclier = 50;

        Vaisseau cargo = new VaisseauCivil(CARGO);
        cargo.nbPassagers = 10000;
        cargo.blindage = 1520;
        cargo.resistanceDuBouclier = 20;

        Vaisseau vaisseauMonde = new VaisseauCivil(VAISSEAUMONDE);
        vaisseauMonde.nbPassagers = 10000;
        vaisseauMonde.blindage = 4784;
        vaisseauMonde.resistanceDuBouclier = 30;

        Vaisseau guerre = new VaisseauDeGuerre(CHASSEUR);
        Vaisseau guerre2 = new VaisseauDeGuerre(CHASSEUR);
        Vaisseau cargo2 = new VaisseauCivil(CARGO);

        terre.accueillirVaisseaux(guerre, guerre2, cargo2);
        System.out.println("ajout vaisseaux ");


        Scanner sc = new Scanner(System.in);
        boolean recommencer = true;
        while (recommencer) {
            System.out.println("Quel vaisseau souhaitez vous manipuler: " + CHASSEUR.name() + ", " + FREGATE.name() + ", " + CROISEUR.name() + ", " + CARGO.name() + " ou " + VAISSEAUMONDE.name() + " ?");
            String typeVaisseauString = sc.nextLine().toUpperCase().trim();
            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(typeVaisseauString);
            Vaisseau vaisseauSelectionne = null;
            switch (typeVaisseau) {
                case CHASSEUR:
                    vaisseauSelectionne = chasseur;
                    break;
                case FREGATE:
                    vaisseauSelectionne = fregate;
                    break;
                case CROISEUR:
                    vaisseauSelectionne = croiseur;
                    break;
                case CARGO:
                    vaisseauSelectionne = cargo;
                    break;
                case VAISSEAUMONDE:
                    vaisseauSelectionne = vaisseauMonde;
                    break;
            }

            System.out.println("Sur quelle planète du systeme solaire voulez-vous vous poser ?");
            int i = 0;
            for (Planete s : systemeSolaire.planetes) {
                System.out.println(i + ". " + s.nom);
                i++;
            }
            int planete = sc.nextInt();
            PlaneteTellurique planeteSelectionnee = null;
            switch (planete) {
                case 0:
                    planeteSelectionnee = mercure;
                    break;
                case 1:
                    planeteSelectionnee = venus;
                    break;
                case 2:
                    planeteSelectionnee = terre;
                    break;
                case 3:
                    planeteSelectionnee = mars;
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    System.out.println("Impossible de se poser sur une planète gazeuse");
                    continue;
            }


            Integer tonnageSouhaite = null;
            while (true) {
                System.out.println("Quel tonnage souhaitez-vous emporter ?");
                try {
                    tonnageSouhaite = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Le tonnage n'est pas un numérique");
                }


                if (planeteSelectionnee.restePlaceDisponible(vaisseauSelectionne)) {
                    planeteSelectionnee.accueillirVaisseaux(vaisseauSelectionne);

                    try {
                        vaisseauSelectionne.emporterCargaison(tonnageSouhaite);
                    } catch (DepassementTonnageException e) {
                        System.out.println("Le vaisseau a rejeté : " + e.tonnageEnExces + " tonnes.");
                        System.out.println("Voulez-vous emporter un tonnage partiel de" + (tonnageSouhaite - e.tonnageEnExces + " ? (oui/non)"));
                        String response = sc.nextLine();

                        if (response.equals("oui")) {
                            try {
                                vaisseauSelectionne.emporterCargaison(tonnageSouhaite - e.tonnageEnExces);
                            } catch (DepassementTonnageException ex) {
                                System.out.println("Erreur innatendue");
                            }
                        } else {
                            System.out.println("Opération annulée");
                        }
                    }

                } else {
                    System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place dans la baie.");
                }

                sc.nextLine();
                System.out.println("Voulez-vous recommencer oui/non ?");

                recommencer = sc.nextLine().equals("oui");


            }
        }
    }
}

