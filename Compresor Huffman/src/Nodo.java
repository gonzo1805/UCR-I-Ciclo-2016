
public class Nodo {
	
	
		private ArbolBinario valor;
		private Nodo siguiente = null;
		
		public void setValor(ArbolBinario valor){
			this.valor = valor;
		}
		
		public void setSiguiente(Nodo siguiente){
			this.siguiente = siguiente;
		}
		
		public Nodo(){
			
		}
		
		public Nodo(ArbolBinario valor){
			this.valor = valor;
		}//Serias dudas sobre este

		public ArbolBinario getValor(){
			return this.valor;
		}
		
		public Nodo getSiguiente(){
			return this.siguiente;
		}
		
		
}
