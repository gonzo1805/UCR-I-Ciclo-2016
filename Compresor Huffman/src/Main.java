import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) {
		/*String CD = "c";
		String Inicio = "";
		String Destino = "";*/
		
		/*if(args.length!=0){
            //CD = args[0];
            Inicio = args[1];
            Destino = args[2];
        }
		System.out.println(CD + Inicio + Destino);
		if (args[0] == CD){
			System.out.println(CD);
		}*/
		Compresor_Descompresor accion = new Compresor_Descompresor();
		accion.Comprime();
		accion.Descomprime();

	}
}