package Modele;

public class Cles {
    // Attribut
    private ElementArtefact elementOfKey;
    static Cles CLEAIR = new Cles(ElementArtefact.AIR);
    static Cles CLEFEU = new Cles(ElementArtefact.FEU);
    static  Cles CLEEAU = new Cles(ElementArtefact.EAU);
    static Cles CLETERRE = new Cles(ElementArtefact.TERRE);

    // Constructeur
    public Cles(ElementArtefact element) { this.elementOfKey = element; }

    // Methodes
    public ElementArtefact getElementOfKey() { return elementOfKey; }


}
