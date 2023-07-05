package org.example;

public class HelloUniverse {

    public static void main(String... args) {
        Planete mercure = new Planete();
        mercure.nom = "Mercure";
        mercure.diametre = 4880;
        mercure.matiere = "Tellurique";

        Planete venus = new Planete();
        venus.nom = "Venus";
        venus.diametre = 12100;
        venus.matiere = "Tellurique";

        Planete terre = new Planete();
        terre.nom = "Terre";
        terre.diametre = 12756;
        terre.matiere = "Tellurique";

        Planete mars = new Planete();
        mars.nom = "Mars";
        mars.diametre = 6792;
        mars.matiere = "Tellurique";

        Planete jupiter = new Planete();
        jupiter.nom = "Jupiter";
        jupiter.diametre = 142984;
        jupiter.matiere = "Gazeuse";

        Planete saturne = new Planete();
        saturne.nom = "Saturne";
        saturne.diametre = 120536;
        saturne.matiere = "Gazeuse";

        Planete uranus = new Planete();
        uranus.nom = "Uranus";
        uranus.diametre = 51118;
        uranus.matiere = "Gazeuse";
        Atmosphere atmosphere = new Atmosphere();
        uranus.atmosphere = atmosphere;
        uranus.atmosphere.hydrogene = 83.0f;
        uranus.atmosphere.helium = 15.0f;
        uranus.atmosphere.methane = 2.5f;

        Planete neptune = new Planete();
        neptune.nom = "Neptune";
        neptune.diametre = 49532;
        neptune.matiere = "Gazeuse";

        Planete planeteX = new Planete();

        System.out.println(planeteX.nom + " est une planète " + planeteX.matiere + " avec un diamètre de " + planeteX.diametre + " kilomètres.");

        neptune.revolution(-3542);
        mars.rotation(-684);
        venus.rotation(1250);

        mars.accueillirVaisseau(8);
        mars.accueillirVaisseau("FREGATE");
        System.out.printf("Le nombre d'humains ayant déjà séjourné sur %s est actuellement de %s.", mars.nom, mars.totalVisiteurs);

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
    }
}
