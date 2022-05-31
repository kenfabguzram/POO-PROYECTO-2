package Model;

import java.util.Random;

import Controller.Controlador;
import View.Interfaz;

public class Aliado implements Observador,Constantes{
    private int[] currentPosition;
    private boolean visible;
    Random random;
    public Aliado(){
        currentPosition=new int[2];
        random=new Random();
        do {
            currentPosition[X]=random.nextInt(TAMANIO_MAPA_FILAS-1 + 0 + 1 ) + 0;
            currentPosition[Y]=random.nextInt(TAMANIO_MAPA_COLUMNAS-1 + 0 + 1 ) + 0;
        }
        while(Interfaz.etiquetas[currentPosition[X]][currentPosition[Y]].getIcon()!=null);
        setVisible(false);
        actualizar();
        
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int[] getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int[] currentPosition) {
        this.currentPosition = currentPosition;
    }
    public void actualizar(){
        if(Controlador.personaje.getCoords()[X]==getCurrentPosition()[X] & Controlador.personaje.getCoords()[Y]==getCurrentPosition()[Y]){
            setVisible(false);
            Controlador.personaje.agregarVida();
            Controlador.aliadosEliminar.add(this);
        }
        else if(Math.abs(Controlador.personaje.getCoords()[X]-getCurrentPosition()[X])<RANGO_APARICION_ALIADO & Math.abs(Controlador.personaje.getCoords()[Y]-getCurrentPosition()[Y])<RANGO_APARICION_ALIADO){
            setVisible(true);
        }
        else{
            setVisible(false);
        }
    }
}
