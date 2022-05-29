package Controller;

import java.util.ArrayList;

import javax.swing.JLabel;

import Model.Aliado;
import Model.Constantes;
import Model.Enemigo;
import Model.PersonajePrincipal;
import View.Interfaz;

public class Controlador implements Constantes {
    public static int turnos;
    public static PersonajePrincipal personaje;
    private JLabel currentEtiquetaPersonajePrincipal;
    private JLabel lastEtiquetaPersonajePrincipal;
    private ArrayList<Enemigo> enemigos;
    private ArrayList<Aliado> aliados;
    Enemigo currentEnemigo;
    Aliado currentAliado;
    public Controlador(){
        
        aliados=new ArrayList<Aliado>();
        enemigos=new ArrayList<Enemigo>();
        turnos=0;
        personaje=new PersonajePrincipal();
        personaje.setDireccion(ABAJO);
        currentEtiquetaPersonajePrincipal=Interfaz.etiquetas[personaje.getCoords()[X]][personaje.getCoords()[Y]];
        lastEtiquetaPersonajePrincipal=Interfaz.etiquetas[personaje.getOldCoords()[X]][personaje.getOldCoords()[Y]];
        currentEtiquetaPersonajePrincipal.setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
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
        turnos++;
        currentEtiquetaPersonajePrincipal=Interfaz.etiquetas[personaje.getCoords()[X]][personaje.getCoords()[Y]];
        lastEtiquetaPersonajePrincipal=Interfaz.etiquetas[personaje.getOldCoords()[X]][personaje.getOldCoords()[Y]];
        lastEtiquetaPersonajePrincipal.setIcon(null);
        
        if(turnos%INTERVALO_DE_TURNOS_APARICION_DE_ALIADOS==0 && personaje.getObserversSize()<CANTIDAD_MAXIMA_DE_ALIADOS){
            currentAliado=new Aliado();
            aliados.add(currentAliado);
            personaje.agregarObservador(currentAliado);
        }
        if (turnos%INTERVALO_DE_TURNOS_APARICION_DE_ENEMGOS==0){
            currentEnemigo=new Enemigo();
            enemigos.add(currentEnemigo);
            personaje.agregarObservador(currentEnemigo); 
        }
        actualizarEtiquetasEnemigos();


    }
    public void actualizarEtiquetasEnemigos(){
        for(Enemigo enemigo:enemigos){
            despintarOldEnemigo(enemigo);
            pintarEnemigo(enemigo);
        }
    }
    public void despintarOldEnemigo(Enemigo enemigo){
        JLabel oldEtiqueta=Interfaz.etiquetas[enemigo.getLastPosition()[X]][enemigo.getLastPosition()[Y]];
        oldEtiqueta.setIcon(null);
        oldEtiqueta.setBackground(COLOR_FONDO);
        oldEtiqueta.revalidate();
        oldEtiqueta.repaint();
    }
    public void pintarEnemigo(Enemigo enemigo){
        JLabel currentEtiquetaEnemigo=Interfaz.etiquetas[enemigo.getCurrentPosition()[X]][enemigo.getCurrentPosition()[Y]];
        switch(enemigo.getDireccion()){
            case ARRIBA:
                currentEtiquetaEnemigo.setIcon(ICONO_ARRIBA_ENEMIGO);
                currentEtiquetaEnemigo.revalidate();
                currentEtiquetaEnemigo.repaint();
                break;
            case ABAJO:
                currentEtiquetaEnemigo.setIcon(ICONO_ABAJO_ENEMIGO);
                currentEtiquetaEnemigo.revalidate();
                currentEtiquetaEnemigo.repaint();
                break;
            case IZQUIERDA:
                currentEtiquetaEnemigo.setIcon(ICONO_IZQUIERDA_ENEMIGO);
                currentEtiquetaEnemigo.revalidate();
                currentEtiquetaEnemigo.repaint();
                break;
            case DERECHA:
                currentEtiquetaEnemigo.setIcon(ICONO_DERECHA_ENEMIGO);
                currentEtiquetaEnemigo.revalidate();
                currentEtiquetaEnemigo.repaint();
                break;
        }
    }
    public int getLastDirection(){
        return personaje.getDireccion();
    }
    public void pintarCurrentEtiqueta(){
        switch(personaje.getDireccion()){
            case ARRIBA:
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_ARRIBA_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
                    break;
            case ABAJO:
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
                    break;
            case IZQUIERDA:
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
                    break;
            case DERECHA:
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_DERECHA_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
                    break;
        }
    }
    private void despintarCurrentEtiqueta(){
        currentEtiquetaPersonajePrincipal=Interfaz.etiquetas[personaje.getCoords()[X]][personaje.getCoords()[Y]];
        currentEtiquetaPersonajePrincipal.setIcon(null);
        currentEtiquetaPersonajePrincipal.setBackground(COLOR_FONDO);
        currentEtiquetaPersonajePrincipal.revalidate();
        currentEtiquetaPersonajePrincipal.repaint();
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
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_ARRIBA_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
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
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
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
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
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
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_DERECHA_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
                }
                else{
                    despintarCurrentEtiqueta();
                    moveWithValidation();
                    
                    pintarCurrentEtiqueta();
                }
                break;
            case ATACAR:
                if(personaje.getDireccion()==DERECHA){
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_DERECHA_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
                }
                if(personaje.getDireccion()==IZQUIERDA){
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
                }
                if(personaje.getDireccion()==ARRIBA){
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_ARRIBA_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
                }
                if(personaje.getDireccion()==ABAJO){
                    currentEtiquetaPersonajePrincipal.setIcon(ICONO_ABAJO_PERSONAJE_PRINCIPAL);
                    currentEtiquetaPersonajePrincipal.revalidate();
                    currentEtiquetaPersonajePrincipal.repaint();
                }
                break;
        }
    }
    public void keyPressed(int codigoDeTecla){
        if(codigoDeTecla==ATACAR){
            if(personaje.getDireccion()==DERECHA){ 
                currentEtiquetaPersonajePrincipal.setIcon(ICONO_ATACA_DERECHA_PERSONAJE_PRINCIPAL);
                currentEtiquetaPersonajePrincipal.revalidate();
                currentEtiquetaPersonajePrincipal.repaint();
            }
            if(personaje.getDireccion()==IZQUIERDA){ 
                currentEtiquetaPersonajePrincipal.setIcon(ICONO_ATACA_IZQUIERDA_PERSONAJE_PRINCIPAL);
                currentEtiquetaPersonajePrincipal.revalidate();
                currentEtiquetaPersonajePrincipal.repaint();
            }
            if(personaje.getDireccion()==ARRIBA){ 
                currentEtiquetaPersonajePrincipal.setIcon(ICONO_ATACA_ARRIBA_PERSONAJE_PRINCIPAL);
                currentEtiquetaPersonajePrincipal.revalidate();
                currentEtiquetaPersonajePrincipal.repaint();
            }
            if(personaje.getDireccion()==ABAJO){ 
                currentEtiquetaPersonajePrincipal.setIcon(ICONO_ATACA_ABAJO_PERSONAJE_PRINCIPAL);
                currentEtiquetaPersonajePrincipal.revalidate();
                currentEtiquetaPersonajePrincipal.repaint();
            }
        }
    }
}
