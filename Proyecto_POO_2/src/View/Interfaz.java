package View;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import Common.Constantes;
import Controller.Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Interfaz extends JFrame implements KeyListener, Constantes{
    public static JLabel[][] etiquetas;
    Controlador controlador;
   public Interfaz(){
        super();
        
        etiquetas=new JLabel[TAMANIO_MAPA_FILAS][TAMANIO_MAPA_COLUMNAS];
        setLayout(new GridLayout(TAMANIO_MAPA_FILAS,TAMANIO_MAPA_COLUMNAS));
        this.addKeyListener(this);
        for (int i=0;i<TAMANIO_MAPA_FILAS;i++){
            for (int j=0;j<TAMANIO_MAPA_COLUMNAS;j++){
                etiquetas[i][j]=new JLabel();
                etiquetas[i][j].setOpaque(true);
                etiquetas[i][j].setBackground(COLOR_FONDO);
                add(etiquetas[i][j]);

            }
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        controlador=new Controlador();
   }
public void keyReleased(KeyEvent e) {controlador.keyReleased(e.getKeyCode());}
public void keyTyped(KeyEvent e) {}
public void keyPressed(KeyEvent e) {}
}