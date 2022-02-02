package streams.exo.models;

public class Magasin {

    private String nom;
    private String rue;
    private String ville;
    private int codePostal;
    private long numero;
    private float superficie;
    private int produitDispo;

    public Magasin (String nom, String rue, String ville, int codePostal, long numero, float superficie, int produitDispo){
        this.nom = nom;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.numero = numero;
        this.superficie = superficie;
        this.produitDispo = produitDispo;
    }


    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public String getRue() {return rue;}
    public void setRue(String rue) {this.rue = rue;}

    public String getVille() {return ville;}
    public void setVille(String ville) {this.ville = ville;}

    public int getCodePostal() {return codePostal;}
    public void setCodePostal(int codePostal) {this.codePostal = codePostal;}

    public long getNumero() {return numero;}
    public void setNumero(long numero) {this.numero = numero;}

    public float getSuperficie() {return superficie;}
    public void setSuperficie(float superficie) {this.superficie = superficie;}

    public int getProduitDispo() {return produitDispo;}
    public void setProduitDispo(int produitDispo) {this.produitDispo = produitDispo;}
}
