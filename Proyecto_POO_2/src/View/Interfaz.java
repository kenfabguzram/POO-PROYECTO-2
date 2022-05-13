package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Interfaz extends JFrame implements KeyListener{
    JLabel[][] etiquetas;
    
   public Interfaz(){
        super();
        etiquetas=new JLabel[50][50];
        setLayout(new GridLayout(50,50));
        for (int i=0;i<50;i++){
            for (int j=0;j<50;j++){
                etiquetas[i][j]=new JLabel();
                etiquetas[i][j].setOpaque(true);
                etiquetas[i][j].setBackground(Color.white);
                etiquetas[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                etiquetas[i][j].setBackground(Color.white);
                add(etiquetas[i][j]);
            }
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1300,700));
        pack();
        setVisible(true);
   }

@Override
public void keyTyped(KeyEvent e) {

    
}

@Override
public void keyPressed(KeyEvent e) {

    
}

@Override
public void keyReleased(KeyEvent e) {
    
    
}

   
}