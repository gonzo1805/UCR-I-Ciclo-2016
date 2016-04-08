//
public class ArbolBinario {

	private float frecuencia;
	private int ASCII;
	private ArbolBinario hijoDerecho = null;
	private ArbolBinario hijoIzquierdo = null;

	private int letra;

	public int getASCII() {
		return this.ASCII;
	}

	public void setASCII(int ASCII) {
		this.ASCII = ASCII;
	}

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

	public ArbolBinario(float frecuencia, int ASCII) {
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
