package Model;

import java.util.Random;

import Controller.Controlador;
import View.Interfaz;

public class Enemigo implements Observador,Constantes{
    private int[] currentPosition;
    private int[] lastPosition;
    private int direccion;
    Random random;
    public Enemigo(){
        currentPosition=new int[2];
        lastPosition=new int[2];
        random=new Random();
        do {
            currentPosition[X]=random.nextInt(TAMANIO_MAPA_FILAS-1 + 0 + 1 ) + 0;
            currentPosition[Y]=random.nextInt(TAMANIO_MAPA_COLUMNAS-1 + 0 + 1 ) + 0;
        }
        while(Interfaz.etiquetas[currentPosition[X]][currentPosition[Y]].getIcon()!=null);
        direccion=ARRIBA;
        
    }
    
    public int[] getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int[] currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int[] getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(int[] lastPosition) {
        this.lastPosition = lastPosition;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void actualizar() {
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
        Random random = new Random();
        int rand = random.nextInt(1 + 0 + 1 ) + 0;
    
        if(Controlador.personaje.getCoords()[X] != currentPosition[X]){
            if(Controlador.personaje.getCoords()[Y] != currentPosition[Y]){
                if(rand==0){
                    currentPosition[X] += (Controlador.personaje.getCoords()[X]-currentPosition[X])/Math.abs(Controlador.personaje.getCoords()[X]-currentPosition[X]);
                    direccion=lastPosition[X]<currentPosition[X]?ABAJO:ARRIBA;
                }
                else{
                    currentPosition[Y] += (Controlador.personaje.getCoords()[Y]-currentPosition[Y])/Math.abs(Controlador.personaje.getCoords()[Y]-currentPosition[Y]);
                    direccion=lastPosition[Y]<currentPosition[Y]?DERECHA:IZQUIERDA;
                }
            }
            
            else{
                currentPosition[X] += (Controlador.personaje.getCoords()[X]-currentPosition[X])/Math.abs(Controlador.personaje.getCoords()[X]-currentPosition[X]);
                direccion=lastPosition[X]<currentPosition[X]?ABAJO:ARRIBA;
            }
        }
        else if(Controlador.personaje.getCoords()[Y] != currentPosition[Y]){
                currentPosition[Y] += (Controlador.personaje.getCoords()[Y]-currentPosition[Y])/Math.abs(Controlador.personaje.getCoords()[Y]-currentPosition[Y]);
                direccion=lastPosition[Y]<currentPosition[Y]?DERECHA:IZQUIERDA;
            }
        if(currentPosition[X]==Controlador.personaje.getCoords()[X] & currentPosition[Y]==Controlador.personaje.getCoords()[Y]){
            Controlador.personaje.reducirVida();
            Controlador.enemigosEliminar.add(this);
        }
        
    }


}
