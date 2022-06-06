package Model;

import java.util.ArrayList;



public class PersonajePrincipal implements Constantes{
    private int[] coords;
    private int[] oldCoords;
    private ArrayList<Observador> observadores;
    private int vida;
    private int direccion;
    public PersonajePrincipal(){
        setVida(CANTIDAD_INICIAL_VIDA);
        coords=new int[2];
        oldCoords=new int[2];
        coords[X]=0;
        coords[Y]=0;
        oldCoords[X]=0;
        oldCoords[Y]=0;
        direccion=ABAJO;
        observadores=new ArrayList<Observador>();
    }
    public void agregarVida(){
        vida++;
    }
    public int getObserversSize(){
        return observadores.size();
    }
    public int[] getOldCoords() {
        return oldCoords;
    }
    public void setOldCoords(int[] oldCoords) {
        this.oldCoords = oldCoords;
    }
    public void move(){
        switch(direccion){
            case ARRIBA:
                oldCoords[X]=coords[X];
                coords[X]=coords[X]-1;
                notificarObservadores();
                break;
            case ABAJO:
                oldCoords[X]=coords[X];
                coords[X]=coords[X]+1;
                
                notificarObservadores();
                break;
            case IZQUIERDA:
                oldCoords[Y]=coords[Y];
                coords[Y]=coords[Y]-1;
                notificarObservadores();
                break;
            case DERECHA:  
                oldCoords[Y]=coords[Y];
                coords[Y]=coords[Y]+1;
                notificarObservadores();
                break;
        }
    }
    public int getDireccion() {
        return direccion;
    }
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void agregarObservador(Observador o) {
        observadores.add(o);
        
    }
    public void reducirVida(){
        vida--;
    }
    public int[] getCoords() {
        return coords;
    }
    public void setCoords(int[] coords) {
        this.coords = coords;
    }
    public void borrarObservador(Observador o) {
        observadores.remove(o);
        
    }
    public void notificarObservadores() {
        for (Observador o:observadores){
            o.actualizar();
        }  
    }
}
