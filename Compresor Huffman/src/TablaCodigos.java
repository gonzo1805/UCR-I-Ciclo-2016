
public class TablaCodigos {

    private TablaCodigos inicio;
    private static int cantidadDatos = 0;

    private int ASCII;
    private String codigoHuff;
    private int tamanoCodigo;
    private TablaCodigos siguiente = null;
    private TablaCodigos cola;

    public TablaCodigos() {
    	inicio = null;
    	cola = inicio;
    }
    
    public TablaCodigos(int dato, String huff){
    	this.ASCII = dato;
    	this.codigoHuff = huff;
    }
    
    public TablaCodigos(int dato, String huff, int tamanoCodigo){
    	this.ASCII = dato;
    	this.codigoHuff = huff;
    	this.tamanoCodigo = tamanoCodigo;
    }
    
    public String getHuff(){
    	return this.codigoHuff;
    }
    
    public void settamano(int tamano){
    	this.tamanoCodigo = tamano;
    }
    
    public void setHuff(int dato, String codigo){
    	TablaCodigos auxiliar = inicio;
    	while (auxiliar != null){
    		if (auxiliar.ASCII == dato) auxiliar.codigoHuff = codigo;
    		auxiliar = auxiliar.siguiente;
    	}
    	
    }
    
    public void setHuff(String huff){
    	this.codigoHuff = huff;
    }
    
    public TablaCodigos getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(TablaCodigos siguiente) {
        this.siguiente = siguiente;
        cantidadDatos++; 
    }

    public void setDato(int dato) {
        this.ASCII = dato;
    }

    public String getCodigo(int dato) {   
    	return sacaHuff(dato);
    }
    
    public int getTamano(int dato){
    	TablaCodigos auxiliar = inicio;
    	for (int i=0; i<cantidadDatos; i++){
    		if (auxiliar.ASCII == dato) return auxiliar.tamanoCodigo;
    		auxiliar = auxiliar.siguiente;
    	}
    	return 0;
    }
    
    public int tamanoCodigo(int dato){
    	return (sacaHuff(dato)).length();
    }
    
    public boolean existe(int dato){
    	TablaCodigos auxiliar = inicio;
    	while (auxiliar != null){
    		if (auxiliar.ASCII == dato) return true;
    		auxiliar = auxiliar.siguiente;
    	}
    	return false;
    }
    

    public void inserteDato(int dato, String huff) {
        TablaCodigos insertado = new TablaCodigos(dato, huff);
        if (cantidadDatos == 0 || inicio == null){
        	inicio = insertado;
        	cola = insertado;
        	cantidadDatos++;
        }
        else {
        	 cola.siguiente = insertado;
        	 cola = cola.siguiente;
        	 cantidadDatos++;
        }
    }
    
    public void inserteDato(int dato, String huff, int tamano) {
        TablaCodigos insertado = new TablaCodigos(dato, huff, tamano);
        if (cantidadDatos == 0 || inicio == null){
        	inicio = insertado;
        	cola = insertado;
        	cantidadDatos++;
        }
        else {
        	 cola.siguiente = insertado;
        	 cola = cola.siguiente;
        	 cantidadDatos++;
        }
    }
    
    public String sacaHuff(int ASCII){
    	TablaCodigos auxiliar = inicio;
    	for (int i=0; i<cantidadDatos; i++){
    		if (auxiliar.ASCII != ASCII) auxiliar = auxiliar.siguiente;
    		if (auxiliar.ASCII == ASCII) return auxiliar.codigoHuff;
    	}
    	return null;
    }
    
    public void imprimaTabla(){
    	TablaCodigos auxiliar = inicio;
    	for (int i=0; i<cantidadDatos; i++){
    		System.out.println("ASCII = " + auxiliar.ASCII + " Codigo Huffman = " + auxiliar.codigoHuff);
    		auxiliar = auxiliar.siguiente;
    	}
    }


}
