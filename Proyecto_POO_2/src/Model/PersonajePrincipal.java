package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Common.Constantes;

public class PersonajePrincipal implements Observable, Serializable,Constantes{
    private int[] coords;
    private ArrayList<Observador> observadores;
    int vida;
    public PersonajePrincipal(){
        vida=CANTIDAD_INICIAL_VIDA;
        coords=new int[2];
        coords[X]=0;
        coords[Y]=0;
        observadores=new ArrayList<Observador>();
    }

    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
        
    }

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    @Override
    public void borrarObservador(Observador o) {
        observadores.remove(o);
        
    }

    @Override
    public void notificarObservadores() {
        for (Observador o:observadores){
            o.actualizar(coords);
        }
        
    }
}
