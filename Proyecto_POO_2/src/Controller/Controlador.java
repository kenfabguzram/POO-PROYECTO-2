package Controller;

import java.util.ArrayList;

import javax.swing.JLabel;

import Model.Aliado;
import Model.Constantes;
import Model.Enemigo;
import Model.Factory;
import Model.PersonajePrincipal;
import View.Interfaz;

public class Controlador implements Constantes {
    public Factory factory;
    public static int turnos;
    public static PersonajePrincipal personaje;
    private JLabel currentEtiquetaPersonajePrincipal;
    private JLabel lastEtiquetaPersonajePrincipal;
    public static ArrayList<Enemigo> enemigos;
    public static ArrayList<Enemigo> enemigosEliminar;
    public static ArrayList<Aliado> aliadosEliminar;
    public static ArrayList<Aliado> aliados;
    Enemigo currentEnemigo;
    Aliado currentAliado;
    public Controlador(){
        factory=new Factory();
        aliadosEliminar=new ArrayList<Aliado>();
        enemigosEliminar=new ArrayList<Enemigo>();
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
                    turnos++;
                }
                break;
            case ABAJO:
                if(personaje.getCoords()[X]<TAMANIO_MAPA_FILAS-1){
                    personaje.move();
                    turnos++;
                }
                break;
            case IZQUIERDA:
                if(personaje.getCoords()[Y]>0){
                    personaje.move();
                    turnos++;
                }
                break;
            case DERECHA:
                if(personaje.getCoords()[Y]<TAMANIO_MAPA_COLUMNAS-1){
                    personaje.move();
                    turnos++;
                }
                break;
        }
        
        currentEtiquetaPersonajePrincipal=Interfaz.etiquetas[personaje.getCoords()[X]][personaje.getCoords()[Y]];
        lastEtiquetaPersonajePrincipal=Interfaz.etiquetas[personaje.getOldCoords()[X]][personaje.getOldCoords()[Y]];
        lastEtiquetaPersonajePrincipal.setIcon(null);
        
        if(turnos%INTERVALO_DE_TURNOS_APARICION_DE_ALIADOS==0 && personaje.getObserversSize()<CANTIDAD_MAXIMA_DE_ALIADOS){
            currentAliado=(Aliado) factory.crear(ALIADO);
            aliados.add(currentAliado);
            personaje.agregarObservador(currentAliado);
        }
        if (turnos%INTERVALO_DE_TURNOS_APARICION_DE_ENEMIGOS==0){
            currentEnemigo=(Enemigo) factory.crear(ENEMIGO);
            enemigos.add(currentEnemigo);
            personaje.agregarObservador(currentEnemigo); 
        }


        actualizarEtiquetasAliados();
        aliados.removeAll(aliadosEliminar);
        for(int i=0;i<aliadosEliminar.size();i++)
            personaje.borrarObservador(aliadosEliminar.get(i));
        Controlador.aliadosEliminar.clear();

        actualizarEtiquetasEnemigos();
        enemigos.removeAll(enemigosEliminar);
        for(int i=0;i<enemigosEliminar.size();i++)
            personaje.borrarObservador(enemigosEliminar.get(i));
        Controlador.enemigosEliminar.clear();
    }
    public void actualizarEtiquetasAliados(){
        for(Aliado aliado:aliados){
            if(aliado.isVisible()){
                pintarAliado(aliado);
            }
            else{
                despintarAliado(aliado);
            }
        }
    }
    public void pintarAliado(Aliado aliado){
        JLabel currentEtiquetaEnemigo=Interfaz.etiquetas[aliado.getCurrentPosition()[X]][aliado.getCurrentPosition()[Y]];
        currentEtiquetaEnemigo.setIcon(ICONO_ALIADO);
        currentEtiquetaEnemigo.revalidate();
        currentEtiquetaEnemigo.repaint();
    }
    public void despintarAliado(Aliado aliado){
        JLabel aliadoEtiqueta=Interfaz.etiquetas[aliado.getCurrentPosition()[X]][aliado.getCurrentPosition()[Y]];
        aliadoEtiqueta.setIcon(null);
        aliadoEtiqueta.setBackground(COLOR_FONDO);
        aliadoEtiqueta.revalidate();
        aliadoEtiqueta.repaint();
    }
    public void actualizarEtiquetasEnemigos(){
        for(Enemigo enemigo:enemigos){
            despintarOldEnemigo(enemigo);
        }
        for(Enemigo enemigo:enemigos){
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
                for(Enemigo enemigo:enemigos){
                    if(personaje.getCoords()[Y]+1==enemigo.getCurrentPosition()[Y] & personaje.getCoords()[X]==enemigo.getCurrentPosition()[X]){
                        enemigosEliminar.add(enemigo);
                        JLabel enemigoEliminar=Interfaz.etiquetas[enemigo.getCurrentPosition()[X]][enemigo.getCurrentPosition()[Y]];
                        enemigoEliminar.setIcon(null);
                        enemigoEliminar.setBackground(COLOR_FONDO);
                        enemigoEliminar.revalidate();
                        enemigoEliminar.repaint();
                    }
                }
            }
            if(personaje.getDireccion()==IZQUIERDA){ 
                currentEtiquetaPersonajePrincipal.setIcon(ICONO_ATACA_IZQUIERDA_PERSONAJE_PRINCIPAL);
                currentEtiquetaPersonajePrincipal.revalidate();
                currentEtiquetaPersonajePrincipal.repaint();
                for(Enemigo enemigo:enemigos){
                    if(personaje.getCoords()[Y]-1==enemigo.getCurrentPosition()[Y] & personaje.getCoords()[X]==enemigo.getCurrentPosition()[X]){
                        enemigosEliminar.add(enemigo);
                        JLabel enemigoEliminar=Interfaz.etiquetas[enemigo.getCurrentPosition()[X]][enemigo.getCurrentPosition()[Y]];
                        enemigoEliminar.setIcon(null);
                        enemigoEliminar.setBackground(COLOR_FONDO);
                        enemigoEliminar.revalidate();
                        enemigoEliminar.repaint();
                    }
                }
            }
            if(personaje.getDireccion()==ARRIBA){ 
                currentEtiquetaPersonajePrincipal.setIcon(ICONO_ATACA_ARRIBA_PERSONAJE_PRINCIPAL);
                currentEtiquetaPersonajePrincipal.revalidate();
                currentEtiquetaPersonajePrincipal.repaint();
                for(Enemigo enemigo:enemigos){
                    if(personaje.getCoords()[X]-1==enemigo.getCurrentPosition()[X] & personaje.getCoords()[Y]==enemigo.getCurrentPosition()[Y]){
                        enemigosEliminar.add(enemigo);
                        JLabel enemigoEliminar=Interfaz.etiquetas[enemigo.getCurrentPosition()[X]][enemigo.getCurrentPosition()[Y]];
                        enemigoEliminar.setIcon(null);
                        enemigoEliminar.setBackground(COLOR_FONDO);
                        enemigoEliminar.revalidate();
                        enemigoEliminar.repaint();
                    }
                }
            }
            if(personaje.getDireccion()==ABAJO){ 
                currentEtiquetaPersonajePrincipal.setIcon(ICONO_ATACA_ABAJO_PERSONAJE_PRINCIPAL);
                currentEtiquetaPersonajePrincipal.revalidate();
                currentEtiquetaPersonajePrincipal.repaint();
                for(Enemigo enemigo:enemigos){
                    if(personaje.getCoords()[X]+1==enemigo.getCurrentPosition()[X] & personaje.getCoords()[Y]==enemigo.getCurrentPosition()[Y]){
                        enemigosEliminar.add(enemigo);
                        JLabel enemigoEliminar=Interfaz.etiquetas[enemigo.getCurrentPosition()[X]][enemigo.getCurrentPosition()[Y]];
                        enemigoEliminar.setIcon(null);
                        enemigoEliminar.setBackground(COLOR_FONDO);
                        enemigoEliminar.revalidate();
                        enemigoEliminar.repaint();
                        
                    }
                }
            }
            enemigos.removeAll(Controlador.enemigosEliminar);
            for(int i=0;i<Controlador.enemigosEliminar.size();i++)
                personaje.borrarObservador(enemigosEliminar.get(i));
            Controlador.enemigosEliminar.clear();
        }
    }
}
