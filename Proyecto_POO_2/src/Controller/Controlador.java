package Controller;

import javax.swing.JLabel;

import Common.Constantes;
import Model.PersonajePrincipal;
import View.Interfaz;
import Model.Factory;

public class Controlador implements Constantes {
    public static PersonajePrincipal personaje;
    private JLabel currentEtiqueta;
    public Controlador(){
        Factory factory= new Factory();
        factory.crearEnemigo();
        personaje=new PersonajePrincipal();
        personaje.setDireccion(ABAJO);
        actualizarCurrentEtiqueta();
        currentEtiqueta.setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
    }
    private void actualizarCurrentEtiqueta(){
        currentEtiqueta=Interfaz.etiquetas[personaje.getCoords()[X]][personaje.getCoords()[Y]];
    }
    public int getLastDirection(){
        return personaje.getDireccion();
    }
    public void setPersonajePrincipal(int fila, int columna,int direccion){
        switch(direccion){
            case ARRIBA:
                if(personaje.getDireccion()!=ARRIBA){
                    personaje.setDireccion(ARRIBA);
                    Interfaz.etiquetas[fila][columna].setIcon(ICONO_ARRIBA_PERSONAJE_PRINCIPAL);
                    Interfaz.etiquetas[fila][columna].revalidate();
                    Interfaz.etiquetas[fila][columna].repaint();
                }
                else
                    personaje.move();
                break;
            case ABAJO:
                if(personaje.getDireccion()!=ABAJO){
                    personaje.setDireccion(ABAJO);
                    Interfaz.etiquetas[fila][columna].setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
                    Interfaz.etiquetas[fila][columna].revalidate();
                    Interfaz.etiquetas[fila][columna].repaint();
                }
                else
                    personaje.move();
                break;
            case IZQUIERDA:
                if(personaje.getDireccion()!=IZQUIERDA){
                    personaje.setDireccion(IZQUIERDA);
                    Interfaz.etiquetas[fila][columna].setIcon(ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL);
                    Interfaz.etiquetas[fila][columna].revalidate();
                    Interfaz.etiquetas[fila][columna].repaint();
                }
                else
                    personaje.move();
                break;
            case DERECHA:
                if(personaje.getDireccion()!=DERECHA){
                    personaje.setDireccion(DERECHA);
                    Interfaz.etiquetas[fila][columna].setIcon(ICONO_DERECHA_PERSONAJE_PRINCIPAL);
                    Interfaz.etiquetas[fila][columna].revalidate();
                    Interfaz.etiquetas[fila][columna].repaint();
                }
                else
                    personaje.move();
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
        actualizarCurrentEtiqueta();
        switch(codigoDeTecla){
            case ARRIBA:
                if(personaje.getDireccion()!=ARRIBA){
                    personaje.setDireccion(ARRIBA);
                    currentEtiqueta.setIcon(ICONO_ARRIBA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                else{

                }
                    //personaje.move();
                break;
            case ABAJO:
                if(personaje.getDireccion()!=ABAJO){
                    personaje.setDireccion(ABAJO);
                    currentEtiqueta.setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                else{

                }
                    //personaje.move();
                break;
            case IZQUIERDA:
                if(personaje.getDireccion()!=IZQUIERDA){
                    personaje.setDireccion(IZQUIERDA);
                    currentEtiqueta.setIcon(ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                else{

                }
                    //personaje.move();
                break;
            case DERECHA:
                if(personaje.getDireccion()!=DERECHA){
                    personaje.setDireccion(DERECHA);
                    currentEtiqueta.setIcon(ICONO_DERECHA_PERSONAJE_PRINCIPAL);
                    currentEtiqueta.revalidate();
                    currentEtiqueta.repaint();
                }
                else{

                }
                    //personaje.move();
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
        actualizarCurrentEtiqueta();
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

