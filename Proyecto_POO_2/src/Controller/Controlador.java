package Controller;

import javax.swing.JLabel;

import Common.Constantes;
import Model.PersonajePrincipal;
import View.Interfaz;

public class Controlador implements Constantes {
    public static PersonajePrincipal personaje;
    private JLabel currentEtiqueta;
    private JLabel lastEtiqueta;
    public Controlador(){
        personaje=new PersonajePrincipal();
        personaje.setDireccion(ABAJO);
        currentEtiqueta=Interfaz.etiquetas[personaje.getCoords()[X]][personaje.getCoords()[Y]];
        lastEtiqueta=Interfaz.etiquetas[personaje.getOldCoords()[X]][personaje.getOldCoords()[Y]];
        currentEtiqueta.setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
    }

    private void moveWithValidation(){
        switch(personaje.getDireccion()){
            case ARRIBA:
                if(personaje.getCoords()[X]>0){
                    personaje.move();
                }
                break;
            case ABAJO:
                if(personaje.getCoords()[X]<TAMANIO_MAPA_FILAS-1){
                    personaje.move();
                }
                break;
            case IZQUIERDA:
                if(personaje.getCoords()[Y]>0){
                    personaje.move();
                }
                break;
            case DERECHA:
                if(personaje.getCoords()[Y]<TAMANIO_MAPA_COLUMNAS-1){
                    personaje.move();
                }
                break;
        }
        currentEtiqueta=Interfaz.etiquetas[personaje.getCoords()[X]][personaje.getCoords()[Y]];
        lastEtiqueta=Interfaz.etiquetas[personaje.getOldCoords()[X]][personaje.getOldCoords()[Y]];
        lastEtiqueta.setIcon(null);
    }
    public int getLastDirection(){
        return personaje.getDireccion();
    }
    public void pintarCurrentEtiqueta(){
        switch(personaje.getDireccion()){
            case ARRIBA:
                    currentEtiqueta.setIcon(ICONO_ARRIBA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                    break;
            case ABAJO:
                    currentEtiqueta.setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                    break;
            case IZQUIERDA:
                    currentEtiqueta.setIcon(ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                    break;
            case DERECHA:
                    currentEtiqueta.setIcon(ICONO_DERECHA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                    break;
        }
    }
    private void despintarCurrentEtiqueta(){
        currentEtiqueta=Interfaz.etiquetas[personaje.getCoords()[X]][personaje.getCoords()[Y]];
        currentEtiqueta.setIcon(null);
        currentEtiqueta.setBackground(COLOR_FONDO);
        currentEtiqueta.revalidate();
        currentEtiqueta.repaint();
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
    public void keyReleased(int codigoDeTecla){
        switch(codigoDeTecla){
            case ARRIBA:
                if(personaje.getDireccion()!=ARRIBA){
                    personaje.setDireccion(ARRIBA);
                    currentEtiqueta.setIcon(ICONO_ARRIBA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                else{
                    despintarCurrentEtiqueta();
                    moveWithValidation();
                    pintarCurrentEtiqueta();
                }
                    
                break;
            case ABAJO:
                if(personaje.getDireccion()!=ABAJO){
                    personaje.setDireccion(ABAJO);
                    currentEtiqueta.setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                else{
                    despintarCurrentEtiqueta();
                    moveWithValidation();
                    
                    pintarCurrentEtiqueta();
                }
                break;
            case IZQUIERDA:
                if(personaje.getDireccion()!=IZQUIERDA){
                    personaje.setDireccion(IZQUIERDA);
                    currentEtiqueta.setIcon(ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                else{
                    despintarCurrentEtiqueta();
                    moveWithValidation();
                   
                    pintarCurrentEtiqueta();
                }
                break;
            case DERECHA:
                if(personaje.getDireccion()!=DERECHA){
                    personaje.setDireccion(DERECHA);
                    currentEtiqueta.setIcon(ICONO_DERECHA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                else{
                    despintarCurrentEtiqueta();
                    moveWithValidation();
                    
                    pintarCurrentEtiqueta();
                }
                break;
            case ATACAR:
                if(personaje.getDireccion()==DERECHA){
                    currentEtiqueta.setIcon(ICONO_DERECHA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                if(personaje.getDireccion()==IZQUIERDA){
                    currentEtiqueta.setIcon(ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                if(personaje.getDireccion()==ARRIBA){
                    currentEtiqueta.setIcon(ICONO_ARRIBA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                if(personaje.getDireccion()==ABAJO){
                    currentEtiqueta.setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                break;
        }
    }
    public void keyPressed(int codigoDeTecla){
        if(codigoDeTecla==ATACAR){
            if(personaje.getDireccion()==DERECHA){ 
                currentEtiqueta.setIcon(ICONO_ATACA_DERECHA_PERSONAJE_PRINCIPAL);
                currentEtiqueta.revalidate();
                currentEtiqueta.repaint();
            }
            if(personaje.getDireccion()==IZQUIERDA){ 
                currentEtiqueta.setIcon(ICONO_ATACA_IZQUIERDA_PERSONAJE_PRINCIPAL);
                currentEtiqueta.revalidate();
                currentEtiqueta.repaint();
            }
            if(personaje.getDireccion()==ARRIBA){ 
                currentEtiqueta.setIcon(ICONO_ATACA_ARRIBA_PERSONAJE_PRINCIPAL);
                currentEtiqueta.revalidate();
                currentEtiqueta.repaint();
            }
            if(personaje.getDireccion()==ABAJO){ 
                currentEtiqueta.setIcon(ICONO_ATACA_ABAJO_PERSONAJE_PRINCIPAL);
                currentEtiqueta.revalidate();
                currentEtiqueta.repaint();
            }
        }
    }
}
