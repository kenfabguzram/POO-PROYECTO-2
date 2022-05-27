package Common;
import java.awt.Color;
import javax.swing.ImageIcon;
public interface Constantes {
    public static final int TAMANIO_MAPA_COLUMNAS=50;
    public static final int TAMANIO_MAPA_FILAS=50;
    public static final Color COLOR_FONDO=Color.GREEN;
    public static final int DERECHA=39;
    public static final int ABAJO=40;
    public static final int IZQUIERDA=37;
    public static final int ARRIBA=38;
    public static final int ATACAR=10;

    public static final ImageIcon ICONO_ARRIBA_PERSONAJE_PRINCIPAL= new ImageIcon("iconos/linkMatricialArriba.png");
    public static final ImageIcon ICONO_ABAJO_PERSONAJE_PRINCIPAL= new ImageIcon("iconos/linkMatricialAbajo.png");
    public static final ImageIcon ICONO_DERECHA_PERSONAJE_PRINCIPAL= new ImageIcon("iconos/linkMatricialDerecha.png");
    public static final ImageIcon ICONO_IZQUIERDA_PERSONAJE_PRINCIPAL= new ImageIcon("iconos/linkMatricialIzquierda.png");
    public static final ImageIcon ICONO_ATACA_ARRIBA_PERSONAJE_PRINCIPAL= new ImageIcon("iconos/linkMatricialAtacaArriba.png");
    public static final ImageIcon ICONO_ATACA_ABAJO_PERSONAJE_PRINCIPAL= new ImageIcon("iconos/linkMatricialAtacaAbajo.png");
    public static final ImageIcon ICONO_ATACA_DERECHA_PERSONAJE_PRINCIPAL= new ImageIcon("iconos/linkMatricialAtacaDerecha.png");
    public static final ImageIcon ICONO_ATACA_IZQUIERDA_PERSONAJE_PRINCIPAL= new ImageIcon("iconos/linkMatricialAtacaIzquierda.png");
    
    public static final ImageIcon ICONO_ARRIBA_ENEMIGO= new ImageIcon("iconos/linkenemigoDerechaArriba.png");
    public static final ImageIcon ICONO_ABAJO_ENEMIGO= new ImageIcon("iconos/linkenemigoIzquierdaAbajo.png");
    public static final ImageIcon ICONO_DERECHA_ENEMIGO= new ImageIcon("iconos/linkenemigoDerechaArriba.png");
    public static final ImageIcon ICONO_IZQUIERDA_ENEMIGO= new ImageIcon("iconos/linkenemigoIzquierdaAbajo.png");

    public static final ImageIcon ICONO_ALIADO= new ImageIcon("iconos/linkAliado.png");


}
