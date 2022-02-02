package servlet.exceptions;

public class MagasinNotFoundException extends RuntimeException{

    public MagasinNotFoundException(){super("Le magasin désiré n'est pas disponible");}
}
