package Model;

public interface Observable {
    public void agregarObservador(Observador o);
    public void borrarObservador(Observador o);
    public void notificarObservadores(Observador o);

}
