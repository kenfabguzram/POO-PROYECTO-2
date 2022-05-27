package Common;
import java.awt.Color;
import javax.swing.ImageIcon;
public interface Constantes {
    public static final int X=0;
    public static final int Y=1;
    public static final int TAMANIO_MAPA_COLUMNAS=30;
    public static final int TAMANIO_MAPA_FILAS=20;
    public static final Color COLOR_FONDO=Color.GREEN;
    public static final int IZQUIERDA=37;
    public static final int ARRIBA=38;
    public static final int DERECHA=39;
    public static final int ABAJO=40;
    public static final int ATACAR=10;
    public static final int PERSONAJE=0;
    public static final int ALIADO=1;
    public static final int ENEMIGO=2;
    public static final int CANTIDAD_INICIAL_VIDA=15;

    public static final ImageIcon ICONO_ARRIBA_PERSONAJE_PRINCIPAL= new ImageIcon("images/linkMatricialArriba.jpg");
    public static final ImageIcon ICONO_ABAJO_PERSONAJE_PRINCIPAL= new ImageIcon("images/linkMatricialAbajo.jpg");
    public static final ImageIcon ICONO_DERECHA_PERSONAJE_PRINCIPAL= new ImageIcon("images/linkMatricialDerecha.jpg");
    public static final ImageIcon ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL= new ImageIcon("images/linkMatricialIzquierda.jpg");
    public static final ImageIcon ICONO_ATACA_ARRIBA_PERSONAJE_PRINCIPAL= new ImageIcon("images/linkMatricialAtacaArriba.jpg");
    public static final ImageIcon ICONO_ATACA_ABAJO_PERSONAJE_PRINCIPAL= new ImageIcon("images/linkMatricialAtacaAbajo.jpg");
    public static final ImageIcon ICONO_ATACA_DERECHA_PERSONAJE_PRINCIPAL= new ImageIcon("images/linkMatricialAtacaDerecha.jpg");
    public static final ImageIcon ICONO_ATACA_IZQUIERDA_PERSONAJE_PRINCIPAL= new ImageIcon("images/linkMatricialAtacaIzquierda.jpg");
    
    public static final ImageIcon ICONO_ARRIBA_ENEMIGO= new ImageIcon("images/linkenemigoDerechaArriba.png");
    public static final ImageIcon ICONO_ABAJO_ENEMIGO= new ImageIcon("images/linkenemigoIzquierdaAbajo.png");
    public static final ImageIcon ICONO_DERECHA_ENEMIGO= new ImageIcon("images/linkenemigoDerechaArriba.png");
    public static final ImageIcon ICONO_IZQUIERDA_ENEMIGO= new ImageIcon("images/linkenemigoIzquierdaAbajo.png");

    public static final ImageIcon ICONO_ALIADO= new ImageIcon("images/linkAliado.jpg");


}
