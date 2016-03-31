/**
 * Created by Gonzalo on 3/30/2016.
 */
public interface ListaOrdenadaP<N,A>{
    //public ListaOrdenada();

    public void insertarNodo(N nuevoNodo);

    public void insertarArbol(A arbol);

    public void combinarFrecuencias(N arbol_1, N arbol_2);

    public void borrarNodo(N nodo);

    public void generaArbol(N raiz);
}
