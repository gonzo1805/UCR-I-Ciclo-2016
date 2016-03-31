/**
 * Created by Gonzalo on 3/30/2016.
 */
public interface ArbolBinarioP<N> {

    public void setFrecuencia(float frecuencia);

    public float getFrecuencia();

    public ArbolBinario getHijoDerecho();

    public ArbolBinario getHijoIzquierdo();

    public void setHijoIzquierdo(ArbolBinario hijo);

    public void setHijoDerecho(ArbolBinario hijo);

    //public ArbolBinario();

    //public ArbolBinario(float frecuencia, Comparable ASCII);

    public ArbolBinario getArbolEntero(N raiz);

    public void imprima();

    public void imprimaArbol();

    public ArbolBinario combinaFrecuencias(N arbol_1, N arbol_2);

    public String getCodigoHuffman(ArbolBinario raiz, int letra);

    public String getCodigoHuffman(ArbolBinario actual, int letra, ArbolBinario padre, String codigo);
}
