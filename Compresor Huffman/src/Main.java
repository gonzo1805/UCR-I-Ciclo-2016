import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) {
		/*String C = "-c";
		String D = "-d";
		String Inicio = "";
		String Destino = "";*/
		Compresor_Descompresor accion = new Compresor_Descompresor();
		/*if(args.length!=0){
        }
		//System.out.println(CD + Inicio + Destino);
		if (C.equals(args[0])){
			accion.Comprime(args[1], args[2]);
		}
		else if (D.equals(args[0])){
			accion.Descomprime(args[1], args[2]);
		}*/
		
		accion.Comprime();
		accion.Descomprime();

	}
}