package Model;

public class Factory {
    
    public Factory(){}

    public Aliado crearAliado(){
        return new Aliado();
    }
    public Enemigo crearEnemigo(){
        return new Enemigo();
    }
    
}
