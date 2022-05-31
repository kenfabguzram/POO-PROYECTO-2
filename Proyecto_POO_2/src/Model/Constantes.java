package Model;
import java.awt.Color;
import javax.swing.ImageIcon;

import javax.swing.Icon;
import java.awt.Image;
public interface Constantes {
    public static final int X=0;
    public static final int Y=1;
    public static final int RANGO_APARICION_ALIADO=5;
    public static final int TAMANIO_MAPA_COLUMNAS=50;
    public static final int TAMANIO_MAPA_FILAS=25;
    public static final Color COLOR_FONDO=Color.BLACK;
    public static final int IZQUIERDA=37;
    public static final int ARRIBA=38;
    public static final int DERECHA=39;
    public static final int ABAJO=40;
    public static final int ATACAR=10;
    public static final int ALIADO=1;
    public static final int ENEMIGO=2;
    public static final int CANTIDAD_INICIAL_VIDA=15;
    public static final int INTERVALO_DE_TURNOS_APARICION_DE_ENEMIGOS=7;
    public static final int INTERVALO_DE_TURNOS_APARICION_DE_ALIADOS=7;
    public static final int CANTIDAD_MAXIMA_DE_ALIADOS=10;
    public static final Icon ICONO_ARRIBA_PERSONAJE_PRINCIPAL=
    new ImageIcon(new ImageIcon("images/linkMatricialArriba.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));

    public static final Icon ICONO_ABAJO_PERSONAJE_PRINCIPAL=
    new ImageIcon(new ImageIcon("images/linkMatricialAbajo.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
    
    public static final Icon ICONO_DERECHA_PERSONAJE_PRINCIPAL= 
    new ImageIcon(new ImageIcon("images/linkMatricialDerecha.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
    
    public static final Icon ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL= 
    new ImageIcon(new ImageIcon("images/linkMatricialIzquierda.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
    
    public static final Icon ICONO_ATACA_ARRIBA_PERSONAJE_PRINCIPAL= 
    new ImageIcon(new ImageIcon("images/linkMatricialAtacaArriba.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
    
    public static final Icon ICONO_ATACA_ABAJO_PERSONAJE_PRINCIPAL= 
    new ImageIcon(new ImageIcon("images/linkMatricialAtacaAbajo.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
    
    public static final Icon ICONO_ATACA_DERECHA_PERSONAJE_PRINCIPAL= 
    new ImageIcon(new ImageIcon("images/linkMatricialAtacaDerecha.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
    
    public static final Icon ICONO_ATACA_IZQUIERDA_PERSONAJE_PRINCIPAL=
    new ImageIcon(new ImageIcon("images/linkMatricialAtacaIzquierda.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
     
    
    public static final Icon ICONO_ARRIBA_ENEMIGO=
    new ImageIcon(new ImageIcon("images/enemigoArriba.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
     
    public static final Icon ICONO_ABAJO_ENEMIGO=
    new ImageIcon(new ImageIcon("images/enemigoAbajo.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
     
    public static final Icon ICONO_DERECHA_ENEMIGO= 
    new ImageIcon(new ImageIcon("images/enemigoDerecha.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
    
    public static final Icon ICONO_IZQUIERDA_ENEMIGO= 
    new ImageIcon(new ImageIcon("images/enemigoIzquierda.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
    

    public static final Icon ICONO_ALIADO= 
    new ImageIcon(new ImageIcon("images/linkAliado.jpg")
    .getImage()
    .getScaledInstance(27,29,Image.SCALE_DEFAULT));
    


}
