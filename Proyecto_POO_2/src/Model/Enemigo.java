package Model;
import java.util.Random;

import View.Interfaz;

public class Enemigo implements Observador,Constantes{
    private int[] currentPosition;
    private int[] lastPosition;
    private int direccion;
    PersonajePrincipal personaje;
    Random random;
    public Enemigo(){
        personaje=new PersonajePrincipal();
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

    public void actualizar(int[] coords) {
        personaje.setCoords(coords);
        move();
        
    }
    public void move(){
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
        Random random = new Random();
        int rand = random.nextInt(1 + 0 + 1 ) + 0;
    
        if(personaje.getCoords()[X] != currentPosition[X]){
            if(personaje.getCoords()[Y] != currentPosition[Y]){
                if(rand==0){
                    currentPosition[X] += (personaje.getCoords()[X]-currentPosition[X])/Math.abs(personaje.getCoords()[X]-currentPosition[X]);
                    direccion=lastPosition[X]<currentPosition[X]?ABAJO:ARRIBA;
                }
                else{
                    currentPosition[Y] += (personaje.getCoords()[Y]-currentPosition[Y])/Math.abs(personaje.getCoords()[Y]-currentPosition[Y]);
                    direccion=lastPosition[Y]<currentPosition[Y]?DERECHA:IZQUIERDA;
                }
            }
            
            else{
                currentPosition[X] += (personaje.getCoords()[X]-currentPosition[X])/Math.abs(personaje.getCoords()[X]-currentPosition[X]);
                direccion=lastPosition[X]<currentPosition[X]?ABAJO:ARRIBA;
            }
        }
        else{
            if(personaje.getCoords()[Y] != currentPosition[Y]){
                currentPosition[Y] += (personaje.getCoords()[Y]-currentPosition[Y])/Math.abs(personaje.getCoords()[Y]-currentPosition[Y]);
                direccion=lastPosition[Y]<currentPosition[Y]?DERECHA:IZQUIERDA;
            }
            else{
                
            }
        }

    }
}
