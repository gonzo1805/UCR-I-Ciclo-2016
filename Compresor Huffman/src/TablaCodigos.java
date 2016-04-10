
public class TablaCodigos {

    private TablaCodigos inicio;
    private static int cantidadDatos = 0;

    private int ASCII;
    private String codigoHuff;
    private int tama�oCodigo;
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
    
    public TablaCodigos(int dato, String huff, int tama�oCodigo){
    	this.ASCII = dato;
    	this.codigoHuff = huff;
    	this.tama�oCodigo = tama�oCodigo;
    }
    
    public String getHuff(){
    	return this.codigoHuff;
    }
    
    public void setTama�o(int tama�o){
    	this.tama�oCodigo = tama�o;
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
    
    public int getTama�o(int dato){
    	TablaCodigos auxiliar = inicio;
    	for (int i=0; i<cantidadDatos; i++){
    		if (auxiliar.ASCII == dato) return auxiliar.tama�oCodigo;
    		auxiliar = auxiliar.siguiente;
    	}
    	return 0;
    }
    
    public int tama�oCodigo(int dato){
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
    
    public void inserteDato(int dato, String huff, int tama�o) {
        TablaCodigos insertado = new TablaCodigos(dato, huff, tama�o);
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
