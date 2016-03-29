
public class Nodo {
	
	
		ArbolBinario valor;
		Nodo siguiente = null;
	
		
		public void setValor(ArbolBinario valor){
			this.valor = valor;
		}
		
		public void setSiguiente(Nodo siguiente){
			this.siguiente = siguiente;
		}
		
		public Nodo(){
			
		}
		
		public Nodo Nodo(ArbolBinario valor){
			Nodo nodo = new Nodo();
			this.valor = valor;
			return nodo;
		}//Serias dudas sobre este

		public ArbolBinario getValor(){
			return this.valor;
		}
		
		public Nodo getSiguiente(){
			return this.siguiente;
		}
		
		
}
