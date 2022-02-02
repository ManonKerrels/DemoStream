package servlet.models;

public class Magasin {

    private int id;
    private String nom;
    private String rue;
    private String ville;
    private int codePostal;
    private int numero;
    private float superficie;
    private int produitDispo;

    public Magasin (int id, String nom, String rue, String ville, int codePostal, int numero, float superficie, int produitDispo){
        this.id = id;
        this.nom = nom;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.numero = numero;
        this.superficie = superficie;
        this.produitDispo = produitDispo;
    }

    public Magasin() {

    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public String getRue() {return rue;}
    public void setRue(String rue) {this.rue = rue;}

    public String getVille() {return ville;}
    public void setVille(String ville) {this.ville = ville;}

    public int getCodePostal() {return codePostal;}
    public void setCodePostal(int codePostal) {this.codePostal = codePostal;}

    public long getNumero() {return numero;}
    public void setNumero() {this.numero = numero;}

    public float getSuperficie() {return superficie;}
    public void setSuperficie(float superficie) {this.superficie = superficie;}

    public int getProduitDispo() {return produitDispo;}
    public void setProduitDispo(int produitDispo) {this.produitDispo = produitDispo;}

    @Override
    public String toString() {
        return "Magasin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal=" + codePostal +
                ", numero=" + numero +
                ", superficie=" + superficie +
                ", produitDispo=" + produitDispo +
                '}';
    }
}
