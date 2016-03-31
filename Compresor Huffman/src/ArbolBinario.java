
public class ArbolBinario implements ArbolBinarioP<Nodo> {

	private float frecuencia;
	private Comparable ASCII;
	private ArbolBinario hijoDerecho = null;
	private ArbolBinario hijoIzquierdo = null;

	public void setFrecuencia(float frecuencia) {
		this.frecuencia = frecuencia;
	}

	public float getFrecuencia() {
		return this.frecuencia;
	}

	public ArbolBinario getHijoDerecho() {
		return this.hijoDerecho;
	}

	public ArbolBinario getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public void setHijoIzquierdo(ArbolBinario hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void setHijoDerecho(ArbolBinario hijo) {
		this.hijoDerecho = hijo;
	}

	public ArbolBinario() {

	}

	public ArbolBinario(float frecuencia, Comparable ASCII) {
		this.frecuencia = frecuencia;
		this.ASCII = ASCII;
	}

	public ArbolBinario getArbolEntero(Nodo raiz) {
		return raiz.getValor();
	}// Cuando todo el arbol esta guardado en un mismo nodo ya para usar los
		// codigos.

	public void imprima() {
		this.imprimaArbol();
	}

	public void imprimaArbol() {
		System.out.print(frecuencia + " ");
		if (hijoIzquierdo != null)
			hijoIzquierdo.imprima();
		if (hijoDerecho != null)
			hijoDerecho.imprima();
	}

	public ArbolBinario combinaFrecuencias(Nodo arbol_1, Nodo arbol_2) {
		ArbolBinario nuevoArbol = new ArbolBinario();
		nuevoArbol.frecuencia = arbol_1.getValor().getFrecuencia() + arbol_2.getValor().getFrecuencia();

		if (arbol_1.getValor().getFrecuencia() < arbol_2.getValor().getFrecuencia()) {
			nuevoArbol.hijoIzquierdo = arbol_1.getValor();
			nuevoArbol.hijoDerecho = arbol_2.getValor();
		} else if (arbol_1.getValor().getFrecuencia() >= arbol_2.getValor().getFrecuencia()) {
			nuevoArbol.hijoIzquierdo = arbol_2.getValor();
			nuevoArbol.hijoDerecho = arbol_1.getValor();
		}
		return nuevoArbol;
	}
	
	public String getCodigoHuffman(ArbolBinario raiz, int letra){
		String codigo = null;
		codigo = getCodigoHuffman(raiz, letra, raiz, codigo);
		return codigo;
	}
	
	public String getCodigoHuffman(ArbolBinario actual, int letra, ArbolBinario padre, String codigo){
		if (actual.ASCII.getValorASCII() != letra){
			
			codigo += "0";
			getCodigoHuffman(actual.hijoIzquierdo, letra, actual, codigo);
			codigo.substring(0, codigo.length()-1);
			
			codigo += "1";
			getCodigoHuffman(actual.hijoDerecho, letra, actual, codigo);
			codigo.substring(0, codigo.length()-1);
		}
		if (actual.ASCII.getValorASCII() == letra){
			return codigo;
		}
		System.out.println("No aparecio la letra indicada en el arbol, se retornara un null");
		return null;
	}

}
