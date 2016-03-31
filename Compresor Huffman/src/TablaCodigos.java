
public class TablaCodigos implements TablaCodigosP<Comparable> {

    private TablaCodigos raiz;
    private static int cantidadDatos = 0;

    private Comparable dato;
    private TablaCodigos siguiente = null;

    public TablaCodigos getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(TablaCodigos siguiente) {
        this.siguiente = siguiente;
    }

    public void setDato(Comparable dato) {
        this.dato = dato;
    }

    public Comparable getDato() {
        return this.dato;
    }

    public TablaCodigos() {
        raiz = null;
    }

    public TablaCodigos(TablaCodigos dato) {
        this.raiz = dato;
    }

    public TablaCodigos apuntaUltimo(TablaCodigos raiz) {
        if (raiz.siguiente == null) {
            return raiz;
        } else if (raiz.siguiente != null) {
            apuntaUltimo(raiz.siguiente);
        }
        return null;
    }

    public void inserteDato(Comparable dato) {
        TablaCodigos insertado = new TablaCodigos();
        insertado.dato = dato;
        apuntaUltimo(raiz).siguiente = insertado;
        cantidadDatos++;
    }


}
