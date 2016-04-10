/**
 * Estructura de datos usada para el almacenamiento de todos los Caracteres con sus respectivas frecuencias y c�digos de Huff.
 * Además, también se utiliza para la descompresi�n en la creaci�n del arbol para conseguir los caracteres al momento de la lectura del comprimido
 *
 * @author Gonzalo
 */
public class ArbolBinario {

    /**
     * Frecuencia: la frecuencia del ASCII en el texto original
     * ASCII: el valor ASCII de la letra en el texto original y en el arbol de descompresion
     * HijoDerecho: hijo derecho del arbol
     * HijoIzquierdo: hijo izquierdo del arbol
     */
    private float frecuencia;
    private int ASCII;
    private ArbolBinario hijoDerecho = null;
    private ArbolBinario hijoIzquierdo = null;
    //private int letra;

    /**
     * Retorna el ASCII del ArbolBinario al que se esta apuntando
     *
     * @return el ASCII del ArbolBinario al que se esta apuntando
     */
    public int getASCII() {
        return this.ASCII;
    }

    /**
     * Asigna el valor ASCII mandado por parametro al ArbolBinario que se esta apuntando
     *
     * @param ASCII valor a asignar en el ArbolBinario al que se esta apuntando
     */
    public void setASCII(int ASCII) {
        this.ASCII = ASCII;
    }

    /**
     * Asigna el valor de la frecuencia mandado por parametro al ArbolBinario que se esta apuntando
     *
     * @param frecuencia valor a asignar en el ArbolBinario al que se esta apuntando
     */
    public void setFrecuencia(float frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     * Retorna la frecuencia en el ArbolBinario que se esta apuntando
     *
     * @return la frecuencia en el ArbolBinario que se esta apuntando
     */
    public float getFrecuencia() {
        return this.frecuencia;
    }

    /**
     * Retorna el hijo derecho del ArbolBinario que se esta apuntando
     *
     * @return el hijo derecho del ArbolBinario que se esta apuntando
     */
    public ArbolBinario getHijoDerecho() {
        return this.hijoDerecho;
    }

    /**
     * Retorna el hijo izquierdo del ArbolBinario que se esta apuntando
     *
     * @return el hijo izquierdo del ArbolBinario que se esta apuntando
     */
    public ArbolBinario getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    /**
     * Asinga al hijo izquierdo del ArbolBinario que se apunta el hijo mandado por parametro
     *
     * @param hijo ArbolBinario que sera el hijo izquierdo del ArbolBinario que se apunta
     */
    public void setHijoIzquierdo(ArbolBinario hijo) {
        this.hijoIzquierdo = hijo;
    }

    /**
     * Asinga al hijo derecho del ArbolBinario que se apunta el hijo mandado por parametro
     *
     * @param hijo ArbolBinario que sera el hijo derecho del ArbolBinario que se apunta
     */
    public void setHijoDerecho(ArbolBinario hijo) {
        this.hijoDerecho = hijo;
    }

    /**
     * Metodo usado en la descompresion del archivo, crea un hijo izquierdo al ArbolBinario que se esta apuntando
     */
    public void creaHijoIzquierdo() {
        this.hijoIzquierdo = new ArbolBinario();
    }

    /**
     * Metodo usado en la descompresion del archivo, crea un hijo derecho al ArbolBinario que se esta apuntando
     */
    public void creaHijoDerecho() {
        this.hijoDerecho = new ArbolBinario();
    }

    /**
     * Constructor ArbolBinario
     */
    public ArbolBinario() {

    }

    /**
     * Constructor por parametros de ArbolBinario
     * @param frecuencia valor de la frecuencia del ASCII en el texto
     * @param ASCII letra especifica del texto
     */
    public ArbolBinario(float frecuencia, int ASCII) {
        this.frecuencia = frecuencia;
        this.ASCII = ASCII;
    }

    /**
     * Un get para obtener solamente el ArbolBinario que esta dentro del nodo
     * @param raiz Nodo enviado por parametro que contiene el ArbolBinario
     * @return el ArbolBinario dentro del nodo
     */
    public ArbolBinario getArbolEntero(Nodo raiz) {
        return raiz.getValor();
    }// Cuando todo el arbol esta guardado en un mismo nodo ya para usar los
    // codigos.

    public void imprima() {
        this.imprimaArbol();
    }

    public void imprimaArbol() {

        if (this.hijoIzquierdo != null) {
            // System.out.print(frecuencia + ASCII + " ");
            this.hijoIzquierdo.imprima();
        }
        System.out.println(frecuencia + " " + (char) ASCII + " ");
        if (this.hijoDerecho != null) {
            // System.out.print(frecuencia + ASCII + " ");
            this.hijoDerecho.imprima();
        }

    }

    public ArbolBinario(ArbolBinario arbol_1, ArbolBinario arbol_2) {

        this.frecuencia = arbol_1.getFrecuencia() + arbol_2.getFrecuencia();

        //if (arbol_1.getFrecuencia() <= arbol_2.getFrecuencia()) {
        this.hijoIzquierdo = arbol_1;
        this.hijoDerecho = arbol_2;
        //}
        //if (arbol_1.getFrecuencia() > arbol_2.getFrecuencia()) {
        //this.hijoIzquierdo = arbol_2;
        //this.hijoDerecho = arbol_1;
        //}
        /*
         * if (arbol_1.getFrecuencia() == arbol_2.getFrecuencia()){
		 * this.hijoIzquierdo = arbol_1; this.hijoDerecho = arbol_2; }
		 */
    }

    public void obtieneCodigosHuffman(TablaCodigos tabla, ArbolBinario arbol) {
        String codigo = "";
        obtieneCodigosHuffman(tabla, arbol, codigo);
    }

    public void obtieneCodigosHuffman(TablaCodigos tabla, ArbolBinario arbol, String codigo) {

        if (arbol.hijoIzquierdo != null && arbol.hijoDerecho != null) {

            ArbolBinario hijoIzquierdo = arbol.getHijoIzquierdo();
            ArbolBinario hijoDerecho = arbol.getHijoDerecho();

            codigo += "0";
            obtieneCodigosHuffman(tabla, hijoIzquierdo, codigo);
            codigo = codigo.substring(0, codigo.length() - 1);

            codigo += "1";
            obtieneCodigosHuffman(tabla, hijoDerecho, codigo);
            codigo = codigo.substring(0, codigo.length() - 1);

        } else if (arbol.hijoIzquierdo != null && arbol.hijoDerecho == null) {
            ArbolBinario hijoIzquierdo = arbol.hijoIzquierdo;

            codigo += "0";
            obtieneCodigosHuffman(tabla, hijoIzquierdo, codigo);
            codigo = codigo.substring(0, codigo.length() - 1);
        } else if (arbol.hijoIzquierdo == null && arbol.hijoDerecho != null) {
            ArbolBinario hijoDerecho = arbol.hijoDerecho;

            codigo += "1";
            obtieneCodigosHuffman(tabla, hijoDerecho, codigo);
            codigo = codigo.substring(0, codigo.length() - 1);
        } else if (arbol.hijoIzquierdo == null && arbol.hijoDerecho == null) {
            tabla.inserteDato(arbol.ASCII, codigo);
        }
    }

}
