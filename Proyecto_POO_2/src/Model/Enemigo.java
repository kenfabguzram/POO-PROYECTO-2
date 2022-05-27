package Model;
import java.util.Random;
import Common.Constantes;

public class Enemigo implements Observador,Constantes{
    public int[] currentPosition;
    public int[] lastPosition;
    public int direccion;
    PersonajePrincipal personaje;
    Random random;
    public Enemigo(){
        currentPosition=new int[2];
        currentPosition[X]=0;
        currentPosition[Y]=0;
        direccion=ARRIBA;
        
    }

    public void actualizar(int[] coords) {
        personaje.setCoords(coords);
        
    }
    public void move(){
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
        Random random = new Random(0);
        int rand = random.nextInt(1 + 0) + 1;
    
        if(personaje.getCoords()[X] != currentPosition[X]){
            if(personaje.getCoords()[Y] != currentPosition[Y]){
                if(rand==0)
                    currentPosition[X] += (personaje.getCoords()[X]-currentPosition[X])/Math.abs(personaje.getCoords()[X]-currentPosition[X]);
                else
                    currentPosition[Y] += (personaje.getCoords()[Y]-currentPosition[Y])/Math.abs(personaje.getCoords()[Y]-currentPosition[Y]);
            }
            else{
                currentPosition[X] += (personaje.getCoords()[X]-currentPosition[X])/Math.abs(personaje.getCoords()[X]-currentPosition[X]);
            }
        }
        else{
            if(personaje.getCoords()[Y] != currentPosition[Y]){
                currentPosition[Y] += (personaje.getCoords()[Y]-currentPosition[Y])/Math.abs(personaje.getCoords()[Y]-currentPosition[Y]);
            }
            else{
                
            }
        }
    }
}
