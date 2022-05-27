package Controller;

import Common.Constantes;
import View.Interfaz;

public class Controlador implements Constantes {
    public Controlador(){

    }
    public void setPersonajePrincipal(int fila, int columna,int direccion){
        switch(direccion){
            case ARRIBA:
                Interfaz.etiquetas[fila][columna].setIcon(ICONO_ARRIBA_PERSONAJE_PRINCIPAL);
                break;
            case ABAJO:
                Interfaz.etiquetas[fila][columna].setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
                break;
            case IZQUIERDA:
                Interfaz.etiquetas[fila][columna].setIcon(ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL);
                break;
            case DERECHA:
                Interfaz.etiquetas[fila][columna].setIcon(ICONO_DERECHA_PERSONAJE_PRINCIPAL);
                break;
        }
    }
    public void setEnemigo(int fila, int columna,int direccion){
        switch(direccion){
            case ARRIBA:
                Interfaz.etiquetas[fila][columna].setIcon(ICONO_ARRIBA_ENEMIGO);
                break;
            case ABAJO:
                Interfaz.etiquetas[fila][columna].setIcon(ICONO_ABAJO_ENEMIGO);
                break;
            case IZQUIERDA:
                Interfaz.etiquetas[fila][columna].setIcon(ICONO_IZQUIERDA_ENEMIGO);
                break;
            case DERECHA:
                Interfaz.etiquetas[fila][columna].setIcon(ICONO_DERECHA_ENEMIGO);
                break;
        }
    }
    public void setAliado(int fila, int columna){
        Interfaz.etiquetas[fila][columna].setIcon(ICONO_ALIADO);
    }
    public void resetEtiqueta(int fila,int columna){
        Interfaz.etiquetas[fila][columna].setBackground(COLOR_FONDO);
    }
    public void keyReleased(int codigoDeTecla){
        if(codigoDeTecla==IZQUIERDA){
            
        }
        if(codigoDeTecla==ARRIBA){
            
        }
        if(codigoDeTecla==DERECHA){
            
        }
        if(codigoDeTecla==ABAJO){
            
        }
        if(codigoDeTecla==ATACAR){
            
        }
    }

}
