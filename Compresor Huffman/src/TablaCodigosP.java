/**
 * Created by Gonzalo on 3/30/2016.
 */
public interface TablaCodigosP<C> {

    public TablaCodigos getSiguiente();

    public void setSiguiente(TablaCodigos siguiente);

    public void setDato(C dato);

    public C getDato();

    //public TablaCodigos()

    //public TablaCodigos(TablaCodigos dato)

    public TablaCodigos apuntaUltimo(TablaCodigos raiz);

    public void inserteDato(C dato);
}
