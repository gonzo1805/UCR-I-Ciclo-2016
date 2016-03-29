
public class Comparable {

	char valorASCII;
	String codigoHuf; 
	
	public void setCodigo(String codigo){
		this.codigoHuf = codigo;
	}
	
	public String getCodigo(){
		return this.codigoHuf;
	}
	
	public void setValorASCII(char valor){
		this.valorASCII = valor;
	}
	
	public int getValorASCII(){
		return this.valorASCII;
	}
	
}
