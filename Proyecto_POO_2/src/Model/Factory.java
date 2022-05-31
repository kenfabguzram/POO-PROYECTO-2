package Model;


public class Factory implements Constantes {

    public Factory(){}

    public Observador crear(int codigo){
        switch(codigo){
            case ALIADO:
                return new Aliado();
            case ENEMIGO:
                return new Enemigo();
        }
        return null;
    }
}
